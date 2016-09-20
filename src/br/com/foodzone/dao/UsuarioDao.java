//pacote
package br.com.foodzone.dao;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.foodzone.model.Usuario;

/*
 Esta classe (UsuarioDao) anotada com @Component notifica para o Vraptor que o 
 framework se encarregará de gerenciar suas instâncias,isto é, ele criará uma instância
 e utilizará como argumento para o construtor controller.
 */

@Component
public class UsuarioDao extends Dao<Usuario> {
	public UsuarioDao(Session session) {
		super(session);
	}

	// variável gerenciador de entidades
	EntityManager gerenciadorEntidades;

	// obj: verificar se já existe nome de usuário
	// Tem diferenciação de (A) para (a) ao validar
	// validação de usuário, se nome de usuário já existe ou não
	public boolean validaUsuarioAdicionar(Usuario usuario) {

		Criteria criteria = this.session.createCriteria(Usuario.class);
		criteria.add(Restrictions.eq("nome", usuario.getNome()));
		criteria.list();
		if (!criteria.list().isEmpty()) {
			return true;// usuário já registrado
		} // fim if

		// fecha conexão
		// gerenciadorEntidades.close();

		return false;// usuário não registrado

	}// fim validaUsuario()



	// obj: carrega usuário, com new senha
	public Usuario carregaUsuarioBySenha(Usuario usuario) {
		Criteria criteria = this.session.createCriteria(Usuario.class);
		criteria.add(Restrictions.eq("senha", usuario.getSenha()));
		criteria.add(Restrictions.eq("nome", usuario.getNome()));
		return (Usuario) criteria.uniqueResult();
	}
		public Usuario carregaUsuarioNewSenha(Usuario usuario) {

		Criteria criteria = this.session.createCriteria(Usuario.class);
		criteria.add(Restrictions.eq("pergunta", usuario.getPergunta()));
		criteria.add(Restrictions.eq("email", usuario.getEmail()));
		criteria.add(Restrictions.eq("tipo_pergunta", usuario.getTipoPergunta()));

		// verifica se a lista não está vazia
		if (!criteria.list().isEmpty()) {

			// existe
			// carrega usuário
			usuario = (Usuario) criteria.list().get(0);

		} else {

			// não existe
			// carrega com null
			usuario = null;
		}

		// retorna usuário
		return usuario;

	}// fim carregaUsuario()

	// obj: retorna o número total de usuários no sistema
	public String numeroUsuarios() {
		Criteria criteria = this.session.createCriteria(Usuario.class);
		return ""+criteria.list().size();
	}// fim numeroUsuarios()

}// fim class UsuarioDao
