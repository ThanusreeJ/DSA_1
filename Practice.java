public class Practice {
    public static void kadanes(int a[], int size) {
        int curr_sum = 0;
        int max_sum = Integer.MIN_VALUE;
        for (int i = 0; i <= size; i++) {
            curr_sum += a[i];
            if (max_sum < curr_sum) {
                max_sum = curr_sum;
            }
            if (curr_sum < 0) {
                curr_sum = 0;
            }
        }
        System.out.println("MaximumSum: " +max_sum);
}
public static int boyerMoyer(int[] nums) {
    int votes = 1;
    int majorityElement = nums[0];
    for (int i = 1; i < nums.length; i++) {
        if (votes == 0) {
            majorityElement = nums[i];
            votes++;
        } else if (majorityElement != nums[i]) {
            votes--;
        } else {
            votes++;
        }
    }
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] == majorityElement) {
            count++;
        }
    }
    if (count > nums.length / 2) {
        return majorityElement;
    }
System.out.println("majorityElement is : "+majorityElement);
return 0;
}
public static void dutchNation() {
    int[] a = { 2, 0, 2, 1, 1, 0 };
    int n = a.length;
    int low = 0;
    int mid = 0;
    int high = n - 1;
    while (mid <= high) {
        if (a[mid] == 0) {
            int temp = a[low];
            a[low] = a[mid];
            a[mid] = temp;
            low++;
            mid++;
        } else if (a[mid] == 1) {
            mid++;
        } else {
            int temp = a[mid];
            a[mid] = a[high];
            a[high] = temp;
            high--;
        }
    }
    for (int i = 0; i < a.length; i++) {
        System.out.print(a[i]+" ");
    }
}
public static void twoSum() {
    int[] a = { 2, 7, 11, 19 };
    int target = 9;
    int n = a.length;
    int[] b = new int[2];
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            if (a[i] + a[j] == target) {
                b[0] = i;
                b[1] = j;
                break;
            }
        }
    }
    System.out.println();
    for (int i = 0; i < b.length; i++) {
        System.out.print(+b[i]+" ");
    }
}
public static void bubbleSort(int[] ab)
{   
    int n=ab.length;
    for(int i=0;i<n-1;i++)
    {
        for(int j=0;j<n-i-1;j++)
        {
            if(ab[j]>ab[j+1]) {
                int temp=ab[j];
                ab[j]=ab[j+1];
                ab[j+1]=temp;
            }
        } 
    }
    System.out.println();
    System.out.println("Bubblesort: ");
    for(int i = 0 ;i<n;i++) {
        System.out.println(ab[i]);
    }
}
public static void selectionSort(int[] ab){
    for(int i=0;i<ab.length;i++){
        int minPos=i;
        for(int j=i+1;j<ab.length;j++) {
            if(ab[j]<ab[minPos]){
                minPos=j;
            }
        }
        int temp=ab[i];
        ab[i] = ab[minPos];
        ab[minPos] = temp;
    }
    System.out.println();
    System.out.println("Selection sort : ");
    for(int i=0;i<ab.length;i++) {
        System.out.println(ab[i]);
    }
}
public static void insertionSort(int[] ab)
{
    for(int i=0;i<ab.length-1;i++) {
        int j=i+1;
        while(j>0 && ab[j]<ab[j-1]) {
            int temp=ab[j];
            ab[j]=ab[j-1];
            ab[j-1]=temp;
            j--;
        }

    }
    System.out.println("insertion sort : ");
    for(int i=0;i<ab.length;i++) {
        System.out.println(ab[i]);
    }
}
    public static void main(String[] args) {
        int a[]={1,2,3,4,5};
        int ab[]={3,1,7,4,8};
        int n=a.length-1;
        kadanes(a,n);
        boyerMoyer(a);
        dutchNation();
        twoSum();
        bubbleSort(ab);
        selectionSort(ab);
        insertionSort(ab);
    }
}
