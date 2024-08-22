import sys
sys.setrecursionlimit(10 ** 5)
input = sys.stdin.readline

def SCC(node):
    global idx, scc_num
    visit[node] = idx
    idx += 1
    stack.append(node)
    root = visit[node]
    for nxt in graph[node]:
        if not visit[nxt]:
            root = min(root, SCC(nxt))
        elif not check[nxt]:
            root = min(root, visit[nxt])
    if root == visit[node]:
        cur_scc = []
        while True:
            top = stack.pop()
            check[top] = True
            cur_scc.append(top)
            CNF[top] = scc_num
            if top == node:
                break
        scc_num+=1
        scc_arr.append(cur_scc)
    return root

while True:
    inputline  = input()
    if inputline == "":
        break
    N, M = map(int, inputline.split())
    graph = [[] for _ in range(2*N)]
    for _ in range(M):
        a, b = map(int, input().split())
        if a < 0 :  a = N - a
        if b < 0 : b = N -b
        a -= 1
        b -= 1
        graph[(a+N)%(2*N)].append(b)
        graph[(b+N)%(2*N)].append(a)
    graph[N].append(0)

    visit = [False] * (2*N)
    check = [False] * (2*N)
    idx = 1
    scc_num = 0
    CNF = [-1]*(2*N)
    stack = []
    scc_arr = []

    for i in range(2*N):
        if not visit[i]:
            SCC(i)
    for i in range(N):
        if CNF[i] == CNF[N+i]:
            print("no")
            break
    else:
        print("yes")

