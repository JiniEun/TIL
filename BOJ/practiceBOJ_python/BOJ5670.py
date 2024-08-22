import sys
 
class Node:
    def __init__(self,chr):
        self.chr = chr
        self.child = {}
        self.check = False

class Trie:
    def __init__(self):
        self.root = Node('')

    def insert(self, word):
        node = self.root
        for w in word:
            if w not in node.child:
                new = Node(w)
                node.child[w] = new
                node = new
            else:
                node = node.child[w]
        node.check = True

    def contains(self, word):
        cnt = 0
        cur = self.root
        for w in word:
            cur = cur.child[w]
            if len(cur.child) > 1 or cur.check:
                cnt+=1
        return cnt

while 1:
    t = Trie()
    words = []
    try: N = int(sys.stdin.readline())
    except: break

    for _ in range(N):
        s = sys.stdin.readline().rstrip()
        t.insert(s)
        words.append(s)
    result = 0
    for word in words:
        result += t.contains(word)

    print("%.2f" % (result/N))
