package sort;

import java.util.ArrayList;
import java.util.Collections;

public class BubbleSort {
    public ArrayList<Integer> sort(ArrayList<Integer> dataList) {
        // 리스트의 크기만큼 반복
        for(int index=0; index<dataList.size()-1; index++) {
            boolean swap = false;
            
            for(int index2=0; index2<dataList.size()-1-index; index2++) {
                // 앞 데이터가 뒤 데이터보다 크면 swap
                if(dataList.get(index2) > dataList.get(index2+1)) {
                    Collections.swap(dataList, index2, index2+1);
                    swap = true;
                }
            }
            // 정렬이 되어 있는 상태면 종료
            if(swap == false) {
                break;
            }
        }
        return dataList;
    }
    
    public static void main(String[] args) {
    	ArrayList<Integer> testData = new ArrayList<Integer>();
    	for(int i=0; i<100; i++) {
    	    testData.add((int)(Math.random()*100));
    	}
    	System.out.println(testData);
    	System.out.println("============= After Sort ==================");
    	
    	BubbleSort bSort = new BubbleSort();
    	System.out.println(bSort.sort(testData));
    }
}