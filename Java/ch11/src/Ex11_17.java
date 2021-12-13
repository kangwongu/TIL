import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Ex11_17 {
	public static void main(String[] args) {
		// HashMap에 학생 이름과, 성적 저장, Iterator이용해 이름 : 성적 출력
		// HashMap 생성
		HashMap hm = new HashMap();
		
		// HashMap에 이름, 성적 저장
		hm.put("강원구", 100);
		hm.put("손흥민", 88);
		hm.put("박지성", 85);
		hm.put("메시", 100);
		hm.put("뮐러", 95);
		hm.put("오바메양", 80);
		
		// Iterator를 이용하기 위해서 Map -> Set
		Set set = hm.entrySet();
		Iterator it = set.iterator();
		
		while(it.hasNext()) {
			// Set형태를 Map의 Entry형태로 쪼개서 키, 값을 추출
			Map.Entry me = (Entry)it.next();
			System.out.println("이름 : "+me.getKey()+", 성적 : "+me.getValue());
			
		}
		
		// 키만 뽑아서 이름 출력
		set = hm.keySet();
		System.out.println("이름 : "+set);
		
		// 값만 뽑아서 총점, 평균, 최고점수, 최저점수 출력
		// 값 추출
		Collection values = hm.values();
		
		// iterator 활용
		it = values.iterator();
		int total = 0;	// 총합
		double average = 0.0;
		while(it.hasNext()) {
			total += (int)it.next();
		}
		
		average = (double)total/set.size();
		
		System.out.println("총합:"+total);
		System.out.println("평균:"+Math.round(average*10)/10.0);
		System.out.println("최고점수:"+Collections.max(values));
		System.out.println("최저점수:"+Collections.min(values));
	}
}
