import java.util.Scanner;

public class ZerosAndOnes {

    public static void CountMaxConsecutiveZeros(){

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string consisting of zeros and ones: ");
        String string = scanner.next();
        int maxCountZeros = 0;
        int currentCountZeros = 0;
        int length = string.length();

        for(int i = 0; i < length; i++){
            if(string.charAt(i) == '0'){
                currentCountZeros++;
            }
            else{
                if(currentCountZeros > maxCountZeros) {
                    maxCountZeros = currentCountZeros;
                }
                currentCountZeros = 0;
            }
        }
        if(currentCountZeros > maxCountZeros) {
            maxCountZeros = currentCountZeros;
        }
        System.out.println("Max count of consecutive zeros: " + maxCountZeros);
    }
}
