import javax.swing.JOptionPane;

public class Ex13_4 {	
	public static void main(String[] args) {
		// I/O 블락킹, 입력을 마쳐야 후의 연산이 실행된다.
		// 1. 입력
		String input = JOptionPane.showInputDialog("아무 값이나 입력하세요");
		System.out.println("입력하신 값은 "+input+"입니다.");
		
		// 2. 입력 후 연산
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