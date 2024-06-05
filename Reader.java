import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Reader {
    /**
     * This method reads sentences from the input file, creates a Sentence object
     * for each, and returns a Set of the Sentences.
     *
     * @param filename Name of the input file to be read
     * @return Set containing one Sentence object per sentence in the input file
     * @throws IllegalArgumentException if filename is null
     */
    public static Set<Sentence> readFile(String filename) {
        /*
         * Implement this method in Part 1
         */
        if (filename == null) {
            throw new IllegalArgumentException("Input filename is null.");
        }

        Set<Sentence> sentences = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                int spaceIndex = line.indexOf(" ");
                if (spaceIndex > 0) {
                    String scoreString = line.substring(0, spaceIndex);
                    try {
                        int score = Integer.parseInt(scoreString);
                        if (score < -2 || score > 2) {
                            continue;
                        }
                        String text = line.substring(spaceIndex + 1).trim().toLowerCase();
                        if (!text.isEmpty()) {
                            Sentence sentence = new Sentence(score, text);
                            sentences.add(sentence);
                        }
                    } catch (NumberFormatException e) {
                    }
                }
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Cannot open file for reading.");
        }
        return sentences;
    }
}
