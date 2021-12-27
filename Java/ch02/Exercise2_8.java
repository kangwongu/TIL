
public class Exercise2_8 {

	public static void main(String[] args) {
		int x = 1;
		int y = 2;
		int z = 3;
		int tmp;
		
		// x 1 -> 2
		// y 2 -> 3
		// z 3 -> 1
		tmp = x;
		x = y;
		y = z;
		z = tmp;
		
		
		System.out.println("x=" + x);
		System.out.println("y=" + y);
		System.out.println("z=" + z);
	}

}
