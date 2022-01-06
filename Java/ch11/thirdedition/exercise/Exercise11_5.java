package thirdedition.exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Exercise11_5 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(new Student("박지성",1,1,100,100,100));
		list.add(new Student("사카",1,2,90,100,80));
		list.add(new Student("손흥민",1,3,66,60,80));
		list.add(new Student("로우",2,1,90,95,88));
		list.add(new Student("화이트",2,2,100,100,100));
	
		// 정렬
		Collections.sort(list);
		Iterator it = list.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
	}
}

class Student implements Comparable {
	String name;
	int ban;
	int no;
	int kor, eng, math;
	
	Student(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	int getTotal() {
		return kor+eng+math;
	}
	
	float getAverage() {
		return (int)((getTotal()/3f)*10+0.5)/10f;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", ban=" + ban + ", no=" + no + ", kor=" + kor + ", eng=" + eng + ", math="
				+ math + "]";
	}

	@Override
	public int compareTo(Object o) {
		// 1. Student객체로 변환
		// 2. 이름을 기준으로 정렬 (String에 정의된 compareTo를 활용)
		
		// instanceof로 타입체크 
		if(o instanceof Student) {
			// 변환
			Student s = (Student)o;
			// 2.
			return name.compareTo(s.name);
		} else {
			return -1;
		}
	}
	
	
	
}
