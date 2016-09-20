//pacote
package br.com.foodzone.dao;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.foodzone.model.Estabelecimento;
import br.com.foodzone.model.Usuario;

/*
 Esta classe (UsuarioDao) anotada com @Component notifica para o Vraptor que o 
 framework se encarregará de gerenciar suas instâncias,isto é, ele criará uma instância
 e utilizará como argumento para o construtor controller.
 */

@Component
public class EstabelecimentoDao extends Dao<Estabelecimento>{
	public EstabelecimentoDao(Session session) {
		super(session);
	}



	// obj: retorna o número total de usuários no sistema
	public String numeroCadastro() {
		Criteria criteria = this.session.createCriteria(Estabelecimento.class);
		return ""+criteria.list().size();
	}// fim numeroUsuarios()

}// fim class UsuarioDao
