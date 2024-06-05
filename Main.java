import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Main class for the sentiment analysis program.
 */
public class Main {

    public static void main(String[] args) {

        /* Implement this in Part 4 */
        if (args.length < 1) {
            System.out.println("no input file");
            System.exit(1);
        }
        String filename = args[0];
        Set<Sentence> sentences;
        Map<String, Double> wordScores;
        try {
            sentences = Reader.readFile(filename);
            wordScores = Analyzer.calculateWordScores(sentences);
        } catch (IllegalArgumentException e) {
            System.out.println("no input file");
            System.exit(1);
            return;
        }
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a sentence: ");
            String input = scanner.nextLine();
            if ("exit".equals(input)) {
                break;
            }
            try {
                double sentenceScore = Analyzer.calculateSentenceScore(wordScores, input);
                System.out.println("Sentence score: " + sentenceScore);
            } catch (Exception e) {
            }
        }
        scanner.close();
    }
}
