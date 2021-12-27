package thirdedition;

public class VarEx2 {

	public static void main(String[] args) {
		int x = 6;
		int y = 3;
		int tmp;
		
		tmp = x;
		x = y;
		y = tmp;
		System.out.println("x = " + x);
		System.out.println("y = " + y);
		
	}

}
