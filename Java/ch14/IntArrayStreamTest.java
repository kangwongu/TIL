import java.util.Arrays;
import java.util.stream.IntStream;

public class IntArrayStreamTest {

	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5};
		
		for(int num : arr) {
			System.out.println(num);
		}
		
		// ��Ʈ�� Ȱ��
		System.out.println();
		Arrays.stream(arr).forEach(n -> System.out.println(n));
	
//		IntStream is = Arrays.stream(arr);
		
		System.out.println();
		int sum = Arrays.stream(arr).sum();
		System.out.println(sum);
	}

}
