
public class Ex13_3 {
	// 멀티쓰레드
	
	static long startTime = 0;
	public static void main(String[] args) {
		
		Thread th1 = new Thread(new ThreadEx3_1());
		// 시작
		th1.start();
		startTime = System.currentTimeMillis();
		for(int i=0; i<300; i++) {
			System.out.printf("%s", new String("-"));
		}
		
		System.out.println("소요시간1: " + (System.currentTimeMillis()-startTime));
		
	}
}

// 쓰레드
class ThreadEx3_1 implements Runnable {

	@Override
	public void run() {
		for(int i=0; i<300; i++) {
			System.out.printf("%s", new String("|"));
		}
		
		System.out.println("소요시간2: " + (System.currentTimeMillis()-Ex13_3.startTime));
	}
}