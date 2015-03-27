package nordea;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import nordea.model.Sentence;

import org.custommonkey.xmlunit.XMLAssert;
import org.custommonkey.xmlunit.XMLUnit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.xml.sax.SAXException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:nordea/applicationContext.xml")
public class XmlBuilderTest {

	@Autowired
	@Qualifier("xmlSentenceBuilder")
	private XmlSentenceBuilder xmlBuilder;

	@Test
	public void xmlWordBuilderTest() throws SAXException, IOException{
		String expected="<word>test</word>";
		String actual = xmlBuilder.buildWordXml("test").toString();
		
	    XMLUnit.setIgnoreWhitespace(true); // ignore whitespace differences
	    XMLAssert.assertXMLEqual(expected, actual); 
	}
	
	@Test
	public void xmlSentenceBuilderTest() throws SAXException, IOException{
		String expected="<sentence><word>test</word><word>test2</word></sentence>";
		List<String> words = new ArrayList<String>();
		words.add("test");
		words.add("test2");
		Sentence sentence = new Sentence();
		sentence.setWords(words);
		String actual = xmlBuilder.build(sentence).toString();
		XMLUnit.setIgnoreWhitespace(true); // ignore whitespace differences
	    XMLAssert.assertXMLEqual(expected, actual); 
	}
	
	
}
