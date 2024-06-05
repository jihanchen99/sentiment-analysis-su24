import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;

public class CalculateSentenceScoreTest {
    @Test
    public void nullWordScoresTest() {
        Map<String, Double> wordScores = null;
        String sentence = "This is a test sentence.";
        double result = Analyzer.calculateSentenceScore(wordScores, sentence);
        double expected = 0.0;
        double delta = 0.0001;
        assertEquals(expected,result,delta);
    }

    @Test
    public void nullSentenceTest() {
        Map<String, Double> wordScores = new HashMap<>();
        wordScores.put("Test", 0.0);
        String sentence = null;
        double result = Analyzer.calculateSentenceScore(wordScores, sentence);
        double expected = 0.0;
        double delta = 0.0001;
        assertEquals(expected,result,delta);
    }

    @Test
    public void emptySentenceTest() {
        Map<String, Double> wordScores = new HashMap<>();
        wordScores.put("Test", 0.0);
        String sentence = " ";
        double result = Analyzer.calculateSentenceScore(wordScores, sentence);
        double expected = 0.0;
        double delta = 0.0001;
        assertEquals(expected,result,delta);
    }

    @Test
    public void noneLetterStartTest() {
        Map<String, Double> wordScores = new HashMap<>();
        wordScores.put("test", -1.0);
        wordScores.put("is", 1.0);
        wordScores.put("hard", -3.0);
        String sentence = "3xx Test is hard";
        double result = Analyzer.calculateSentenceScore(wordScores, sentence);
        double expected = -1.0;
        double delta = 0.0001;
        assertEquals(expected, result, delta);
    }

    @Test
    public void normalOperations() {
        Map<String, Double> wordScores = new HashMap<>();
        wordScores.put("test", -1.0);
        wordScores.put("is", 1.0);
        wordScores.put("hard", -3.0);
        String sentence = "Test is hard";
        double result = Analyzer.calculateSentenceScore(wordScores, sentence);
        double expected = -1.0;
        double delta = 0.0001;
        assertEquals(expected, result, delta);
    }

    @Test
    public void emptyWordCountTest() {
        Map<String, Double> wordScores = new HashMap<>();
        wordScores.put("test", -1.0);
        wordScores.put("is", 1.0);
        wordScores.put("hard", -3.0);
        String sentence = "333";
        double result = Analyzer.calculateSentenceScore(wordScores, sentence);
        double expected = 0.0;
        double delta = 0.0001;
        assertEquals(expected, result, delta);
    }
}
