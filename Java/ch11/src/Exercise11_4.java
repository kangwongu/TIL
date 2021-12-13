import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

class Student{
	// 속성
	String name;
	int ban;
	int no;
	int kor, eng, math;
	
	// 생성자
	Student(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	int getTotal() {
		return kor + eng + math;
	}
	
	float getAverage() {
		return (int)((getTotal()/3f)*10+0.5)/10f;
	}
	
	public String toString() {
		return name+","+ban+","+no+","+kor+","+eng+","+math+","+getTotal()+","+getAverage();
	}

}

// 정렬기준
// 반, 번호를 기준으로 오름차순 정렬
class BanNoAscending implements Comparator {
	// instanceof를 이용해  타입체크 후, 형변환하고 비교
	// Student로 형변환, ban비교
	@Override
	public int compare(Object o1, Object o2) {
		if(o1 instanceof Student && o2 instanceof Student) {
			// o1, o2가 Student면 형변환
			Student s1 = (Student)o1;
			Student s2 = (Student)o2;
			
			// 결과, 오름차순
			int result = s1.ban - s2.ban;
			// 반이 같으면 번호를 비교
			if(result==0) {
				return s1.no - s2.no;
			}
			return result;
		}
		return -1;

	}
}


public class Exercise11_4 {
	public static void main(String[] args) {
		// ArrayList 생성
		ArrayList list = new ArrayList();
		
		// list에 요소 추가
		list.add(new Student("홍길동",1,3,100,100,100));
		list.add(new Student("남궁성",1,1,90,70,80));
		list.add(new Student("김자바",1,2,80,80,90));
		list.add(new Student("이자바",2,1,70,90,70));
		list.add(new Student("안자바",2,2,60,100,80));
		
		// sort
		Collections.sort(list, new BanNoAscending());
		
		// 출력, Iterator활용
		Iterator it = list.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
