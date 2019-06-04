
public class SegmentTree_LazyPropagation {

    int n;
    static int DEFAULT = 0;
    int tree[];
    int[] lazy_value;

    public SegmentTree_LazyPropagation(int si) {
        double x = Math.log(si) / Math.log(2);
        n = (int) (Math.pow(2, Math.ceil(x) + 1)) + 1;
        tree = new int[n];
        lazy_value = new int[n];
    }

    public int query(int start, int end, int pos, int l, int r) {
        if (toBeUpdated(pos)) {
            updateFunction(pos, lazy_value[pos], start, end);
            if (start != end) {
                lazyUpdate(2 * pos, lazy_value[pos]);
                lazyUpdate(2 * pos + 1, lazy_value[pos]);
            }
            lazy_value[pos] = 0;
        }
        if (end < l || r < start) {
            return DEFAULT;
        } else if (l <= start && end <= r) {
            return tree[pos];
        } else {
            int mid = (start + end) / 2;
            int a = query(start, mid, 2 * pos, l, r);
            int b = query(mid + 1, end, 2 * pos + 1, l, r);
            return keyFunction(a, b);
        }
    }

    public void update(int start, int end, int pos, int l, int r, int d) {
        if (start > r || end < l) {
            return;
        }
        if (toBeUpdated(pos)) {
            updateFunction(pos, lazy_value[pos], start, end);
            if (start != end) {
                lazyUpdate(2 * pos, lazy_value[pos]);
                lazyUpdate(2 * pos + 1, lazy_value[pos]);
            }
            lazy_value[pos] = 0;
        }
        if (l <= start && end <= r) {
            updateFunction(pos, d, start, end);
            if (start != end) {
                lazyUpdate(2 * pos, d);
                lazyUpdate(2 * pos + 1, d);
            }
        } else {
            int mid = (start + end) / 2;
            update(start, mid, 2 * pos, l, r, d);
            update(mid + 1, end, 2 * pos + 1, l, r, d);
            tree[pos] = keyFunction(tree[2 * pos], tree[2 * pos + 1]);
        }
    }

    private int keyFunction(int a, int b) {
        return a + b;
    }

    private void lazyUpdate(int pos, int d) {
        lazy_value[pos] += d;
    }

    private void updateFunction(int pos, int d, int start, int end) {
        tree[pos] += (end - start + 1) * d;
    }

    private boolean toBeUpdated(int pos) {
        return lazy_value[pos] != 0;
    }
}
