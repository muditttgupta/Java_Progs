class posnegzero {
	public static void main(String args[])
	{
		double b = Double.parseDouble(args[1]);
		if(args[0].equals("-")){
			System.out.println("Value is negative: "+args[0]+args[1]);
        }
		else if(args[0].equals("+")){
			System.out.println("Value is positive: "+args[0]+args[1]);
        }
		else if(args[0].equals("0")){
			System.out.println("Value is zero: "+args[0]+args[1]);
        }
	}
}
    

