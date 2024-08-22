import sys
input = sys.stdin.readline

log = 18
M = int(input())
f = [0]+list(map(int,input().split()))
dp = [[f[i]] for i in range(M+1)]

for j in range(1, log + 1):
    for i in range(1, M + 1):
        dp[i].append(dp[dp[i][j-1]][j-1])

Q = int(input())
for _ in range(Q):
    n,x = map(int, input().split())
    for b in range(log, -1, -1):
        if n >= 1 << b:
            n -= 1<<b
            x = dp[x][b]
    print(x)
