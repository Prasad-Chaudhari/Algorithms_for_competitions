
class Factorial {

    long fac[], inv_fac[];

    public Factorial(int n, long m) {
        fac = new long[n + 1];
        inv_fac = new long[n + 1];
        fac[0] = 1;
        inv_fac[0] = 1;
        for (int i = 1; i <= n; i++) {
            fac[i] = (fac[i - 1] * i) % m;
            inv_fac[i] = pow_mod(fac[i], m - 2, m);
        }
    }

    long pow_mod(long a, long n, long m) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return a;
        }
        long p = pow_mod(a, n / 2, m);
        if (n % 2 == 0) {
            return (p * p) % m;
        } else {
            return ((p * p) % m * a) % m;
        }
    }
}
