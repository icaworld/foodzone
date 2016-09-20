//pacote
package br.com.foodzone.controller;

//import's
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.foodzone.application.UsuarioApplication;
import br.com.foodzone.intercepts.Liberado;

/* Classe controladora IndexController contém 
 as regras de negócio, com anotação @Resource para o
 Vraptor saber que essa classe é um controller
 */

@Resource
public class IndexController {

	Result result; // mostra resultados
	UsuarioApplication usuarioApplication;

	/*
	 * Injetando dependências no controller IndexController inicializando, o
	 * controller se encarregara de instânciar para nós o que precisamos
	 * simplesmente declarando no parâmetro do construtor
	 */

	public IndexController(Result result, UsuarioApplication usuarioApplication) {

		this.result = result;
		this.usuarioApplication = usuarioApplication;
	}// fim do contrutor

	// Acesso
	@Liberado
	// tipo de requisição
	@Get
	// caminho da requição
	@Path("/")
	public void index() {

		// define título da página
		result.include("titulo", "Sistema FoodZone");

		// define atributo para a jsp
		// Numero total de usuários
		result.include("numeroUsuarios", usuarioApplication.numeroTotalUsuarios());

	}// fim index()

}// fim class IndexController
