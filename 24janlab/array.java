public class array {
    public static void main(String args[]){
        int arr[] = {2, 3, 2, 5, 2, 6};
        int target = 2;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                count++;
            }
        }

        System.out.println("The number " + target + " appears " + count + " times in the array.");
    }
    
}
