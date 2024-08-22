import sys
input = sys.stdin.readline

def bfs(x):
    isTree = True
    que = [x]
    while que:
        now = que.pop(0)
        if visit[now] == True: # 사이클
            isTree = False
        visit[now] = True
        for j in graph[now]:
            if visit[j] == 0:
                que.append(j)
    return isTree

testcase = 0
while True:
    testcase += 1
    N, M = map(int, input().split())
    if [N, M] == [0, 0]: 
        break
    graph = [[] for _ in range(N + 1)] # 서로 연결된 요소 저장
    for _ in range(M):
        a, b = map(int, input().split())
        graph[a].append(b)
        graph[b].append(a)
    treeCnt = 0
    visit = [False] * (N + 1)
    for i in range(1, N + 1):
        if visit[i] == True: # 방문한적 있다면 패스
            continue
        if bfs(i) is True: # 현재의 연결 요소가 tree 라면 카운트
            treeCnt += 1
    if treeCnt == 0:
        print('Case {}: No trees.'.format(testcase))
    elif treeCnt == 1:
        print('Case {}: There is one tree.'.format(testcase))
    else:
        print('Case {}: A forest of {} trees.'.format(testcase, treeCnt))


