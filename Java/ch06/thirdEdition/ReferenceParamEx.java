package thirdEdition;


class Things { int x; }

public class ReferenceParamEx {
	public static void main(String[] args) {
		// 인스턴스 생성
		Things t = new Things();
		t.x = 10;
		System.out.println("t.x = "+t.x);
		change(t);	// 참조변수를 넘겨줌
		System.out.println("after - t.x = " + t.x);
		
	}
	
	// 기본형을 매개변수로 받는 메소드
	// 매개변수로 받은 값을 변경시키는 메소드
	static void change(Things t) {
		t.x = 1000;
		System.out.println("change(int x) = "+ t.x);
	}

}
