import javax.swing.JOptionPane;

public class Ex13_4 {	
	public static void main(String[] args) {
		// I/O ���ŷ, �Է��� ���ľ� ���� ������ ����ȴ�.
		// 1. �Է�
		String input = JOptionPane.showInputDialog("�ƹ� ���̳� �Է��ϼ���");
		System.out.println("�Է��Ͻ� ���� "+input+"�Դϴ�.");
		
		// 2. �Է� �� ����
		for(int i=10; i>0; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}