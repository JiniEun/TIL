import sys
import math
input = sys.stdin.readline

N  = int(input())
point = [[]] * N
for i in range(N):
    point[i] = list(map(int, input().split()))
    
point.append(point[0])
result = 0

for i in range(N):
    result += (point[i][0] * point[i+1][1]) - (point[i+1][0] * point[i][1])

print("%.1f" % (abs(result)/2))
