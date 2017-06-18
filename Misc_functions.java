// get arraylist for graph
public static ArrayList<LinkedList<Integer>> getGraph(Scanner in, int n,int m){
	ArrayList<LinkedList<Integer>> a=new ArrayList<LinkedList<Integer>>();
	for(int i=0;i<=n;i++){
		a.add(new LinkedList<Integer>());
	}
	for(int i=0;i<m;i++){
		int x=in.nextInt();
		int y=in.nextInt();
		a.get(x).add(y);
		a.get(y).add(x);
	}
	return a;
}
