import java.util.HashSet;

public class UniqueNames {
    public static void main(String args[]) {
        String names[] = {"Aman", "Varchasv", "Divyansh", "Varchasv", "Aman"};
        HashSet<String> uniqueNames = new HashSet<>();
        for (String name : names) {
            uniqueNames.add(name);
        }
        String nameToCheck = "Divyansh";
        if (uniqueNames.contains(nameToCheck)) {
            System.out.println(nameToCheck + " is present in the set.");
        } else {
            System.out.println(nameToCheck + " is not in the set.");
        }
        System.out.println("\nUnique names:");
        for (String name : uniqueNames) {
            System.out.println(name);
        }
    }
}
