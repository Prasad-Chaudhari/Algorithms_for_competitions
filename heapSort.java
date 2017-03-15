import java.util.*;
class solve 
{    
    private static int N;
    static int [] a2;
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
    }

    public static void main(String[] args) 
    {
        Scanner in = new Scanner( System.in );            
        int t=in.nextInt();
        while(t-->0){
            int n=in.nextInt();
            int [] p=new int[n];
            int [] b=new int[n];
            for(int i=0;i<n;i++){
                p[i]=in.nextInt();
                b[i]=i+1;
            }
            a2=b;
            sort(p);
            ArrayList<LinkedList<Integer>> a=new ArrayList<LinkedList<Integer>>();
            for(int i=0;i<=n;i++){
                a.add(new LinkedList<Integer>());
                a.get(i).add(i);
            }
            for(int i=0;i<n-1;i++){
                int b2=in.nextInt();
                int c=in.nextInt();
                a.get(b2).add(c);
                a.get(c).add(b2);
            }
            for(int i=1;i<=n;i++){
                LinkedList b2=a.get(i);
                int j;
                for(j=n-1;j>=0;j--){
                    if(!b2.contains(b[j])){
                        System.out.print(b[j]+" ");
                        break;
                    }
                }
                if(j==-1){
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }    
}