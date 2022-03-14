package sort;

import java.util.ArrayList;

public class MergeSort {

	public ArrayList<Integer> mergeFunc(ArrayList<Integer> leftList, ArrayList<Integer> rightList) {
        ArrayList<Integer> mergedList = new ArrayList<Integer>();
        int leftPoint = 0;
        int rightPoint = 0;

        // CASE 1 : left/right 둘 다 있을 때
        while(leftList.size() > leftPoint && rightList.size() > rightPoint) {
            // 크기 비교해 정렬
            if(leftList.get(leftPoint) > rightList.get(rightPoint)) {
                mergedList.add(rightList.get(rightPoint));
                rightPoint++;
            } else {
                mergedList.add(leftList.get(leftPoint));
                leftPoint++;
            }
        }

        // CASE 2 : right 데이터가 없을 때
        while(leftList.size() > leftPoint) {
            mergedList.add(leftList.get(leftPoint));
            leftPoint++;
        }

        // CASE 3 : left 데이터가 없을 때
        while(rightList.size() > rightPoint) {
            mergedList.add(rightList.get(rightPoint));
            rightPoint++;
        }

        return mergedList;
    }
    
    public ArrayList<Integer> mergeSplitFunc(ArrayList<Integer> dataList) {
        if (dataList.size() <= 1) {
            return dataList;
        }
        int medium = dataList.size() / 2;  

        ArrayList<Integer> leftArr = new ArrayList<Integer>();
        ArrayList<Integer> rightArr = new ArrayList<Integer>();

        leftArr = mergeSplitFunc(new ArrayList<Integer>(dataList.subList(0, medium))); 
        rightArr = mergeSplitFunc(new ArrayList<Integer>(dataList.subList(medium, dataList.size()))); 

        return mergeFunc(leftArr, rightArr);
    }
	
	public static void main(String[] args) {
		ArrayList<Integer> testData = new ArrayList<Integer>();
		
		testData.add(3);
		testData.add(9);
		testData.add(2);
		testData.add(7);
		testData.add(1);
		testData.add(8);
		testData.add(5);
		testData.add(3);
		
		MergeSort mSort = new MergeSort();
		System.out.println(mSort.mergeSplitFunc(testData));

	}

}
