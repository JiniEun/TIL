import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

def find(x):
    if x == parent[x]:
        return x
    parent[x] = find(parent[x]) # 부모 테이블 갱신
    return parent[x]

def union(x, y): 
    x = find(x) 
    y = find(y)

    if x == y: # 동일한 집합일 경우
        return

    if x < y:
        parent[y] = x 
    else: 
        parent[x] = y 

V, E = map(int, input().split())
edge = []

for _ in range(E):
    s, e, cost = map(int, input().split())
    edge.append((s, e, cost))

edge.sort(key=lambda x : x[2])

parent = [i for i in range(V+1)]

result = 0
for s, e, c in edge:
    if find(s) != find(e):
        union(s, e)
        result += c

print(result)
