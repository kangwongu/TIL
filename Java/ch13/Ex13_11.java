import javax.swing.JOptionPane;

public class Ex13_11 {
	
	static long startTime = 0;
	public static void main(String[] args) {
		// 1. 쓰레드 생성 후, 실행
		Thread th1 = new Thread(new ThreadEx11_1());
		Thread th2 = new Thread(new ThreadEx11_2());
		
		th1.start();
		th2.start();
		
		// 소요시간 산출
		startTime = System.currentTimeMillis();
		
		// 3. 메인쓰레드가 쓰레드 1,2 끝날때까지 기다림
		try {
			th1.join();
			th2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("소요시간:"+(System.currentTimeMillis()-startTime));
	
	}
}

// 쓰레드
class ThreadEx11_1 implements Runnable {

	@Override
	public void run() {
		for(int i=0; i<300; i++) {
			System.out.printf("%s", new String("-"));
		}
		
		// 2. 소요시간
		System.out.print("쓰레드1: " + (System.currentTimeMillis()-Ex13_11.startTime));
	}
	
}

class ThreadEx11_2 implements Runnable {

	@Override
	public void run() {
		for(int i=0; i<300; i++) {
			System.out.printf("%s", new String("|"));
		}
		// 2. 소요시간
		System.out.print("쓰레드2: " + (System.currentTimeMillis()-Ex13_11.startTime));
	}
	
}