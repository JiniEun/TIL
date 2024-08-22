import sys
input = sys.stdin.readline

x,y,d,t = map(int,input().split())
dist = (x*x + y*y) ** 0.5
if t > d:
    print(dist)
else:
    n = dist // d
    print(min(t*n+dist-d*n,t*(n+1) if d<dist else min(dist,t+d-dist,2*t)))
