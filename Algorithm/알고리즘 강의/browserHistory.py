class Node:
    def __init__(self, value=0, next=None, prev=None):
        self.value = value
        self.next = next
        self.prev = prev

class BrowserHistory(object):
    def __init__(self, homepage):
        self.head = self.current = Node(homepage)

    def visit(self, url):
        # new_node = Node(url)
        # self.current.next = new_node
        # new_node.prev = self.current
        self.current.next = Node(value=url, prev=self.current)
        self.current = self.current.next
        return None

    def back(self, steps):
        while steps > 0 and self.current.prev is not None:
            steps -= 1
            self.current = self.current.prev
        return self.current.value

    def forward(self, steps):
        while steps > 0 and self.current.next is not None:
            steps -= 1
            self.current = self.current.next
        return self.current.value
    