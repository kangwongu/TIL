package thirdEdition;

// �߻� Ŭ����
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

// �߻� Ŭ������ ��ӹ޴� Ŭ����
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
