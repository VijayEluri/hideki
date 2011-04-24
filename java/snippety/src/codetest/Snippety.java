package codetest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Snippty generate a relevant snippet for a document with given query
 */
public class Snippety {
	/********************************************
	 * Constants 
	 ********************************************/
	// simple debugging flag
	public static final boolean DEBUG = false;
	// highlighting tags
	public static final String BEGIN_HIGHLIGHT_TAG = "[[HIGHLIGHT]]";
	public static final String END_HIGHLIGHT_TAG = "[[ENDHIGHLIGHT]]";
	// maximum number of summary sentences
	public static final int MAX_SUMMARY_SENTENCES = 2;
	// maximum summary sentence length
	public static final int MAX_SUMMARY_SENTECE_LEN = 100;
	
	
	/********************************************
	 * functions 
	 ********************************************/
	
	/**
	 * Return a relevant document summary for a given query with highlighting
	 * query words.
	 * 
	 * @param document String that is a document to be highlighted
	 * @param query String that contains the search query
	 * @return The the most relevant snippet with the query terms highlighted.
	 */
	public String highlight(String document, String query) {
		// check document parameter: if document is null or empty, retuurn ""
		if (document == null || document.trim().length() == 0) {
			return "";
		}
		
		// tokenize document to generate list of sentences
		String[] sentences = document.trim().split("(\\. |\\.\t|\\.\n|\\.|\n)");
		if (DEBUG) {
			System.out.println("----- Sentences -----");
			dump(sentences);
		}
		
		// if no sentences, return "";
		if(sentences.length == 0){
			return "";
		}
		
		// in case query parameter is null, return default summary
		if(query == null|| query.trim().length() == 0){
			return  summaryWithoutQueryWordsMatch(sentences);
		}

		// tokenize query to identify words
		String[] queryWords = query.trim().split("( |\t)");
		if (DEBUG) {
			System.out.println("----- Query Words -----");
			dump(queryWords);
		}
		
		// in case query parameter is empty, return first one or two sentences
		if(queryWords.length == 0){
			return  summaryWithoutQueryWordsMatch(sentences);
		}
		
		// list of sentence features
		List<SentenceFeatures> featuresList = new ArrayList<SentenceFeatures>();
		// analyze sentences in document, find matched query words in setence
		for (int i = 0; i < sentences.length; i++) {
			// tokenize a sentence
			String[] words = sentences[i].split("( |\t)");
			if (DEBUG) {
				System.out.println("----- Words in sentence -----");
				dump(words);
			}

			// find matched query words in the sentence
			// Map<word position in sentence, query word index>
			Map<Integer, Integer> match = match(queryWords, words); 
			if (DEBUG) {
				System.out.println("----- Keyword Matchs -----");
				dump(match);
			}
			
			// if a sentence contains any query word, set feature values for relevance ranking
			if (match.size() > 0) {
				SentenceFeatures features = new SentenceFeatures(words, match);
				// set position of sentence in the document
				features.setPosition(i, sentences.length);
				// set matched query words
				features.setMatchedWords(match.size(), queryWords.length);
				// set if sentence contains a complete query
				features.setCompleteQuery(hasCompleteQuery(match, queryWords.length));
				// claculate sentence score
				features.score();
				if (DEBUG) {System.out.println(features);}
				featuresList.add(features);
			}
		}

		// rank by sentence score
		Collections.sort(featuresList);
		
		StringBuffer summary = new StringBuffer();
		
		// no match - query words don't match with any document words
		if(featuresList.size() == 0){
			summary.append(summaryWithoutQueryWordsMatch(sentences));
		}
		// more then 1 sentence contain query word(s)
		else{
			// selected top 2 (configurable) sentences to be part of summary
			List<SentenceFeatures> subFeaturesList = featuresList.subList(0, Math.min(featuresList.size(), MAX_SUMMARY_SENTENCES));
			// sort sentence features by position
			Collections.sort(subFeaturesList, new Comparator<SentenceFeatures>(){
				@Override
				public int compare(SentenceFeatures o1, SentenceFeatures o2) { return o1.getPosition() - o2.getPosition(); }
			});			
			// catnate sentences with highlighting
			for(int i = 0; i < Math.min(featuresList.size(), MAX_SUMMARY_SENTENCES); i++){
				if (i != 0) summary.append(" ");
				summary.append(highlightingSentence(subFeaturesList.get(i).getWords(), subFeaturesList.get(i).getMatch()));
			}
		}
		
		if(DEBUG){System.out.println(summary);}
		
		// return snippet
		return summary.toString();
	}
	
