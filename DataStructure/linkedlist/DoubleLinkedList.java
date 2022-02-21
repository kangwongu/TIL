package linkedlist;

public class DoubleLinkedList<T> {
    
    private Node<T> head = null;
    private Node<T> tail = null;
    
    public class Node<T> {
        T data;
        Node<T> prev = null;
        Node<T> next = null;
        
        Node(T data) {
            this.data = data;
        }
    }
    
    // ������ �߰�
    public void addNode(T data) {
        // 1. ����Ʈ�� ��尡 �ϳ��� ������
        if(head == null) {
            head = new Node<T>(data);
            tail = head;
        } else {
        // 2. ����Ʈ�� ��尡 �ϳ� �̻� �ִ���
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
        // 1. ����Ʈ�� ��尡 �ϳ��� ������
        if(head == null) {
            System.out.println("����Ʈ�� ��尡 �����");
        } else {
            // 2. ����Ʈ�� ��尡 �ϳ� �̻� �ִ���
            Node<T> node = head;
            while(node != null) {
                System.out.println(node.data);
                node = node.next;
            }
        }
    }
    
    // tail���� Ư�� ��� ã��
    public T searchFromTail(T data) {
        // 1. ����Ʈ�� ��尡 �ϳ��� ������
        if(head == null) {
            return null;
        // 2. ����Ʈ�� ��尡 �ϳ� �̻� �ִ���
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
    
    // head���� Ư�� ��� ã��
    public T searchFromHead(T data) {
        // 1. ����Ʈ�� ��尡 �ϳ��� ������
        if(head == null) {
            return null;
        // 2. ����Ʈ�� ��尡 �ϳ� �̻� �ִ���
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
    
    // ���� ��� �տ� ��� �߰�
    public boolean insertToFront(T searchNode, T data) {
        // 1. ����Ʈ�� ��尡 �ϳ��� ������
        if(head == null) {
            head = new Node<T>(data);
            tail = head;
            return true;
        // 2. ����Ʈ�� ��尡 �ϳ� �̻� �ִ���
        // 2-1. head�� ���� ��� -> head�� �ٲ�� ��
        } else if(head.data == searchNode) {
            Node<T> newHead = new Node<T>(data);
            newHead.next = this.head;
            head = newHead;
            head.next.prev = head;
            return true;
            // 2-2. �Ϲ����� ���
        } else {
            Node<T> node = head;
            while(node != null) {
                if(node.data == searchNode) {
                    Node<T> prevNode = node.prev;
                    
                    prevNode.next = new Node<T>(data);
                    prevNode.next.next = node;
                    
                    prevNode.next.prev = prevNode;
                    node.prev = prevNode.next;
                    return true;
                    
                } else {
                    node = node.next;
                }
            }
            return false;
            
        }

    }
    
    public static void main(String[] args) {
        DoubleLinkedList<Integer> MyLinkedList = new DoubleLinkedList<Integer>();

        MyLinkedList.addNode(1);
        MyLinkedList.addNode(2);
        MyLinkedList.addNode(3);
        MyLinkedList.addNode(4);
        MyLinkedList.addNode(5);
        MyLinkedList.printAll();
        System.out.println("----------------");

        MyLinkedList.insertToFront(3, 2);
        MyLinkedList.printAll();
        System.out.println("----------------");

        MyLinkedList.insertToFront(6, 2);
        MyLinkedList.insertToFront(1, 0);
        MyLinkedList.printAll();
        System.out.println("----------------");

        MyLinkedList.addNode(6);
        MyLinkedList.printAll();
    }

}