
public class Ex6_14 {
	// 명시적 초기화
	static int[] arr = new int[10];
	
	// 복잡 초기화
	// 클래스 초기화 블럭
	static {
		for(int i=0; i<arr.length; i++) {
			arr[i] = (int)(Math.random()*10)+1;
		}
	}
	public static void main(String[] args) {
		for(int i=0; i<arr.length; i++) {
			System.out.println("arr["+i+"] : " + arr[i]);
		}
	}
}

