class commandexample {
    public static void main(String args[]) {
        System.out.println((args[0] + " " + args[1]));
        int a  = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        System.out.println("Sum is: " + (a +b));
        String op = args[1];
        if (op.equals ("+")) {
            System.out.println("Addition: " + (a +b));
        }
    }
}
