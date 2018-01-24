// get arraylist for graph
public static ArrayList<LinkedList<Integer>> getGraph(Scanner in, int n, int m) {
	ArrayList<LinkedList<Integer>> a = new ArrayList<LinkedList<Integer>>();
	for (int i = 0; i <= n; i++) {
		a.add(new LinkedList<Integer>());
	}
	for (int i = 0; i < m; i++) {
		int x = in.nextInt();
		int y = in.nextInt();
		a.get(x).add(y);
		a.get(y).add(x);
	}
	return a;
}

//print values in a array
public static void print(int []a) {
	for (int i : a) {
		System.out.print(i + " ");
	}
	System.out.println();
}

// long to String partial to the base of k
public static String baseChangeString(long l, int k) {
	String s = "";
	while (l > 0) {
		s = s + l % k;
		l /= k;
	}
	return s;
}

// check if the string is pallindrome
public static boolean isPallindrome(String s) {
	char c[] = s.toCharArray();
	int n = c.length;
	for (int i = 0; i <= n / 2; i++) {
		if (c[i] != c[n - 1 - i]) {
			return false;
		}
	}
	return true;
}

// GCD of two Numbers
public int gcd(int x, int y) {
	if (y > x) {
		return gcd(y, x);
	}
	if (y == 0) {
		return x;
	} else {
		return gcd(y, x % y);
	}
}