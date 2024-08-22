import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

def find(x):
    if x == parent[x]:
        return x
    parent[x] = find(parent[x]) # 부모 테이블 갱신
    return parent[x]

def union(x,y):
    x = find(x)
    y = find(y)

    if x > y:
        parent[x] = y
    else :
        parent[y] = x

N, M = map(int, input().split())
parent = [i for i in range(N)]

for i in range(M):
    a, b = map(int, input().split())
    if find(a) == find(b):
        print(i+1)
        break
    union(a, b)
else :
    print(0)
