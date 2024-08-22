import sys
input=sys.stdin.readline
bit_set = 0
for _ in range(int(input())):
    op = input().split()
    if op[0]=='add' : bit_set |= 1 << int(op[1])
    if op[0]=='remove' : bit_set &= ~(1 << int(op[1]))
    if op[0]=='check' : print(1 if bit_set & (1 << int(op[1])) else 0)
    if op[0]=='toggle' : bit_set ^= (1 << int(op[1]))
    if op[0]=='all' : bit_set = (1<<21)-1
    if op[0]=='empty' : bit_set = 0
