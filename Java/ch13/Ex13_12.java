import javax.swing.JOptionPane;

public class Ex13_12 {	
	public static void main(String[] args) {
		Runnable r = new ThreadEx12_1();
		new Thread(r).start();
		new Thread(r).start();
	}
}

// 계좌 클래스
class Account {
	// 속성
	private int balance = 1000;
	
	// 기능
	public int getBalance() {
		return balance;
	}
	
	public void withdraw(int money) {
		if(balance >= money) {
			// 콘솔에 출력되는 속도를 늦춤
			try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
			balance -= money;
			
		}
			
	}
}

// 쓰레드
class ThreadEx12_1 implements Runnable {
	Account account = new Account();
	
	@Override
	public void run() {
		while(account.getBalance()>0) {
			// 100, 200, 300원을 랜덤으로 계좌에서 인출
			int money = (int)(Math.random()*3+1)*100;
			account.withdraw(money);
			System.out.println("balance:"+account.getBalance());
			
		}
	}
	
}