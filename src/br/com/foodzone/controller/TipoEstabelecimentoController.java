package br.com.foodzone.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.foodzone.application.TipoEstabelecimentoApplication;
import br.com.foodzone.model.TipoEstabelecimento;
import br.com.foodzone.model.UsuarioWeb;


/*Classe controladora TipoEstabelecimentoController contém 
 as regras de negócio, com anotação @Resource para o
 Vraptor saber que essa classe é um controller*/

@Resource
public class TipoEstabelecimentoController {

	private UsuarioWeb usuarioWeb;// mantem o estado do usuário
	private Result result; // mostra resultados
	private Validator validator; // validação
	private TipoEstabelecimentoApplication tipoEstabelecimentoApplication; // usuário app

	// ...
	public TipoEstabelecimentoController(Validator validator, UsuarioWeb usuarioWeb,
			TipoEstabelecimentoApplication tipoEstabelecimentoApplication, Result result) {

		this.result = result;
		this.validator = validator;
		this.usuarioWeb = usuarioWeb;
		this.tipoEstabelecimentoApplication = tipoEstabelecimentoApplication;

	}// fim do construtor

	// Acesso
	@Get
	// método get
	@Path("/tipoEstabelecimento/novo")
	// url de caminho
	// lógica de negócio
	public void novo() {
		// define título da página
		result.include("titulo", "Adicionar Tipo de Estabelecimento");

		// define atributo para a jsp
		// retorna uma lista de estados
//		result.include("estados", estadoApplication.listaTodosEstados());

	}// fim novo()


	@Post
	// método post
	@Path("/tipoEstabelecimento/adicionar")
	// url de caminho
	public void adicionar(TipoEstabelecimento tipoEstabelecimento) {

		// define título da página
		result.include("titulo", "Adicionar Usuário");

		try {
//			if(tipoEstabelecimentoApplication.validaTipoEstabelecimentoAdicionar(tipoEstabelecimento)){
			// processo salvar cliente
			tipoEstabelecimentoApplication.salvaTipoEstabelecimento(tipoEstabelecimento);
			
			
		} catch (Exception e) {
			// redireciona para a página novo() caso houver erro na validação
			validator.onErrorUsePageOf(this).novo();
		}
		
		// define atributo para a jsp
		// adicionado com sucesso
		result.include("sucesso_adicionado", "TipoEstabelecimento " + tipoEstabelecimento.getNome()
				+ " adicionado com sucesso!");

		// redirecionando para a página novo()
		result.redirectTo(this).novo();
	}// fim adicionar()


}// fim class TipoEstabelecimentoController
