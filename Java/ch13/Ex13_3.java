
public class Ex13_3 {
	// ��Ƽ������
	
	static long startTime = 0;
	public static void main(String[] args) {
		
		Thread th1 = new Thread(new ThreadEx3_1());
		// ����
		th1.start();
		startTime = System.currentTimeMillis();
		for(int i=0; i<300; i++) {
			System.out.printf("%s", new String("-"));
		}
		
		System.out.println("�ҿ�ð�1: " + (System.currentTimeMillis()-startTime));
		
	}
}

// ������
class ThreadEx3_1 implements Runnable {

	@Override
	public void run() {
		for(int i=0; i<300; i++) {
			System.out.printf("%s", new String("|"));
		}
		
		System.out.println("�ҿ�ð�2: " + (System.currentTimeMillis()-Ex13_3.startTime));
	}
}