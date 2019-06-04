
/**
 * Source : https://www.geeksforgeeks.org/multiplicative-inverse-under-modulo-m/
 *
 * @author PRASAD
 */
class GCD {

    public GCD() {
        // Sry Nothing to initalise
    }

    public long a_inv_b(long a, long m) {
        long g = calc_gcd(a, m);
        a /= g;
        m /= g;
        if (gcd(a, m) == 1) {
            long m0 = m;
            long y = 0, x = 1;
            if (m == 1) {
                return 0;
            }
            while (a > 1) {
                long q = a / m;
                long t = m;
                m = a % m;
                a = t;
                t = y;
                y = x - q * y;
                x = t;
            }
            if (x < 0) {
                x += m0;
            }
            return x;
        } else {
            return -1;
        }
    }

    public int calc_gcd(int a, int b) {
        if (b > a) {
            a = a ^ b;
            b = a ^ b;
            a = a ^ b;
        }
        return (int) gcd(a, b);
    }

    public long calc_gcd(long a, long b) {
        if (b > a) {
            a = a ^ b;
            b = a ^ b;
            a = a ^ b;
        }
        return gcd(a, b);
    }

    private long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        long gcd = gcd(b, a % b);
        return gcd;
    }
}
