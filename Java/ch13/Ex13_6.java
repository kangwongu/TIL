import javax.swing.JOptionPane;

// ������ �켱����
public class Ex13_6 {	
	public static void main(String[] args) {
		Thread th1 = new Thread(new ThreadEx13_1());
		Thread th2 = new Thread(new ThreadEx13_2());
		
		th1.setPriority(8);
		
		th1.start();
		th2.start();
		
		
	}
}

// ������
class ThreadEx13_1 implements Runnable {

	@Override
	public void run() {
		for(int i=0; i<300; i++) {
			System.out.print("-");
			for(int x=0; x<10000000; x++);
		}
	}
	
}

//������
class ThreadEx13_2 implements Runnable {

	@Override
	public void run() {
		for(int i=0; i<300; i++) {
			System.out.print("|");
			for(int x=0; x<10000000; x++);
		}
	}
	
}