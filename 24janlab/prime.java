public class prime {
    public static void main(String args[]) {
        int count = 0; 
        for (int i = 2; i <= 1000; i++) {
            int prime = 1;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    prime = 0; 
                    break;
                }
            }
            if (prime == 1) {
                count++;
                System.out.println(i);
            }
        }
        System.out.println("Total number of prime numbers between 1 and 1000: " + count);
        
        
    }

    
}
