
public class Ex13_2 {
	public static void main(String[] args) {
		// 싱글 쓰레드
		// 두 개의 반복문 실행 후 소요시간 구하기
		long startTime = System.currentTimeMillis();
		
		for(int i=0; i<300; i++) {
			System.out.printf("%s", new String("-"));
		}
		
		System.out.println("소요시간1: " + (System.currentTimeMillis()-startTime));
		
		for(int i=0; i<300; i++) {
			System.out.printf("%s", new String("|"));
		}
		
		System.out.println("소요시간2: " + (System.currentTimeMillis()-startTime));
	}
}

