//pacote
package br.com.foodzone.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.com.foodzone.model.Indicador;
import br.com.foodzone.model.TipoEstabelecimento;

/*
 Esta classe (UsuarioDao) anotada com @Component notifica para o Vraptor que o 
 framework se encarregará de gerenciar suas instâncias,isto é, ele criará uma instância
 e utilizará como argumento para o construtor controller.
 */

@Component
public class IndicadorDao extends Dao<Indicador>{
	public IndicadorDao(Session session) {
		super(session);
	}



	// obj: retorna o número total de usuários no sistema
	public String numeroCadastro() {
		Criteria criteria = this.session.createCriteria(Indicador.class);
		return ""+criteria.list().size();
	}// fim numeroUsuarios()

}// fim class UsuarioDao
