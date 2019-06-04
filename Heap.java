<<<<<<< HEAD
class Heap {

    int heap[] = new int[100001];
    int size = 0;

    public void insert(int a) {
        heap[size++] = a;
        int parent = (size - 2) / 2;
        while (true) {
            int left = 2 * parent + 1;
            int right = 2 * parent + 2;
            int largest = parent;
            if (left < size && heap[left] > heap[parent]) {
                largest = left;
            }
            if (right < size && heap[right] > heap[largest]) {
                largest = right;
            }
            if (largest != parent) {
                swap(largest, parent);
                maxheap(largest);
                parent = (parent - 1) / 2;
            } else {
                break;
            }
        }
    }

    public void maxheap(int parent) {
        int left = 2 * parent + 1;
        int right = 2 * parent + 2;
        int largest = parent;
        if (left < size && heap[left] > heap[parent]) {
            largest = left;
        }
        if (right < size && heap[right] > heap[largest]) {
            largest = right;
        }
        if (largest != parent) {
            swap(largest, parent);
            maxheap(largest);
        }
    }

    public void swap(int i, int j) {
        Trainer temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public int delete_max() {
        if (size == 0) {
            return 0;
        }
        if (heap[0].l > 1) {
            heap[0].l--;
            return heap[0];
        } else {
            int max = heap[0];
            heap[0] = heap[size - 1];
            heap[size - 1] = null;
            size--;
            maxheap(0);
            return 0 - max;
        }
    }
}
=======
class Heap {

    int heap[] = new int[100001];
    int size = 0;

    public void insert(int a) {
        heap[size++] = a;
        int parent = (size - 2) / 2;
        while (true) {
            int left = 2 * parent + 1;
            int right = 2 * parent + 2;
            int largest = parent;
            if (left < size && heap[left] > heap[parent]) {
                largest = left;
            }
            if (right < size && heap[right] > heap[largest]) {
                largest = right;
            }
            if (largest != parent) {
                swap(largest, parent);
                maxheap(largest);
                parent = (parent - 1) / 2;
            } else {
                break;
            }
        }
    }

    public void maxheap(int parent) {
        int left = 2 * parent + 1;
        int right = 2 * parent + 2;
        int largest = parent;
        if (left < size && heap[left] > heap[parent]) {
            largest = left;
        }
        if (right < size && heap[right] > heap[largest]) {
            largest = right;
        }
        if (largest != parent) {
            swap(largest, parent);
            maxheap(largest);
        }
    }

    public void swap(int i, int j) {
        Trainer temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public int delete_max() {
        if (size == 0) {
            return 0;
        }
        if (heap[0].l > 1) {
            heap[0].l--;
            return heap[0];
        } else {
            int max = heap[0];
            heap[0] = heap[size - 1];
            heap[size - 1] = null;
            size--;
            maxheap(0);
            return 0 - max;
        }
    }
}
>>>>>>> parent of 80d014c... Merge pull request #2 from Prasad-Chaudhari/Updating_classes
