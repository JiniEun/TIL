import sys
sys.setrecursionlimit(100000)
input = sys.stdin.readline
LOG = 21
# 2^i 단위의 부모값을 저장하기 위한 크기


N = int(input())
parent = [[0] * LOG for _ in range(N + 1)]
visit = [False] * (N + 1)
depth = [0] * (N + 1)
tree = [[] for _ in range(N + 1)]

for _ in range(N - 1):
    a, b = map(int, input().split())
    tree[a].append(b)
    tree[b].append(a)

def dfs(cur, d):
    visit[cur] = True
    depth[cur] = d
    for node in tree[cur]:
        if not visit[node]:
            parent[node][0] = cur
            dfs(node, d + 1)

def lca(a, b):
    if depth[a] > depth[b]:
        a, b = b, a

    # a와 b의 깊이 동일하게
    for i in range(LOG - 1, -1, -1):
        if depth[b] - depth[a] >= (1<<i):
            b = parent[b][i]

    if a == b:
        return a

    # 올라가면서 공통 조상 찾기
    for i in range(LOG - 1, -1, -1):
        if parent[a][i] != parent[b][i]:
            a = parent[a][i]
            b = parent[b][i]

    return parent[a][0]

dfs(1, 0)
# 모든 노드의 전체 부모 관계 갱신
for i in range(1, LOG):
    for j in range(1, N + 1):
        # 각 노드에 대해 2**i번째 부모 정보 갱신
        parent[j][i] = parent[parent[j][i - 1]][i - 1]

M = int(input())

for _ in range(M):
    a, b = map(int, input().split())
    print(lca(a, b))
