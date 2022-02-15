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
	  
	// ������ ����
	public boolean insertNode(int data) {
	    // CASE1: Node �� �ϳ��� ���� ��
	    if (this.head == null) {
	        this.head = new Node(data);
	    } else {
	        // CASE2: Node �� �ϳ� �̻� �� ���� ��
	        Node findNode = this.head;
	        while (true) {
	            // CASE2-1: ���� Node �� ���ʿ� Node �� ������ ��
	            if (data < findNode.value) {
	                if (findNode.left != null) {
	                    findNode = findNode.left;
	                } else {
	                    findNode.left = new Node(data);
	                    break;
	                }
	            // CASE2-2: ���� Node �� �����ʿ� Node �� ������ ��                    
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
	
	// ������ �˻�
	public Node search(int data) {
	    // case1. ��尡 �ϳ��� ���� ��
	    if(head == null) {
	        return null;
	    // case2. ��尡 �ϳ� �̻� ���� ��
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