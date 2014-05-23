package bmptask;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		String inputFile = null;
		String outputFile = null;
		if (args.length > 0 && args[0] != null && args[1] != null) {
			inputFile = args[0];
			outputFile = args[1];
		} else {
			System.out.println("Please provide name of bmp file to rotate");
			System.out.println("and name of output file");
			System.exit(0);
		}

		try {
			System.out.println("Start transforming");
			ImageTransformer bmpOperation = ImageTransformerFactory.getOperation(inputFile);
			bmpOperation.rotate(outputFile);
			System.out.println("Transforming finished");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
