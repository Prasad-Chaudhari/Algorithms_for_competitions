public static long pow(long a,long n,long m){
	if(n==1){
		return a;
	}
	long p=pow(a,n/2,m);
	if(n%2==0){
		return (p*p)%m;
	}
	else{
		return ((p*p)%m*a)%m;
	}
}