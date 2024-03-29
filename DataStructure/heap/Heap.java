package heap;

import java.util.ArrayList;
import java.util.Collections;

public class Heap {
    public ArrayList<Integer> heapArray = null;
    
    public Heap(Integer data) {
        heapArray = new ArrayList<Integer>();
        
        heapArray.add(null);
        heapArray.add(data);
    }
    
    // 자리변경이 필요한 지를 체크
    public boolean move_up(Integer inserted_idx) {
        // 루트노드거나 없으면
        if(inserted_idx <= 1) {
            return false;
        }
        // 부모보다 큰지 체크
        Integer parent_idx = inserted_idx / 2;
        if(this.heapArray.get(inserted_idx) > this.heapArray.get(parent_idx)) {
            return true;
        } else {
            return false;
        }
    }
    
    // 데이터 삽입
    public boolean insert(Integer data) {
        // 인덱스
        Integer inserted_idx, parent_idx;
        
        if(heapArray == null) {
            heapArray = new ArrayList<Integer>();
            
            heapArray.add(null);
            heapArray.add(data);
            return true;
        }
        
        this.heapArray.add(data);
        inserted_idx = this.heapArray.size() -1;
        
        // swap이 필요한 경우
        while(this.move_up(inserted_idx)) {
            parent_idx = inserted_idx / 2; // 부모 인덱스 구하기
            Collections.swap(this.heapArray, inserted_idx, parent_idx);
            inserted_idx = parent_idx;
        }
        
        // swap이 필요하지 않은 경우
        return true;
    }
    
 // 자리바꿈이 필요한지 체크하는 메소드
    public boolean move_down(Integer popped_idx) {
        Integer left_child_popped_idx, right_child_popped_idx;
        
        left_child_popped_idx = popped_idx * 2;
        right_child_popped_idx = popped_idx * 2 +1;
        
        // CASE1 : 왼쪽 자식노드도 없을 때 (자식 노드가 하나도 없을 때)
        if(left_child_popped_idx >= this.heapArray.size()) {
            return false;
        // CASE2 : 오른쪽 자식노드만 없을 때
        } else if(right_child_popped_idx >= this.heapArray.size()) {
            if(this.heapArray.get(popped_idx) < this.heapArray.get(left_child_popped_idx)) {
                return true;
            } else {
                return false;
            }
        // CASE3 : 왼쪽/오른쪽 자식 노드가 모두 있을 때
        } else {
            // 자식노드간 비교
            if(this.heapArray.get(left_child_popped_idx) > this.heapArray.get(right_child_popped_idx)) {
                if(this.heapArray.get(popped_idx) < this.heapArray.get(left_child_popped_idx)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                if(this.heapArray.get(popped_idx) < this.heapArray.get(right_child_popped_idx)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }
    
    // 데이터 삭제 ( 루트노드 )
    public Integer pop() {
        Integer returned_data, popped_idx, left_child_popped_idx, right_child_popped_idx;
        
        if(this.heapArray == null) {
            return null;
        } else {
            // 가장 맨 끝 데이터를 루트노드와 swap
            returned_data = this.heapArray.get(1);
            this.heapArray.set(1, this.heapArray.get(this.heapArray.size()-1));
            this.heapArray.remove(this.heapArray.size()-1);
            
            // 체크해야할 인덱스
            popped_idx = 1;
            
            // 자식노드와 자리바꿈이 필요한 지 체크
            while(this.move_down(popped_idx)) {
                left_child_popped_idx = popped_idx * 2;
                right_child_popped_idx = popped_idx * 2 +1;
            
                // CASE2 : 오른쪽 자식노드만 없을 때
                if(right_child_popped_idx >= this.heapArray.size()) {
                    if(this.heapArray.get(popped_idx) < this.heapArray.get(left_child_popped_idx)) {
                        Collections.swap(this.heapArray, popped_idx, left_child_popped_idx);
                        popped_idx = left_child_popped_idx;
                    }
                // CASE3 : 왼쪽/오른쪽 자식 노드가 모두 있을 때
                } else {
                    // 자식노드간 비교
                    if(this.heapArray.get(left_child_popped_idx) > this.heapArray.get(right_child_popped_idx)) {
                        if(this.heapArray.get(popped_idx) < this.heapArray.get(left_child_popped_idx)) {
                            Collections.swap(heapArray, popped_idx, left_child_popped_idx);
                            popped_idx = left_child_popped_idx;
                        }
                    } else {
                        if(this.heapArray.get(popped_idx) < this.heapArray.get(right_child_popped_idx)) {
                            Collections.swap(heapArray, popped_idx, right_child_popped_idx);
                            popped_idx = right_child_popped_idx;
                        }
                    }
                }   
            }
            return returned_data;  // 루트노드
        }
    }
    
    public static void main(String[] args) {
        Heap heapTest = new Heap(15);
        heapTest.insert(10);
        heapTest.insert(8);
        heapTest.insert(5);
        heapTest.insert(4);
        heapTest.insert(20);
        System.out.println(heapTest.heapArray);

        heapTest.pop();
        System.out.println(heapTest.heapArray);
    }
}
