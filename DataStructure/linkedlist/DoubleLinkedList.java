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
    
    // ���
    // ������ �߰�
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
    
    // ������ ���
    public void printAll() {
        if(head == null) {
            System.out.println("����Ʈ�� �����Ͱ� �����");
        } else {
            Node<T> node = head;
            while(node != null) {
                System.out.println(node.data);
                node = node.next;
            }
        }
    }
    
    // head���� Ư�� ��� ã��
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
    
    // tail���� Ư�� ��� ã��
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
    
    // �����͸� ���� ��� �տ� ��带 �߰�
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
