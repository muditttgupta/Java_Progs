public class sumofdig {
    public static void main(String args[]){
        int no=Integer.parseInt(args[0]);
		int sum=0;
		int rem;
		while(no!=0){
			rem=no%10;
			sum+=rem;
			no=no/10;
		}
		System.out.println("Sum of the digits is :"+sum);

    }
    
}
