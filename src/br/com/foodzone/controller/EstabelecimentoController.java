package br.com.foodzone.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.foodzone.application.CidadeApplication;
import br.com.foodzone.application.EstabelecimentoApplication;
import br.com.foodzone.model.Cidade;
import br.com.foodzone.model.Estabelecimento;
import br.com.foodzone.model.UsuarioWeb;


/*Classe controladora EstabelecimentoController contém 
 as regras de negócio, com anotação @Resource para o
 Vraptor saber que essa classe é um controller*/

@Resource
public class EstabelecimentoController {

	private UsuarioWeb usuarioWeb;// mantem o estado do usuário
	private Result result; // mostra resultados
	private Validator validator; // validação
	private EstabelecimentoApplication estabelecimentoApplication; // usuário app
	private CidadeApplication cidadeApplication; // usuário app
	// ...
	public EstabelecimentoController(Validator validator, UsuarioWeb usuarioWeb,
			EstabelecimentoApplication estabelecimentoApplication, 
			CidadeApplication cidadeApplication, Result result) {

		this.result = result;
		this.validator = validator;
		this.usuarioWeb = usuarioWeb;
		this.estabelecimentoApplication = estabelecimentoApplication;
		this.cidadeApplication = cidadeApplication;

	}// fim do construtor

	// Acesso
	@Get
	// método get
	@Path("/estabelecimento/novo")
	// url de caminho
	// lógica de negócio
	public void novo() {
		// define título da página
		result.include("titulo", "Adicionar Estabelecimento");
		result.include("cidades",this.cidadeApplication.listAll());
	}// fim novo()


	@Post
	// método post
	@Path("/estabelecimento/adicionar")
	// url de caminho
	public void adicionar(Estabelecimento estabelecimento) {
		// define título da página
		result.include("titulo", "Adicionar Estabelecimento");

		try {
//			if(estabelecimentoApplication.validaEstabelecimentoAdicionar(estabelecimento)){
			// processo salvar cliente
			estabelecimentoApplication.salvaEstabelecimento(estabelecimento);
			
			
		} catch (Exception e) {
			// redireciona para a página novo() caso houver erro na validação
			validator.onErrorUsePageOf(this).novo();
		}
		
		// define atributo para a jsp
		// adicionado com sucesso
		result.include("sucesso_adicionado", "Estabelecimento " + estabelecimento.getNome()
				+ " adicionado com sucesso!");

		// redirecionando para a página novo()
		result.redirectTo(this).novo();
	}// fim adicionar()


}// fim class EstabelecimentoController
