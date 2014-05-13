package bmptask;

import java.io.IOException;

import org.junit.Test;

public class FileUtilityTest {

	@Test
	public void readFileTest() throws IOException{
		
		System.out.print("byte[] byte = {");
		byte[] cos=FileUtility.readFile("bmptask/test.txt");
		for(byte t:cos){
			System.out.print(t+",");
		}
		
	}
}
