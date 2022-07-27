import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BullsAndCows {

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

            StringBuilder result = new StringBuilder(countCows + " cows");
            if(countCows != 0){
                result.append(": ");
            }
            for(int i = 0; i < cows.size(); i++){
                result.append(cows.get(i));
                if(i != cows.size() - 1){
                    result.append(", ");
                }
            }
            result.append(" and ").append(countBulls).append(" bulls");
            if(countBulls != 0){
                result.append(": ");
            }
            for(int i = 0; i < bulls.size(); i++){
                result.append(bulls.get(i));
                if(i != bulls.size() - 1){
                    result.append(", ");
                }
            }
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

        Scanner scanner = new Scanner(System.in);
        int number;
        int numberOfDigits = 4;
        String sNumber;
        if (scanner.hasNextInt()) {
            sNumber = scanner.next();
            try {
                number = Integer.valueOf(sNumber);
                if(sNumber.length() != numberOfDigits || number < 0){
                    System.out.println("Incorrect number! Please, enter a positive four-digit number.");
                    sNumber = InputNumber();
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
            for(int i = 0; i < numberOfDigits - 1; i++){
                for(int j = i + 1; j < numberOfDigits; j++){
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
