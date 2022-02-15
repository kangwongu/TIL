package tree;

class Node {
    Node left;
    Node right;
    int value;
    public Node (int data) {
        this.value = data;
        this.left = null;
        this.right = null;
    }
}

public class Tree {
	Node head = null;
	  
	// 데이터 삽입
	public boolean insertNode(int data) {
	    // CASE1: Node 가 하나도 없을 때
	    if (this.head == null) {
	        this.head = new Node(data);
	    } else {
	        // CASE2: Node 가 하나 이상 들어가 있을 때
	        Node findNode = this.head;
	        while (true) {
	            // CASE2-1: 현재 Node 의 왼쪽에 Node 가 들어가야할 때
	            if (data < findNode.value) {
	                if (findNode.left != null) {
	                    findNode = findNode.left;
	                } else {
	                    findNode.left = new Node(data);
	                    break;
	                }
	            // CASE2-2: 현재 Node 의 오른쪽에 Node 가 들어가야할 때                    
	            } else {
	                if (findNode.right != null) {
	                    findNode = findNode.right;
	                } else {
	                    findNode.right = new Node(data);
	                    break;
	                }
	            }
	        }
	    }
	    return true;        
	}
	
	// 데이터 검색
	public Node search(int data) {
	    // case1. 노드가 하나도 없을 때
	    if(head == null) {
	        return null;
	    // case2. 노드가 하나 이상 있을 때
	    } else {
	        Node findNode = head;
	        while(findNode != null) {
	            if(findNode.value == data) {
	                return findNode;
	            } else if(data < findNode.value) {
	                findNode = findNode.left;
	            } else {
	                findNode = findNode.right;
	            }
	        }
	        return null;
	    }
	}
	
	public static void main(String[] args) {
		Tree myTree = new Tree();
		myTree.insertNode(2);
		myTree.insertNode(3);
		myTree.insertNode(4);
		myTree.insertNode(6);
		Node testNode = myTree.search(3);
		System.out.println(testNode.value);
	}
}