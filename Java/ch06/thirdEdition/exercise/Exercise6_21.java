package thirdEdition.exercise;


class MyTv {
	// 加己
	boolean isPowerOn;
	int channel;
	int volume;
	
	final int MAX_VOLUME = 100;
	final int MIN_VOLUME = 0;
	final int MAX_CHANNEL = 200;
	final int MIN_CHANNEL = 1;
	
	// 积己磊
	
	
	// 扁瓷
	void turnOnOff() { isPowerOn = !isPowerOn; }
	void volumeUp() {
		if(volume < MAX_VOLUME) {
			volume++;
		} else {
			volume = MAX_VOLUME;
		}
	}
	void volumeDown() {
		if(volume > MIN_VOLUME) {
			volume--;
		} else {
			volume = MIN_VOLUME;
		}
	}
	void channelUp() {
		if(channel == MAX_CHANNEL)
			channel = MIN_CHANNEL;
		else
			channel++;
	}
	void channelDown() {
		if(channel == MIN_CHANNEL)
			channel = MAX_CHANNEL;
		else
			channel--;
	}
	
}

public class Exercise6_21 {
	public static void main(String[] args) {
		MyTv t = new MyTv();
		
		t.channel = 199;
		t.volume = 99;
		t.channelUp();
		System.out.println(t.channel);
		t.channelUp();
		System.out.println(t.channel);
		
		t.volumeUp();
		System.out.println(t.volume);
		t.volumeUp();
		System.out.println(t.volume);
	}
}


