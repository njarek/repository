package best.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Author {

	private int id;
	private String name;
	private List<Book> books;

	public Author() {

	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "a_id", unique = true, nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "a_name", nullable = false, length = 20)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToMany
	@JoinTable(name = "author_book", joinColumns = { @JoinColumn(name = "a_id", referencedColumnName = "a_id") }, inverseJoinColumns = { @JoinColumn(name = "b_id", referencedColumnName = "b_id") })
	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Author [a_id=" + id + ", a_name=" + name + ", books=" + books + "]";
	}

}
