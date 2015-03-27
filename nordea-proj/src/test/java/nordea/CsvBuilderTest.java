package nordea;

import java.io.IOException;

import nordea.model.Sentence;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.xml.sax.SAXException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:nordea/applicationContext.xml")
public class CsvBuilderTest {

	@Autowired
	@Qualifier("csvSentenceBuilder")
	private CsvSentenceBuilder csvBuilder;

	@Test
	public void xmlWordBuilderTest() throws SAXException, IOException {
		String expected = "Sentence 1, test, test1";
		Sentence sentence = new Sentence();
		sentence.getWords().add("test");
		sentence.getWords().add("test1");

		String actual = csvBuilder.build(sentence).toString().replaceAll("\n", "");

		Assert.assertEquals(expected, actual);
	}
}
