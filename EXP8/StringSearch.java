import java.util.Scanner;

public class StringSearch{
    public static void main ( String args[]){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the main string: ");
        String mainString = scanner.nextLine();
        System.out.println("Enter the character or substring to search for: ");
        String searchString = scanner.nextLine();

        int firstOccurence = mainString.indexOf(searchString);
        if (firstOccurence != -1){
            System.out.println("First Occurence of " + searchString + "is at index " + firstOccurence);
        }
        else{
            System.out.println(" ' " + searchString + " ' not found in the main string");
        }

        int lastOccurence = mainString.lastIndexOf(searchString);
        if (lastOccurence != -1){
            System.out.println("Last occurence of " + searchString + " is at index: " + lastOccurence);
        }
        else{
            System.out.println("'" + searchString + "not found in the main string");
        }

        scanner.close();
        }
}