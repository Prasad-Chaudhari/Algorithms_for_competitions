
public class BIT {

    long[] bit;

    public BIT(int n, long a[]) {
        for (int i = 1; i <= n; i++) {
            bit[i] += a[i];
            if (i + (i & -i) <= n) {
                bit[i + (i & -i)] += bit[i];
            }
        }
    }

    public BIT(int n, int a[]) {
        for (int i = 1; i <= n; i++) {
            bit[i] += a[i];
            if (i + (i & -i) <= n) {
                bit[i + (i & -i)] += bit[i];
            }
        }
    }

    public void update(int index, int n, long value) {
        index++;
        while (index <= n) {
            bit[index] += value;
            index += index & -index;
        }
    }

    public long getSum(int i) {
        i++;
        long sum = 0;
        while (i > 0) {
            sum += bit[i];
            i -= (i & -i);
        }
        return sum;
    }
}
