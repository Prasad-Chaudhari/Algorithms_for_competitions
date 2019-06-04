class UnionFind {

    private int noOfComponents, n;
    private int component[], size[];
    private ArrayList<LinkedList<Integer>> members;

    public UnionFind(int p) {
        n = p;
        noOfComponents = n;
        component = new int[n + 1];
        size = new int[n + 1];
        members = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            component[i] = i;
            size[i] = 1;
            members.add(new LinkedList<Integer>());
            members.get(i).add(i);
        }
    }

    public int find(int k) {
        return component[k];
    }

    public void union(int a, int b) {
        if (size[a] > size[b]) {
            a = a ^ b;
            b = a ^ b;
            a = a ^ b;
        }
        LinkedList<Integer> membersofa = members.get(a);
        LinkedList<Integer> membersofb = members.get(b);
        for (int i = 0; i < size[a]; i++) {
            int member = membersofa.removeFirst();
            component[member] = component[b];
            membersofb.add(member);
        }
        size[b] = size[b] + size[a];
        noOfComponents--;
    }

    public int noOfComponents() {
        return noOfComponents;
    }
}
