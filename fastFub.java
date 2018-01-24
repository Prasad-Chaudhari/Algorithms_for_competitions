class fastFub{
	static HashMap<Integer,Long> map =new HashMap<Integer,Long>();
	public static long fub(int n,int m){
		if(n==1){
			return 0;
		}
		if(n==2){
			return 1;
		}
		if(map.containsKey(n)){
			return map.get(n);
		}
		long f1=fub(n/2,m);
		long f2=fub(n/2+1,m);
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
} 
