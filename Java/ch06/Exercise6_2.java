
public class Exercise6_2 {
	public static void main(String[] args) {
		Student s = new Student("홍길동",1,1,100,60,76);
		
		String str = s.info();
		System.out.println(str);
	}
	

}

class Student {
	// 속성
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	int sum;
	double average;
	
	Student() {}
	
	// 생성자
	Student(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		
		sum = kor + eng + math;
		average = (int)(sum/3.0*10+0.5)/10.0;
	}
	
	String info() {
		return name+","+ban+","+no+","+kor+","+eng+","+math+","+sum+","+average;
	}
	
	// 총점을 더해서 반환
	int getTotal() {
		int total = kor + eng + math;
		return total;
	}
	
	// 평균을 구해서 반환
	float getAverage() {
		float average = (int)((kor+eng+math)/3f*10+0.5)/10f;
		return average;
	}
}
