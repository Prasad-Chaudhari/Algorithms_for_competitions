t = int(raw_input())

primes =[]
c= []
for i in range(100002):
	c.append(False)

for i in range(2,int(100001**(1/2.0))):
	if not c[i]:
		for j in range(i*i,100001,i):
			c[j] = True

for i in range(2,100001):
	if not c[i]:
		primes.append(i)

while t>0:
	n = int(raw_input())
	while n%2==0:
		n/=2
	s1 =1;
	for i in primes:
		if n%i==0:
			s2 = 1
			while n%i==0:
				s2 = s2*i
				s2+=1
				n=n/i
			s1*=s2
		if n==1:
			break;
	if n!=1:
		s1+=n
	print s1
	t-=1