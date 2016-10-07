package br.com.foodzone.application;

import br.com.caelum.vraptor.ioc.Component;
import br.com.foodzone.dao.EnderecoDao;
import br.com.foodzone.dao.EstabelecimentoDao;
import br.com.foodzone.model.Estabelecimento;

@Component
public class EstabelecimentoApplication {

	private EstabelecimentoDao estabelecimentoDao;
	private EnderecoDao enderecoDao;

	
	public EstabelecimentoApplication() {
		estabelecimentoDao = new EstabelecimentoDao(null);
		enderecoDao = new EnderecoDao(null);
	}


	public Estabelecimento carregaEstabelecimento(Integer idEstabelecimento) {

		return estabelecimentoDao.carregar(idEstabelecimento);
	}

	public void excluirEstabelecimento(Estabelecimento idEstabelecimento) {
		estabelecimentoDao.deletar(idEstabelecimento);
	}

	public void atualizaEstabelecimento(Estabelecimento estabelecimento) {
		estabelecimentoDao.atualizar(estabelecimento);

	}


	public boolean validaEstabelecimentoEditar(Estabelecimento estabelecimento) {

		return validaEstabelecimentoEditar(estabelecimento);
	}

	public void salvaEstabelecimento(Estabelecimento estabelecimento) {
		estabelecimentoDao.adicionar(estabelecimento);
	}


	public String numeroTotalEstabelecimentos(){
		
		return estabelecimentoDao.numeroCadastro();
	}
	
}
