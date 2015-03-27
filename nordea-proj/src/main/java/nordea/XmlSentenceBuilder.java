package nordea;

import nordea.model.Sentence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XmlSentenceBuilder implements Builder {
	
	private static final String XML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n";
	private static final String TEXT_PREFIX = "<text>\n";
	private static final String TEXT_SUFFIX = "</text>";

	private static final String WORD_PREFIX = "<word>";
	private static final String WORD_SUFFIX = "</word>";

	private static final String SENTENCE_PREFIX = "<sentence>";
	private static final String SENTENCE_SUFFIX = "</sentence>";
	

	private static Logger log = LoggerFactory.getLogger(XmlSentenceBuilder.class);

	public StringBuilder build(Sentence sentence) {
		log.info("Converting sentence {}", sentence);
		StringBuilder sentenceBuilder = new StringBuilder();
		sentenceBuilder.append(SENTENCE_PREFIX);
		sentenceBuilder.append(NEW_LINE);
		for (String word : sentence.getWords()) {
			sentenceBuilder.append(buildWordXml(word));
		}
		sentenceBuilder.append(SENTENCE_SUFFIX);
		sentenceBuilder.append(NEW_LINE);
		return sentenceBuilder;
	}

	protected StringBuilder buildWordXml(String word) {
		log.debug("Converting word {}", word);
		StringBuilder wordBuilder = new StringBuilder();
		wordBuilder.append(WORD_PREFIX);
		wordBuilder.append(word);
		wordBuilder.append(WORD_SUFFIX);
		wordBuilder.append(NEW_LINE);
		return wordBuilder;
	}

	@Override
	public StringBuilder additionalPrefix() {
		StringBuilder prefix = new StringBuilder();
		prefix.append(XML).append(TEXT_PREFIX);
		return prefix;
	}

	@Override
	public StringBuilder additionalSuffix() {
		StringBuilder suffix = new StringBuilder();
		suffix.append(TEXT_SUFFIX);
		return suffix;
	}



}
