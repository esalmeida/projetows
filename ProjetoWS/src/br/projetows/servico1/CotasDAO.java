package br.projetows.servico1;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;


public class CotasDAO {
	Logger logger = Logger.getLogger(CotasDAO.class);

	public String cadastra(Cotas c) {

		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>inicializando o procedimento cadastra");
		String codigoRetorno = "";
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("cnscotas");
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			em.persist(c);
			em.getTransaction().commit();
			em.close();
			codigoRetorno = "Cadastro realizado com sucesso";
		} catch (PersistenceException exception) { // HibernateException
			codigoRetorno = "Erro no cadastro";
			logger.info("disparou um erro na transacao de persistencia do tipo PersistenceException = " + exception.toString());
			logger.info(exception.getMessage());
		}
		return codigoRetorno;
	}
	public Cotas consulta(Cotas c) {
		
		logger.info("inicializando o procedimento de consulta cotas");
		Cotas cotas = null;

		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("cnscotas");
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			cotas = em.find(Cotas.class, c.getInscricao_nacional());
			em.getTransaction().commit();
		} catch (PersistenceException exception) {
			logger.info("disparou um erro na transacao de persistencia do tipo PersistenceException = " + exception.toString());
			logger.info(exception.getMessage());
		}
		return cotas;
	}
	public int exclui(String inscricao_nacional) {

		logger.info("inicializando o procedimento de exclusao de cota");
		int codigoRetorno = 0;
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("cnscotas");
			EntityManager em = factory.createEntityManager();

			String jpql = " DELETE FROM Cotas c WHERE c.inscricao_nacional = :inscricao_nacional";
			em.getTransaction().begin();
			Query query = em.createQuery(jpql);
			query.setParameter("inscricao_nacional", inscricao_nacional);
			codigoRetorno = query.executeUpdate();
			logger.info(" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>resultado da query exclui cnpj ="+ inscricao_nacional + " e codigoRetorno =" + codigoRetorno + " excluido");
			em.getTransaction().commit();
		} catch (HibernateException exception) {
			exception.printStackTrace();
		}
		return codigoRetorno;
	}
}

