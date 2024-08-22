import sys
sys.setrecursionlimit(10 ** 9)
 
N = int(sys.stdin.readline()) # 노드의 개수
tree=[[] for _ in range(N+1)]
for _ in range(N-1):
    s,e=map(int,sys.stdin.readline().split())
    tree[s].append(e)
    tree[e].append(s)

# 부모 저장
parents=[0 for _ in range(N+1)]

def DFS(start):
    for i in tree[start]: # 연결된 노드 모두탐색
        if parents[i]==0: # 방문 여부 - X 
            parents[i]=start # 부모노드 저장
            DFS(i)

DFS(1)
 
for i in range(2,N+1):
    print(parents[i])
