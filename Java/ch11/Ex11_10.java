import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Ex11_10 {
	public static void main(String[] args) {
		// HashSet 생성
		Set set = new HashSet();
		
		// HashSet에 랜덤값 추가
		for(int i=0; i<6; i++) {
			int num = (int)(Math.random()*45)+1;
			set.add(num);
		}
		System.out.println(set);
		
		// sort하기위해 HashSet -> LinkedList
		// Set은 sort가 안됨
		List list = new LinkedList(set);
		Collections.sort(list);
		System.out.println(list);
	}
}