package best.entities;


public class AuthorsResult {

	private String name;
	private String cathegory;
	private Integer count;

	public AuthorsResult(String name, String cathegory, Object count) {
		super();
		this.name = name;
		this.cathegory = cathegory;
		this.count = new Integer(count.toString());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCathegory() {
		return cathegory;
	}

	public void setCathegory(String cathegory) {
		this.cathegory = cathegory;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "DisplayAuthor [name=" + name + ", cathegory=" + cathegory + ", count=" + count + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cathegory == null) ? 0 : cathegory.hashCode());
		result = prime * result + ((count == null) ? 0 : count.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AuthorsResult other = (AuthorsResult) obj;
		if (cathegory == null) {
			if (other.cathegory != null)
				return false;
		} else if (!cathegory.equals(other.cathegory))
			return false;
		if (count == null) {
			if (other.count != null)
				return false;
		} else if (!count.equals(other.count))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
