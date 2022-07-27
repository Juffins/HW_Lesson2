import java.util.Scanner;

public class PowerOfLine {

    public static void CalculatePowerOfLine(){

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String string = scanner.next();
        System.out.print("Enter the power: ");
        int power = scanner.nextInt();
        int length = string.length();

        if(Math.abs(power) >= 100001 || length > 1000){
            System.out.println("Input data too large.");
            return;
        }

        String result = "";
        int maxResultLength = 1023;
        boolean isWordSplit = true;
        if(power > 0){
            if(length * power > maxResultLength){
                power = maxResultLength / length + 1;
            }
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
        if(result.length() > 1023){
            result = result.substring(0, 1023);
        }
        System.out.println("Result: " + result + ".");
    }
}
