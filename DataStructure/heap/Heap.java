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
    
    // �ڸ������� �ʿ��� ���� üũ
    public boolean move_up(Integer inserted_idx) {
        // ��Ʈ���ų� ������
        if(inserted_idx <= 1) {
            return false;
        }
        // �θ𺸴� ū�� üũ
        Integer parent_idx = inserted_idx / 2;
        if(this.heapArray.get(inserted_idx) > this.heapArray.get(parent_idx)) {
            return true;
        } else {
            return false;
        }
    }
    
    // ������ ����
    public boolean insert(Integer data) {
        // �ε���
        Integer inserted_idx, parent_idx;
        
        if(heapArray == null) {
            heapArray = new ArrayList<Integer>();
            
            heapArray.add(null);
            heapArray.add(data);
            return true;
        }
        
        this.heapArray.add(data);
        inserted_idx = this.heapArray.size() -1;
        
        // swap�� �ʿ��� ���
        while(this.move_up(inserted_idx)) {
            parent_idx = inserted_idx / 2; // �θ� �ε��� ���ϱ�
            Collections.swap(this.heapArray, inserted_idx, parent_idx);
            inserted_idx = parent_idx;
        }
        
        // swap�� �ʿ����� ���� ���
        return true;
    }
    
 // �ڸ��ٲ��� �ʿ����� üũ�ϴ� �޼ҵ�
    public boolean move_down(Integer popped_idx) {
        Integer left_child_popped_idx, right_child_popped_idx;
        
        left_child_popped_idx = popped_idx * 2;
        right_child_popped_idx = popped_idx * 2 +1;
        
        // CASE1 : ���� �ڽĳ�嵵 ���� �� (�ڽ� ��尡 �ϳ��� ���� ��)
        if(left_child_popped_idx >= this.heapArray.size()) {
            return false;
        // CASE2 : ������ �ڽĳ�常 ���� ��
        } else if(right_child_popped_idx >= this.heapArray.size()) {
            if(this.heapArray.get(popped_idx) < this.heapArray.get(left_child_popped_idx)) {
                return true;
            } else {
                return false;
            }
        // CASE3 : ����/������ �ڽ� ��尡 ��� ���� ��
        } else {
            // �ڽĳ�尣 ��
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
    
    // ������ ���� ( ��Ʈ��� )
    public Integer pop() {
        Integer returned_data, popped_idx, left_child_popped_idx, right_child_popped_idx;
        
        if(this.heapArray == null) {
            return null;
        } else {
            // ���� �� �� �����͸� ��Ʈ���� swap
            returned_data = this.heapArray.get(1);
            this.heapArray.set(1, this.heapArray.get(this.heapArray.size()-1));
            this.heapArray.remove(this.heapArray.size()-1);
            
            // üũ�ؾ��� �ε���
            popped_idx = 1;
            
            // �ڽĳ��� �ڸ��ٲ��� �ʿ��� �� üũ
            while(this.move_down(popped_idx)) {
                left_child_popped_idx = popped_idx * 2;
                right_child_popped_idx = popped_idx * 2 +1;
            
                // CASE2 : ������ �ڽĳ�常 ���� ��
                if(right_child_popped_idx >= this.heapArray.size()) {
                    if(this.heapArray.get(popped_idx) < this.heapArray.get(left_child_popped_idx)) {
                        Collections.swap(this.heapArray, popped_idx, left_child_popped_idx);
                        popped_idx = left_child_popped_idx;
                    }
                // CASE3 : ����/������ �ڽ� ��尡 ��� ���� ��
                } else {
                    // �ڽĳ�尣 ��
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
            return returned_data;  // ��Ʈ���
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
