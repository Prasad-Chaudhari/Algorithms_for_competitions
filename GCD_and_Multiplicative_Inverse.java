class GCD {

    private long x, y;
    private boolean co_prime;

    public GCD() {
        co_prime = false;
    }

    public int calc_gcd(int a, int b) {
        if (b > a) {
            a ^= b;
            b ^= a;
            a ^= b;
        }
        return (int) gcd(a, b);
    }

    public long calc_gcd(long a, long b) {
        if (b > a) {
            a ^= b;
            b ^= a;
            a ^= b;
        }
        return gcd(a, b);
    }

    private long gcd(long a, long b) {
        if (b == 0) {
            x = 1;
            y = 0;
            if (a == 1) {
                co_prime = true;
            }
            return a;
        }
        long gcd = gcd(b, a % b);
        if (co_prime) {
            x = y - (a / b) * x;
            y = x;
        }
        return gcd;
    }
}
