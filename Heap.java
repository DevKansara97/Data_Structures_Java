
// rightChild idx = 2i+1
// parent idx = i/2
public class Heap {

    static int[] heap;
    static int size;

    public Heap() {
        heap = new int[100];
        // heap[0] = -1;
        size = 0;
    }

    // O(logn)
    public void insertNode(int val) {
        int idx = size++;
        heap[idx] = val;

        while (idx > 0) {
            int parentIdx = (idx - 1) / 2;
            if (heap[parentIdx] < heap[idx]) {
                // swap them
                swap(heap, idx, parentIdx);
            } else {
                return;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
    }

    public void deleteNode() {
        if (size == 0) {
            System.out.println("Empty Heap...");
            return;
        }

        heap[0] = heap[size - 1];
        size--;

        int i = 0;
        while (i < size) {
            int leftIdx = 2 * i + 1;
            int rightIdx = 2 * i + 2;

            if (leftIdx < size && heap[i] < heap[leftIdx]) {
                swap(heap, i, leftIdx);
                i = leftIdx;
            } else if (rightIdx < size && heap[i] < heap[rightIdx]) {
                swap(heap, i, rightIdx);
                i = rightIdx;
            } else {
                return;
            }
        }
    }

    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(this.heap[i] + " ");
        }
        System.out.println();
    }

    // public static void swap(int[] arr, int i, int j) {
    //     int temp = arr[i];
    //     arr[i] = arr[j];
    //     arr[j] = temp;
    // }
    public static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[largest] < arr[left]) {
            largest = left;
        }

        if (right < n && arr[largest] < arr[right]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, largest, i);
            heapify(arr, n, largest);
        }
    }

    public static void heapSort(int[] heap, int n) {
        int size = n;
        while (size > 0) {
            swap(heap, size - 1, 0);
            size--;

            heapify(heap, size, 0);
        }
    }

    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.insertNode(50);
        heap.insertNode(55);
        heap.insertNode(53);
        heap.insertNode(52);
        heap.insertNode(54);
        heap.printHeap();
        heap.deleteNode();
        heap.printHeap();

        int[] arr = {4, 3, 5, 2, 0};
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        printArray(arr, n);

        heapSort(arr, n);
        printArray(arr, n);
    }

    public static void printArray(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

}
