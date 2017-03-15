class Node{
	int data;
	Node left;
	Node right;
	public Node(int data){
		this.data=data;
		left=null;
		right=null;
	}
}
class BinarySearchTree{
	Node root;
	public BinarySearchTree(int data){
		root=new Node(data);
	}
	public void add(int data){
		Node curr=root;
		while(true){
			if(curr.data>=data){
				if(curr.left==null){
					curr.left=new Node(data);
					break;
				}
				else{
					curr=curr.left;
				}
			}
			else{
				if(curr.right==null){
					curr.right=new Node(data);
					break;
				}
				else{
					curr=curr.right;
				}
			}
		}
	}
}