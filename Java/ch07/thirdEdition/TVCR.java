package thirdEdition;

// 조상클래스
class Tv2 {
	boolean power;
	int channel;
	
	void power() { power = !power; }
	void channelUp() { ++channel; }
	void channelDown() { --channel; }
}

// 포함클래스
class VCR {
	boolean power;
	int counter = 0;
	
	void power() { power = !power; }
	void play() {}
	void stop() {}
	void rew() {}
	void ff() {}
}

// Tv의 상속을 받고 VCR을 포함
public class TVCR extends Tv2 {
	// VCR을 포함시켜서 사용
	VCR vcr = new VCR();
	int counter = vcr.counter;
	
	// VCR클래스와 일치하는 선언부의 메소드 선언
	// VCR클래스의 것을 호출해서 사용
	void play() {
		vcr.play();
	}
	
	void stop() {
		vcr.stop();
	}
}
