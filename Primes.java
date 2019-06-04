
class Primes {

    public static int[] getPrimes(int n) {
        boolean[] c = new boolean[n + 1];
        int nop = 0;
        int root = (int) (Math.sqrt(n) + 1);
        for (int i = 2; i <= root; i++) {
            if (!c[i]) {
                for (int j = i * i; j <= n; j = j + i) {
                    c[j] = true;
                }
            }
        }
        for (int i = 2; i < n; i++) {
            if (!c[i]) {
                nop++;
            }
        }
        int[] primes = new int[nop];
        nop = 0;
        for (int i = 2; i < n; i++) {
            if (!c[i]) {
                primes[nop++] = i;
            }
        }
        return primes;
    }
}
