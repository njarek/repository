package nordea;

public class BuilderFactory {

	private Builder xmlBuilder;
	private Builder csvBuilder;

	public Builder getBuilder(BuilderEnum builderEnum) {
		if (BuilderEnum.XML == builderEnum) {
			return xmlBuilder;
		} else {
			return csvBuilder;
		}

	}

	public void setXmlBuilder(Builder xmlBuilder) {
		this.xmlBuilder = xmlBuilder;
	}

	public void setCsvBuilder(Builder csvBuilder) {
		this.csvBuilder = csvBuilder;
	}

}
