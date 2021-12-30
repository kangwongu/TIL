
public class Ex6_15 {
	// 클래스 초기화 블럭
	static {
		System.out.println("static { }");
	}
	// 인스턴스 초기화 블럭
	{
		System.out.println("{ }");
	}
	// 생성자
	public Ex6_15() {
		System.out.println("생성자");
	}
	
	
	public static void main(String[] args) {
		System.out.println("Ex6_14 bt = new Ex6_14()");
		Ex6_15 bt = new Ex6_15();
		
		System.out.println("Ex6_14 bt2 = new Ex6_14()");
		Ex6_15 bt2 = new Ex6_15();
		
	}
}

