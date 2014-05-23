package pl.jojco.pojo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Pojo")
public class Pojo {

	private int id;
	private String name;
	private int number;

	public int getId() {
		return id;
	}

	@XmlAttribute
	private void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Pojo [id=" + id + ", name=" + name + ", number=" + number + "]";
	}

}
