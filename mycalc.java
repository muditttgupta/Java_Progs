class mycalc {
    public static void main(String[] args) {
        String op = args [1];
        int a  = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[2]);
        if (op.equals ("+")){
            System.out.println("Sum of " + a + " and " + b + " is: " + (a +b));
        }
        else if (op.equals ("-")) {
            System.out.println("Subtraction of" + a + " and " + b + " is: " + (a - b));
        }   
        else if (op.equals("/")){
            System.out.println("Division of " + a + " and " + b + " is: " + (a/b));
        }
        else if (op.equals("x")){
            System.out.println("Multiplication of" + a + " and " + b + " is: " + (a*b));
        }
    }
    
}
