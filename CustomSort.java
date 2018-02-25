class Data {

	int a, b;

	public Data(int a, int b) {
		this.a = a;
		this.b = b;
	}
}

class Com implements Comparator<Data> {
	public int compare(Data a, Data b) {
		if (a.a == b.a) {
			if (a.b == b.b) {
				return 0;
			} else {
				return a.b - b.b;
			}
		} else {
			return a.a - b.a;
		}
	}
}
