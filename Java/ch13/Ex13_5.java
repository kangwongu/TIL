import javax.swing.JOptionPane;

public class Ex13_5 {	
	public static void main(String[] args) {
		// I/O 블락킹, 입력과 상관없이 연산이 실행
		// 1. 쓰레드 생성/실행
		Thread th1 = new Thread(new ThreadEx5_1());
		th1.start();
		
		// 2. 입력
		String input = JOptionPane.showInputDialog("아무 값이나 입력하세요");
		System.out.println("입력하신 값은 "+input+"입니다.");
	}
}

// 쓰레드
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