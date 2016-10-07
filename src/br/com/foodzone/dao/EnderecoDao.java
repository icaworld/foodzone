//pacote
package br.com.foodzone.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.com.foodzone.model.Cidade;
import br.com.foodzone.model.Endereco;

/*
 Esta classe (UsuarioDao) anotada com @Component notifica para o Vraptor que o 
 framework se encarregará de gerenciar suas instâncias,isto é, ele criará uma instância
 e utilizará como argumento para o construtor controller.
 */

@Component
public class EnderecoDao extends Dao<Endereco>{
	public EnderecoDao(Session session) {
		super(session);
	}



	// obj: retorna o número total de usuários no sistema
	public String numeroCadastro() {
		Criteria criteria = this.session.createCriteria(Cidade.class);
		return ""+criteria.list().size();
	}// fim numeroUsuarios()

	@SuppressWarnings("unchecked")
	public List<Cidade> listAll() {
		Criteria criteria = this.session.createCriteria(Cidade.class);
		
		return criteria.list();
	}
}// fim class UsuarioDao
