package thirdEdition;

// 추상 클래스
abstract class Player {
	boolean pause;
	int currentPos;
	
	Player() {
		pause = false;
		currentPos = 0;
	}
	
	abstract void play(int pos);
	abstract void stop();
	
	void play() {
		play(currentPos);
	}
	
}

// 추상 클래스를 상속받는 클래스
class AudioPlayer extends Player {
	void play(int pos) {
		
	}
	
	void stop() {
		
	}
}


public class AbstractTest {
	public static void main(String[] args) {

	}

}
