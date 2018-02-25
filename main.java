import java.util.*;
import java.lang.*;
import java.io.*;

/*
*/

public class Solution{
    public static void main (String[] args) throws java.lang.Exception{
        FastIO f = new FastIO();
        int n = f.ni();
        byte a[] = new byte[n];
        for(int i=0;i<n;i++){
            a[i] = (byte)f.ni();
        }
        int min = 0;
        int max =0;
        for(int i=0;i<n;i++){
            if(a[i]==1){
                min++;
                max++;
                if(i!=n-1){
                    if(a[i+1]==1){
                        i++;
                        max++;
                    }
                }
            }
        }
        System.out.println(min+" "+max);
    }
}

/*
public class Solution{
    public static void main (String[] args) throws java.lang.Exception{
        FastIO f = new FastIO();
    }
}
public class Solution{
    public static void main (String[] args) throws java.lang.Exception{
        FastIO f = new FastIO();
    }
}
public class Solution{
    public static void main (String[] args) throws java.lang.Exception{
        FastIO f = new FastIO();
    }
}
*/

class FastIO {

	BufferedReader br;
	StringTokenizer st;

	public FastIO() throws IOException {
		//br = new BufferedReader((new FileReader("text.txt")));
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
	}

	public String nextToken() throws IOException {
		if (st.hasMoreTokens()) {
			return st.nextToken();
		} else {
			st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}
	}

	public int ni() throws IOException {
		return Integer.parseInt(nextToken());
	}

	public String ns() throws IOException {
		return nextToken();
	}

	public long nl() throws IOException {
		return Long.parseLong(nextToken());
	}

	public double nd() throws IOException {
		return Double.parseDouble(nextToken());
	}
}