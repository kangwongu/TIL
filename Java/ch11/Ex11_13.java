import java.util.Set;
import java.util.TreeSet;

public class Ex11_13 {
	public static void main(String[] args) {
		Set set = new TreeSet();
		
		for(int i=0; set.size()<6; i++) {
			int num = (int)(Math.random()*6)+1;
			set.add(num);
		}
		
		// TreeSet�̱� ������ �ڵ����� ���ĵǾ� ���
		System.out.println(set);
	}
}
