package nordea;

import nordea.model.Sentence;

public interface Builder {
	
	public static final String NEW_LINE = "\n";

	StringBuilder build(Sentence sentence);
	
	StringBuilder additionalPrefix();
	
	StringBuilder additionalSuffix();
}
