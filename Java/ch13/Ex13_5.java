import javax.swing.JOptionPane;

public class Ex13_5 {	
	public static void main(String[] args) {
		// I/O ���ŷ, �Է°� ������� ������ ����
		// 1. ������ ����/����
		Thread th1 = new Thread(new ThreadEx5_1());
		th1.start();
		
		// 2. �Է�
		String input = JOptionPane.showInputDialog("�ƹ� ���̳� �Է��ϼ���");
		System.out.println("�Է��Ͻ� ���� "+input+"�Դϴ�.");
	}
}

// ������
class ThreadEx5_1 implements Runnable {

	@Override
	public void run() {
		for(int i=10; i>0; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}