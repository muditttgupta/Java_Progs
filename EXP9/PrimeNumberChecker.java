import java.util.ArrayList;

public class PrimeNumberChecker {
    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public static void main(String args[]) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            numbers.add(i);
        }
        for (Integer num : numbers) {
            int value = num;
            if (isPrime(value)) {
                System.out.println(value + " is a prime number.");
            } else {
                System.out.println(value + " is not a prime number.");
            }
        }
    }
}
