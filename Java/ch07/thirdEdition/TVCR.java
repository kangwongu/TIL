package thirdEdition;

// ����Ŭ����
class Tv2 {
	boolean power;
	int channel;
	
	void power() { power = !power; }
	void channelUp() { ++channel; }
	void channelDown() { --channel; }
}

// ����Ŭ����
class VCR {
	boolean power;
	int counter = 0;
	
	void power() { power = !power; }
	void play() {}
	void stop() {}
	void rew() {}
	void ff() {}
}

// Tv�� ����� �ް� VCR�� ����
public class TVCR extends Tv2 {
	// VCR�� ���Խ��Ѽ� ���
	VCR vcr = new VCR();
	int counter = vcr.counter;
	
	// VCRŬ������ ��ġ�ϴ� ������� �޼ҵ� ����
	// VCRŬ������ ���� ȣ���ؼ� ���
	void play() {
		vcr.play();
	}
	
	void stop() {
		vcr.stop();
	}
}
