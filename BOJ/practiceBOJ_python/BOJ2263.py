import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

N = int(input())
in_order = list(map(int, input().split()))
post_order = list(map(int, input().split()))

pos = [0]*(N+1)
for i in range(N):
    pos[in_order[i]] = i # 전위 순회

def solve(in_start, in_end, p_start, p_end):
    if(in_start > in_end) or (p_start > p_end):
        return

    root = post_order[p_end] # 후위순회에서 부모노드 찾기
    print(root, end=" ")
    left = pos[root] - in_start # 왼쪽인자 갯수
    right = in_end - pos[root] # 오른쪽인자 갯수

    solve(in_start, in_start+left-1, p_start, p_start+left-1) # 왼쪽 노드
    solve(in_end-right+1, in_end, p_end-right, p_end-1) # 오른쪽 노드


solve(0, N-1, 0, N-1)

