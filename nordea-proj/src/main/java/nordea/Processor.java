package nordea;

import java.io.InputStream;
import java.io.OutputStream;

interface Processor {
	
	void setInputStream(InputStream inputStream);
	
	void setOutputStream(OutputStream inputStream);

	void process(BuilderEnum builderEnum);
}
