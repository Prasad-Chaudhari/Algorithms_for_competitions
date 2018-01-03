import java.util.*;
import java.lang.*;
import java.io.*;
 
class Solution{
    public static void main (String[] args) throws java.lang.Exception{
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=in.nextInt();
        }
        int m=in.nextInt();
        ArrayList<ArrayList<LinkedList2>> b = new ArrayList<ArrayList<LinkedList2>>();
        int root=(int)Math.sqrt(n);
        for(int i=0;i<=root+1;i++){
            ArrayList<LinkedList2> c= new ArrayList<LinkedList2>();
            for(int j=0;j<=100;j++){
                c.add(new LinkedList2());
            }
            b.add(c);
        }
        for(int i=0;i<n;i++){
            int k=i/root;
            b.get(k).get(a[i]).add(i);
        }
        for(int i=0;i<m;i++){
            int l =in.nextInt()-1;
            int r =in.nextInt()-1;
            int x = in.nextInt();
            int y=in.nextInt();
            int k1= l/root;
            int k2 = r/root;
            if(k1==k2){
                LinkedList2 xl=b.get(k1).get(x);
                LinkedList2 yl=b.get(k2).get(y);
                int h=xl.size();
                for(int k=0;k<h;k++){
                    int p=xl.removeFirst();
                    if(p>=l&&p<=r){
                        yl.add(p);
                    }
                    else{
                        xl.add(p);
                    }
                }
            }
            else{
                LinkedList2 xl = b.get(k1).get(x);
                LinkedList2 yl = b.get(k1).get(y);
                int h=xl.size();
                for(int j=0;j<h;j++){
                    int p=xl.removeFirst();
                    if(p>=l&&p<(k1+1)*root){
                        yl.add(p);
                    }
                    else{
                        xl.add(p);
                    }
                }
                for(int j=k1+1;j<=k2-1;j++){
                    xl = b.get(j).get(x);
                    yl = b.get(j).get(y);
                    yl.addAll(xl);
                    b.get(j).set(x,new LinkedList2());
                }
                xl = b.get(k2).get(x);
                yl = b.get(k2).get(y);
                h=xl.size();
                for(int j=0;j<h;j++){
                    int p=xl.removeFirst();
                    if(p>=k2*root&&p<=r){
                        yl.add(p);
                    }
                    else{
                        xl.add(p);
                    }
                }
            }
        }
        for(ArrayList<LinkedList2> i:b){
            for(int j=0;j<=100;j++){
                LinkedList2 l = i.get(j);
                int p = l.size();
                for(int k=0;k<p;k++){
                    a[l.removeFirst()]=j;
                }
            }
        }
        for(int i:a){
            System.out.print(i+" ");
        }
    }
}
