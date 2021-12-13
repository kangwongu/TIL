
public class Ex9_2 {
	public static void main(String[] args) {
		Person v1 = new Person(10434784864L);
		Person v2 = new Person(10434784864L);
		
		if(v1.equals(v2)) {
			System.out.println("v1과 v2는 같아요");
		} else {
			System.out.println("v1과 v2는 달라요");
		}
	}

}

class Person {
	long id;
	
	Person(long id) {
		this.id = id;
	}

	// equals()메소드 오버라이딩
	@Override
	public boolean equals(Object obj) {
		// instanceof로 타입체크 후, 형변환
		if(obj instanceof Person) {
			return id == ((Person)obj).id;
		} else {
			return false;
		}
	}
	
	
}