	/**
	 * Return summary in case no query match or no query information
	 * 
	 * @param sentences sentence array of document
	 * @return summary string
	 */
	protected String summaryWithoutQueryWordsMatch(String[] sentences){
		StringBuffer buffer = new StringBuffer();
		for(int i = 0; i < MAX_SUMMARY_SENTENCES && i < sentences.length; i++){
			if(i != 0) buffer.append(' ');
			if(sentences[i].length() > MAX_SUMMARY_SENTECE_LEN){
				buffer.append(sentences[i].subSequence(0, MAX_SUMMARY_SENTECE_LEN));
				buffer.append("..");
			}else{
				buffer.append(sentences[i]);
			}
			buffer.append('.');
		}		
		return buffer.toString();
	}
	
	/**
	 * Check if a sentence contains a complete query
	 * 
	 * @param match query word(s) match information 
	 * @param queryWordCount query word count
	 * @return true if sentence contains complete query, false otherwise.
	 */
	protected boolean hasCompleteQuery(Map<Integer, Integer> match, int queryWordCount){
		for(Integer pos: match.keySet()){
			Integer queryWordId = match.get(pos); 			
			if(queryWordId == queryWordCount - 1){
				for(int i = 1; i < queryWordCount; i++){
					if(match.containsKey(pos - i)){
						int value = match.get(pos - i);
						if (value != queryWordId - i){
							break;
						}
						if (value == 0){
							return true;
						}
					} else {
						break;
					}
				}
			}			
		}
		return false;
	}
	
	/**
	 * Highlighting query words in sentence
	 * 
	 * @param words array of sentence words
	 * @param match query word(s) match information 
	 * @return highlighted sentence
	 */
	protected String highlightingSentence(String[] words, Map<Integer, Integer> match) {
		int summarySentenceLen = 0;
		StringBuffer summary = new StringBuffer();
		boolean highlighting = false;
		for (int i = 0; i < words.length; i++) {
			boolean bMatch = match.containsKey(i);
			if (i != 0) {
				summary.append(' ');
				summarySentenceLen += 1;
			}
			if (!highlighting && bMatch) {
				highlighting = true;
				summary.append(BEGIN_HIGHLIGHT_TAG);
			}
			summary.append(words[i]);
			summarySentenceLen += words[i].length();
			if (bMatch && !match.containsKey(i + 1)) {
				summary.append(END_HIGHLIGHT_TAG);
				highlighting = false;
			}
			if(summarySentenceLen >= MAX_SUMMARY_SENTECE_LEN){
				summary.append("..");
				break;
			}
		}
		summary.append('.');
		return summary.toString();
	}

	/**
	 * Find a query word from a give word list
	 * 
	 * @param queryWords a list of query word
	 * @param words a list of word
	 * @return a dictionary which contains pair of word position and query word id
	 */
	protected Map<Integer, Integer> match(String[] queryWords, String[] words) {
		Map<Integer, Integer> match = new HashMap<Integer, Integer>();
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < queryWords.length; j++) {
				if (queryWords[j].equalsIgnoreCase(words[i])) {
					match.put(i, j);
					break;
				}
			}
		}
		return match;
	}

	
	// debugging functions
	
	public static void dump(String[] strings) {
		for (String str : strings) {
			System.out.println("\t" + str);
		}
	}

	public static void dump(Map<Integer, Integer> m) {
		for (Integer key : m.keySet()) {
			System.out.println("\t" + key + " => " + m.get(key));
		}
	}

}
