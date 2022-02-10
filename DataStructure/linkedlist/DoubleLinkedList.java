package linkedlist;

public class DoubleLinkedList<T> {
    public Node<T> head = null;
    public Node<T> tail = null;
    
    public class Node<T> {
        T data;
        Node<T> prev = null;
        Node<T> next = null;
        
        public Node(T data) {
            this.data = data;
        }
    }
    
    // 기능
    // 데이터 추가
    public void addNode(T data) {
        if(head == null) {
            head = new Node<T>(data);
            tail = head;
        } else {
            Node<T> node = head;
            while(node.next != null) {
                node = node.next;
            }
            node.next = new Node<T>(data);
            node.next.prev = node;
            tail = node.next;
        }
    }
    
    // 데이터 출력
    public void printAll() {
        if(head == null) {
            System.out.println("리스트에 데이터가 없어요");
        } else {
            Node<T> node = head;
            while(node != null) {
                System.out.println(node.data);
                node = node.next;
            }
        }
    }
    
    // head부터 특정 노드 찾기
    public T searchFromHead(T data) {
        if(head == null) {
            return null;
        } else {
            Node<T> node = head;
            while(node != null) {
                if(node.data == data) {
                    return node.data;
                } else {
                    node = node.next;
                }
            }
            return null;
        }
    }
    
    // tail부터 특정 노드 찾기
    public T searchFromTail(T data) {
        if(head == null) {
            return null;
        } else {
            Node<T> node = tail;
            while(node != null) {
                if(node.data == data) {
                    return node.data;
                } else {
                    node = node.prev;
                }
            }
            return null;
        }
    }
    
    // 데이터를 임의 노드 앞에 노드를 추가
    public boolean insertToFront(T existedData, T addData) {
        if(head == null) {
            head = new Node<T>(addData);
            tail = head;
            return true;
        } else if(head.data == existedData) {
            Node<T> newHead = new Node<T>(addData);
            newHead.next = head;
            head = newHead;
            head.next.prev = head;
            return true;
        } else {
            Node<T> node = head;
            while(node != null) {
                if(node.data == existedData) {
                    Node<T> nodePrev = node.prev;  
                    
                    nodePrev.next = new Node<T>(addData);
                    nodePrev.next.next = node;
                    
                    nodePrev.next.prev = nodePrev;
                    node.prev = nodePrev.next;
                    return true;
                } else {
                    node = node.next;
                }
            }
            return false;
        }
    }
    
    public static void main(String[] args) {
    	DoubleLinkedList<Integer> myLinkedList = new DoubleLinkedList<Integer>();

    	myLinkedList.addNode(1);
    	myLinkedList.addNode(2);
    	myLinkedList.addNode(3);
    	myLinkedList.addNode(4);
    	myLinkedList.addNode(5);
    	myLinkedList.printAll();

    	System.out.println("===================");
    	myLinkedList.insertToFront(3,2);
    	myLinkedList.printAll();

    	System.out.println("===================");
    	myLinkedList.insertToFront(5,8);
    	myLinkedList.printAll();

    	System.out.println("===================");
    	myLinkedList.addNode(7);
    	myLinkedList.printAll();

    	System.out.println("===================");
    	myLinkedList.insertToFront(1,10);
    	myLinkedList.printAll();
    }
    
}
