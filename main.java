import java.util.*;
import java.lang.*;
import java.io.*;

/*
*/
public class Solution {
	public static void main (String[] args) throws java.lang.Exception {
		FastIO f = new FastIO()
		int n = f.ni();
		int q = f.ni();
		int a[] = new int[(int)Math.pow(2, n)];
		for (int i = 0; i < a.length; i++) {
			a[i] = f.ni();
		}

	}
}
class MixedEverything {

	int array[];
	int tree[];
	int lazy[];
	int k;
	int n;

	public MixedEverything(int n) {
		this.n = n;
		k = 0;
		array[] = new int[Math.pow(2, n)];
		tree[] = new int[Math.pow(2, n + 1)];
		lazy[] = new int[Math.pow(2, n + 1)];
		for (int i = 0; i < lazy.length; i++) {
			lazy[i] = -1;
		}
	}

	public void getArray(int a[]) {
		array = a;
	}

	public void build(int start, int end, int pos) {
		if (start == end) {
			tree[pos] = array[start];
		} else {
			int mid = (start + end) / 2;
			build(start, mid, 2 * pos);
			build(mid + 1, end, 2 * pos + 1);
			tree[pos] = Math.max(tree[2 * pos], tree[2 * pos + 1]);
		}
	}

	public void change(int start, int end, int pos, int l, int r, int x) {
		if (l <= start && end <= r) {
			lazy[pos] = x;
		} else if (r < start || l > end) {
			return;
		} else {
			int mid = (start + end) / 2;
			change(start, mid, 2 * pos, l, r, x);
			change(mid + 1, end, 2 * pos + 1, l, r, x);
		}
	}

	public void permute(int p) {
		k = k ^ p;
	}

	public int query(int start, int end, int pos, int l, int r) {
		if (l <= start && end<=r) {
			if(lazy[pos]!=-1){
				lazy[2*pos] = lazy[pos];
				lazy[2*pos+1] = lazy[pos];
				int ans = lazy[pos];
				lazy[pos] = -1;
				return ans;
			}
		}
	}
}
/*
public class Solution{
    public static void main (String[] args) throws java.lang.Exception{
        FastIO f = new FastIO()
        int n=f.ni();
    }
}
public class Solution{
    public static void main (String[] args) throws java.lang.Exception{
        FastIO f = new FastIO()
        int n=f.ni();
    }
}
public class Solution{
    public static void main (String[] args) throws java.lang.Exception{
        FastIO f = new FastIO()
        int n=f.ni();
    }
}
*/
class FastIO {

	BufferedReader br;
	StringTokenizer st;

	public FastIO() throws IOException {
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