import sys
from collections import deque
input = sys.stdin.readline

T = int(input())

for _ in range(T):
    N,K = map(int,input().split())
    time = [0]+list(map(int,input().split())) # 건설 시간
    tree = [[] for _ in range(N+1)]
    indegree=[0 for _ in range(N+1)]
    result = [0 for _ in range(N+1)] # 해당 건물까지 걸리는 시간

    for _ in range(K): # 입력값 받기
        s, e = map(int,input().split())
        tree[s].append(e)
        indegree[e]+=1

    que = deque()
    for i in range(1,N+1):
        if indegree[i] == 0:
            que.append(i)
            result[i] = time[i]

    while que:
        node = que.popleft()
        for i in tree[node]:
            indegree[i]-=1
            result[i] = max(result[node] + time[i], result[i]) 
            if indegree[i] == 0:
                que.append(i)

    w = int(input())
    print(result[w])
