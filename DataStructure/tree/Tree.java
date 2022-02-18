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
	
    // 데이터 삭제
    public boolean delete(int data) {
        // 코너케이스 1: Tree가 비어있을 때
        if(this.head == null) {
            return false;
        }
        
        // 코너케이스 2 : Tree에 Node가 하나만 있을 때
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
        
        // 여기까지 진행되면, findNode에는 삭제할 Node값이 담겨있고,
        // findNodeParent에는 삭제할 Node의 부모 Node값이 담겨있다
        
        // CASE 1 : 삭제할 Node가 Leaf Node일 때
        if(findNode.left == null && findNode.right == null) {
            if(data < findNodeParent.value) {
                findNodeParent.left = null;
                findNode = null;
            } else {
                findNodeParent.right = null;
                findNode = null;
            }
            return true;
         
            // CASE 2-1 : 삭제할 Node가 Child Node를 1개 가지고 있는 경우 (왼쪽)
        } else if(findNode.left != null && findNode.right == null) {     
            if(data < findNodeParent.value) {
                findNodeParent.left = findNode.left;
                findNode = null;
            } else {
                findNodeParent.right = findNode.left;
                findNode = null;
            }
            return true;
            
            // CASE 2-2 : 삭제할 Node가 Child Node를 1개 가지고 있는 경우 (오른쪽)
        } else if(findNode.left == null && findNode.right != null) {
        	if(data < findNodeParent.value) {
                findNodeParent.left = findNode.right;
                findNode = null;
            } else {
                findNodeParent.right = findNode.right;
                findNode = null;
            }
            return true;
         
            // CASE 3 : 삭제할 Node가 Child Node를 2개 가지고 있는 경우 (삭제할 Node가 부모 Node의 왼쪽에 있는 경우)
        } else {
            // CASE 3-1 : 삭제할 Node가 부모 Node의 왼쪽에 있는 경우
            if(data < findNodeParent.value) {
                // 삭제할 Node의 오른쪽 Child Node로 이동
                Node changeNode = findNode.right;
                Node changeNodeParent = findNode.right;
                
                // 삭제할 Node의 오른쪽 Child Node 중 가장 왼쪽에 있는 Child Node를 찾기
                while(changeNode.left != null) {
                    changeNodeParent = changeNode;
                    changeNode = changeNode.left;
                }
                // 여기까지 진행되면,
                // changeNode에는 삭제할 Node의 오른쪽 Child Node 중 가장 왼쪽에 있는 Child Node,
                
                // CASE 3-1-2 : changeNode의 오른쪽 Child Node가 있을 때
                if(changeNode.right != null) {
                    changeNodeParent.left = changeNode.right;
                    
                // CASE 3-1-1 : changeNode의 Child Node가 없을 때    
                } else {
                    changeNodeParent.left = null;
                }
                
                // findNodeParent의 왼쪽 Child Node에, 삭제할 Node의 오른쪽 자식 중,
                // 가장 작은 값을 가진 changeNode를 연결
                findNodeParent.left = changeNode;
                
                // findNodeParent의 왼쪽 Child Node가 현재, changeNode이고,
                // chagneNode의 왼쪽/오른쪽 Child Node를 모두, 삭제할 findNode의
                // 기존 왼쪽/오른쪽 Node로 변경
                changeNode.right = findNode.right;
                changeNode.left = findNode.left;
                
                findNode = null;
            
                // CASE 3-2 : 삭제할 Node가 부모 Node의 오른쪽에 있는 경우
            } else {
            	
                // 삭제할 Node의 오른쪽 Child Node로 이동
                Node changeNode = findNode.right;
                Node changeNodeParent = findNode.right;
                
                // 삭제할 Node의 오른쪽 Child Node 중 가장 왼쪽에 있는 Child Node를 찾기
                while(changeNode.left != null) {
                    changeNodeParent = changeNode;
                    changeNode = changeNode.left;
                }
                // 여기까지 진행되면,
                // changeNode에는 삭제할 Node의 오른쪽 Child Node 중 가장 왼쪽에 있는 Child Node,
                
                // CASE 3-2-2 : changeNode의 오른쪽 Child Node가 있을 때
                if(changeNode.right != null) {
                    changeNodeParent.left = changeNode.right;
                        
                // CASE 3-2-1 : changeNode의 Child Node가 없을 때    
                } else {
                    changeNodeParent.left = null;
                }
                
                // findNodeParent의 오른쪽 Child Node에, 삭제할 Node의 오른쪽 자식 중,
                // 가장 작은 값을 가진 changeNode를 연결
                findNodeParent.right = changeNode;
                
                // findNodeParent의 왼쪽 Child Node가 현재, changeNode이고,
                // chagneNode의 왼쪽/오른쪽 Child Node를 모두, 삭제할 findNode의
                // 기존 왼쪽/오른쪽 Node로 변경
                changeNode.right = findNode.right;
                changeNode.left = findNode.left;
                    
                findNode = null;
                
            }
            return true;
        }
            
    }
	public static void main(String[] args) {
		// Case3-1: 삭제할 Node가 Child Node를 두 개 가지고 있을 경우
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