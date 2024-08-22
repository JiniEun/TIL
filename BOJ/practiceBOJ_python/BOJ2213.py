import sys
input = sys.stdin.readline
N = int(input())
Nodes = [0] + list(map(int, input().split())) 
Tree = [[] for i in range(N + 1)] 
dp = [[0] * 2 for i in range(N + 1)]
visit = [False for i in range(N + 1)]
num = [[[], []] for i in range(N + 1)]

def dfs(start):
    visit[start] = True
    dp[start][0] = Nodes[start]
    num[start][0].append(start)
    for i in Tree[start]:
        if not visit[i]:
            dfs(i)
            dp[start][0] += dp[i][1]
            for j in num[i][1]:
                num[start][0].append(j)
            if max(dp[i][1], dp[i][0]) != dp[i][1]:
                dp[start][1] += dp[i][0]
                for k in num[i][0]:
                    num[start][1].append(k)
            else:
                dp[start][1] += dp[i][1]
                for k in num[i][1]:
                    num[start][1].append(k)
                    
for i in range(N - 1):
    a, b = map(int, input().split())
    Tree[a].append(b)
    Tree[b].append(a)
    
dfs(1)

if max(dp[1][0], dp[1][1]) == dp[1][0]:
    print(dp[1][0])
    result = num[1][0]
    result.sort()
else:
    print(dp[1][1])
    result = num[1][1]
    result.sort()
    
print(*result)
