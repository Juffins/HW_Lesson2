import java.util.Scanner;

public class Palindrome {

    public static void CheckString(){

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String string = scanner.next();
        int length = string.length();

        String firstHalf = "";
        String reverseHalf = "";
        for(int i = 0; i < length / 2; i++){
            firstHalf += string.charAt(i);
            reverseHalf += string.charAt(length - 1 - i);
        }
        System.out.println(firstHalf + " " + reverseHalf);
        if(firstHalf.equals(reverseHalf)){
            System.out.println("It's a palindrome!");;
        }
        else{
            System.out.println("It's not a palindrome.");
        }
    }
}
