

package linkedlist;

public class SingleLinkedList<T> {
    Node<T> head = null;
    
    public class Node<T> {
        T data;
        Node<T> next = null;
        
        public Node(T data) {
            this.data = data;
        }
    }
    
    // ���
    
    // ������ �߰�
    public void addNode(T data) {
        // 1. ����Ʈ�� �����Ͱ� �ִ��� Ȯ��
        if(head == null) {
            // 2. ����Ʈ�� �����Ͱ� ���� -> �տ� ������ �߰�
            head = new Node<T>(data);
            
        } else {
            // 3. ����Ʈ�� �����Ͱ� �ִ� -> ���� ������ �߰�
            
            // 3-1. head���� �����´� ( ó�� ���� �˾ƾ� ��ȸ ���� )
            Node<T> node = head;
            
            // 3-2. ����Ʈ�� ���������� �̵�
            while(node.next != null) {
                node = node.next;
            }
            // 3-3. ������ ��� �߰�
            node.next = new Node<T>(data);
        }
    }
    
    // ������ ���
    public void printAll() {
        // 1. ����Ʈ�� �����Ͱ� �ִ��� Ȯ��
        if(head == null) {
            // 2. ����Ʈ�� �����Ͱ� ���� -> null
            System.out.println("�����Ͱ� �����");
            
        } else {
            // 3. ����Ʈ�� �����Ͱ� �ִ� -> ������ ���
            // 3-1. head���� �����´�
            Node<T> node = head;
            
            // 3-2. ����Ʈ ��ȸ�ϸ� �����͸� ����Ѵ�
            while(node != null) {
                System.out.println(node.data);
                node = node.next;
            }
        }
    }
    
    // �˻�
    public Node<T> search(T data) {
        // 1. ����Ʈ�� �����Ͱ� �ִ��� Ȯ��
        if(head == null) {
            // 2. ����Ʈ�� �����Ͱ� ���� -> null
            return null;
            
        } else {
            // 3. ����Ʈ�� �����Ͱ� �ִ� -> Node<T>
            // 3-1. head���� �����´�
            Node<T> node = head;
            
            // 3-2. ����Ʈ ��ȸ
            while(node != null) {
                // 3-3. ���� ã���� ��ȯ
                if(node.data == data) {
                    return node;
                } else {
                node = node.next;
                }
            }
            return null;
        }
    }
    
    // ������ �߰��� �߰�
    public void addNodeInside(T data, T isData) {
        // 1. �߰��Ϸ��� �ڸ��� ���� ��� Ž��
        Node<T> searchNode = search(isData);
        
        if(searchNode == null) {
            addNode(data);
        } else {
            // 2. �� ��� ���� ����
            Node<T> node = searchNode.next;  // �� ���
            searchNode.next = new Node<T>(data);
        
            // 3. �߰� ��� ���� ����
            searchNode.next.next = node;
        }
    }
    
    // ������ ����
    public boolean delNode(T isData) {
        // 1. ����Ʈ�� �����Ͱ� �ִ��� Ȯ��
        if(head == null) {
            // 2. ����Ʈ�� �����Ͱ� ����
            return false;
            
        } else {
            // 3. ����Ʈ�� �����Ͱ� �ִ�
            // 3-1. head�� ������
            Node<T> node = head;
            // 3-2. ������ ���� head���̸� head���� ���� ��忡 ����
            if(node.data == isData) {
                head = node.next;
                return true;
            } else {
                // 3-3. ������ ���� head�� �ƴϸ� ��ȸ�ϸ� ã��
                while(node.next != null) {
                    // ������ ����� �� �ڳ�� ���� ����
                    if(node.next.data == isData) {
                        node.next = node.next.next;
                        return true;
                    }
                    node = node.next;
                }
                return false;
            }
        }
    }
    
    public static void main(String[] args) {
    	SingleLinkedList<Integer> myLinkedList = new SingleLinkedList<Integer>();
    	myLinkedList.addNode(1);
    	myLinkedList.addNode(2);
    	myLinkedList.addNode(3);
    	myLinkedList.addNode(4);
    	myLinkedList.addNode(5);

    	myLinkedList.printAll();
    	
    	System.out.println("====================");
    	myLinkedList.addNodeInside(5, 1);
    	myLinkedList.printAll();
    	
    	System.out.println("====================");
    	myLinkedList.delNode(3);
    	myLinkedList.printAll();
    }
}