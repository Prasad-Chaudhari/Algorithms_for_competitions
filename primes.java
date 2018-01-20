boolean [] c = new boolean[1000001];
int [] primes = new int[1000000];
int nop = 0;
for (int i = 2; i <= 1000; i++) {
    if (!c[i]) {
        for (int j = i * i; j <= 1000000; j = j + i) {
            c[j] = !false;
        }
    }
}
for (int i = 2; i < 1000000; i++) {
    if (!c[i]) {
        primes[nop++] = i;
    }
}
