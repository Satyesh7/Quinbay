
class MultipleDigitException extends Exception {
    public MultipleDigitException(String message) {
        super(message);
    }
}


public class SingleDigitChecker {
 
    public static void checkSingleDigit(int number) throws MultipleDigitException {
        if (number < 0) {
            number = Math.abs(number); // Handle negative numbers
        }
        
        if (number > 9) {
            throw new MultipleDigitException("Number " + number + " has multiple digits! Only single-digit numbers are allowed.");
        }
    }

    public static void main(String[] args) {
       
        int[] numbers = {5, 25, -3, 156, 8, -42, 0, 9};

       
        for (int num : numbers) {
            try {
                System.out.println("\nChecking number: " + num);
                checkSingleDigit(num);
                System.out.println("Valid single-digit number!");
            } catch (MultipleDigitException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}