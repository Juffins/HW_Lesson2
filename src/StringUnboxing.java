import java.util.Scanner;

public class StringUnboxing {

    public static void Unboxing(){

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String string = scanner.next();
        int length = string.length();
        int currentCountOfRepetitions = 1;
        String result = "";

        for(int i = 0; i < length - 1; i++){
            if(string.charAt(i) == string.charAt(i + 1)){
                currentCountOfRepetitions++;
            }
            else{
                System.out.println(string.charAt(i));
                if(currentCountOfRepetitions != 1){
                    result += currentCountOfRepetitions;
                }
                result += string.charAt(i);
                currentCountOfRepetitions = 1;
            }
        }
        if(currentCountOfRepetitions != 1){
            result += currentCountOfRepetitions;
        }
        result += string.charAt(length - 1);

        System.out.println(result);
    }
}
