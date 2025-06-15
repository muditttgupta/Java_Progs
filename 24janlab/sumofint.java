public class sumofint {
    public static void main(String args[]){
        int i = 10;
        int j = 950;
        int divisor = 18;
        int totalSum = 0;

        for (int number = i; number <= j; number++) {
            if (number % divisor == 0) {
                totalSum += number;
            }
        }
        System.out.println("The sum of all integers between " + i + " and " + j +  " that are divisible by both 6 and 9 is: " + totalSum);
    }
    
}
