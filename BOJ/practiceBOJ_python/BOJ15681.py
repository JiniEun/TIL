import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**9)

def NodeCount(x):
    cnt[x]=1
    for i in tree[x]:
        if not cnt[i]:
            NodeCount(i)
            cnt[x] += cnt[i]

N, R, Q = map(int, input().split())
tree = [[] for _ in range(N+1)]
cnt = [0]*(N+1)

for i in range(N-1):
    a, b = map(int, input().split())
    tree[a].append(b)
    tree[b].append(a)

NodeCount(R)

for i in range(Q):
    u = int(input())
    print(cnt[u])
