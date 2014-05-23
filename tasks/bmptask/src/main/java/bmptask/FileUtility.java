package bmptask;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;

import com.google.common.io.ByteStreams;

public enum FileUtility {

	INSTANCE;

	public static byte[] readFile(String path) throws IOException {

		File file = new File(path);
		byte[] fileData = new byte[(int) file.length()];
		DataInputStream dis = new DataInputStream(new FileInputStream(file));
		dis.readFully(fileData);
		dis.close();
		return fileData;

	}

	public static byte[] readClasspathFile(String path) throws IOException {

		InputStream in = FileUtility.class.getClassLoader().getResourceAsStream(path);
		byte[] fileData = ByteStreams.toByteArray(in);

		return fileData;

	}

	public static void writeFile(byte[] cos, String outputFile) throws FileNotFoundException, IOException {
		FileOutputStream output = new FileOutputStream(new File(outputFile));
		IOUtils.write(cos, output);
	}

	public static Map<String, Integer> getHeaderValues(byte[] cos) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		int bfOffBits = (((int) cos[13] & 0xff) << 24) | (((int) cos[12] & 0xff) << 16) | (((int) cos[11] & 0xff) << 8) | (int) cos[10] & 0xff;
		// System.out.println("bfOffBits is :" + bfOffBits) ;

		int height = (((int) cos[25] & 0xff) << 24) | (((int) cos[24] & 0xff) << 16) | (((int) cos[23] & 0xff) << 8) | (int) cos[22] & 0xff;
		// System.out.println("height is :" + height);

		int widith = (((int) cos[21] & 0xff) << 24) | (((int) cos[20] & 0xff) << 16) | (((int) cos[19] & 0xff) << 8) | (int) cos[18] & 0xff;
		// System.out.println("widith is :" + widith);
		int size = (((int) cos[37] & 0xff) << 24) | (((int) cos[36] & 0xff) << 16) | (((int) cos[35] & 0xff) << 8) | (int) cos[34] & 0xff;
		// System.out.println(size);
		int type = (((int) cos[29] & 0xff) << 8) | (int) cos[28] & 0xff;
		map.put("bfOffBits", bfOffBits);
		map.put("height", height);
		map.put("widith", widith);
		map.put("size", size);
		map.put("type", type);
		return map;
	}

}
