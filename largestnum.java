public class largestnum {
    public static void main(String[] args) {
        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);
        int num3 = Integer.parseInt(args[2]);
        int greatest;
            if (num1 >= num2) {
                if (num1 >= num3) {
                    greatest = num1;
                } else {
                    greatest = num3;
                }
            } else {
                if (num2 >= num3) {
                    greatest = num2;
                } else {
                    greatest = num3;
                }
            }
            System.out.println("The largest number is: " + greatest);
    }
}
    

