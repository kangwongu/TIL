
public class Ex3_2 {

	public static void main(String[] args) {
		int i = 5, j = 0;

		j = i++;
		System.out.println("j = " + j + ", i = " + i);
		
		i = 5;
		j = 0;
		
		j = ++i;
		System.out.println("j = " + j + ", i = " + i);
	}

}
