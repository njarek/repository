package bmptask;

import java.io.IOException;
import java.util.Map;

public enum ImageTransformerFactory {
	INSTANCE;

	public static ImageTransformer getOperation(String inputFile) throws IOException {
		byte[] bs = FileUtility.readFile(inputFile);
		Map<String, Integer> bmpHeaderValues = FileUtility.getHeaderValues(bs);

		int type = bmpHeaderValues.get("type");

		switch (type) {

		case 1:
			throw new RuntimeException("Not immplemeted");
		case 4:
			throw new RuntimeException("Not immplemeted");// return new
															// BmpOperation16Color();
		case 8:
			return new ImageTransformerBMP256Colors(bs, bmpHeaderValues);

		case 16:
			throw new RuntimeException("Not immplemeted");// return new
															// BmpOperation16Bit();
		case 24:
			throw new RuntimeException("Not immplemeted");// return new
															// BmpOperation24Bit();
		case 32:
			throw new RuntimeException("Not immplemeted");// return new
															// BmpOperation32Bit();
		}
		return null;

	}
}
