import java.util.Random;
import java.util.Scanner;

public class binary_practice {
    public static final Scanner input = new Scanner(System.in);
    public static final Random rand = new Random();
    
    public static int getRandomInteger(int n) {
        /*
        * get a random number
         * in range(0 - n + 1) inclusive
         */
        int random = rand.nextInt(n);
        return random;
    }
    
    public static String getRandomBinary(int length) {
        /*
         * return random binary 
         * 1 if length == 1 or length == 0, 10010 if length == 5, 1010010 if length == 7
         * will just use 0-8 bit (0 - 255)
         */
        if (length <= 0) return "";

        int bit = rand.nextInt(2);
        return String.valueOf(bit) + getRandomBinary(length - 1);
    }

    public static String integerToBinary(int n, int exponent) {
        // return the binary representation of n
        if (exponent < 0) return "";
        
        if ((int) Math.pow(2, exponent) <= n) {
            return "1" + integerToBinary(n - (int) Math.pow(2, exponent), exponent - 1);
        } else {
            return "0" + integerToBinary(n, exponent - 1);
        }
    }

    public static int binaryToInteger(String binary) {
        /*
         * return the base 10 representation of the given base 2 binary
         */
        if (binary.equals("")) return 0;
        
        if (binary.charAt(0) == '1') {
            return (int) Math.pow(2, binary.length() - 1) + binaryToInteger(binary.substring(1));
        } else {
            return binaryToInteger(binary.substring(1));
        }
    }

    public static String getInput() {
        // get user input with rust style compiler
        System.out.print("--> ");
      String usrAnswer = input.nextLine(); // get user's answer
      System.out.println("|");
      System.out.println("|");
      System.out.print("--- ");
      

        if (usrAnswer.equals("exit")) System.exit(0);
        return usrAnswer;
    }

    public static void checkAnswer(String usrAnswer, String answer) {
        if (usrAnswer.equals(answer)) {
            System.out.println("Correct!");
        } else {
            System.out.printf("Incorrect, answer is %s\n", answer);
        }

        System.out.println("|");
        System.out.println("|");        
    }
    

    public static void game1() {
        /*
        * game 1 is binary to integer conversion
        */
        int n = getRandomInteger(256);
        int exponent = (int) Math.floor(Math.log(n) / Math.log(2));
        String binary = integerToBinary(n, exponent);
        String answer = String.valueOf(n);

        System.out.print("binary: ");
        System.out.println(binary);

        String usrAnswer = getInput();
        
        checkAnswer(usrAnswer, answer);
    }

    public static void game2() {
        /*
         * game 2 is integer to binary conversion
         */
        int n = getRandomInteger(256);
        int exponent = (int) Math.floor(Math.log(n) / Math.log(2));
        String answer = integerToBinary(n, exponent);

        System.out.print("integer: ");
        System.out.println(n);

        String usrAnswer = getInput();

        checkAnswer(usrAnswer, answer);
    }


    public static void main(String[] args) {

        System.out.println("Welcome to binary binary binary");
        System.out.println("[Type \"exit\" without quotes to end the game]");
        System.out.print("\n");

        while (true) {
            int mode = getRandomInteger(2);
            if (mode == 0) {
                game1();
            } else {
                game2();
            }
        }
    }


}
