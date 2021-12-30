import java.util.Arrays;

class MyTv {
	// 속성
	boolean isPowerOn;
	int channel;
	int volume;
	
	final int MAX_VOLUME = 100;
	final int MIN_VOLUME = 0;
	final int MAX_CHANNEL = 100;
	final int MIN_CHANNEL = 1;
	
	// 기능
	void turnOnOff() {
		isPowerOn = !isPowerOn;
	}
	
	void volumeUp() {
		// 볼륨이 최대볼륨값보다 작으면 증가
		if(volume < MAX_VOLUME)
			volume++;
	}
	
	void volumeDown() {
		// 볼륨이 최소볼륨값보다 크면 감소
		if(volume > MIN_VOLUME) 
			volume--;
	}
	
	void channelUp() {
		// 채널값 증가, 채널값이 최대채널값이면 최소채널값으로 변경
		if(channel == MAX_CHANNEL)
			channel = MIN_CHANNEL;
		else 
			channel++;
		
	}
	
	void channelDown() {
		// 채널값 감소, 채널값이 최소채널값이면 최대채널값으로 변경
		if(channel == MIN_CHANNEL)
			channel = MAX_CHANNEL;
		else
			channel--;
		
	}
}

public class Exercise6_19 {
	public static void main(String[] args) {
		MyTv t = new MyTv();
		
		t.channel = 100;
		t.volume = 0;
		System.out.println("CH:"+t.channel+", VOL:"+t.volume);
		
		t.channelDown();
		t.volumeDown();
		System.out.println("CH:"+t.channel+", VOL:"+t.volume);

		t.volume = 100;
		t.channelUp();
		t.volumeUp();
		System.out.println("CH:"+t.channel+", VOL:"+t.volume);

		t.channelUp();
		System.out.println("CH:"+t.channel+", VOL:"+t.volume);
		
		
	}
}