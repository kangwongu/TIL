import java.util.ArrayList;
import java.util.Iterator;


class Student {
	// 속성
	String name;
	int ban;
	int no;
	
	// 생성자
	Student(String name, int ban, int no) {
		this.name = name;
		this.ban = ban;
		this.no = no;
	}
}

// Iterator에 지네릭스 적용

public class Ex12_2 {
	public static void main(String[] args) {
		// Student가 대입된 ArrayList 생성
		ArrayList<Student> list = new ArrayList<>();
		
		// 요소 추가
		list.add(new Student("박지성",1,1));
		list.add(new Student("박주영",1,2));
		list.add(new Student("손흥민",2,1));
		
		// Student형의 Iterator사용
		Iterator<Student> it = list.iterator();
		// 이름 출력
		while(it.hasNext()) {
//			Student s = (Student)it.next();	// 지네릭스 사용하지 않을 시
			Student s = it.next();
			System.out.println(s.name);
		}
		
	}
}