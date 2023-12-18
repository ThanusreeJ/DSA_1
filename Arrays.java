public class Arrays{
    public static void kadanesAlgorithm(int[] a){
        int currentSum=0;
        int maxSum=Integer.MIN_VALUE;
        for(int i =0; i<a.length;i++){
            currentSum+=a[i];
            if(currentSum<=0){
                currentSum=0;
            }
        maxSum=Math.max(maxSum,currentSum);
        }
        System.out.println(maxSum);
    }
    public static void sortColors(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int i = 0;

        while (i <= high) {
            if (nums[i] == 0) {
                swap(nums, i, low);
                i++;
                low++;
            } else if (nums[i] == 2) {
                swap(nums, i, high);
                high--;
            } else {
                i++;
            }
        }
        System.out.print("Sorted array: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void findMaxMin(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("Array is empty");
            return;
        }

        int n = arr.length;
        int max = arr[0];
        int min = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            } else if (arr[i] < min) {
                min = arr[i];
            }
        }

        System.out.println("Maximum value: " + max);
        System.out.println("Minimum value: " + min);
    }
    public static void reverse(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            // Swap elements at start and end indices
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            // Move towards the center
            start++;
            end--;
        }
    }
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
    public static void rotateRight(int[] arr, int k) {
        int n = arr.length;


        k = k % n;

        
        reverse(arr, n - k, n - 1);

        
        reverse(arr, 0, n - k - 1);

        
        reverse(arr, 0, n - 1);
        System.out.print("Rotated array: ");
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            
            start++;
            end--;
        }
    }
    public static void findMaxSubarray(int[] arr) {
        int n = arr.length;
        int maxEndingHere = arr[0];
        int maxSoFar = arr[0];
        int start = 0;
        int end = 0;
        int tempStart = 0;

        for (int i = 1; i < n; i++) {
            if (arr[i] > maxEndingHere + arr[i]) {
                maxEndingHere = arr[i];
                tempStart = i;
            } else {
                maxEndingHere = maxEndingHere + arr[i];
            }

            if (maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
                start = tempStart;
                end = i;
            }
        }

        System.out.println("Maximum Subarray Sum: " + maxSoFar);
        System.out.println("Start Index: " + start);
        System.out.println("End Index: " + end);
    }
    public static void example(int[] ab) {
        int n = ab.length ;
        int xor = 2*ab.length+2;
        int k=0;
        for(int i=2;i<=2*ab.length;i=i+2){
               xor = xor ^ i ^ ab[k++];
            }
           System.out.println(xor); 
    }
    public static void main(String ...asd){
        int[] a={-2,-3,4,-1,-2,1,5,-3};
        int[] nums = {2, 0, 2, 1, 1, 0};
        kadanesAlgorithm(a);
        sortColors(nums);
        int[] array = {5, 2, 9, 1, 5, 6};
        findMaxMin(array);
        reverse(array);
        int k = 2;
        rotateRight(array, k);
        findMaxSubarray(array);
        int [] ab={3,7,9,11,13};
        example(ab);
    }
}