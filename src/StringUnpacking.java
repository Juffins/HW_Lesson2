import java.util.Scanner;

public class StringUnpacking {

    public static void Unpacking(){

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String string = scanner.next();
        int length = string.length();
        int currentCountOfRepetitions = 0;
        Character currentChar;
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < length; i++){

            currentChar = (string.charAt(i));
            if(Character.isDigit(currentChar)){
                System.out.println("Current char: " + Character.getNumericValue(currentChar) + " \t" + "currentCountOfRepetitions: " + currentCountOfRepetitions);
                currentCountOfRepetitions = currentCountOfRepetitions * 10 + Character.getNumericValue(currentChar);
            }
            else{
                if(currentCountOfRepetitions != 0){
                    result.append(currentChar.toString().repeat(currentCountOfRepetitions));
                }
                else {
                    result.append(currentChar);
                }
                currentCountOfRepetitions = 0;
            }
        }

        System.out.println(result);
    }
}

