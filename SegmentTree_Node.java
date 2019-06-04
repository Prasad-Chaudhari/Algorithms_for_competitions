
class AnsSegmentTree_Node extends SegmentTree_Node {

    public AnsSegmentTree_Node() {
        DEFAULT = Integer.MAX_VALUE;
    }

    @Override
    public int keyFunction(int a, int b) {
        return a & b;
    }

    @Override
    public void updateCurr(Node root, int value, int start, int end) {
        root.value &= value;
    }
}

class OrSegmentTree_Node extends SegmentTree_Node {

    public OrSegmentTree_Node() {
        DEFAULT = 0;
    }

    @Override
    public int keyFunction(int a, int b) {
        return a | b;
    }

    @Override
    public void updateCurr(Node root, int value, int start, int end) {
        root.value |= value;
    }
}

class MaxSegmentTree_Node extends SegmentTree_Node {

    public MaxSegmentTree_Node() {
        DEFAULT = Integer.MIN_VALUE;
    }

    @Override
    public int keyFunction(int a, int b) {
        return Math.max(a, b);
    }

    @Override
    public void updateCurr(Node root, int value, int start, int end) {
        root.value += value;
    }
}

class MinSegmentTree_Node extends SegmentTree_Node {

    public MinSegmentTree_Node() {
        this.DEFAULT = Integer.MAX_VALUE;
    }

    @Override
    public int keyFunction(int a, int b) {
        return Math.min(a, b);
    }

    @Override
    public void updateCurr(Node root, int value, int start, int end) {
        root.value += value;
    }
}

class SumSegmentTree_Node extends SegmentTree_Node {

    @Override
    public int keyFunction(int a, int b) {
        return a + b;
    }

    @Override
    public void updateCurr(Node root, int value, int start, int end) {
        root.value += value * (end - start + 1);
    }
}

abstract class SegmentTree_Node {

    class Node {

        int lazy;
        int value;
        Node leftNode, rightNode;

        public Node() {
            lazy = 0;
            value = 0;
            leftNode = null;
            rightNode = null;
        }

    }
    Node root;
    int DEFAULT = 0;

    public SegmentTree_Node() {
        root = new Node();
    }

    public int query(int start, int end, int l, int r) {
        return query(start, end, l, r, root);
    }

    private int query(int start, int end, int l, int r, Node root) {
        if (toBeUpdated(root)) {
            updateCurr(root, root.lazy, start, end);
            if (start != end) {
                updateLeft(root, 0);
                updateRight(root, 0);
            }
            root.lazy = 0;
        }
        if (end < l || r < start) {
            return DEFAULT;
        } else if (l <= start && end <= r) {
            return root.value;
        } else {
            int mid = (start + end) / 2;
            int left = query(start, mid, l, r, root.leftNode);
            int right = query(mid + 1, end, l, r, root.rightNode);
            return keyFunction(left, right);
        }
    }

    public void update(int start, int end, int l, int r, int value) {
        update(start, end, l, r, value, root);
    }

    private void update(int start, int end, int l, int r, int value, Node root) {
        if (toBeUpdated(root)) {
            updateCurr(root, root.lazy, start, end);
            if (start != end) {
                updateLeft(root, 0);
                updateRight(root, 0);
            }
            root.lazy = 0;
        }
        if (end < l || r < start) {

        } else if (l <= start && end <= r) {
            updateCurr(root, value, start, end);
            if (start != end) {
                updateLeft(root, value);
                updateRight(root, value);
            }
        } else {
            int mid = (start + end) / 2;
            if (root.leftNode == null) {
                root.leftNode = new Node();
            }
            if (root.rightNode == null) {
                root.rightNode = new Node();
            }
            update(start, mid, l, r, value, root.leftNode);
            update(mid + 1, end, l, r, value, root.rightNode);
            root.value = keyFunction(getValue(root.leftNode), getValue(root.rightNode));
        }
    }

    private int getValue(Node root) {
        if (root == null) {
            return DEFAULT;
        } else {
            return root.value;
        }
    }

    abstract void updateCurr(Node root, int value, int start, int end);

    abstract int keyFunction(int a, int b);

    private boolean toBeUpdated(Node root) {
        return root.lazy != 0;
    }

    private void updateLeft(Node root, int value) {
        if (root.leftNode == null) {
            root.leftNode = new Node();
        }
        root.leftNode.lazy += root.lazy + value;
    }

    private void updateRight(Node root, int value) {
        if (root.rightNode == null) {
            root.rightNode = new Node();
        }
        root.rightNode.lazy += root.lazy + value;
    }

    public void inOrder(int start, int end, Node root) {
        if (start == end) {
            System.out.println(start + " " + end + " " + root.value + " " + root.lazy);
            return;
        }
        int mid = (start + end) / 2;
        inOrder(start, mid, root.leftNode);
        System.out.println(start + " " + end + " " + root.value + " " + root.lazy);
        inOrder(mid + 1, end, root.rightNode);
    }
}
