package bmptask;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

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
		byte[] headers = Arrays.copyOfRange(picuture, 0, 54);
		byte[] picture = Arrays.copyOfRange(picuture, 54, picuture.length);
		byte[] reversePicture = new byte[picture.length];

		int y=picture.length-1;
		for(byte s:picture){
			reversePicture[y]=s;
			y--;
		}
		
		int b = picture.length - 1;
		int c = 0;

		byte[] revertedPicutre = new byte[headers.length + reversePicture.length];
		for (int i = 0; i < headers.length; i++) {
			revertedPicutre[i] = headers[i];

		}
		for (int i = 0, j = headers.length; j < revertedPicutre.length; i++, j++) {
			revertedPicutre[j] = reversePicture[i];
		}
		return revertedPicutre;
	}

	public static void main(String[] args) throws IOException {
		FileReader fileReader = new FileReader();
		byte[] cos = fileReader.readFile("cos2.bmp");

		int i = 0;
		for (byte a : cos) {
			System.out.print(a + "_" + i+" ");
			i++;
		}
		System.out.println();
		cos = fileReader.rotate(cos);
		FileOutputStream output = new FileOutputStream(new File("target-file.bmp"));
		IOUtils.write(cos, output);
		
		i = 0;
		for (byte a : cos) {
			System.out.print(a + "_" + i+" ");
			i++;
		}

	}

}