import sys
from collections import deque
sys.setrecursionlimit(650001)
input = lambda: sys.stdin.readline().rstrip()
read = lambda: map(int, input().split())

def dfs(node):
    visit[node] = 1
    for now in graph[node]:
        if not visit[now]:
            dfs(now)
    stack.append(node)

def reverse_dfs(node, num):
    scc_num[node] = num
    scc_arr[num] += 1
    scc_val[num] += cash[node]
    for now in reverse_graph[node]:
        if scc_num[now] == -1:
            reverse_dfs(now, num)
        elif scc_num[node] != scc_num[now]:
            group[scc_num[now]].append(scc_num[node])

N, M = read()
graph = [[] for i in range(N)]
reverse_graph = [[] for i in range(N)]
visit = [0] * N
stack = []
scc_num = [-1] * N
scc_arr = []
group = []

for i in range(M):
    a, b = read()
    graph[a-1].append(b-1)
    reverse_graph[b-1].append(a-1)	

cash = [int(input()) for i in range(N)]

for i in range(N):
	if not visit[i]:
		dfs(i)
		
scc_val = []
k = 0
while stack:
    now = stack.pop()
    if scc_num[now] == -1:
        group.append([])
        scc_arr.append(0)
        scc_val.append(0)
        reverse_dfs(now, k)
        k += 1
		
S, P = read()
S -= 1
result = list(read())

del graph, reverse_graph

que = deque([scc_num[S]])
dp = [0] * k
dp[scc_num[S]] = scc_val[scc_num[S]]
while que:
	now = que.popleft()
	for n in group[now]:
		if dp[n] < dp[now] + scc_val[n]:
			dp[n] = dp[now] + scc_val[n]
			que.append(n)
answer = 0
for r in result:
	answer = max(answer, dp[scc_num[r-1]])
print(answer)
