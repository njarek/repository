package db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AbstracEntityManager {
	protected static EntityManagerFactory emf;

	protected EntityManager em;

	protected static H2Db h2 = new H2Db();

	@BeforeClass
	public static void createEntityManagerFactory() {
		h2.startDb();
		emf = Persistence.createEntityManagerFactory("test");
	}

	@Before
	public void beginTransaction() {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		h2.populateDb();
	}

	@Test
	public void test() {
		Assert.assertNotNull(em);
	}

	@After
	public void rollbackTransaction() {
		if (em.getTransaction().isActive()) {
			em.getTransaction().rollback();
		}

		if (em.isOpen()) {
			em.close();
		}
		h2.cleanDb();
	}

	@AfterClass
	public static void closeEntityManagerFactory() {
		emf.close();
		h2.destroy();
	}
}
