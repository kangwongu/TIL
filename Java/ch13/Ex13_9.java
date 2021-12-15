import javax.swing.JOptionPane;

public class Ex13_9 {	
	public static void main(String[] args) {
		ThreadEx9_1 th1 = new ThreadEx9_1();
		th1.start();
		
		String input = JOptionPane.showInputDialog("아무 값이나 입력하세요");
		System.out.println("입력하신 값은 " + input + "입니다.");
		th1.interrupt();	// interrupted상태  -> true
		System.out.println("isInterrupted():" + th1.isInterrupted());
		
	}
}


class ThreadEx9_1 extends Thread {
	public void run() {
		int i = 10;
		
		// i가 0이 아니고, interrupted가 false일 동안 반복
		while(i!=0 && !isInterrupted()) {
			System.out.println(i--);
			for(long x=0; x<2500000000L; x++);
		}
		System.out.println("카운트 종료");
	}
}


