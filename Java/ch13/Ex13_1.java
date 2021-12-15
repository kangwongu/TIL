
public class Ex13_1 {
	public static void main(String[] args) {
		// 1. 쓰레드 객체 생성
		Thread th1 = new ThreadEx1_1();
		Thread th2 = new Thread(new ThreadEx1_2());
		
		// 2. 쓰레드 실행
		th1.start();
		th2.start();
	}
}

// Thread상속받은 쓰레드
class ThreadEx1_1 extends Thread {
	// run() 오버라이딩 해야 함
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println(getName());
		}
	}
}

// Runnable구현한 쓰레드
class ThreadEx1_2 implements Runnable {
	@Override
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println(Thread.currentThread().getName());
		}
	}
	
}

