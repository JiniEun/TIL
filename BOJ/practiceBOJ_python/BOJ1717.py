import sys

input = sys.stdin.readline

def find(x):
    if x == parent[x]:
        return x
    
    parent[x] = find(parent[x])
    return parent[x]

def union(x, y):
    x = find(x)
    y = find(y)

    if x < y:
        parent[y] = x
    else :
        parent[x] = y


N, M = map(int, input().split())
parent = [i for i in range(N+1)]

for _ in range(M):
    cmd, x, y = map(int, input().split())

    if not cmd:
        union(x, y)

    if cmd:
        if find(x) == find(y):
            print('YES')
        else:
            print('NO')
