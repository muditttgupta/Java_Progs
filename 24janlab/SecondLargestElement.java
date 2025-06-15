public class SecondLargestElement {
    public static void main(String[] args) {
       int[] arr = {12, 35, 1, 10, 34, 1};
        
        int fl,sl;

        if (arr[0] > arr[1]){
            fl=arr[0];
            sl=arr[1];
        }
	    else{
            fl=arr[1];
            sl=arr[0];
        }

        for(int i = 2; i < arr.length; i++){
            if(arr[i] > fl){
                sl=fl;
                fl=arr[i];
            } else if (arr[i]>sl&& arr[i]!=fl){
                sl=arr[i];
            }
        }
        System.out.println("second largest element: "+sl);
        }
    }

