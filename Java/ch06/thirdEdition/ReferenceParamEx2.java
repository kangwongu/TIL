package thirdEdition;

import java.util.Arrays;

public class ReferenceParamEx2 {
	public static void main(String[] args) {
		// 크기 5인 배열 생성
		int[] x = {1,2,3,4,5};
		System.out.println(Arrays.toString(x));
		change(x);
		System.out.println("after:"+Arrays.toString(x));
		
		
	}
	
	// 배열을 매개변수로 받아서 배열 요소를 변경시키는 메소드
	static void change(int[] arr) {
		arr[1] = 500;
		System.out.println(Arrays.toString(arr));
	}
	
}
