

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
    
    // 기능
    
    // 데이터 추가
    public void addNode(T data) {
        // 1. 리스트에 데이터가 있는지 확인
        if(head == null) {
            // 2. 리스트에 데이터가 없다 -> 앞에 데이터 추가
            head = new Node<T>(data);
            
        } else {
            // 3. 리스트에 데이터가 있다 -> 끝에 데이터 추가
            
            // 3-1. head값을 가져온다 ( 처음 값을 알아야 순회 가능 )
            Node<T> node = head;
            
            // 3-2. 리스트의 마지막으로 이동
            while(node.next != null) {
                node = node.next;
            }
            // 3-3. 마지막 노드 추가
            node.next = new Node<T>(data);
        }
    }
    
    // 데이터 출력
    public void printAll() {
        // 1. 리스트에 데이터가 있는지 확인
        if(head == null) {
            // 2. 리스트에 데이터가 없다 -> null
            System.out.println("데이터가 없어요");
            
        } else {
            // 3. 리스트에 데이터가 있다 -> 데이터 출력
            // 3-1. head값을 가져온다
            Node<T> node = head;
            
            // 3-2. 리스트 순회하며 데이터를 출력한다
            while(node != null) {
                System.out.println(node.data);
                node = node.next;
            }
        }
    }
    
    // 검색
    public Node<T> search(T data) {
        // 1. 리스트에 데이터가 있는지 확인
        if(head == null) {
            // 2. 리스트에 데이터가 없다 -> null
            return null;
            
        } else {
            // 3. 리스트에 데이터가 있다 -> Node<T>
            // 3-1. head값을 가져온다
            Node<T> node = head;
            
            // 3-2. 리스트 순회
            while(node != null) {
                // 3-3. 값을 찾으면 반환
                if(node.data == data) {
                    return node;
                } else {
                node = node.next;
                }
            }
            return null;
        }
    }
    
    // 데이터 중간에 추가
    public void addNodeInside(T data, T isData) {
        // 1. 추가하려는 자리의 앞의 노드 탐색
        Node<T> searchNode = search(isData);
        
        if(searchNode == null) {
            addNode(data);
        } else {
            // 2. 앞 노드 연결 변경
            Node<T> node = searchNode.next;  // 뒤 노드
            searchNode.next = new Node<T>(data);
        
            // 3. 추가 노드 연결 변경
            searchNode.next.next = node;
        }
    }
    
    // 데이터 삭제
    public boolean delNode(T isData) {
        // 1. 리스트에 데이터가 있는지 확인
        if(head == null) {
            // 2. 리스트에 데이터가 없다
            return false;
            
        } else {
            // 3. 리스트에 데이터가 있다
            // 3-1. head값 가져옮
            Node<T> node = head;
            // 3-2. 삭제할 값이 head값이면 head값을 다음 노드에 저장
            if(node.data == isData) {
                head = node.next;
                return true;
            } else {
                // 3-3. 삭제할 값이 head가 아니면 순회하며 찾음
                while(node.next != null) {
                    // 삭제할 노드의 앞 뒤노드 연결 변경
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