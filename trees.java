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
class BinaryTree{
	Node root;
	public BinaryTree(int data){
		root=new Node(data);
	}
	public void add(String s,int data){
		char [] c=s.toCharArray();
		Node curr=root;
		int i=0;
		while(i!=c.length){
			if(c[i]=='L'){
				if(curr.left==null){
					curr.left=new Node(data);
				}
				else{
					curr=curr.left;
				}
			}
			else{
				if(curr.right==null){
					curr.right=new Node(data);
				}
				else{
					curr=curr.right;
				}
			}
		}
	}
}