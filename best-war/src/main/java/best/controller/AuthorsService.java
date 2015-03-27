package best.controller;

import java.io.Serializable;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import best.service.AuthorsDisplayer;
import best.service.DisplayedAuthor;

@ManagedBean(name = "authors")
@SessionScoped
public class AuthorsService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1191685067243358902L;

	private Set<DisplayedAuthor> auts;

	@EJB
	private AuthorsDisplayer authorsDisplayer;

	@PostConstruct
	public void init() {
		
		auts = authorsDisplayer.getAuthorsToDisplay();
		
		System.out.println(auts);
	}

	public Set<DisplayedAuthor> getAuts() {
		return auts;
	}

	public void setAuts(Set<DisplayedAuthor> auts) {
		this.auts = auts;
	}

}
