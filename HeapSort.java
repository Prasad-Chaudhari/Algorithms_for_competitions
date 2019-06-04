class Heapsort {

    private static int N;
    static int [] a2;

    public Heapsort(int n, int [] a) {
        N = n;
        a2 = a;
    }

    public static void sort(int [] arr) {
        heapify(arr);
        for (int i = N; i > 0; i--) {
            swap(arr, 0, i);
            N = N - 1;
            maxheap(arr, 0);
        }
    }

    public static void heapify(int [] arr) {
        N = arr.length - 1;
        for (int i = N / 2; i >= 0; i--)
            maxheap(arr, i);
    }

    public static void maxheap(int [] arr, int i) {
        int left = 2 * i ;
        int right = 2 * i + 1;
        int max = i;
        if (left <= N && arr[left] > arr[i])
            max = left;
        if (right <= N && arr[right] > arr[max])
            max = right;

        if (max != i) {
            swap(arr, i, max);
            maxheap(arr, max);
        }
    }

    public static void swap(int [] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
        a2[i] = a2[i] ^ a2[j];
        a2[j] = a2[i] ^ a2[j];
        a2[i] = a2[i] ^ a2[j];
    }
}
