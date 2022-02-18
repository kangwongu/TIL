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
	
    // ������ ����
    public boolean delete(int data) {
        // �ڳ����̽� 1: Tree�� ������� ��
        if(this.head == null) {
            return false;
        }
        
        // �ڳ����̽� 2 : Tree�� Node�� �ϳ��� ���� ��
        if(this.head.value==data && this.head.left==null && this.head.right==null) {
            this.head = null;
            return true;
        }
        
        boolean searched = false;
        
        Node findNode = this.head;
        Node findNodeParent = this.head;
        
        while(findNode != null) {
            if(data == findNode.value) {
                searched = true;
                break;
            } else if(data < findNode.value) {
                findNodeParent = findNode;
                findNode = findNode.left;
            } else {
                findNodeParent = findNode;
                findNode = findNode.right;
            }
        }
        if(searched == false) {
            return false;
        }
        
        // ������� ����Ǹ�, findNode���� ������ Node���� ����ְ�,
        // findNodeParent���� ������ Node�� �θ� Node���� ����ִ�
        
        // CASE 1 : ������ Node�� Leaf Node�� ��
        if(findNode.left == null && findNode.right == null) {
            if(data < findNodeParent.value) {
                findNodeParent.left = null;
                findNode = null;
            } else {
                findNodeParent.right = null;
                findNode = null;
            }
            return true;
         
            // CASE 2-1 : ������ Node�� Child Node�� 1�� ������ �ִ� ��� (����)
        } else if(findNode.left != null && findNode.right == null) {     
            if(data < findNodeParent.value) {
                findNodeParent.left = findNode.left;
                findNode = null;
            } else {
                findNodeParent.right = findNode.left;
                findNode = null;
            }
            return true;
            
            // CASE 2-2 : ������ Node�� Child Node�� 1�� ������ �ִ� ��� (������)
        } else if(findNode.left == null && findNode.right != null) {
        	if(data < findNodeParent.value) {
                findNodeParent.left = findNode.right;
                findNode = null;
            } else {
                findNodeParent.right = findNode.right;
                findNode = null;
            }
            return true;
         
            // CASE 3 : ������ Node�� Child Node�� 2�� ������ �ִ� ��� (������ Node�� �θ� Node�� ���ʿ� �ִ� ���)
        } else {
            // CASE 3-1 : ������ Node�� �θ� Node�� ���ʿ� �ִ� ���
            if(data < findNodeParent.value) {
                // ������ Node�� ������ Child Node�� �̵�
                Node changeNode = findNode.right;
                Node changeNodeParent = findNode.right;
                
                // ������ Node�� ������ Child Node �� ���� ���ʿ� �ִ� Child Node�� ã��
                while(changeNode.left != null) {
                    changeNodeParent = changeNode;
                    changeNode = changeNode.left;
                }
                // ������� ����Ǹ�,
                // changeNode���� ������ Node�� ������ Child Node �� ���� ���ʿ� �ִ� Child Node,
                
                // CASE 3-1-2 : changeNode�� ������ Child Node�� ���� ��
                if(changeNode.right != null) {
                    changeNodeParent.left = changeNode.right;
                    
                // CASE 3-1-1 : changeNode�� Child Node�� ���� ��    
                } else {
                    changeNodeParent.left = null;
                }
                
                // findNodeParent�� ���� Child Node��, ������ Node�� ������ �ڽ� ��,
                // ���� ���� ���� ���� changeNode�� ����
                findNodeParent.left = changeNode;
                
                // findNodeParent�� ���� Child Node�� ����, changeNode�̰�,
                // chagneNode�� ����/������ Child Node�� ���, ������ findNode��
                // ���� ����/������ Node�� ����
                changeNode.right = findNode.right;
                changeNode.left = findNode.left;
                
                findNode = null;
            
                // CASE 3-2 : ������ Node�� �θ� Node�� �����ʿ� �ִ� ���
            } else {
            	
                // ������ Node�� ������ Child Node�� �̵�
                Node changeNode = findNode.right;
                Node changeNodeParent = findNode.right;
                
                // ������ Node�� ������ Child Node �� ���� ���ʿ� �ִ� Child Node�� ã��
                while(changeNode.left != null) {
                    changeNodeParent = changeNode;
                    changeNode = changeNode.left;
                }
                // ������� ����Ǹ�,
                // changeNode���� ������ Node�� ������ Child Node �� ���� ���ʿ� �ִ� Child Node,
                
                // CASE 3-2-2 : changeNode�� ������ Child Node�� ���� ��
                if(changeNode.right != null) {
                    changeNodeParent.left = changeNode.right;
                        
                // CASE 3-2-1 : changeNode�� Child Node�� ���� ��    
                } else {
                    changeNodeParent.left = null;
                }
                
                // findNodeParent�� ������ Child Node��, ������ Node�� ������ �ڽ� ��,
                // ���� ���� ���� ���� changeNode�� ����
                findNodeParent.right = changeNode;
                
                // findNodeParent�� ���� Child Node�� ����, changeNode�̰�,
                // chagneNode�� ����/������ Child Node�� ���, ������ findNode��
                // ���� ����/������ Node�� ����
                changeNode.right = findNode.right;
                changeNode.left = findNode.left;
                    
                findNode = null;
                
            }
            return true;
        }
            
    }
	public static void main(String[] args) {
		// Case3-1: ������ Node�� Child Node�� �� �� ������ ���� ���
        Tree myTree = new Tree();
        myTree.insertNode(10);
        myTree.insertNode(15);
        myTree.insertNode(13);
        myTree.insertNode(11);
        myTree.insertNode(14);
        myTree.insertNode(18);
        myTree.insertNode(16);
        myTree.insertNode(19);
        myTree.insertNode(17);
        myTree.insertNode(7);
        myTree.insertNode(8);
        myTree.insertNode(6);
        System.out.println(myTree.delete(15));
        System.out.println("HEAD: " + myTree.head.value);
        System.out.println("HEAD LEFT: " + myTree.head.left.value);
        System.out.println("HEAD LEFT LEFT: " + myTree.head.left.left.value);
        System.out.println("HEAD LEFT RIGHT: " + myTree.head.left.right.value);

        System.out.println("HEAD RIGHT: " + myTree.head.right.value);
        System.out.println("HEAD RIGHT LEFT: " + myTree.head.right.left.value);
        System.out.println("HEAD RIGHT RIGHT: " + myTree.head.right.right.value);

        System.out.println("HEAD RIGHT RIGHT LEFT: " + myTree.head.right.right.left.value);
        System.out.println("HEAD RIGHT RIGHT RIGHT: " + myTree.head.right.right.right.value);
	}
}