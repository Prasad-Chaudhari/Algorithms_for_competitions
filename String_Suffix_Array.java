
import java.util.Arrays;

class String_Suffix_Array {

    private char c[];
    private int indices[];

    public String_Suffix_Array(String s) {
        int n = c.length;
        Data d[] = new Data[n];
        int index[] = new int[n];
        indices = new int[n];

        c = s.toCharArray();
        for (int i = 0; i < n; i++) {
            d[i] = new Data(c[i] - 'a', i + 1 < n ? c[i + 1] - 'a' : -1, i);
        }

        Arrays.sort(d);
        for (int k = 2; k < n; k *= 2) {
            int rank = 0;
            int previous_rank = d[0].a;

            d[0].a = rank;
            index[d[0].c] = 0;
            for (int i = 1; i < n; i++) {
                if (d[i].a == previous_rank && d[i].b == d[i - 1].b) {
                    previous_rank = d[i].a;
                    d[i].a = rank;
                } else {
                    previous_rank = d[i].a;
                    d[i].a = ++rank;
                }
                index[d[i].c] = i;
            }

            for (int i = 0; i < n; i++) {
                int next = d[i].c + k;
                if (next < n) {
                    d[i].b = d[index[next]].a;
                } else {
                    d[i].b = -1;
                }
            }

            Arrays.sort(d);
        }

        for (int i = 0; i < n; i++) {
            indices[i] = d[i].c;
        }
    }

    public int[] sorted_suffix_index_list() {
        return indices;
    }

    private class Data implements Comparable<Data> {

        int a, b, c;

        public Data(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public int compareTo(Data o) {
            if (a == o.a) {
                if (b == o.b) {
                    return Integer.compare(c, o.c);
                }
                return Integer.compare(b, o.b);
            }
            return Integer.compare(a, o.a);
        }
    }
}
