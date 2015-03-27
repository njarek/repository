package nordea;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;

import org.apache.commons.io.FileUtils;
import org.custommonkey.xmlunit.XMLAssert;
import org.custommonkey.xmlunit.XMLUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.xml.sax.SAXException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:nordea/applicationContext.xml")
public class SentenceProccesorTest {

	private static final String OUTPUT_FILE_NAME = "processedText.xml";
	private static final String INPUT_FILE_NAME = "text.txt";
	private static final String EXPECTED_XML = "tekstXml.xml";


	@Autowired
	private Processor processor;

	@Before
	public void init() throws FileNotFoundException {
		processor.setInputStream(SentenceProccesorTest.class.getClassLoader().getResourceAsStream(INPUT_FILE_NAME));	
		processor.setOutputStream(new FileOutputStream(SentenceProccesorTest.class.getClassLoader().getResource(OUTPUT_FILE_NAME).getFile(),true));
	}

	@Test
	public void processTest() throws IOException, URISyntaxException, SAXException {
		String expected = FileUtils.readFileToString(new File(SentenceProccesorTest.class.getClassLoader().getResource(EXPECTED_XML).toURI()));
		processor.process(BuilderEnum.XML);
		String actual = FileUtils.readFileToString(new File(SentenceProccesorTest.class.getClassLoader().getResource(OUTPUT_FILE_NAME).toURI()));
		XMLUnit.setIgnoreWhitespace(true); // ignore whitespace differences
		XMLAssert.assertXMLEqual(expected, actual);
	}
	

	
	@After
	public void clean() throws FileNotFoundException{
		PrintWriter writer = new PrintWriter(SentenceProccesorTest.class.getClassLoader().getResource(OUTPUT_FILE_NAME).getFile());
		writer.print("");
		writer.close();
	}

}
