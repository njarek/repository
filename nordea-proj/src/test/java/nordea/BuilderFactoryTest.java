package nordea;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:nordea/applicationContext.xml")
public class BuilderFactoryTest {

	@Autowired
	private BuilderFactory builderFactory;
	
	@Test
	public void xmlBuilderTest(){
		Assert.assertTrue(builderFactory.getBuilder(BuilderEnum.XML) instanceof XmlSentenceBuilder);
	}
}
