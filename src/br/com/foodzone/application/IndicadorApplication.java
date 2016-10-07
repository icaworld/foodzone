package br.com.foodzone.application;

import br.com.caelum.vraptor.ioc.Component;
import br.com.foodzone.dao.IndicadorDao;
import br.com.foodzone.model.Indicador;

@Component
public class IndicadorApplication {

	private IndicadorDao indicadorDao;

	public IndicadorApplication() {
		indicadorDao = new IndicadorDao(null);
	}


	public Indicador carregaIndicador(Integer idIndicador) {

		return indicadorDao.carregar(idIndicador);
	}

	public void excluirIndicador(Indicador idIndicador) {
		indicadorDao.deletar(idIndicador);
	}

	public void atualizaIndicador(Indicador indicador) {
		indicadorDao.atualizar(indicador);

	}


	public boolean validaIndicadorEditar(Indicador indicador) {

		return validaIndicadorEditar(indicador);
	}

	public void salvaIndicador(Indicador indicador) {

		indicadorDao.adicionar(indicador);
	}


	public String numeroTotalIndicadors(){
		
		return indicadorDao.numeroCadastro();
	}


	public boolean validaIndicadorAdicionar(Indicador indicador) {
		return indicadorDao.validaIndicadorAdicionar(indicador);
		
	}
	
}
