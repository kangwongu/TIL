
public class Exercise6_2 {
	public static void main(String[] args) {
		Student s = new Student("ȫ�浿",1,1,100,60,76);
		
		String str = s.info();
		System.out.println(str);
	}
	

}

class Student {
	// �Ӽ�
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	int sum;
	double average;
	
	Student() {}
	
	// ������
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
	
	// ������ ���ؼ� ��ȯ
	int getTotal() {
		int total = kor + eng + math;
		return total;
	}
	
	// ����� ���ؼ� ��ȯ
	float getAverage() {
		float average = (int)((kor+eng+math)/3f*10+0.5)/10f;
		return average;
	}
}
