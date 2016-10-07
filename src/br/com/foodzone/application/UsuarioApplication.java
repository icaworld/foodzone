package br.com.foodzone.application;

import java.security.NoSuchAlgorithmException;

import br.com.caelum.vraptor.ioc.Component;
import br.com.foodzone.dao.UsuarioDao;
import br.com.foodzone.exception.UsuarioInvalidoException;
import br.com.foodzone.model.HashUtil;
import br.com.foodzone.model.Usuario;
import br.com.foodzone.service.UsuarioService;

@Component
public class UsuarioApplication {

    private UsuarioDao usuarioDao;
    private UsuarioService usuarioService;

    public UsuarioApplication() {
	usuarioDao = new UsuarioDao(null);
	usuarioService = new UsuarioService(usuarioDao);
    }

    public Usuario autenticaoLogin(Usuario usuario) throws UsuarioInvalidoException {
    	try {
			usuario.setSenha(HashUtil.toMD5(usuario.getSenha()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	// validação
	usuarioService.validacaoLogin(usuario);

	// se válido retorna
	usuario = usuarioDao.carregaUsuarioBySenha(usuario);
	return usuario;
    }

    public Usuario restSenha(Usuario usuario) throws UsuarioInvalidoException {
	// se válido retorna
	return usuarioDao.carregaUsuarioNewSenha(usuario);
    }

    public Usuario carregaUsuario(Integer idUsuario) {

	return usuarioDao.carregar(idUsuario);
    }

    public void excluirUsuario(Usuario idUsuario) {
	usuarioDao.deletar(idUsuario);
    }

    public void atualizaUsuario(Usuario usuario) {
	usuarioDao.atualizar(usuario);

    }

    public boolean validaUsuarioAdicionar(Usuario usuario) {
	return usuarioDao.validaUsuarioAdicionar(usuario);
    }

    public boolean validaUsuarioEditar(Usuario usuario) {

	return validaUsuarioEditar(usuario);
    }

    public void salvaUsuario(Usuario usuario) {
    	try {
			usuario.setSenha(HashUtil.toMD5(usuario.getSenha()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	usuarioDao.adicionar(usuario);
    }

    public String numeroTotalUsuarios() {

	return usuarioDao.numeroUsuarios();
    }

}
