import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

V, E = map(int, input().split())
graph = [[] for _ in range(V + 1)]
reverse_graph = [[] for _ in range(V + 1)]
for _ in range(E):
    a, b = map(int, input().split())
    # 정방향 그래프, 역방향 그래프 추가
    graph[a].append(b)
    reverse_graph[b].append(a)

# 정방향 dfs, dfs 가 종료되는 노드를 stack에.
def dfs(node, visit, stack):
    visit[node] = 1
    for now in graph[node]:
        if visit[now] == 0:
            dfs(now, visit, stack)
    stack.append(node)

# 역방향 dfs, 탐색하는 순서대로 stack에.
def reverse_dfs(node, visit, stack):
    visit[node] = 1
    stack.append(node)
    for now in reverse_graph[node]:
        if visit[now] == 0:
            reverse_dfs(now, visit, stack)

stack = []
visit = [0] * (V + 1)
# 모든 노드에서 dfs를 수행.
for i in range(1, V + 1):
    if visit[i] == 0:
        dfs(i, visit, stack)
visit = [0] * (V + 1)
result = []
while stack:
    # pop되는 요소에서 역방향 dfs, scc를 결과에.
    ssc = []
    node = stack.pop()
    if visit[node] == 0:
        reverse_dfs(node, visit, ssc)
        result.append(sorted(ssc))

print(len(result))
answer = sorted(result)
for i in answer:
    print(*i, -1)
