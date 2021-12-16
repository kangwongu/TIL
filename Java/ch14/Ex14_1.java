
@FunctionalInterface
interface MyLambda {
	void call();
}

public class Ex14_1 {
	public static void main(String[] args) {
		// 그냥 호출
		MyLambda ml = () -> System.out.println("call()");
		ml.call();
		
		// 매개변수가 MyLambda
		callLambda(ml);
		callLambda2(ml);
		
		MyLambda ml2 = null;
		callLambda2(ml2);
		
		// 반환형이 MyLambda
		MyLambda ml3 = returnLambda();
		ml3.call();
		
		
		
	}
	
	// 매개변수가 함수형인터페이스, 람다식이 정의된 함수가 들어와야 정상실행
	static void callLambda(MyLambda ml) {
		ml.call();
	}
	
	// 람다식을 새로 정의
	static void callLambda2(MyLambda ml) {
		ml = () -> System.out.println("call2()");
		ml.call();
	}
	
	// 반환형이 함수형인터페이스
	static MyLambda returnLambda() {
		MyLambda ml3 = () -> System.out.println("call3()");
		return ml3;
	}
	
}
