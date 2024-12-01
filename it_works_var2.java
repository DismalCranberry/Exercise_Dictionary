import java.util.*;

public class Problem3 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        var definitionsInput = scanner.nextLine();
        var testWordsInput = scanner.nextLine();
        var command = scanner.nextLine();

        output(definitionsInput, testWordsInput, command);
    }

    public static void output(String definitionsInput, String testWordsInput, String command) {
        var notebook = new HashMap<String, List<String>>();

        var pairs = definitionsInput.split("\\|");

        for (var pair : pairs) {
            var wordAndDefinition = pair.split(":");
            if (wordAndDefinition.length < 2) continue;

            var word = wordAndDefinition[0].trim();
            var definition = wordAndDefinition[1].trim();

            notebook.computeIfAbsent(word, key -> new ArrayList<>()).add(definition);
        }

        var testWords = testWordsInput.split("\\|");

        switch (command) {
            case "Test" -> {
                for (var testWord : testWords) {
                    testWord = testWord.trim();
                    if (notebook.containsKey(testWord)) {
                        System.out.println(testWord + ":");
                        for (var definition : notebook.get(testWord)) {
                            System.out.println("-" + definition);
                        }
                    }
                }
            }
            case "Hand Over" -> {
                for (var word : notebook.keySet()) {
                    System.out.print(word + " ");
                }
                System.out.println();
            }
            default -> System.out.println("Invalid command: " + command);
        }
    }
}
