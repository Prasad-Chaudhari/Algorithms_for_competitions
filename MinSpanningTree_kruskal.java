import java.util.*;
class TestClass {
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
    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        UnionFind u= new UnionFind(n);
        int x[]=new int[m];
        int y[]=new int[m];
        int e[]=new int[m];
        for(int i=0;i<m;i++){
            x[i]=in.nextInt();
            y[i]=in.nextInt();
            e[i]=in.nextInt();
        }
        HeapSort h=new HeapSort(m,x,y);
        h.sort(e);
        x=h.a2;
        y=h.a3;
        ArrayList<LinkedList<Integer>> a=new ArrayList<LinkedList<Integer>>();
        ArrayList<LinkedList<Integer>> b=new ArrayList<LinkedList<Integer>>();
        for(int i=0;i<=n;i++){
            a.add(new LinkedList<Integer>());
            b.add(new LinkedList<Integer>());
        }
        int count=0;
        for(int i=0;i<m&&count!=n-1;i++){
            if(u.find(x[i])!=u.find(y[i])){
                a.get(x[i]).add(y[i]);
                a.get(y[i]).add(x[i]);
                b.get(x[i]).add(e[i]);
                b.get(y[i]).add(e[i]);
                System.out.println(x[i]+" "+y[i]+" "+e[i]);
                u.union(u.find(x[i]),u.find(y[i]));
            }
        }
    }
}
class UnionFind{
    int component[];
    int size[];
    int n;
    ArrayList<LinkedList<Integer>> members;
    public UnionFind(int p){
        n=p;
        component=new int[n+1];
        size=new int[n+1];
        members=new ArrayList<LinkedList<Integer>>();
        for(int i=0;i<=n;i++){
            component[i]=i;
            size[i]=1;
            members.add(new LinkedList<Integer>());
            members.get(i).add(i);
        }
    }
    
    public int find(int k){
        return component[k];
    }
    
    public void union(int a,int b){
        if(size[a]>size[b]){
            a=a^b;
            b=a^b;
            a=a^b;
        }
        LinkedList<Integer> membersofa=members.get(a);
        LinkedList<Integer> membersofb=members.get(b);
        for(int i=0;i<size[a];i++){
            int member=membersofa.removeFirst();
            component[member]=component[b];
            membersofb.add(member);
        }
        size[b]=size[b]+size[a];
    }
}
class HeapSort 
{    
    private static int N;
    static int [] a2;
    static int [] a3;
    public HeapSort(int n,int [] a,int [] b){
        N=n;
        a2=a;
        a3=b;
    }
    public static void sort(int [] arr){
        heapify(arr);        
        for (int i = N; i > 0; i--)
        {
            swap(arr,0, i);
            N = N-1;
            maxheap(arr, 0);
        }
    }
    public static void heapify(int [] arr){
        N = arr.length-1;
        for (int i = N/2; i >= 0; i--)
            maxheap(arr, i);        
    }
    public static void maxheap(int [] arr, int i){
        int left = 2*i ;
        int right = 2*i + 1;
        int max = i;
        if (left <= N && arr[left] > arr[i])
            max = left;
        if (right <= N && arr[right] > arr[max])        
            max = right;
 
        if (max != i)
        {
            swap(arr, i, max);
            maxheap(arr, max);
        }
    }
    public static void swap(int [] arr, int i, int j){
        arr[i]=arr[i]^arr[j];
        arr[j]=arr[i]^arr[j];
        arr[i]=arr[i]^arr[j];
        a2[i]=a2[i]^a2[j];
        a2[j]=a2[i]^a2[j];
        a2[i]=a2[i]^a2[j];
        a3[i]=a3[i]^a3[j];
        a3[j]=a3[i]^a3[j];
        a3[i]=a3[i]^a3[j];
    }    
}
