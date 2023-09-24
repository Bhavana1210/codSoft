import java.util.*;
import java.io.*;

class codSoftTask2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("            Welcome to the Word Counter");
        System.out.println("Enter the text or provide a file path : ");
        String input = sc.nextLine();
        String text = readInput(input);
        if (text != null) {
            String[] words = text.split(" ");
            int wordCount = 0;
            Set<String> stopWords = Set.of("the", "and", "is", "in", "it", "to", "of");
            Map<String, Integer> wordFreqency = new HashMap<>();
            for (String word : words) {
                if (!stopWords.contains(word.toLowerCase())) {
                    wordCount++;
                    wordFreqency.put(word.toLowerCase(), wordFreqency.getOrDefault(word.toLowerCase(), 0) + 1);
                }
            }
            System.out.println("Total word count : " + wordCount);
            System.out.println("Do you want to see particular word count : ");
            String additionalTask = sc.next();
            if (additionalTask.equalsIgnoreCase("yes")) {
                System.out.println("Enter the word : ");
                String word = sc.next();
                if (!wordFreqency.containsKey(word))
                    System.out.println("Error:Invalid word");
                else
                    System.out.println("WordFrequency  of " + word + " word  is :" + wordFreqency.get(word));
            }
        } else {
            System.out.println("Error: empty input");
        }
    }

    public static String readInput(String input) {
        StringBuilder text = new StringBuilder();
        try {
            if (input.endsWith(".txt")) {
                BufferedReader reader = new BufferedReader(new FileReader(input));
                String line;
                while ((line = reader.readLine()) != null) {
                    text.append(line).append(" ");
                }
                reader.close();
            } else {
                text.append(input);
            }
            return text.toString().trim();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}