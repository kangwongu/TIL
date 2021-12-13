
public class Ex9_1 {
	public static void main(String[] args) {
		Value v1 = new Value(10);
		Value v2 = new Value(10);
		
		if(v1.equals(v2)) {
			System.out.println("v1과 v2는 같아요");
		} else {
			System.out.println("v1과 v2는 달라요");
		}
	}

}

class Value {
	int value;
	
	Value(int value) {
		this.value = value;
	}

	// ==는 주소 비교, equals()메소드 오버라이딩으로 객체 내용을 비교하게 함
	@Override
	public boolean equals(Object obj) {
		// instanceof연산자로 타입 체크후 비교
		if(obj instanceof Value) {
			Value v = (Value)obj;
			// 같은지 비교
			if(value==v.value)
				return true;
		}
		
		return false;
	}
	
	
	
		
	
}
