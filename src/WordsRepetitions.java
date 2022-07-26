import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordsRepetitions {

    public static void CalculateWordsRepetitions(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String string = scanner.nextLine();
        String[] words = string.split(" ");
        int countOfWords = words.length;
        HashMap<String, Integer> wordsAndCount = new HashMap<>();
        int currentCount;

        for(int i = 0; i < countOfWords; i++){
            if(!wordsAndCount.containsKey(words[i])){
                wordsAndCount.put(words[i], 1);
            }
            else{
                currentCount = wordsAndCount.get(words[i]) + 1;
                wordsAndCount.put(words[i], currentCount);
            }
        }

        for (Map.Entry entry: wordsAndCount.entrySet()) {
            System.out.println(entry);
        }
    }
}
