
// 데몬 쓰레드
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
		System.out.println("프로그램 종료");
	}

	@Override
	public void run() {
		// 데몬 쓰레드
		// 무한루프를 돌면서 조건을 만족시키면 실행
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
		System.out.println("작업파일이 자동저장되었습니다.");
	}

}
