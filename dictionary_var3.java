import java.util.*;
import java.util.regex.Pattern;

public class Problem3 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            var definitionsInput = scanner.nextLine();
            var testWordsInput = scanner.nextLine();
            var command = scanner.nextLine();

            output(definitionsInput, testWordsInput, command);
        }
    }

    public static void output(String definitionsInput, String testWordsInput, String command) {
        var notebook = new HashMap<String, List<String>>();
        var pattern = Pattern.compile("(\\w+):([^|]+)");
        var matcher = pattern.matcher(definitionsInput);

        while (matcher.find()) {
            var word = matcher.group(1).trim();
            var definition = matcher.group(2).trim();

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
