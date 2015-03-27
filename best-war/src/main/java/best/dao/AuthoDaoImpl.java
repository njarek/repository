package best.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import best.entities.Author;
import best.entities.AuthorsResult;

@Stateless
public class AuthoDaoImpl implements AuthorDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void setEntityManager(EntityManager em) {
		this.em = em;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AuthorsResult> getAuthorsByCathegoryCount() {
		Query query = em
				.createQuery("SELECT NEW best.entities.AuthorsResult(a.name,c.name, count(b)) FROM Author a  join a.books b  JOIN b.cathegory c group by a.name,c.name order by a.name ");
		return query.getResultList().isEmpty() ? new ArrayList<AuthorsResult>() : query.getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Author> getAllAuthors() {
		Query query = em.createQuery("SELECT a FROM Author a");
		return query.getResultList().isEmpty() ? new ArrayList<AuthorsResult>() : query.getResultList();
	}

}
