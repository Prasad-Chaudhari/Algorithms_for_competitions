class Expo{
    static long a_pow_n_mod_m(long a,long n,long m){
        if(n==1){
            return a;
        }
        long p=a_pow_n_mod_m(a,n/2,m);
        if(n%2==0){
            return (p*p)%m;
        }
        else{
            return ((p*p)%m*a)%m;
        }
    }
    static long a_pow_n(long a,long n){
        if(n==1){
            return a;
        }
        long p=a_pow_n(a,n/2);
        if(n%2==0){
            return (p*p);
        }
        else{
            return ((p*p)*a);
        }
    }
}
