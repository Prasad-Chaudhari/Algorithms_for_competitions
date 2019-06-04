
public class FastUnionFind {

    int noOfComponents, n;
    private int[] parent, rank;

    public FastUnionFind(int n) {
        this.n = n;
        this.noOfComponents = n;
        parent = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int p) {
        if (parent[p] == p) {
            return p;
        } else {
            return find(parent[p]);
        }
    }

    public void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            if (rank[a] > rank[b]) {
                parent[b] = a;
            } else if (rank[b] > rank[a]) {
                parent[a] = b;
            } else {
                parent[b] = a;
                rank[a]++;
            }
            noOfComponents--;
        }
    }
}
