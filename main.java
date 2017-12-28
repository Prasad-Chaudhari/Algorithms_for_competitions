/* package codechef; // don't place package name! */
 
import java.util.*;
import java.lang.*;
import java.io.*;
 
/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner in = new Scanner(new File("TC5"));
        int t=in.nextInt();
        double ans []=new double[t];
        double ss[]=new double[t];
        double bb[]=new double[t];
        double pp[]=new double[t];
        PrintWriter writer = new PrintWriter("OC5_java.txt", "UTF-8");
        for(int i=0;i<t;i++){
            ss[i]=in.nextDouble();
            bb[i]=in.nextDouble();
            pp[i]=in.nextDouble();
            double s=ss[i];
            double b=bb[i];
            double p =pp[i];
            double a = Math.log((s-b)/(s-b/2));
            double f = Math.log(1-p);
            ans[i]=(Math.floor(a/f));
            writer.println(ans[i]);
        }
        in = new Scanner(new File("OC5"));
        double correct[]=new double[t];
        for(int i=0;i<t;i++){
            correct[i]=in.nextDouble();
        }
        for(int i=0;i<t;i++){
            if(ans[i]!=correct[i]){
                System.out.println(i+" "+ss[i]+" "+bb[i]+" "+pp[i]+" "+ans[i]+" "+correct[i]+" ");
            }
        }
    }
}
 