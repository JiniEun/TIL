from collections import deque
import sys
input = sys.stdin.readline

def bfs():
    que = deque()
    que.append([a, ""])
    while que:
        num, result = que.popleft()
        dn = (num * 2) % 10000
        sn = num - 1 if num != 0 else 9999
        ln = int(num % 1000 * 10 + num / 1000)
        rn = int(num % 10 * 1000 + num // 10)
        
        if dn == b: return result + "D"
        elif cmd[dn] == 0:
            cmd[dn] = 1
            que.append([dn, result + "D"])

        if sn == b: return result + "S"
        elif cmd[sn] == 0:
            cmd[sn] = 1
            que.append([sn, result + "S"])

        if ln == b: return result + "L"
        elif cmd[ln] == 0:
            cmd[ln] = 1
            que.append([ln, result + "L"])

        if rn == b: return result + "R"
        elif cmd[rn] == 0:
            cmd[rn] = 1
            que.append([rn, result + "R"])
            
tc = int(input())
for i in range(tc):
    a, b = map(int, input().split())
    cmd = [0 for i in range(10000)]
    print(bfs())
