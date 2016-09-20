// pacote
package br.com.foodzone.dao;

// import
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.foodzone.connection.FabricaDeConexao;

/*
 clazz abstract Dao
 */

public abstract class Dao<T> {
	public Class getClazz() {
		return clazz;
	}

	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	private Class clazz;
	protected Session session;

	public Dao(Session session) {
		this.session = (Session) FabricaDeConexao.getInstanciaConexaoMysql().getDelegate();
	}

	// método adiciona
	public void adicionar(T objeto) {
		try {
			this.session.beginTransaction();
			this.session.save(objeto);
			this.session.close();
		} catch (Exception e) {

			// transação ocorreu erro
			this.session.getTransaction().rollback();
			// mostra erro
			e.printStackTrace();
		}
	}

	// método exluir
	public void deletar(T objeto) {
		try {
			this.session.delete(objeto);
			this.session.close();
		} catch (Exception e) {

			// transação ocorreu erro
			this.session.getTransaction().rollback();
			// mostra erro
			e.printStackTrace();
		}

	}

	// método atualiza
	public void atualizar(T objeto) {
		try {
			Transaction ts = session.beginTransaction();
			session.update(objeto);
			ts.commit();
		} catch (Exception e) {

			// transação ocorreu erro
			this.session.getTransaction().rollback();
			// mostra erro
			e.printStackTrace();
		}

	}


	// método carrega objeto
	public T carregar(Integer id) {
		return (T) session.load(clazz, id);
	}

}// fim class Dao
