import java.util.*;

public class Problem3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String definitionsInput = scanner.nextLine();
        String testWordsInput = scanner.nextLine();
        String command = scanner.nextLine();

        output(definitionsInput, testWordsInput, command);
    }

    public static void output(String definitionsInput, String testWordsInput, String command) {
        Map<String, List<String>> notebook = new HashMap<>();

        String[] pairs = definitionsInput.split("\\|");

        for (String pair : pairs) {
            String[] wordAndDefinition = pair.split(":");
            if (wordAndDefinition.length < 2) continue;

            String word = wordAndDefinition[0].trim();
            String definition = wordAndDefinition[1].trim();

            notebook.computeIfAbsent(word, key -> new ArrayList<>()).add(definition);
        }

        String[] testWords = testWordsInput.split("\\|");

        if ("Test".equals(command)) {
            for (String testWord : testWords) {
                testWord = testWord.trim();
                if (notebook.containsKey(testWord)) {
                    System.out.println(testWord + ":");
                    for (String definition : notebook.get(testWord)) {
                        System.out.println(" -" + definition);
                    }
                }
            }
        } else if ("Hand Over".equals(command)) {
            for (String word : notebook.keySet()) {
                System.out.print(word + " ");
            }
            System.out.println();
        } else {
            System.out.println("Invalid command: " + command);
        }
    }
}
