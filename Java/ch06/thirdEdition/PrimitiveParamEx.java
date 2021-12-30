package thirdEdition;


class Data { int x; }

public class PrimitiveParamEx {
	public static void main(String[] args) {
		// Data클래스 인스턴스 생성
		Data d = new Data();
		// 인스턴스의 x값을 change 메소드에 넘겨줌
		System.out.println("d.x = " + d.x);
		change(d.x);
		System.out.println("after - d.x = " + d.x);
		
	}
	
	// 기본형을 매개변수로 받는 메소드
	// 매개변수로 받은 값을 변경시키는 메소드
	static void change(int x) {
		x = 1000;
		System.out.println("change(int x) = "+ x);
	}

}
