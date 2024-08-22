import sys
input = sys.stdin.readline

x1, y1, x2, y2 = map(int, input().split())
x3, y3, x4, y4 = map(int, input().split())

A, B, C, D = [x1,y1], [x2,y2], [x3,y3], [x4,y4]

def ccw(p1, p2, p3):
    return (p1[0]*p2[1] + p2[0]*p3[1] + p3[0]*p1[1]) - (p2[0]*p1[1] + p3[0]*p2[1] + p1[0]*p3[1])

if ccw(A,B,C)*ccw(A,B,D) < 0 and ccw(C,D,A)*ccw(C,D,B) < 0:
    print(1)
else:
    print(0)
