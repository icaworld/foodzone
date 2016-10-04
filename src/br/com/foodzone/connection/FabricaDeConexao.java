// pacote
package br.com.foodzone.connection;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

// import's

/* A classe estática ConnectionFactory responsável por invocar as métodos com as 
 conexões com os bancos de dados, tanto com o mysql quanto o do postgres
 */

public class FabricaDeConexao {

	// variáveis de fábricas de gerenciador de entidades
	private static EntityManagerFactory fabricaMysql = null,
			fabricaPostgres = null;

	private FabricaDeConexao() {

	}// fim construtor padrão

	/*
	 * Recupera gerenciador de entidades com conexão com o banco de dado mysql
	 */

	public static Session getSession() {
	     AnnotationConfiguration configuration = new AnnotationConfiguration();
	     configuration.configure();
	 
	     SessionFactory factory = configuration.buildSessionFactory();
	     Session session = factory.openSession();
	     return session;
	   }

	public static EntityManagerFactory getFabricaPostgres() {
		return fabricaPostgres;
	}

	public static void setFabricaPostgres(EntityManagerFactory fabricaPostgres) {
		FabricaDeConexao.fabricaPostgres = fabricaPostgres;
	}

	 

}// fim class ConnectionFactory
