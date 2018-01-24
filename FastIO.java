class FastIO {

	BufferedReader br;
	StringTokenizer st;

	public FastIO() throws IOException{
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