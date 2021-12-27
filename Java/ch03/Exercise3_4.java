
public class Exercise3_4 {

	public static void main(String[] args) {
		// 변수, 사과 수, 바구니 크기,사과를 담을 바구니
		int numOfApples = 121;
		int sizeOfBucket = 10;
		int numOfBucket = 
				(numOfApples/sizeOfBucket + (numOfApples%sizeOfBucket >= 1 ? 1 : 0));
		
		
		System.out.println(numOfBucket);
	
	
	}

}
