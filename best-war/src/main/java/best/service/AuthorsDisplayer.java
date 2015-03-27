package best.service;

import java.util.Set;

import best.dao.AuthorDao;

public interface AuthorsDisplayer {

	Set<DisplayedAuthor> getAuthorsToDisplay();

	void setAuthorDao(AuthorDao authorsDao);
}
