import java.util.Set;
import java.util.TreeSet;

public class Ex11_15 {
	public static void main(String[] args) {
		TreeSet set = new TreeSet();
		int[] score = {80,95,50,35,45,65,10,100};
		
		for(int i=0; i<score.length; i++) 
			set.add(new Integer(score[i]));
		
		
		System.out.println("50보다 작은 값 : " + set.headSet(new Integer(50)));
		System.out.println("50보다 큰 값 : " + set.tailSet(new Integer(50)));
		
	}
}

// 참조 타입을 넣으려면 정렬 기준이 정의되어 있어야 함
// Compareable이 구현되어 있으면 ok 
// 정의 안되어있으면 Comparator를 구현해 정렬 기준을 만들어야 함