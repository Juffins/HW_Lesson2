import java.util.Scanner;

public class PowerOfLine {

    public static void CalculatePowerOfLine(){

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String string = scanner.next();
        System.out.print("Enter the power: ");
        int power = scanner.nextInt();
        int length = string.length();

        String result = "";
        boolean isWordSplit = true;
        if(power > 0){
            result = string.repeat(power);
        }
        else if(power < 0){
            power *= -1;
            String powerOfString = string.substring(0, length / power);

            if(length % power == 0){
                for(int i = 0; i < length; i += length / power){
                    if(!powerOfString.equals(string.substring(i, i + length / power)) ){
                        isWordSplit = false;
                    }
                }
                if(isWordSplit){
                    result = powerOfString;
                }
                else{
                    result = "NO SOLUTION";;
                }
            }
            else{
                result = "NO SOLUTION";
            }
        }
        else{
            System.out.println("0");
        }
        System.out.println("Result: " + result + ".");
    }
}
