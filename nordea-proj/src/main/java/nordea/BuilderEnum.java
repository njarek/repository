package nordea;

public enum BuilderEnum {

	XML("1"), CSV("2");

	private String builder;

	private BuilderEnum(String builder) {
		this.builder = builder;
	}

	public String getBuilder() {
		return builder;
	}

	public void setBuilder(String builder) {
		this.builder = builder;
	}

	public static BuilderEnum getBuilderEnum(String value) {
		switch (value) {
		case "2":
			return CSV;
		default:
			return XML;
		}
	}
}
