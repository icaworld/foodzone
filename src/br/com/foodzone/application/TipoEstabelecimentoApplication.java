package br.com.foodzone.application;

import br.com.caelum.vraptor.ioc.Component;
import br.com.foodzone.dao.TipoEstabelecimentoDao;
import br.com.foodzone.model.TipoEstabelecimento;

@Component
public class TipoEstabelecimentoApplication {

	private TipoEstabelecimentoDao tipoEstabelecimentoDao;

	public TipoEstabelecimentoApplication() {
		tipoEstabelecimentoDao = new TipoEstabelecimentoDao(null);
	}


	public TipoEstabelecimento carregaTipoEstabelecimento(Integer idTipoEstabelecimento) {

		return tipoEstabelecimentoDao.carregar(idTipoEstabelecimento);
	}

	public void excluirTipoEstabelecimento(TipoEstabelecimento idTipoEstabelecimento) {
		tipoEstabelecimentoDao.deletar(idTipoEstabelecimento);
	}

	public void atualizaTipoEstabelecimento(TipoEstabelecimento tipoEstabelecimento) {
		tipoEstabelecimentoDao.atualizar(tipoEstabelecimento);

	}


	public boolean validaTipoEstabelecimentoEditar(TipoEstabelecimento tipoEstabelecimento) {

		return validaTipoEstabelecimentoEditar(tipoEstabelecimento);
	}

	public void salvaTipoEstabelecimento(TipoEstabelecimento tipoEstabelecimento) {

		tipoEstabelecimentoDao.adicionar(tipoEstabelecimento);
	}


	public String numeroTotalTipoEstabelecimentos(){
		
		return tipoEstabelecimentoDao.numeroCadastro();
	}
	
}
