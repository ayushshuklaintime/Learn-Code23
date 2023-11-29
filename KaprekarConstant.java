import java.util.Arrays;

public class KaprekarConstant {

    public static void main(String[] args) {
        int number = 3524;
        int kaprekarCount = performKaprekarRoutine(number);
        System.out.println("Number of iterations to reach Kaprekar's constant (6174): " + kaprekarCount);
    }

    private static int performKaprekarRoutine(int number) {
        int iterations = 0;

        while (number != 6174) {
            String formattedNumber = String.format("%04d", number);
            char[] digits = formattedNumber.toCharArray();
            Arrays.sort(digits);
            int ascending = Integer.parseInt(new String(digits));
            StringBuilder descendingBuilder = new StringBuilder(new String(digits)).reverse();
            int descending = Integer.parseInt(descendingBuilder.toString());
            number = descending - ascending;
            iterations++; //result
            System.out.println("Iteration " + iterations + ": " + descending + " - " + ascending + " = " + number);
        }
        return iterations;
    }
}
