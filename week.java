class week{
	public static void main(String args[])
	{
		int a=Integer.parseInt(args[0]);
		switch(a){
		case(1):
			System.out.println("Sunday");
			break;
		case(2):
			System.out.println("Monday");
			break;
		case(3):
			System.out.println("Tuesday");
			break;
		case(4):
			System.out.println("Wednesday");
			break;
		case(5):
			System.out.println("Thrusday");
			break;
		case(6):
			System.out.println("Friday");
			break;
		case(7):
			System.out.println("Saturday");
			break;
		default:
			System.out.println("Not a Week");
		}

	}
}
