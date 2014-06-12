package pl.store.domain;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "lifecycle")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "LIFECYCLE")
public class LifeCycleState {

	@XmlAttribute(required = true)
	private int id;
	@XmlElement(required = true)
	private String lifecycle;

	private long version;

	@XmlElement(required = true)
	private Basket basket;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "l_id", unique = true, nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "l_lifecycle")
	public String getLifecycle() {
		return lifecycle;
	}

	@SuppressWarnings("unused")
	private void setLifecycle(String lifecycle) {
		this.lifecycle = lifecycle;
	}

	public void setLifecycleEnum(LifeCycleEnum lifecycleEnum) {
		this.lifecycle = lifecycleEnum.getLifecycle();
	}

	@Version
	@Column(name = "l_version")
	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	@OneToOne
	@JoinColumn(name = "b_id")
	public Basket getBasket() {
		return basket;
	}

	public void setBasket(Basket basket) {
		this.basket = basket;
	}

	@Override
	public String toString() {
		return "LifeCycle [id=" + id + ", lifecycle=" + lifecycle + ", version=" + version + "]";
	}

}
