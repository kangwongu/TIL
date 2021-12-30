import java.util.Arrays;

public class Exercise6_20 {
	public static int max(int[] arr) {
		// 유효성 검사
		if(arr==null || arr.length==0)
			return -999999;
		
		
		// 배열 0번째를 최대값 지정
		int max = arr[0];
		
		// 배열 0번째를 배열 1번째 부터 순회한 요소와 비교해 최대값 도출 
		for(int i=1; i<arr.length; i++) {
			if(arr[i] > max)
				max = arr[i];
		}
		
		return max;
		
	}
	
	public static void main(String[] args) {
		int[] data = {3,2,9,4,7};
		System.out.println(Arrays.toString(data));
		System.out.println(max(data));
		System.out.println(max(null));
		System.out.println(max(new int[] {}));
	}
}