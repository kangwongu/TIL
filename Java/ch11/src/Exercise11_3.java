//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Iterator;
//
//class Student implements Comparable {
//	// 속성
//	String name;
//	int ban;
//	int no;
//	int kor, eng, math;
//	
//	// 생성자
//	Student(String name, int ban, int no, int kor, int eng, int math) {
//		this.name = name;
//		this.ban = ban;
//		this.no = no;
//		this.kor = kor;
//		this.eng = eng;
//		this.math = math;
//	}
//	
//	int getTotal() {
//		return kor + eng + math;
//	}
//	
//	float getAverage() {
//		return (int)((getTotal()/3f)*10+0.5)/10f;
//	}
//	
//	public String toString() {
//		return name+","+ban+","+no+","+kor+","+eng+","+math+","+getTotal()+","+getAverage();
//	}
//
//	@Override
//	public int compareTo(Object o) {
//		// instanceof로 타입체크 후 형변환해서 비교
//		// Student형으로 형변환 후, 이름끼리 비교
//		if(o instanceof Student) {
//			Student s = (Student)o;
//			
//			return name.compareTo(s.name);	// String클래스의 compareTo()호출
//		}
//		return -1;
//		
//	}
//}
//
//
//public class Exercise11_3 {
//	public static void main(String[] args) {
//		// ArrayList 생성
//		ArrayList list = new ArrayList();
//		
//		// list에 요소 추가
//		list.add(new Student("홍길동",1,1,100,100,100));
//		list.add(new Student("남궁성",1,2,90,70,80));
//		list.add(new Student("김자바",1,3,80,80,90));
//		list.add(new Student("이자바",1,4,70,90,70));
//		list.add(new Student("안자바",1,5,60,100,80));
//		
//		// sort
//		Collections.sort(list);
//		
//		// 출력, Iterator활용
//		Iterator it = list.iterator();
//		
//		while(it.hasNext()) {
//			System.out.println(it.next());
//		}
//	}
//
//}
