/**
*Use Stack for dsf
*/

class Graph {

    int [] level,parent,connected;
    int n;
    Queue<Integer> q;
    Stack<Integer> st;
    ArrayList<LinkedList<Integer>> a;

    public Graph(ArrayList<LinkedList<Integer>> input) {
        a = input;
        n = a.size() - 1;
        level = new int[n + 1];
        parent = new int[n + 1];
        connected = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            level[i] = -1;
            parent[i] = -1;
        }
        //q = new LinkedList<Integer>();
        //st = new Stack<Integer>();
        build();
    }

    void build() {
        boolean [] c = new boolean[n + 1];
        int count = 1;
        for (int i = 1; i <= n; i++) {
            if (!c[i]) {
                level[i] = 1;
                connected[i] = count++;
                //q.enqueue(i); nextbfs(c);
                //st.push(i); nextdfs(c);
            }
        }
    }

    void nextbfs(boolean [] c) {
        if (q.isEmpty()) {
            return;
        }
        int root = q.peek();
        c[root] = true;
        LinkedList<Integer> sibs = a.get(root);
        int size = sibs.size();
        for (int i = 0; i < size; i++) {
            int sib = sibs.removeFirst();
            if (!c[sib]) {
                c[sib] = true;
                parent[sib] = root;
                level[sib] = level[root] + 1;
                connected[sib] = connected[root];
                q.enqueue(sib);
            }
        }
        q.dequeue();
        nextbfs(c);
    }

    void nextdfs(boolean [] c) {
        if (st.isEmpty()) {
            return;
        }
        int root = st.pop();
        c[root] = true;
        LinkedList<Integer> sibs = a.get(root);
        int size = sibs.size();
        for (int i = 0; i < size; i++) {
            int sib = sibs.removeFirst();
            if (!c[sib]) {
                c[sib] = true;
                parent[sib] = root;
                level[sib] = level[root] + 1;
                connected[sib] = connected[root];
                st.push(sib);
                nextdfs(c);
            }
        }
    }
}
