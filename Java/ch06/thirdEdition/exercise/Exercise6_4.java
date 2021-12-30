package thirdEdition.exercise;

public class Exercise6_4 {
	public static void main(String[] args) {
		Student s = new Student();
		s.name = "홍길동";
		s.ban=1;
		s.no=1;
		s.kor=100;
		s.eng=60;
		s.math=76;
		
		System.out.println(s.name);
		System.out.println(s.getTotal());
		System.out.println(s.getAverage());
	}
}

//class Student {
//	// 속성
//	String name;
//	int ban;
//	int no;
//	int kor;
//	int eng;
//	int math;
//	
//	// 기능
//	// 총합을 구하는 메소드
//	int getTotal() {
//		return kor+eng+math;
//	}
//	
//	
//	// 평균을 구하는 메소드
//	float getAverage() {
//		float average = (kor+eng+math)/3f;
//		return Math.round(average*10)/10f;
//	}
//
//}