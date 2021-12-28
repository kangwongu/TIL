package thirdedition.exercise;

public class Exercise4_6 {
	
	public static void main(String[] args) {
	
		// 두 수의 합이 6이되는 경우
		for(int i=1; i<=6; i++) {
			for(int j=1; j<=6; j++) {
				if(i+j==6) {
					System.out.println("i:"+i+", j:"+j);
				}
			}
		}
	}
}
