class Node:
    def __init__(self, value = 0, next = None):
        self.value = value
        self.next = next

class LinkedList(object):
    def __init__(self):
        self.head = None
    
    def append(self, value):
        new_node = Node(value)
        if self.head is None:
            self.head = new_node
        else:
            current_node = self.head
            while current_node.next:
                current_node = current_node.next
            current_node.next = new_node
    
    def get(self, idx):
        if idx<0:
            raise Exception("유효하지 않은 idx")
        current_node = self.head
        for _ in range(idx):
            current_node = current_node.next
        return current_node.value
    
    def insert(self, idx, value):
        new_node = Node(value)
        if idx==0:
            new_node.next = self.head
            self.head = new_node
        else:
            current_node = self.head
            for _ in range(idx-1):
                current_node = current_node.next
            new_node.next = current_node.next
            current_node.next = new_node

    def remove(self, idx):
        if idx==0:
            self.head = self.head.next
        else:
            current_node = self.head
            for _ in range(idx-1):
                current_node = current_node.next
            current_node.next = current_node.next.next



ll = LinkedList()
ll.append(1)
ll.append(2)
ll.append(3)
ll.append(4)
ll.insert(2, 9)
ll.remove(0)
print(ll.get(0))
print(ll.get(1))
print(ll.get(2))
print(ll.get(3))
# print(ll.get(4))