package testUtility;

public enum ExampleMessages {

	MESSAGE_OK(
			"<?xml version=\"1.0\" encoding=\"UTF-8\"?><tns:tesco xmlns:tns=\"http://www.example.org/main\" xmlns:tns1=\"http://www.example.org/tesco\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.example.org/main main.xsd \"><tns:buyerDetails id=\"0\"><tns1:contracting>smallStore</tns1:contracting><tns1:tradeDate>2001-01-01</tns1:tradeDate></tns:buyerDetails><tns:orderDetails id=\"0\"><tns1:name>tv</tns1:name><tns1:type>RTV</tns1:type><tns1:quatity>5</tns1:quatity><tns1:price>200.0</tns1:price></tns:orderDetails><tns:deliveryPriorytet>Low</tns:deliveryPriorytet></tns:tesco>"), 
	BAD_MESSAGE(
			"<?xml version=\"1.0\" encoding=\"UTF-8\"?><tns:tesco xmlns:tns=\"http://www.example.org/main\" xmlns:tns1=\"http://www.example.org/tesco\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.example.org/main main.xsd \"><tns:buyerDetails id=\"0\"><tns1:contracting>smallStore</tns1:contracting><tns1:tradeDate>2001-01-01</tns1:tradeDate></tns:buyerDetails><tns:orderDetails id=\"0\"><tns1:name>tv</tns1:name><tns1:type>RTc</tns1:type><tns1:quatity>5</tns1:quatity><tns1:price>200.0</tns1:price></tns:orderDetails><tns:deliveryPriorytet>Low</tns:deliveryPriorytet></tns:tesco>");

	private String message;

	private ExampleMessages(String message) {
		this.message=message;
	}

	public String getMessage() {
		return message;
	}
}
