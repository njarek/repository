package bmptask;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;

public class FileReader {

	public byte[] readFile(String path) throws IOException {

		File file = new File(path);
		byte[] fileData = new byte[(int) file.length()];
		DataInputStream dis = new DataInputStream(new FileInputStream(file));
		dis.readFully(fileData);
		dis.close();
		return fileData;

	}

	public byte[] rotate(byte[] picuture) {
		byte[] bmp = picuture;
		Map<String, Integer> map = getHeaderValues(bmp);
		int bfOffBits = map.get("bfOffBits");
		int height = map.get("height");
		int widith = map.get("widith");
		int size = map.get("size");

		int newSize = height * widith;
		//System.out.println("elo" + height * widith);

		byte[] picture2 = Arrays.copyOfRange(picuture, bfOffBits, picuture.length);
		
//		System.out.println(Arrays.toString(picture2));

		byte[] reversePicture = new byte[picture2.length];

		int y = picture2.length - 1;
		for (byte s : picture2) {
			reversePicture[y] = s;
			y--;
		}
		
//		System.out.println(Arrays.toString(reversePicture));

		int b = picture2.length - 1;
		int c = bfOffBits;

		byte[] revertedPicutre = bmp;
		for (int i = 0; i < picture2.length; i++) {
			revertedPicutre[c] = reversePicture[i];
			c++;
		}

		return revertedPicutre;
	}

	public static void main(String[] args) throws IOException {
		FileReader fileReader = new FileReader();
		byte[] cos = fileReader.readFile("cos5.bmp");

		int i = 0;
		for (byte a : cos) {
			System.out.print(a + "_" + i + " ");
			i++;
		}

		byte[] cos180 = fileReader.readFile("cos5180.bmp");
		System.out.println();
		i = 0;
		for (byte a : cos180) {
			System.out.print(a + "_" + i + " ");
			i++;
		}

		System.out.println();
		cos = fileReader.rotate(cos);
		FileOutputStream output = new FileOutputStream(new File("target-file.bmp"));
		IOUtils.write(cos, output);

		i = 0;
		for (byte a : cos) {
			System.out.print(a + "_" + i + " ");
			i++;
		}
		System.out.println();
		System.out.println(fileReader.getHeaderValues(cos).get("size") + " " + fileReader.getHeaderValues(cos).get("bfOffBits") + " "
				+ fileReader.getHeaderValues(cos).get("height") + " "+fileReader.getHeaderValues(cos).get("widith"));
		
		System.out.println(6%4);
		System.out.println(2%4);
		System.out.println(16%4);

	}

	private Map<String, Integer> getHeaderValues(byte[] cos) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		int bfOffBits = (((int) cos[13] & 0xff) << 24) | (((int) cos[12] & 0xff) << 16) | (((int) cos[11] & 0xff) << 8) | (int) cos[10] & 0xff;
		//System.out.println("bfOffBits is :" + bfOffBits);

		int height = (((int) cos[25] & 0xff) << 24) | (((int) cos[24] & 0xff) << 16) | (((int) cos[23] & 0xff) << 8) | (int) cos[22] & 0xff;
		// System.out.println("height is :" + height);

		int widith = (((int) cos[21] & 0xff) << 24) | (((int) cos[20] & 0xff) << 16) | (((int) cos[19] & 0xff) << 8) | (int) cos[18] & 0xff;
		// System.out.println("widith is :" + widith);
		int size = (((int) cos[37] & 0xff) << 24) | (((int) cos[36] & 0xff) << 16) | (((int) cos[35] & 0xff) << 8) | (int) cos[34] & 0xff;
		//System.out.println(size);
		map.put("bfOffBits", bfOffBits);
		map.put("height", height);
		map.put("widith", widith);
		map.put("size", size);
		return map;
	}

}