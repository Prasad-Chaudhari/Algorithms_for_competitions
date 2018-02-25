import java.util.*;
import java.lang.*;
import java.io.*;
/*
*/
public class Solution{
    public static void main (String[] args) throws java.lang.Exception{
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        if(n==2){
            System.out.println("2 2\n1 2 2");
            System.exit(0);
        }
        boolean [] c=new boolean[1000001];
        int [] primes=new int[1000000];
        int nop=0;
        for(int i=2;i<=1000;i++){
            if(!c[i]){
                for(int j=i*i;j<=1000000;j=j+i){
                    c[j]=!false;
                }
            }
        }
        for(int i=2;i<1000000;i++){
            if(!c[i]){
                primes[nop++]=i;
            }
        }
        ArrayList<LinkedList<Integer>> a = new ArrayList<LinkedList<Integer>>(n+1);
        ArrayList<LinkedList<Integer>> b = new ArrayList<LinkedList<Integer>>(n+1);
        for(int i=0;i<=n;i++){
            a.add(i, new LinkedList<Integer>());
            b.add(i, new LinkedList<Integer>());
        }
        a.get(1).add(n);
        a.get(n).add(1);
        b.get(1).add(2);
        b.get(n).add(2);
        for(int i=2;i<=n-2;i++){
            a.get(i).add(i+1);
            a.get(i+1).add(i);
            b.get(i).add(1);
            b.get(i+1).add(1);
        }
        int sum = n-1;
        int index = Arrays.binarySearch(primes,0,nop,sum);
        if(index<0){
            index = -1*index-1;
        }
        index+=10;
        a.get(2).add(1);
        a.get(1).add(2);
        b.get(1).add(primes[index]-sum);
        b.get(2).add(primes[index]-sum);
        m-=(n-1);
        int p = primes[index]-sum+1;
        for(int i=3;i<=n-1&&m>0;i++,m--){
            a.get(1).add(i);
            a.get(i).add(i);
            b.get(i).add(p);
            b.get(1).add(p);
        }
        for(int i=2;i<n&&m>0;i++){
            for(int j=i+2;j<n&&m>0;j++,m--){
                a.get(i).add(j);
                a.get(j).add(i);
                b.get(i).add(p);
                b.get(j).add(p);
            }
        }
        for(int i=2;i<n&&m>0;i++,m--){
            a.get(n).add(i);
            a.get(i).add(n);
            b.get(i).add(p);
            b.get(n).add(p);
        }
        System.out.println(2+" "+primes[index]);
        boolean g[]=new boolean[n+1];
        for(int i=1;i<=n;i++){
            LinkedList<Integer> l = a.get(i);
            LinkedList<Integer> e = b.get(i);
            int si = l.size();
            g[i]=true;
            while(si-->0){
                int u = l.removeFirst();
                int y = e.removeFirst();
                if(!g[u]){
                    System.out.println(i+" "+u+" "+y);
                }
            }
        }
    }
}
/*
public class Solution{
    public static void main (String[] args) throws java.lang.Exception{
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
    }
}
public class Solution{
    public static void main (String[] args) throws java.lang.Exception{
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
    }
}
public class Solution{
    public static void main (String[] args) throws java.lang.Exception{
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
    }
}
public class Solution{
    public static void main (String[] args) throws java.lang.Exception{
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
    }
}
*/