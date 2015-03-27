package best.service;

import java.util.Set;
import java.util.TreeSet;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import best.dao.AuthorDao;
import best.entities.AuthorsResult;

@Stateless
public class AuthorsDisplayerImpl implements AuthorsDisplayer {

	@EJB
	private AuthorDao authorDao;
	
	private Set<DisplayedAuthor> auts = new TreeSet<DisplayedAuthor>();

	@Override
	public Set<DisplayedAuthor> getAuthorsToDisplay() {
		String previousAuthorName = "";
		DisplayedAuthor previousAuthor = new DisplayedAuthor();
		for (AuthorsResult authorsResult :  authorDao.getAuthorsByCathegoryCount()) {
			previousAuthor = createOrUpdate(previousAuthorName, previousAuthor, authorsResult);
			previousAuthorName = authorsResult.getName();
		}
		auts.add(previousAuthor);
		return auts;
	}

	private DisplayedAuthor createOrUpdate(String previousAuthorName, DisplayedAuthor previousAuthor, AuthorsResult authorsResult) {
		if (authorsResult.getName().equals(previousAuthorName)) {
			previousAuthor.getCathegoryCounters().add(new CathegoryCounter(authorsResult.getCount(), authorsResult.getCathegory()));

		} else {
			addPrevious(previousAuthor);
			previousAuthor = createNew(authorsResult, authorsResult.getName());
		}
		return previousAuthor;
	}

	private void addPrevious(DisplayedAuthor previousAuthor) {
		if (!previousAuthor.getName().isEmpty()) {
			auts.add(previousAuthor);
		}
	}

	private DisplayedAuthor createNew(AuthorsResult authorsResult, String name) {
		DisplayedAuthor newAuthor = new DisplayedAuthor(name);
		newAuthor.getCathegoryCounters().add(new CathegoryCounter(authorsResult.getCount(), authorsResult.getCathegory()));
		return newAuthor;
	}

	@Override
	public void setAuthorDao(AuthorDao authorsDao) {
		this.authorDao = authorsDao;

	}

}
