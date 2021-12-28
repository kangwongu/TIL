import java.util.Arrays;

public class Ex5_4 {

	public static void main(String[] args) {
		// 0~9
		int[] iArr = {0,1,2,3,4,5,6,7,8,9};
		System.out.println(Arrays.toString(iArr));
		
		// 100번 반복
		for(int i=0; i<100; i++) {
			// 0~9범위의 랜덤 수
			int idx = (int)(Math.random()*10);
			int tmp = iArr[0];
			iArr[0] = iArr[idx];
			iArr[idx] = tmp;
		}
		System.out.println(Arrays.toString(iArr));
	}
}
