package nordea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Collections;

import nordea.model.Sentence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SentenceProcessor implements Processor {

	private static Logger log = LoggerFactory.getLogger(SentenceProcessor.class);
	private InputStream inputStream = System.in;
	private OutputStream outputStream = System.out;
	private BuilderFactory builderFactory;
	private Builder builder;

	public SentenceProcessor(BuilderFactory builderFactory) {
		this.builderFactory = builderFactory;
	}

	@Override
	public void process(BuilderEnum builderEnum) {
		builder = builderFactory.getBuilder(builderEnum);
		log.info("Start prccessing, pls provide text, to stop press 1");
		try {
			outputStream.write(builder.additionalPrefix().toString().getBytes());
			Charset encoding = Charset.defaultCharset();
			BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, encoding));
			processText(br);
			outputStream.write(builder.additionalSuffix().toString().getBytes());
		} catch (IOException io) {
			log.error("Error ", io);
		} finally {
			try {
				outputStream.close();
				inputStream.close();
			} catch (IOException e) {
				log.error("Error while closing stream ", e);
			}

		}
		
	}

	private void processText(BufferedReader br) throws IOException {
		int input;
		StringBuilder word = new StringBuilder();
		Sentence sentence = new Sentence();
		while ((input = br.read()) != -1) {
			char ch = (char) input;

			if (Character.isAlphabetic(ch)) {
				word.append(ch);
			} else if (word.length() > 0) {
				sentence.getWords().add(word.toString());
				word = new StringBuilder();
			}
			if (ch == '.') {
				Collections.sort(sentence.getWords(), String.CASE_INSENSITIVE_ORDER);
				StringBuilder sentenceBuilder = builder.build(sentence);
				outputStream.write(sentenceBuilder.toString().getBytes());
				sentence = new Sentence();
			}
			if (ch == '1') {
				log.info("Prccessing finished");
				return ;
			}

		}
	}

	@Override
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;

	}

	@Override
	public void setOutputStream(OutputStream outputStream) {
		this.outputStream = outputStream;

	}

	public void setXmlBuilder(Builder xmlBuilder) {
		this.builder = xmlBuilder;
	}

}
