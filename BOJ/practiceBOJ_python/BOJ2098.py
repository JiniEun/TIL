import sys
input = sys.stdin.readline
N = int(input())

def tps(n, v):
    if dp[n][v] is not None:
        return dp[n][v]

    result = 10**9
    for i in range(N - 1):
        if i != v and n & (1 << i):
            tmp = tps(n - (1 << v), i) + w[i][v]
            if tmp < result:
                result = tmp
    dp[n][v] = result
    return result

w = [list(map(lambda x: int(x) if x != "0" else 10**9, input().split())) for _ in range(N)]
dp = [[None] * (N - 1) for _ in range(1 << N - 1)]
for i in range(N - 1):
    dp[1 << i][i] = w[-1][i]
print(min(tps((1 << N - 1) - 1, i) + w[i][-1] for i in range(N - 1)))
