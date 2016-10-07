package br.com.foodzone.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.foodzone.application.UsuarioApplication;
import br.com.foodzone.exception.UsuarioInvalidoException;
import br.com.foodzone.intercepts.Liberado;
import br.com.foodzone.model.Usuario;
import br.com.foodzone.model.UsuarioWeb;

/*Classe controladora UsuarioController contém 
 as regras de negócio, com anotação @Resource para o
 Vraptor saber que essa classe é um controller*/

@Resource
public class UsuarioController {

	private UsuarioWeb usuarioWeb;// mantem o estado do usuário
	private Result result; // mostra resultados
	private Validator validator; // validação
	private UsuarioApplication usuarioApplication; // usuário app

	// ...
	public UsuarioController(Validator validator, UsuarioWeb usuarioWeb, UsuarioApplication usuarioApplication,
			Result result) {

		this.result = result;
		this.validator = validator;
		this.usuarioWeb = usuarioWeb;
		this.usuarioApplication = usuarioApplication;

	}// fim do construtor

	// página de login
	@Get("/login")
	public void loginForm() {

		// define título da página
		result.include("titulo", "Login - Sistema FoodZone");

	}// fim login()

	// página de reset
	@Get("/reset")
	public void resetForm() {

		// define título da página
		result.include("titulo", "Login - Sistema FoodZone");

	}// fim login()

	// ação de login
	@Post("/login")
	public void login(Usuario usuario) {

		Usuario usuarioValido = null;

		try {

			// condição que permite fazer login
			usuarioValido = usuarioApplication.autenticaoLogin(usuario);

		} catch (UsuarioInvalidoException e) {

			validator.add(new ValidationMessage(e.getMessage(), null));

		} finally {

			// redireciona para a página loginForm() caso houver erro na
			// validação
			validator.onErrorUsePageOf(UsuarioController.class).loginForm();

			// permite fazer login sem erros em sessão
			usuarioWeb.fazerLogin(usuarioValido);

		}

		// redirecionando para a index
		result.redirectTo(IndexController.class).index();

	}// fim login()

	// ação de newSenha
	@Post("/newSenha")
	public void newSenha(Usuario usuario) {
		Usuario usuarioValido = null;
		try {
			// condição que permite fazer login
			usuarioValido = usuarioApplication.restSenha(usuario);

		} catch (UsuarioInvalidoException e) {

			validator.add(new ValidationMessage(e.getMessage(), null));

		} finally {

			// redireciona para a página loginForm() caso houver erro na
			// validação
			validator.onErrorUsePageOf(UsuarioController.class).resetForm();

			// permite fazer login sem erros em sessão
			usuarioWeb.fazerLogin(usuarioValido);

		}

		// redirecionando para a index
		result.redirectTo(IndexController.class).index();

	}// fim login()

	// ação de sair do sistema
	@Path("/logout")
	public void logout() {

		// permite sair
		usuarioWeb.logout();

		// redirecionando para a página de login
		result.redirectTo(UsuarioController.class).loginForm();

	}// fim logout()

	// Acesso
	@Liberado
	@Get
	// método get
	@Path("/usuario/novo")
	// url de caminho
	// lógica de negócio
	public void novo() {
		// define título da página
		result.include("titulo", "Adicionar Usuários");

		// define atributo para a jsp
		// retorna uma lista de estados
		// result.include("estados", estadoApplication.listaTodosEstados());

	}// fim novo()

	@Liberado
	@Post
	// método post
	@Path("/usuario/adicionar")
	// url de caminho
	public void adicionar(Usuario usuario) {
		// define título da página
		result.include("titulo", "Adicionar Usuário");

		try {
			if (!usuarioApplication.validaUsuarioAdicionar(usuario)) {
				// processo salvar cliente
				usuarioApplication.salvaUsuario(usuario);
				result.include("sucesso_adicionado", "Usuario " + usuario.getNome() + " adicionado com sucesso!");
			}else{
				
			}
		} catch (Exception e) {
			// redireciona para a página novo() caso houver erro na validação
			validator.onErrorUsePageOf(this).novo();
		}

		// define atributo para a jsp
		// adicionado com sucesso

		// redirecionando para a página novo()
		result.redirectTo(this).novo();
	}// fim adicionar()

}// fim class UsuarioController
