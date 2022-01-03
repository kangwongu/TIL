package thirdedition;

public class EqualsTest2 {
	public static void main(String[] args) {
		Person p1 = new Person(8097934750L);
		Person p2 = new Person(8097934750L);
	
		if(p1==p2) 
			System.out.println("같다");
		else
			System.out.println("다르다");
	
		if(p1.equals(p2))
			System.out.println("같다");
		else
			System.out.println("다르다");
	}

}

class Person {
	long id;
	
	// 오버라이딩
	public boolean equals(Object obj) {
		// instanceof로 형변환 가능한지 체크 후, 형변환 후 비교
		if(obj!=null && obj instanceof Person) {
			return id == ((Person)obj).id;
		} else {
			return false;
		}
	}
	
	Person(long id) {
		this.id = id;
	}
}
