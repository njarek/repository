package best.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import best.dao.AuthorDao;
import best.entities.AuthorsResult;

public class AuthorsDisplayerTest {

	private static AuthorDao authorsDao = Mockito.mock(AuthorDao.class);
	private static AuthorsDisplayer authorsDisplayer = new AuthorsDisplayerImpl();

	@BeforeClass
	public static void init() {
		Mockito.when(authorsDao.getAuthorsByCathegoryCount()).thenReturn(prepareResult());
		authorsDisplayer.setAuthorDao(authorsDao);
	}

	@Test
	public void testAuthorsToDisplay() {
		Set<DisplayedAuthor> autohrs = authorsDisplayer.getAuthorsToDisplay();
		Assert.assertEquals(getExpected(), autohrs);
	}

	private static List<AuthorsResult> prepareResult() {
		List<AuthorsResult> authorsResults = new ArrayList<AuthorsResult>();
		authorsResults.add(new AuthorsResult("autor 1", "cat1", new Integer(1)));
		authorsResults.add(new AuthorsResult("autor 1", "cat2", new Integer(2)));
		authorsResults.add(new AuthorsResult("autor 1", "cat3", new Integer(3)));
		authorsResults.add(new AuthorsResult("autor 1", "cat4", new Integer(4)));
		authorsResults.add(new AuthorsResult("autor 2", "cat1", new Integer(5)));
		authorsResults.add(new AuthorsResult("autor 2", "cat2", new Integer(6)));
		authorsResults.add(new AuthorsResult("autor 2", "cat3", new Integer(7)));
		authorsResults.add(new AuthorsResult("autor 2", "cat4", new Integer(8)));
		authorsResults.add(new AuthorsResult("autor 2", "cat5", new Integer(9)));
		return authorsResults;
	}

	private Set<DisplayedAuthor> getExpected() {
		Set<DisplayedAuthor> autohrs = new TreeSet<DisplayedAuthor>();
		List<CathegoryCounter> cathegoryCounters = new ArrayList<CathegoryCounter>();
		cathegoryCounters.add(new CathegoryCounter(new Integer(1), "cat1"));
		cathegoryCounters.add(new CathegoryCounter(new Integer(2), "cat2"));
		cathegoryCounters.add(new CathegoryCounter(new Integer(3), "cat3"));
		cathegoryCounters.add(new CathegoryCounter(new Integer(4), "cat4"));
		autohrs.add(new DisplayedAuthor("autor 1", cathegoryCounters));

		cathegoryCounters = new ArrayList<CathegoryCounter>();
		cathegoryCounters.add(new CathegoryCounter(new Integer(5), "cat1"));
		cathegoryCounters.add(new CathegoryCounter(new Integer(6), "cat2"));
		cathegoryCounters.add(new CathegoryCounter(new Integer(7), "cat3"));
		cathegoryCounters.add(new CathegoryCounter(new Integer(8), "cat4"));
		cathegoryCounters.add(new CathegoryCounter(new Integer(9), "cat5"));
		autohrs.add(new DisplayedAuthor("autor 2", cathegoryCounters));

		return autohrs;
	}
}
