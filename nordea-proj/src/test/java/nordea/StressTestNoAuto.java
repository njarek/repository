package nordea;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.xml.sax.SAXException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:nordea/applicationContext.xml")
public class StressTestNoAuto {

	@Autowired
	private Processor processor;
	
	private static final String STRESS_TEXT = "stres.txt";
	
	@Test
	public void stressTest() throws IOException, URISyntaxException, SAXException {
		processor.setInputStream(SentenceProccesorTest.class.getClassLoader().getResourceAsStream(STRESS_TEXT));
		processor.process(BuilderEnum.XML);
	}
}
