package br.com.foodzone.service;

import br.com.foodzone.dao.UsuarioDao;
import br.com.foodzone.exception.UsuarioInvalidoException;
import br.com.foodzone.model.Usuario;

public class UsuarioService {

	private UsuarioDao usuarioDao;

	public UsuarioService(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	public void usuarioExisteAdicionar(Usuario usuario) throws UsuarioInvalidoException {

		if (usuarioDao.validaUsuarioAdicionar(usuario)) {

			throw new UsuarioInvalidoException("Nome de usuário '"
					+ usuario.getNome() + "' já existe no adicionar!");

		}// fim if

	}// usuarioExisteAdicionar()


	public void validacaoLogin(Usuario usuario) throws UsuarioInvalidoException {

		if (usuarioDao.carregaUsuarioBySenha(usuario) == null) {
			throw new UsuarioInvalidoException("Login e/ou senha inválidos");
		}
	}
}
