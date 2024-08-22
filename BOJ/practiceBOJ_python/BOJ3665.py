import sys
from collections import deque

t = int(sys.stdin.readline())
for _ in range(t):
    n = int(sys.stdin.readline())
    rank = list(map(int, sys.stdin.readline().split()))
    edges = [[False]*(n+1) for _ in range(n + 1)]
    indegree = [0] * (n + 1)
    
    for i in range(n):
        for j in range(i + 1, n):
            edges[rank[i]][rank[j]] = True
            
    m = int(sys.stdin.readline())
    for _ in range(m):
        a, b = map(int, sys.stdin.readline().split())
        edges[a][b], edges[b][a] = edges[b][a], edges[a][b]

    que = deque()
    answer = []
    cnt = 0
    for i in range(1, n + 1):
        indegree[i] = edges[i].count(True)
        if indegree[i] == 0:
            cnt += 1
            que.append(i)

    if cnt != 1:
        if cnt > 1:
            print("?")
        elif cnt == 0:
            print("IMPOSSIBLE")
        continue
            
    while que and cnt == 1:
        cnt = 0
        cur = que.popleft()
        answer.append(cur)
        for i in range(1, n + 1):
            if edges[i][cur]:
                indegree[i] -= 1
                if indegree[i] == 0:
                    cnt += 1
                    que.append(i)
                    
    if cnt > 1:
        print("?")
    elif len(answer) != n:
        print("IMPOSSIBLE")
    else:
        print(*answer[::-1])
