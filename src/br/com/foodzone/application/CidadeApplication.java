package br.com.foodzone.application;

import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.com.foodzone.dao.CidadeDao;
import br.com.foodzone.model.Cidade;

@Component
public class CidadeApplication {

	private CidadeDao cidadeDao;

	public CidadeApplication() {
		cidadeDao = new CidadeDao(null);
	}


	public Cidade carregaCidade(Integer idCidade) {

		return cidadeDao.carregar(idCidade);
	}

	public void excluirCidade(Cidade idCidade) {
		cidadeDao.deletar(idCidade);
	}

	public void atualizaCidade(Cidade cidade) {
		cidadeDao.atualizar(cidade);

	}


	public boolean validaCidadeEditar(Cidade cidade) {

		return validaCidadeEditar(cidade);
	}

	public void salvaCidade(Cidade cidade) {

		cidadeDao.adicionar(cidade);
	}


	public String numeroTotalCidades(){
		
		return cidadeDao.numeroCadastro();
	}
	public List<Cidade> listAll(){
		
		return cidadeDao.listAll();
	}
	
}
