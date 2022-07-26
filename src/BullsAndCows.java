import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BullsAndCows {

    private static Scanner scanner = new Scanner(System.in);

    public static void PlayBullsAndCows(){

        String intendedNumber = RandomNumber();
        System.out.println("For debug: intendedNumber is " + intendedNumber);
        String enteredNumber;
        System.out.println("Let's gooo!!!!! Try to guess what the number I'm up to!");


        int countCows = 0;
        int countBulls = 0;
        ArrayList<Character> cows;
        ArrayList<Character> bulls;
        boolean isGuessed = false;

        while(!isGuessed){
            countCows = 0;
            countBulls = 0;
            cows = new ArrayList<>();
            bulls = new ArrayList<>();

            System.out.print("Enter four-digit number: ");
            enteredNumber = InputNumber();

            for(int i = 0; i < intendedNumber.length(); i++){
                for(int j = 0; j < intendedNumber.length(); j++){
                    if(intendedNumber.charAt(i) == enteredNumber.charAt(j)){
                        if(i == j){
                            countBulls++;
                            bulls.add(intendedNumber.charAt(i));
                        }
                        else{
                            countCows++;
                            cows.add(intendedNumber.charAt(i));
                        }
                    }
                }
            }

            String result = countCows + " cows: ";
            for(int i = 0; i < cows.size(); i++){
                result += cows.get(i) + ", ";
            }
            result = result.substring(0, result.length() - 2);
            result += " and " + countBulls + " bulls: ";
            for(int i = 0; i < bulls.size(); i++){
                result += bulls.get(i) + ", ";
            }
            result = result.substring(0, result.length() - 2);
            System.out.println(result);

            if(countBulls == 4){
                isGuessed = true;
            }
        }

        String congratulation = "Congratulations! You guessed the number!";
        System.out.println(congratulation);
    }

    public static String RandomNumber(){

        Random random = new Random();
        int bound = 10;

        String number = Integer.toString(random.nextInt(bound));
        String randomChar = "";
        boolean isNotRepeated;
        while(number.length() != 4){
            isNotRepeated = false;
            while(!isNotRepeated){
                isNotRepeated = true;
                randomChar = Integer.toString(random.nextInt(bound));
                if(number.contains(randomChar)){
                    isNotRepeated = false;
                }
            }
            number += randomChar;
        }

        return number;
    }

    public static String InputNumber(){

        int number;
        String sNumber;
        if (scanner.hasNextInt()) {
            sNumber = scanner.next();
            try {
                number = Integer.valueOf(sNumber);
                if(sNumber.length() != 4 || number < 0){
                    System.out.println("Incorrect number! Please, enter a positive four-digit number.");
                    sNumber = InputNumber();
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
            for(int i = 0; i < 3; i++){
                for(int j = i + 1; j < 4; j++){
                    if(sNumber.charAt(i) == sNumber.charAt(j)){
                        System.out.println("Chars must not to be repeated!");
                        sNumber = InputNumber();
                    }
                }
            }
        }
        else {
            System.out.println("Incorrect number! Please, enter a positive four-digit number.");
            scanner.next();
            sNumber = InputNumber();
        }
        return sNumber;
    }
}
