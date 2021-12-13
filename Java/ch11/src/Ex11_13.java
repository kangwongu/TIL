import java.util.Set;
import java.util.TreeSet;

public class Ex11_13 {
	public static void main(String[] args) {
		Set set = new TreeSet();
		
		for(int i=0; set.size()<6; i++) {
			int num = (int)(Math.random()*6)+1;
			set.add(num);
		}
		
		// TreeSet이기 때문에 자동으로 정렬되어 출력
		System.out.println(set);
	}
}
