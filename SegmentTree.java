class SegmentTree {

    private int [] tree, array;

    public void getArray(int [] a) {
        array = a;
        int si = a.length;
        double x = Math.log(si) / Math.log(2);
        int n = (int)(Math.pow(2, Math.ceil(x) + 1)) + 1;
        tree = new int[n];
    }

    public void build(int start, int end, int pos) {
        if (start == end) {
            tree[pos] = array[start];
        } else {
            int mid = (start + end) / 2;
            build(start, mid, 2 * pos);
            build(mid + 1, end, 2 * pos + 1);
            tree[pos] = Math.max(tree[2 * pos], tree[2 * pos + 1]);
        }
    }

    public void update(int start, int end, int pos, int idx, int x) {
        if (start == end) {
            array[start] = x;
            tree[pos] = x;
        } else {
            int mid = (start + end) / 2;
            if (start <= idx && idx <= mid) {
                update(start, mid, 2 * pos, idx, x);
            } else {
                update(mid + 1, end, 2 * pos + 1, idx, x);
            }
            tree[pos] = Math.max(tree[2 * pos], tree[2 * pos + 1]);
        }
    }

    public int query(int start, int end, int pos, int l, int r) {
        if (start > r || end < l) {
            return 0;
        }
        if (l <= start && end <= r) {
            return tree[pos];
        } else {
            int mid = (start + end) / 2;
            int a = query(start, mid, 2 * pos, l, r);
            int b = query(mid + 1, end, 2 * pos + 1, l, r);
            return Math.max(a, b);
        }
    }

    public void printTree() {
        for (int i = 0; i <= 2 * array.length; i++) {
            System.out.println(i + " " + tree[i]);
        }
        System.out.println();
    }
}
