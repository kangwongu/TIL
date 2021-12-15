
public class Ex13_1 {
	public static void main(String[] args) {
		// 1. ������ ��ü ����
		Thread th1 = new ThreadEx1_1();
		Thread th2 = new Thread(new ThreadEx1_2());
		
		// 2. ������ ����
		th1.start();
		th2.start();
	}
}

// Thread��ӹ��� ������
class ThreadEx1_1 extends Thread {
	// run() �������̵� �ؾ� ��
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println(getName());
		}
	}
}

// Runnable������ ������
class ThreadEx1_2 implements Runnable {
	@Override
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println(Thread.currentThread().getName());
		}
	}
	
}

