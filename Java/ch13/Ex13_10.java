import javax.swing.JOptionPane;

public class Ex13_10 {	
	public static void main(String[] args) {
		Thread th1 = new Thread(new RunImplEx10(), "*");
		Thread th2 = new Thread(new RunImplEx10(), "**");
		Thread th3 = new Thread(new RunImplEx10(), "***");
		th1.start(); th2.start(); th3.start();
		
		try {
			Thread.sleep(2000);
			th1.suspend();
			Thread.sleep(2000);
			th2.suspend();
			th1.resume();
			Thread.sleep(3000);
			th1.stop();
			th2.stop();
			Thread.sleep(2000);
			th3.stop();
		} catch (InterruptedException e) {}
		
	}
}

class RunImplEx10 implements Runnable {
	public void run() {
		while(true) {
			System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
		}
	}
}


