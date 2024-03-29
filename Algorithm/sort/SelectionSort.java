package sort;

import java.util.ArrayList;
import java.util.Collections;

public class SelectionSort {
    public ArrayList<Integer> sort(ArrayList<Integer> dataList) {
        int lowest;  // 가장 작은 값의 인덱스
        
        for(int stand=0; stand<dataList.size()-1; stand++) {
            lowest = stand;
            
            for(int index=stand+1; index<dataList.size(); index++) {
                // 가장 작은 값을 구함
                if(dataList.get(lowest) > dataList.get(index)) {
                    lowest = index;
                }
            }
            // 순차적으로 순회하는 기준값과, 가장 작은 값 자리변경
            Collections.swap(dataList, lowest, stand);
        }
        return dataList;
    }
    
    public static void main(String[] args) {
    	ArrayList<Integer> testData = new ArrayList<Integer>();

    	for (int i = 0; i < 100; i++) {
    	    testData.add((int)(Math.random() * 100));
    	}
    	SelectionSort sSort = new SelectionSort();
    	System.out.println(sSort.sort(testData));
    }
}