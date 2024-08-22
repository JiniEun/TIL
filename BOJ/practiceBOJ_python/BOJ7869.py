import math
import sys
input = sys.stdin.readline

x1, y1, r1, x2, y2, r2  = map(float, input().split())

def area(x1, y1, r1, x2, y2, r2):
    d = math.sqrt(pow(x2 - x1, 2) + pow(y2 - y1, 2))
    rr1 = r1 * r1
    rr2 = r2 * r2
    if (d > r2 + r1): # 원이 겹치지 않음
        return 0
    elif (d <= abs(r1 - r2) and r1 < r2): # 원1이 내부에
        return math.pi * rr1
    elif (d <= abs(r1 - r2) and r1 >= r2): # 원2이 내부에
        return math.pi * rr2
    else: # 두 점에서 만나는 경우
        phi = (math.acos((rr1 + (d * d) - rr2) / (2 * r1 * d))) * 2
        theta = (math.acos((rr2 + (d * d) - rr1) / (2 * r2 * d))) * 2
        area1 = 0.5 * rr2 * (theta - math.sin(theta))
        area2 = 0.5 * rr1 * (phi - math.sin(phi))
        return area1 + area2

result = float(round(1000 * area(x1, y1, r1, x2, y2, r2)) / 1000)
print('%.3f' % result)
