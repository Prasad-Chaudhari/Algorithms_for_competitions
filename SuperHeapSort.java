
class SuperHeapSort {

    private int n;
    private Item a[];

    public void sort(int a[]) {
        n = a.length;
        this.a = new Item[n];
        for (int i = 0; i < n; i++) {
            this.a[i] = new Item(a[i]);
        }
        sorting();
        n = a.length;
        for (int i = 0; i < n; i++) {
            a[i] = this.a[i].i;
        }
    }

    public void sort(long a[]) {
        n = a.length;
        this.a = new Item[n];
        for (int i = 0; i < n; i++) {
            this.a[i] = new Item(a[i]);
        }
        sorting();
        n = a.length;
        for (int i = 0; i < n; i++) {
            a[i] = this.a[i].l;
        }
    }

    public void sort(char a[]) {
        n = a.length;
        this.a = new Item[n];
        for (int i = 0; i < n; i++) {
            this.a[i] = new Item(a[i]);
        }
        sorting();
        n = a.length;
        for (int i = 0; i < n; i++) {
            a[i] = this.a[i].c;
        }
    }

    public void sort(double a[]) {
        n = a.length;
        this.a = new Item[n];
        for (int i = 0; i < n; i++) {
            this.a[i] = new Item(a[i]);
        }
        sorting();
        n = a.length;
        for (int i = 0; i < n; i++) {
            a[i] = this.a[i].d;
        }
    }

    public void sort(String a[]) {
        n = a.length;
        this.a = new Item[n];
        for (int i = 0; i < n; i++) {
            this.a[i] = new Item(a[i]);
        }
        sorting();
        n = a.length;
        for (int i = 0; i < n; i++) {
            a[i] = this.a[i].s;
        }
    }

    public void sort(Data a[]) {
        n = a.length;
        this.a = new Item[n];
        for (int i = 0; i < n; i++) {
            this.a[i] = new Item(a[i]);
        }
        sorting();
        n = a.length;
        for (int i = 0; i < n; i++) {
            a[i] = this.a[i].data;
        }
    }

    private void sorting() {
        heapify();
        for (int i = n; i > 0; i--) {
            swap(0, i);
            n = n - 1;
            maxheap(0);
        }
    }

    private void heapify() {
        n = a.length - 1;
        for (int i = n / 2; i >= 0; i--) {
            maxheap(i);
        }
    }

    private void maxheap(int i) {
        int left = 2 * i;
        int right = 2 * i + 1;
        int max = i;
        if (left <= n && a[left].compareTo(a[i]) > 0) {
            max = left;
        }
        if (right <= n && a[right].compareTo(a[max]) > 0) {
            max = right;
        }
        if (max != i) {
            swap(i, max);
            maxheap(max);
        }
    }

    private void swap(int i, int j) {
        Item temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }

    private class Item implements Comparable<Item> {

        Integer i;
        Long l;
        Character c;
        Double d;
        String s;
        Data data;

        public Item(int a) {
            i = a;
        }

        public Item(long a) {
            l = a;
        }

        public Item(char a) {
            c = a;
        }

        public Item(double a) {
            d = a;
        }

        public Item(Data a) {
            data = a;
        }

        public Item(String a) {
            s = a;
        }

        @Override
        public int compareTo(Item item) {
            if (i != null) {
                return i.compareTo(item.i);
            } else if (l != null) {
                return l.compareTo(item.l);
            } else if (c != null) {
                return c.compareTo(item.c);
            } else if (d != null) {
                return d.compareTo(item.d);
            } else if (s != null) {
                return s.compareTo(item.s);
            } else {
                return data.compareTo(item.data);
            }
        }
    }
}

class Data implements Comparable<Data> {

    int a, b;

    public Data(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Data o) {
        if (this.a == o.a) {
            return Integer.compare(this.b, o.b);
        } else {
            return Integer.compare(this.a, o.a);
        }
    }
}
