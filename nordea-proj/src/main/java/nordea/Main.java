package nordea;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	private static Logger log = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		if (args.length == 0) {
			log.error("Pls provide converter, 1. xml 2. cvs");
			throw new RuntimeException("Pls provide converter, 1. xml 2. cvs");
		}
		BuilderEnum builderEnum = BuilderEnum.getBuilderEnum(args[0]);

		AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("nordea/applicationContext.xml");

		SentenceProcessor sentenceProcessor = (SentenceProcessor) applicationContext.getBean("sentenceProcessor");
		sentenceProcessor.process(builderEnum);
		applicationContext.close();
	}
}
