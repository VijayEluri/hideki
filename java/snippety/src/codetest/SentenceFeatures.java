package codetest;
import java.util.Map;

/**
 * Sentence feature information which is used to calculate sentence relevance score and data storage
 */
public class SentenceFeatures implements Comparable<SentenceFeatures>{
	/********************************************
	 * Constants 
	 ********************************************/
	
	// feature weights for relevance ranking
	public final static float FEATURE_WEIGHT_POSITION      = 1.0f;
	public final static float FEATURE_WEIGHT_MATCHEDWORD   = 5.0f;
	public final static float FEATURE_WEIGHT_COMPLETEQUERY = 10.0f;
	
	/********************************************
	 * Variables 
	 ********************************************/
	// word list  of a sentence
	private String[] words = null;
	
	// pair (word position in sentence, query word index)
	private Map<Integer, Integer> match = null;
	
	// sentence position in the document
	private int position = -1; 
	// normalized position between 0.0 and 1.0
	private float normalizedPostion = Float.MIN_VALUE;
	
	// matched query word count
	private int matchedWords = -1;
	// normalized matched query word:  if query contains 3 words and sentence contains 2 out of 3, value could be 0.66
	private float normalizedMatchedWords = Float.MIN_VALUE;
	
	// true or false if a sentence contains a complete query.
	private boolean completeQuery = false; 
	// 1.0 or 0.0
	private float normalizedCompleteQuery = Float.MIN_VALUE;
	
	// sentence relevance score
	private float score = Float.MIN_VALUE;
	
	/********************************************
	 * Constructors
	 ********************************************/
	public SentenceFeatures(String[] words, Map<Integer, Integer> match) {
		super();
		this.words = words;
		this.match = match;
	}
	/********************************************
	 * Getter/Setter functions 
	 ********************************************/
	public String[] getWords() { return words; }
	public Map<Integer, Integer> getMatch() { return match; }	
	public int getPosition() { return position; }
	public float getNormalizedPostion() { return normalizedPostion; }
	public int getMatchedWords() { return matchedWords; }
	public float getNormalizedMatchedWords() { return normalizedMatchedWords; }
	public boolean isCompleteQuery() { return completeQuery; }
	public float getNormalizedCompleteQuery() { return normalizedCompleteQuery; }

	public void setPosition(int position, int totalSentence) {
		this.position = position;
		this.normalizedPostion = totalSentence == 1? 1f : 1f - (float)position/(totalSentence - 1);
	}

	public void setMatchedWords(int matchedWords, int queryWords) {
		this.matchedWords = matchedWords;
		this.normalizedMatchedWords = (float)matchedWords / queryWords;
	}

	public void setCompleteQuery(boolean completeQuery) {
		this.completeQuery = completeQuery;
		this.normalizedCompleteQuery = completeQuery ? 1.0f : 0.0f;
	}

	/********************************************
	 * Implementation of Comparable interface 
	 ********************************************/	
	@Override
	public int compareTo(SentenceFeatures o) {
		if (o == null) return -1;
		
		return (score() - o.score() > 0)? -1:1;
	}

	
	/********************************************
	 * functions 
	 ********************************************/	
	
	// return sentence's relevance score
	public float score(){
		if(score == Float.MIN_VALUE){
			if(normalizedPostion == Float.MIN_VALUE || normalizedMatchedWords== Float.MIN_VALUE || normalizedCompleteQuery == Float.MIN_VALUE){
				return Float.MIN_VALUE;
			}
			score = 0f;
			// sentence position
			score += FEATURE_WEIGHT_POSITION * normalizedPostion;
			// matched query word frequency in sentence
			score += FEATURE_WEIGHT_MATCHEDWORD * normalizedMatchedWords;
			// query words completeness in the sentence
			score += FEATURE_WEIGHT_COMPLETEQUERY * normalizedCompleteQuery;
		}
		return score;
	}
	
	@Override
	public String toString() {
		StringBuffer buffer =new StringBuffer();
		buffer.append("SentenceFeatures: {\n");
		buffer.append("\tposition: " + position + " ("+normalizedPostion+");\n");
		buffer.append("\tmatchedWords: " + matchedWords + " ("+normalizedMatchedWords+");\n");
		buffer.append("\tcompleteQuery:" + completeQuery + " ("+normalizedCompleteQuery+");\n");
		buffer.append("\tscore:" + score + ";\n");
		buffer.append("}");
		return buffer.toString();
	}
}
