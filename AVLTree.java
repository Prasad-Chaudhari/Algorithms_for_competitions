
public class AVLTree<T extends Comparable<T>> {

    private Node traverse(Node base, T value) {
        if (base == null) {
            Node node = new Node();
            node.value = value;
            return node;
        } else if (base.value.compareTo(value) <= 0) {
            base.left = traverse(base.left, value);
        } else {
            base.right = traverse(base.right, value);
        }
        base.height = 1 + Math.max(getHeight(base.left), getHeight(base.right));
        int balance_factor = getBalanceFactor(getHeight(base.left), getHeight(base.right));
        if (balance_factor > 1 && value.compareTo(base.left.value) <= 0) {
            return rightRotate(base);
        } else if (balance_factor < -1 && value.compareTo(base.right.value) > 0) {
            return leftRotate(base);
        } else if (balance_factor > 1 && value.compareTo(base.left.value) > 0) {
            base.left = leftRotate(base.left);
            return rightRotate(base);
        } else if (balance_factor < -1 && value.compareTo(base.right.value) <= 0) {
            base.right = rightRotate(base.right);
            return leftRotate(base);
        }
        return base;
    }

    private Node leftRotate(Node y) {
        Node x = y.right;
        Node t2 = x.left;
        x.left = y;
        y.right = t2;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        return x;
    }

    private Node rightRotate(Node x) {
        Node y = x.left;
        Node t2 = y.right;
        y.right = x;
        x.left = t2;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        return y;
    }

    private int getBalanceFactor(int a, int b) {
        return a - b;
    }

    private int getHeight(Node n) {
        if (n == null) {
            return 0;
        } else {
            return n.height;
        }
    }

    private class Node {

        Node left, right;
        T value;
        int height;

        public Node() {
            left = null;
            right = null;
            height = 0;
        }
    }

    Node base;

    public AVLTree() {
        base = new Node();
    }

    public void insert(T value) {
        if (base.value == null) {
            base.value = value;
        } else {
            base = traverse(base, value);
        }
    }
}
