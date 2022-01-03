package thirdedition.exercise;

public class Exercise9_4 {
	static void printGraph(int[] dateArr, char ch) {
		// dateArr의 요소만큼 ch를 출력
		for(int i=0; i<dateArr.length; i++) {
			for(int j=0; j<dateArr[i]; j++) {
				System.out.print(ch);
			}
			System.out.println(dateArr[i]);
		}
	}
	
	public static void main(String[] args) {
		printGraph(new int[] {3,7,1,4}, '*');
	}
}