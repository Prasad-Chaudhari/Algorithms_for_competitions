
class LazyProp {

    int n;
    int tree[];

    public LazyProp(int si) {
        double x = Math.log(si) / Math.log(2);
        n = (int) (Math.pow(2, Math.ceil(x) + 1)) + 1;
        tree = new int[n];
    }

    public void insert(int s, int e, int pos, int l, int r, int d) {
        if (l <= s && e <= r) {
            tree[pos] += d;
            return;
        }
        if (r < s || l > e) {
            return;
        }
        int mid = (s + e) / 2;
        insert(s, mid, 2 * pos + 1, l, r, d);
        insert(mid + 1, e, 2 * pos + 2, l, r, d);
    }

    public int get(int s, int e, int pos, int index) {
        if (s == e) {
            return tree[pos];
        }
        if (2 * pos + 1 < n) {
            tree[2 * pos + 1] += tree[pos];
        }
        if (2 * pos + 2 < n) {
            tree[2 * pos + 2] += tree[pos];
        }
        tree[pos] = 0;
        int mid = (s + e) / 2;
        if (index <= mid) {
            return get(s, mid, 2 * pos + 1, index);
        } else {
            return get(mid + 1, e, 2 * pos + 2, index);
        }
    }
}
