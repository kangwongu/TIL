
// ���� ������
public class Ex13_7 implements Runnable {	
	static boolean autoSave = false;
	
	public static void main(String[] args) {
		Thread th = new Thread(new Ex13_7());
		th.setDaemon(true);
		th.start();
		
		for(int i=1; i<=10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(i);
			
			if(i==5) autoSave=true;
		}
		System.out.println("���α׷� ����");
	}

	@Override
	public void run() {
		// ���� ������
		// ���ѷ����� ���鼭 ������ ������Ű�� ����
		while(true) {
			try {
				Thread.sleep(3*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(autoSave) autoSave();
		}
	}
	
	public void autoSave() {
		System.out.println("�۾������� �ڵ�����Ǿ����ϴ�.");
	}

}
