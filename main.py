from datetime import datetime, timedelta

t = timedelta(seconds = int(raw_input())*60)
h, m = raw_input().split()
d = datetime(1999, 1, 1, int(h), int(m), 0, 0)
i =0
while True:
	if datetime.strftime(d,"%H:%M").find('7') != -1:
		print i
		break;
	d = d-t
	i+=1

