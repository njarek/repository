package best.dao;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import best.entities.AuthorsResult;
import db.AbstracEntityManager;

public class AuthorDaoTest extends AbstracEntityManager {

	private static AuthorDao authorDao = new AuthoDaoImpl();

	@Before
	public void init() {
		authorDao.setEntityManager(em);

	}

	@Test
	public void testAllAuthors() {
		Assert.assertNotNull(authorDao.getAllAuthors());
	}

	@Test
	public void testAuthorsByCathegoryCount() {
		List<AuthorsResult> authors = authorDao.getAuthorsByCathegoryCount();
		Assert.assertEquals(getAuthors(), authors);
	}

	@Test
	public void testEmptyResult() {
		h2.cleanDb();
		Assert.assertNotNull(authorDao.getAllAuthors());
		Assert.assertNotNull(authorDao.getAuthorsByCathegoryCount());
		Assert.assertEquals(0, authorDao.getAllAuthors().size());
	}

	private List<AuthorsResult> getAuthors() {
		List<AuthorsResult> authors = new ArrayList<AuthorsResult>();
		authors.add(new AuthorsResult("autor 1", "cat 1", new Integer("1")));
		authors.add(new AuthorsResult("autor 1", "cat 2", new Integer("1")));
		authors.add(new AuthorsResult("autor 1", "cat 3", new Integer("1")));

		authors.add(new AuthorsResult("autor 2", "cat 1", new Integer("1")));
		authors.add(new AuthorsResult("autor 2", "cat 3", new Integer("1")));
		authors.add(new AuthorsResult("autor 2", "cat 2", new Integer("2")));

		authors.add(new AuthorsResult("autor 3", "cat 1", new Integer("3")));
		authors.add(new AuthorsResult("autor 3", "cat 2", new Integer("1")));

		authors.add(new AuthorsResult("autor 4", "cat 2", new Integer("1")));
		authors.add(new AuthorsResult("autor 4", "cat 3", new Integer("1")));

		return authors;
	}

}
