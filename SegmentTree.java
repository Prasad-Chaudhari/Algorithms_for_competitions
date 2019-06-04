
class AnsSegmentTree extends SegmentTree {

    public AnsSegmentTree() {
        DEFAULT = Integer.MAX_VALUE;
    }

    @Override
    public int keyFunc(int a, int b) {
        return a & b;
    }
}

class OrSegmentTree extends SegmentTree {

    public OrSegmentTree() {
        DEFAULT = 0;
    }

    @Override
    public int keyFunc(int a, int b) {
        return a | b;
    }
}

class MaxSegmentTree extends SegmentTree {

    @Override
    public int keyFunc(int a, int b) {
        return Math.max(a, b);
    }
}

class MinSegmentTree extends SegmentTree {

    public MinSegmentTree() {
        this.DEFAULT = Integer.MAX_VALUE;
    }

    @Override
    public int keyFunc(int a, int b) {
        return Math.min(a, b);
    }
}

class SegmentTree {

    private int[] tree, array;
    int DEFAULT = 0;

    public void getArray(int[] a) {
        array = a;
        int si = a.length;
        double x = Math.log(si) / Math.log(2);
        int n = (int) (Math.pow(2, Math.ceil(x) + 1)) + 1;
        tree = new int[n];
    }

    public void build(int start, int end, int pos) {
        if (start == end) {
            tree[pos] = array[start];
        } else {
            int mid = (start + end) / 2;
            build(start, mid, 2 * pos);
            build(mid + 1, end, 2 * pos + 1);
            tree[pos] = keyFunc(tree[2 * pos], tree[2 * pos + 1]);
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
            tree[pos] = keyFunc(tree[2 * pos], tree[2 * pos + 1]);
        }
    }

    public int query(int start, int end, int pos, int l, int r) {
        if (start > r || end < l) {
            return DEFAULT;
        }
        if (l <= start && end <= r) {
            return tree[pos];
        } else {
            int mid = (start + end) / 2;
            int a = query(start, mid, 2 * pos, l, r);
            int b = query(mid + 1, end, 2 * pos + 1, l, r);
            return keyFunc(a, b);
        }
    }

    public void printTree() {
        for (int i = 0; i <= 2 * array.length; i++) {
            System.out.println(i + " " + tree[i]);
        }
        System.out.println();
    }

    public int keyFunc(int a, int b) {
        return a + b;
    }
}
