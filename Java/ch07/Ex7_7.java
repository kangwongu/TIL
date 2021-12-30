// Car클래스
class Car {
	// 속성
	String color;
	int door;
	
	// 기능
	void drive() {
		System.out.println("부우우웅");
	}
	
	void stop() {
		System.out.println("끼익");
	}
}

// Car클래스 상속받는 FireEngine클래스
class FireEngine extends Car {
	void water() {
		System.out.println("슈슈슛");
	}
}


public class Ex7_7 {
	public static void main(String[] args) {
		// Car형 참조변수
		Car car = null;
		// FireEngine인스턴스
		FireEngine fe = new FireEngine();
		car = fe;	// 형변환, 자손->조상
		//car.water() // 조상은 자손의 멤버를 사용할 수 없음	
		
		doWork(car);
		//doWork(fe);
	}
	
	public static void doWork(Car c) {
		if(c instanceof Car) {
			FireEngine fe = (FireEngine)c;
			fe.water();
		}
	}
	
	
}
