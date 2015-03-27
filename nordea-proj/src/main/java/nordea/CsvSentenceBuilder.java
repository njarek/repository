package nordea;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import nordea.model.Sentence;

public class CsvSentenceBuilder implements Builder {

	
	private static final String COMMA = ", ";
	private static final String SENTENCE = "Sentence ";
	private static Logger log = LoggerFactory.getLogger(XmlSentenceBuilder.class);
	private int counter = 1;

	@Override
	public StringBuilder build(Sentence sentence) {
		log.info("Converting sentence{} {}", counter, sentence);
		StringBuilder sentenceBuilder = new StringBuilder();
		sentenceBuilder.append(SENTENCE + counter);
		for (String word : sentence.getWords()) {
			sentenceBuilder.append(COMMA).append((word));
		}
		sentenceBuilder.append(NEW_LINE);
		counter++;
		return sentenceBuilder;
	}

	@Override
	public StringBuilder additionalPrefix() {
		return new StringBuilder();
	}

	@Override
	public StringBuilder additionalSuffix() {
		return new StringBuilder();
	}

}
