package br.com.foodzone.model;

import java.io.Serializable;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

@Component
@SessionScoped
public class UsuarioWeb implements Serializable{
	private static final long serialVersionUID = 1L;

	// objeto do tipo Usuário
	private Usuario logado;

	// que pode ser o id do vendedor ou id do proprietário
	private Integer idEntidadeUsuario;

	public Integer getIdEntidadeUsuario() {
		return idEntidadeUsuario;
	}

	public void setIdEntidadeUsuario(Integer idEntidadeUsuario) {
		this.idEntidadeUsuario = idEntidadeUsuario;
	}

	// Guarda o objeto Usuário
	public void fazerLogin(Usuario usuario) {
		this.logado = usuario;

		if (usuario != null) {


		}// fim if
	}

	// recupera informações do objeto
	// como id
	public Integer getarioId() {
		return logado.getId();
	}

	// recupera informações do objeto
	// como nome
	public String getNome() {
		return logado.getNome();
	}

	public void atualizaNomeUsuario() {
		// se usuário é um proprietário
		// define nome

	}

	public void setNome(String nome) {
		logado.setNome(nome);
	}

	// verifica se está logado
	public boolean isLogado() {
		return logado != null;
	}

	// sair
	public void logout() {
		this.logado = null;
	}
}
