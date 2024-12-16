
public class Sorting_Techniques {

    public static void main(String[] args) {
        int[] nums = {4, 8, 3, 7, 1, 2, 5};
        int n = nums.length;
        // BubbleSort(nums, n);
        // SelectionSort(nums, n);
        // InsertionSort(nums);
        // MergeSort(nums);
        printArray(nums);
    }

    public static void BubbleSort(int[] nums, int n) {
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;

                    swapped = true;
                }
            }

            if (!swapped) {
                return;
            }
        }
    }

    public static void SelectionSort(int[] nums, int n) {
        for (int i = 0; i < n - 1; i++) {
            int mpos = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[mpos]) {
                    mpos = j;
                }
            }

            int temp = nums[mpos];
            nums[mpos] = nums[i];
            nums[i] = temp;
        }
    }

    private static void InsertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j--;
            }
        }
    }

    public static void recMergeSort(int[] theSeq, int left, int right) {
        if (left < right) {

            // Middle point
            int mid = left + (right - left) / 2;

            // Sort first and second halves
            recMergeSort(theSeq, left, mid);
            recMergeSort(theSeq, mid + 1, right);

            // Merge sorted halves
            merge(theSeq, left, mid, right);

        }

    }

    public static void MergeSort(int[] theSeq) {
        recMergeSort(theSeq, 0, theSeq.length - 1);
    }

    private static void merge(int[] theSeq, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = theSeq[left + i];
        }

        for (int j = 0; j < n2; j++) {
            R[j] = theSeq[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                theSeq[k] = L[i];
                i++;
            } else {
                theSeq[k] = R[j];
                j++;
            }

            k++;
        }

        while (i < n1) {
            theSeq[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            theSeq[k] = R[j];
            j++;
            k++;
        }
    }

    public static int partitionSequence(int[] arr, int low, int high) {
        // Choose pivot 
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void quickSort(int[] theSeq, int first, int last) {
        // Partition Index: index of the pivot
        int pi = partitionSequence(theSeq, first, last);

        quickSort(theSeq, 0, pi - 1);
        quickSort(theSeq, pi + 1, last);
    }

    public static void printArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
