import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class CalculateWordScoresTest {
    @Before
    public void setUp() {
        Set<Sentence> sentences = new HashSet<>();
        sentences.add(new Sentence(2, "I eat cake everyday ."));
        sentences.add(new Sentence(-1, "I like cake ."));
    }

    @Test
    public void nullInputTest() {
        Set<Sentence> sentences = null;
        Map<String, Double> result = Analyzer.calculateWordScores(sentences);
        Map<String, Double> expected = new HashMap<>();
        assertEquals(expected, result);
    }

    @Test
    public void emptyInputTest() {
        Set<Sentence> sentences = new HashSet<>();
        Map<String, Double> result = Analyzer.calculateWordScores(sentences);
        Map<String, Double> expected = new HashMap<>();
        assertEquals(expected, result);
    }

    @Test
    public void noneLetterStartWordTest() {
        Set<Sentence> sentences = new HashSet<>();
        sentences.add(new Sentence(1, "123 should not be counted"));
        sentences.add(new Sentence(2, "$$$ should be ignored"));
        Map<String, Double> result = Analyzer.calculateWordScores(sentences);
        Map<String, Double> expected = new HashMap<>();
        expected.put("not", 1.0);
        expected.put("be", 1.5);
        expected.put("counted", 1.0);
        expected.put("should", 1.5);
        expected.put("ignored", 2.0);
        assertEquals(expected, result);
    }

    @Test
    public void normalOperationsTest() {
        Set<Sentence> sentences = new HashSet<>();
        sentences.add(new Sentence(2, "I eat cake everyday"));
        sentences.add(new Sentence(-1, "I don't like cake"));
        Map<String, Double> result = Analyzer.calculateWordScores(sentences);
        Map<String, Double> expected = new HashMap<>();
        expected.put("i", 0.5);
        expected.put("eat", 2.0);
        expected.put("cake", 0.5);
        expected.put("everyday", 2.0);
        expected.put("don't", -1.0);
        expected.put("like", -1.0);
        assertEquals(expected.size(), result.size());
        assertEquals(expected, result);
    }

    @Test
    public void caseInsensitivityTest() {
        Set<Sentence> sentences = new HashSet<>();
        sentences.add(new Sentence(1, "Cake"));
        sentences.add(new Sentence(2, "cake"));
        sentences.add(new Sentence(3, "CAKE"));
        Map<String, Double> result = Analyzer.calculateWordScores(sentences);
        Map<String, Double> expected = new HashMap<>();
        expected.put("cake", 2.0);
        assertEquals(expected.size(), result.size());
        assertEquals(expected, result);
    }


}
