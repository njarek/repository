package bmptask;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Arrays;

import org.junit.Test;

public class ImageTransformerBMP256ColorsTest {

	private static final String EXPECTED = "cos180.bmp";
	private static final String TARGET_FILE_BMP = "target-file.bmp";
	private static final String TO_ROATATE = "cos.bmp";

	@Test
	public void rotateTest() throws IOException {

		// given
		byte[] expected = FileUtility.readFile(EXPECTED);

		ImageTransformer bmpOperation = ImageTransformerFactory.getOperation(TO_ROATATE);

		// when
		bmpOperation.rotate(TARGET_FILE_BMP);

		// then
		byte[] actual = FileUtility.readFile(TARGET_FILE_BMP);

		assertTrue(Arrays.equals(expected, actual));

	}
}
