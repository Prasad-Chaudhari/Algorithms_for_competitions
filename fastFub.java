import java.util.*;
class fastFub{

	static HashMap<Integer,Long> map =new HashMap<Integer,Long>();
	public static long fub(int n,int m){
		if(n==1){
			return 0;
		}
		if(n==2){
			return 1;
		}
		long f1=fub(n/2,m);
		long f2=fub(n/2+1,m);
		if(map.containsKey(n)){
			return map.get(n);
		}
		if(n%2==0){
		    long f=((f1*f1)%m+(f2*f2)%m)%m;
		    map.put(n,f); 	
			return f;
		}
		else{
			long f=((2*f1*f2)%m+(f2*f2)%m)%m;
		    map.put(n,f); 	
			return f;
		}
	}
	public static long pow(int a,int n,int m){
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

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int m=1000000007;
		int t=in.nextInt();
		while(t-->0){
			int a=in.nextInt();
			int b=in.nextInt();
			int n=in.nextInt();
			if(n==0){
				System.out.println(a);
			}
			else if(n==1){
				System.out.println(b);
			}
			else{
				long fn=fub(n+1,m-1);
				long fnm1=fub(n,m-1);
				long ans=(pow(a+1,(int)fnm1,m)*pow(b+1,(int)fn,m)-1)%m;
				System.out.println(ans);
			}
		}
	}
} 