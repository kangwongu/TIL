import java.util.Arrays;

public class Exercise6_17 {
	static int[] shuffle(int[] arr) {
		// 유효성 검사
		if(arr==null || arr.length==0)
			return arr;
		
		for(int i=0; i<arr.length; i++) {
			int idx = (int)(Math.random()*9);
			int tmp = arr[i];
			arr[i] = arr[idx];
			arr[idx] = tmp;
		}
		return arr;
	}
	
	
	public static void main(String[] args) {
		int[] original = {1,2,3,4,5,6,7,8,9};
		System.out.println(Arrays.toString(original));
		
		int[] result = shuffle(original);
		System.out.println(Arrays.toString(result));
	
	}
}