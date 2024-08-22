import sys
sys.setrecursionlimit(10 ** 6)
input = sys.stdin.readline

def post_order(start, end):
    if start > end:
        return

    root = pre_order[start] # 루트 노드
    idx = start + 1

    # root보다 커지는 지점을 찾기 
    while idx <= end:
        if pre_order[idx] > root:
            break
        idx += 1
  
    post_order(start + 1, idx - 1) # 왼쪽     
    post_order(idx, end) # 오른쪽

    print(root) # 후위 순회 root 마지막 출력


pre_order = []
while 1:
    try:
        pre_order.append(int(input()))
    # 예외 발생시 break
    except:
        break

post_order(0, len(pre_order) - 1)
