
import java.util.Arrays;
import java.util.Stack;

public class LCA_SparseTable {

    private final int n, parent[], level[], sptable[][];

    public LCA_SparseTable(int n, int top, int adja[][]) {

        this.n = n;
        parent = new int[n + 1];
        level = new int[n + 1];
        sptable = new int[n + 1][25];
        Stack<Integer> st = new Stack<>();
        boolean b[] = new boolean[n + 1];

        for (int i[] : sptable) {
            Arrays.fill(i, -1);
        }
        Arrays.fill(parent, -1);
        st.push(top);
        b[top] = true;

        while (!st.isEmpty()) {
            int root = st.pop();
            for (int i : adja[root]) {
                if (!b[i]) {
                    b[i] = true;
                    parent[i] = root;
                    level[i] = level[root] + 1;
                    st.push(i);
                }
            }
            int j = 0;
            sptable[root][j] = parent[root];
            while (sptable[root][j] != -1) {
                sptable[root][j + 1] = sptable[sptable[root][j]][j];
                j++;
            }
        }
    }

    public int[][] sptable() {
        return sptable;
    }

    public int lca(int u, int v) {
        if (level[u] < level[v]) {
            u ^= v;
            v ^= u;
            u ^= v;
        }
        int dist = level[u] - level[v];
        while (dist > 0) {
            int raised_to = (int) (Math.log(dist) / Math.log(2));
            u = sptable[u][raised_to];
            dist -= 1 << raised_to;
        }
        if (u == v) {
            return v;
        }
        for (int j = 24; j >= 0; j--) {
            if (sptable[u][j] != -1 && sptable[u][j] != sptable[v][j]) {
                u = sptable[u][j];
                v = sptable[v][j];
            }
        }
        return parent[u];
    }
}
