
public class Exercise3_4 {

	public static void main(String[] args) {
		// ����, ��� ��, �ٱ��� ũ��,����� ���� �ٱ���
		int numOfApples = 121;
		int sizeOfBucket = 10;
		int numOfBucket = 
				(numOfApples/sizeOfBucket + (numOfApples%sizeOfBucket >= 1 ? 1 : 0));
		
		
		System.out.println(numOfBucket);
	
	
	}

}
