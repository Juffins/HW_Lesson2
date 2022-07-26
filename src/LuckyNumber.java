import java.util.Scanner;

public class LuckyNumber {

    public static Scanner scanner = new Scanner(System.in);

    public static void CheckNumber() {
        System.out.print("Enter an even positive number: ");

        String sNumber;
        int number;
        int length;
        sNumber = InputNumber();
        length = sNumber.length();
        try {
            number = Integer.valueOf(sNumber);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        int sumFirstHalf = 0;
        int sumSecondHalf = 0;
        int firstDigit;
        int secondDigit;
        int numberOfDigits = length;

        for(int i = 0; i < length; i++, numberOfDigits -= 2){
            secondDigit = number % 10;
            sumSecondHalf += number % 10;
            firstDigit = (number / Math.max((int)Math.pow(10, numberOfDigits - 1), 1));
            sumFirstHalf += firstDigit;
            number -= firstDigit * (int)Math.pow(10, numberOfDigits - 1);
            number -= secondDigit;
            number /= 10;
        }

        if(sumFirstHalf == sumSecondHalf) {
            System.out.println("Congratulations! It's a lucky number!!!");
        }
        else {
            System.out.println("Better luck next time!");
        }
    }

    public static String InputNumber(){
        int number;
        String sNumber;
        if (scanner.hasNextInt()) {
            number = scanner.nextInt();
            sNumber = Integer.toString(number);
            if(sNumber.length() % 2 != 0 || number < 0){
                System.out.println("Incorrect number! Please, enter an even positive number.");
                sNumber = InputNumber();
            }
        }
        else {
            System.out.println("Incorrect number! Please, enter an even positive number.");
            scanner.next();
            sNumber = InputNumber();
        }
        return sNumber;
    }
}

