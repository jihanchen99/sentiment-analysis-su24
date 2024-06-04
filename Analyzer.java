

import java.util.*;

public class Analyzer {
	

	/**
	 * This method calculates the weighted average for each word in all the Sentences.
	 * This method is case-insensitive and all words should be stored in the Map using
	 * only lowercase letters.
	 * 
	 * @param sentences Set containing Sentence objects with words to score
	 * @return Map of each word to its weighted average; or an empty Map if the Set of
	 * Sentences is empty or null.
	 */
	public static Map<String, Double> calculateWordScores(Set<Sentence> sentences) {
		/*
		 * Implement this method in Part 2
		 */
		if (sentences == null || sentences.isEmpty()) {
			return new HashMap<>();
		}

		Map<String, Integer> totalScores = new HashMap<>();
		Map<String, Integer> wordCount = new HashMap<>();
		Map<String, Double> wordScores = new HashMap<>();

		for (Sentence sentence : sentences) {
			int score = sentence.getScore();
			String text = sentence.getText().toLowerCase();
			String[] words = text.split("\\s+");
			for (String word : words) {
				// Ignore words that do not start with a letter
				if (!Character.isLetter(word.charAt(0))) {
					continue;
				}
				// updating totalScores
				int currentTotalScore = totalScores.getOrDefault(word, 0);
				int newTotalScore = currentTotalScore + score;
				totalScores.put(word, newTotalScore);
				// updating wordCount
				int currentWordCount = wordCount.getOrDefault(word, 0);
				int newWordCount = currentWordCount + 1;
				wordCount.put(word, newWordCount);
			}
		}

		for (Map.Entry<String, Integer> entry : totalScores.entrySet()) {
			String word = entry.getKey();
			int totalScore = entry.getValue();
			int count = wordCount.get(word);
			double wordScore = (double) totalScore / count;
			wordScores.put(word, wordScore);
		}

		return wordScores;
	}
	
	/**
	 * This method determines the sentiment of the input sentence using the average of the
	 * scores of the individual words, as stored in the Map.
	 * This method is case-insensitive and all words in the input sentence should be
	 * converted to lowercase before searching for them in the Map.
	 * 
	 * @param wordScores Map of words to their weighted averages
	 * @param sentence Text for which the method calculates the sentiment
	 * @return Weighted average scores of all words in input sentence; or 0 if any error occurs
	 */
	public static double calculateSentenceScore(Map<String, Double> wordScores, String sentence) {
		/*
		 * Implement this method in Part 3
		 */
		return 0;
	}


}
