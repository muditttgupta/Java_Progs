import java.util.Scanner;

public class StringToUpperCase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i < inputString.length(); i++) {
            char currentChar = inputString.charAt(i);
            if (currentChar >= 'a' && currentChar <= 'z') {
                currentChar = (char) (currentChar - 32);
            }
            stringBuffer.append(currentChar);
        }
        System.out.println("String in uppercase: " + stringBuffer.toString());
        scanner.close();
    }
}