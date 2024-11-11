import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TopWords {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\User\\Desktop\\Lab6\\text.txt";
        File file = new File(filePath);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Map<String, Integer> wordCountMap = new HashMap<>();
        while (scanner != null && scanner.hasNext()) {
            String word = scanner.next().toLowerCase();
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }
        if (scanner != null) {
            scanner.close();
        }

        List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordCountMap.entrySet());

        Collections.sort(wordList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        int count = 0;
        for (Map.Entry<String, Integer> entry : wordList) {
            if (count >= 10) break;
            System.out.println(entry.getKey() + ": " + entry.getValue());
            count++;
        }
    }
}