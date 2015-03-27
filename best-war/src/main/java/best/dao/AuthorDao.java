package best.dao;

import java.util.List;

import javax.persistence.EntityManager;

import best.entities.Author;
import best.entities.AuthorsResult;

public interface AuthorDao {

	void setEntityManager(EntityManager em);

	List<AuthorsResult> getAuthorsByCathegoryCount();

	List<Author> getAllAuthors();
}
