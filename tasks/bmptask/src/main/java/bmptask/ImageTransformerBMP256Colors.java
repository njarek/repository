package bmptask;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

public class ImageTransformerBMP256Colors implements ImageTransformer {

	private byte[] bmpPicture;
	private Map<String, Integer> headrValues;

	public ImageTransformerBMP256Colors(byte[] bs, Map<String, Integer> bmpHeaderValues) {
		this.bmpPicture = bs;
		this.headrValues = bmpHeaderValues;
	}

	public void rotate(String output) throws FileNotFoundException, IOException {
		byte[] bmp = bmpPicture;
		int bfOffBits = headrValues.get("bfOffBits");
		int height = headrValues.get("height");
		int widith = headrValues.get("widith");
		int size = headrValues.get("size");
		int newWidith = size / height;

		byte[] picture2 = Arrays.copyOfRange(bmp, bfOffBits, bfOffBits + size);
		byte[] reversePixelArray = new byte[picture2.length];

		reversePixelArray(height, widith, newWidith, picture2, reversePixelArray);

		byte[] revertedPicutre = bmp;
		reversePicture(bfOffBits, reversePixelArray, revertedPicutre);

		FileUtility.writeFile(revertedPicutre, output);
	}

	private void reversePixelArray(int height, int widith, int newWidith, byte[] picture2, byte[] reversePicture) {
		int o = 0;
		for (int y = height; 0 < y; y--) {
			byte[] temp = Arrays.copyOfRange(picture2, (y - 1) * newWidith, (y * newWidith));
			byte[] temp2 = Arrays.copyOfRange(temp, 0, widith);

			for (int i = 0; i < temp2.length / 2; i++) {
				byte tempInt = temp2[i];
				temp[i] = temp2[temp2.length - i - 1];
				temp[temp2.length - i - 1] = tempInt;
			}

			System.arraycopy(temp, 0, reversePicture, o * newWidith, newWidith);

			o++;

		}
	}

	private void reversePicture(int bfOffBits, byte[] reversePixelArray, byte[] revertedPicutre) {
		int c = bfOffBits;

		for (int i = 0; i < reversePixelArray.length; i++) {
			revertedPicutre[c] = reversePixelArray[i];
			c++;
		}
	}

}
