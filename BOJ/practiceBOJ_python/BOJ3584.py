import sys
input = sys.stdin.readline

for _ in range(int(input())):
    N = int(input())
    parent = [0 for _ in range(N+1)] # 각 노드의 부모노드 저장
    for _ in range(N-1):
        p,c = map(int,input().split())
        parent[c] = p # 부모 노드 저장

    u, v = map(int,input().split())
    u_p = [u]
    v_p = [v]

    while parent[u]:
        u_p.append(parent[u])
        u = parent[u]

    while parent[v]:
        v_p.append(parent[v])
        v = parent[v]

    # 같은 레벨로
    u_level = len(u_p)-1
    v_level = len(v_p)-1

    while u_p[u_level] == v_p[v_level]: # 부모 노드가 다를 때까지 
        u_level -= 1
        v_level -= 1

    print(u_p[u_level + 1])
