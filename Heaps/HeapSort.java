public class HeapSort {

    public static void heapify(int arr[], int i, int size) {
        int maxidx = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && arr[left] > arr[maxidx]) {
            maxidx = left;
        }

        if (right < size && arr[right] > arr[maxidx]) {
            maxidx = right;
        }

        if (i != maxidx) {
            int temp = arr[maxidx];
            arr[maxidx] = arr[i];
            arr[i] = temp;

            heapify(arr, maxidx, size);
        }
    }

    public static void Sort(int arr[]) {
        int n = arr.length;
        for (int i = n / 2; i >= 0; i--) {
            heapify(arr, i, n);
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            heapify(arr, 0, i);
        }
    }

    public static void main(String[] args) {
        int a[] = { 1, 2, 4, 5, 3 };

        Sort(a);

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

    }
}
