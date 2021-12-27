package thirdedition;

public class VarEx3 {

	public static void main(String[] args) {

		final int score = 100;
		//score = 200;
		boolean power = true;
		System.out.println(power);
		
		byte b = 127;
		
		int oct = 010;	// 8진수
		int hex = 0x10;	// 16진수
		System.out.println(score);
		
		System.out.println(oct);
		System.out.println(hex);
		
		
		long l = 10_000_000_000L;
		System.out.println(l);
		System.out.println(10.);
		System.out.println(.10);
		System.out.println(10f);
		System.out.println(1e3);
		System.out.println(3e-2);
		
		System.out.println(""+7+7);
		System.out.println(7+7+"");
	}

}
