/**
* Recomended to use Fast IO
* Resource: https://en.wikipedia.org/wiki/Binomial_heap
*/

class BinomialHeap {

	private final Map<Integer, Node> trees;
	private int size;

	//Constructor
	public BinomialHeap() {
		trees = new HashMap<Integer, Node>();
	}

	//Public methods
	public void insert(int i) {
		Node newNode = new Node(i);
		addSubTree(0, newNode);
		size++;
	}

	public int findMin() {
		int min = Integer.MAX_VALUE;
		for (Node i : trees.values()) {
			if (min > i.getValue()) {
				min = i.getValue();
			}
		}
		return min;
	}

	public void deleteMin() {
		int min = Integer.MAX_VALUE;
		Node minTree = null;
		for (Node i : trees.values()) {
			if (min > i.getValue()) {
				min = i.getValue();
				minTree = i;
			}
		}
		trees.remove(minTree.getOrder());
		Node children = minTree.getChildren();
		addAllSiblings(children);
		minTree.setChild(null);
		size--;
	}

	public void merge(BinomialHeap b) {
		int size = b.size();
		int i = 0;
		while (size > 0) {
			if ((size & 1) == 1) {
				Node tree1 = trees.get(i);
				Node tree2 = b.getSubTree(i);
				if (tree1 != null) {
					deleteSubTree(i);
					Node mergedTree = mergeTrees(tree1, tree2);
					addSubTree(i + 1, mergedTree);
				} else {
					addSubTree(i, tree2);
				}
			}
			size = size >> 1;
			i++;
		}
	}

	public int size() {
		return size;
	}

	public Node getSubTree(int order) {
		return trees.get(order);
	}

	private Node mergeTrees(Node a, Node b) {
		if (a.getValue() < b.getValue()) {
			a.addChild(b);
			return a;
		} else {
			b.addChild(a);
			return b;
		}
	}

	private void addSubTree(int order, Node tree) {
		while (trees.containsKey(order)) {
			tree = mergeTrees(tree, trees.get(order));
			deleteSubTree(order);
			order++;
		}
		trees.put(order, tree);
	}

	private void addAllSiblings(Node n) {
		if (n != null) {
			addAllSiblings(n.getSibling());
			n.setSibling(null);
			addSubTree(n.getOrder(), n);
		}
	}

	private void deleteSubTree(int order) {
		trees.remove(order);
	}

	private class Node {

		private Node sibling;
		private Node child;
		private int order;
		private final int value;

		//Construtor
		public Node(int value) {
			this.value = value;
			sibling = null;
			child = null;
			order = 0;
		}

		// Public methods
		public void addChild(Node a) {
			if (child == null) {
				child = a;
			} else {
				a.sibling = child;
				child = a;
			}
			order++;
		}

		public int getValue() {
			return value;
		}

		public int getOrder() {
			return order;
		}

		public Node getChildren() {
			return child;
		}

		public Node getSibling() {
			return sibling;
		}

		public void setSibling(Node a) {
			sibling = a;
		}

		public void setChild(Node a) {
			child = a;
		}
	}
}

