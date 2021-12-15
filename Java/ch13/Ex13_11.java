import javax.swing.JOptionPane;

public class Ex13_11 {
	
	static long startTime = 0;
	public static void main(String[] args) {
		// 1. ������ ���� ��, ����
		Thread th1 = new Thread(new ThreadEx11_1());
		Thread th2 = new Thread(new ThreadEx11_2());
		
		th1.start();
		th2.start();
		
		// �ҿ�ð� ����
		startTime = System.currentTimeMillis();
		
		// 3. ���ξ����尡 ������ 1,2 ���������� ��ٸ�
		try {
			th1.join();
			th2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("�ҿ�ð�:"+(System.currentTimeMillis()-startTime));
	
	}
}

// ������
class ThreadEx11_1 implements Runnable {

	@Override
	public void run() {
		for(int i=0; i<300; i++) {
			System.out.printf("%s", new String("-"));
		}
		
		// 2. �ҿ�ð�
		System.out.print("������1: " + (System.currentTimeMillis()-Ex13_11.startTime));
	}
	
}

class ThreadEx11_2 implements Runnable {

	@Override
	public void run() {
		for(int i=0; i<300; i++) {
			System.out.printf("%s", new String("|"));
		}
		// 2. �ҿ�ð�
		System.out.print("������2: " + (System.currentTimeMillis()-Ex13_11.startTime));
	}
	
}