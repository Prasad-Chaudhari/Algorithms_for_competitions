class Graph{
    int [] level;
    int [] parent;
    int [] connected;
    int n;
    int []queue;
    int start;
    int end;
    ArrayList<LinkedList<Integer>> a;
    public Graph(ArrayList<LinkedList<Integer>> input){
        a=input;
        n=a.size()-1;
        level= new int[n+1];
        parent=new int[n+1];
        connected=new int[n+1];
        for(int i=0;i<=n;i++){
            level[i]=-1;
            parent[i]=-1;
        }
        build();
    }
    void build(){
        boolean [] c=new boolean[n+1];
        int count=1;
        queue= new int[n+1];
        queue[0]=1;
        start=0;
        end=0;
        for(int i=1;i<=n;i++){
            if(!c[i]){
                level[i]=1;
                connected[i]=count++;
                queue[start]=i;
                end=start+1;
                next(c);
            }
        }
    }
    void next(boolean [] c){
        if(start==end){
            return;
        }
        int root=queue[start];
        c[root]=true;
        LinkedList<Integer> sibs=a.get(root);
        int size=sibs.size();
        for(int i=0;i<size;i++){
            int sib=sibs.removeFirst();
            if(!c[sib]){
                print(queue);
                c[sib]=true;
                parent[sib]=root;
                level[sib]=level[root]+1;
                connected[sib]=connected[root];
                queue[end++]=sib;
            }
        }
        start++;
        next(c);
    }
    void print(int [] a){
        for(int i:a){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}