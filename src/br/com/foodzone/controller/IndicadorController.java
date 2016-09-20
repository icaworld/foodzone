package br.com.foodzone.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.foodzone.application.IndicadorApplication;
import br.com.foodzone.model.Indicador;
import br.com.foodzone.model.UsuarioWeb;


/*Classe controladora IndicadorController contém 
 as regras de negócio, com anotação @Resource para o
 Vraptor saber que essa classe é um controller*/

@Resource
public class IndicadorController {

	private UsuarioWeb usuarioWeb;// mantem o estado do usuário
	private Result result; // mostra resultados
	private Validator validator; // validação
	private IndicadorApplication indicadorApplication; // usuário app

	// ...
	public IndicadorController(Validator validator, UsuarioWeb usuarioWeb,
			IndicadorApplication indicadorApplication, Result result) {

		this.result = result;
		this.validator = validator;
		this.usuarioWeb = usuarioWeb;
		this.indicadorApplication = indicadorApplication;

	}// fim do construtor

	// Acesso
	@Get
	// método get
	@Path("/indicador/novo")
	// url de caminho
	// lógica de negócio
	public void novo() {
		// define título da página
		result.include("titulo", "Adicionar de Indicador");

		// define atributo para a jsp
		// retorna uma lista de estados
//		result.include("estados", estadoApplication.listaTodosEstados());

	}// fim novo()


	@Post
	// método post
	@Path("/indicador/adicionar")
	// url de caminho
	public void adicionar(Indicador indicador) {

		System.out.println("-----------------------"+ indicador.getDataInatividade());
		// define título da página
		result.include("titulo", "Adicionar Usuário");

		try {
//			if(indicadorApplication.validaIndicadorAdicionar(indicador)){
			// processo salvar cliente
			indicadorApplication.salvaIndicador(indicador);
			
			
		} catch (Exception e) {
			// redireciona para a página novo() caso houver erro na validação
			validator.onErrorUsePageOf(this).novo();
		}
		
		// define atributo para a jsp
		// adicionado com sucesso
		result.include("sucesso_adicionado", "Indicador " + indicador.getNome()
				+ " adicionado com sucesso!");

		// redirecionando para a página novo()
		result.redirectTo(this).novo();
	}// fim adicionar()


}// fim class IndicadorController
