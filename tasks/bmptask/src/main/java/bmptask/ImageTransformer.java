package bmptask;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface ImageTransformer {

	public void rotate(String outputFile) throws FileNotFoundException, IOException;

}
