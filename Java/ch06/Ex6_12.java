
// Car 努贰胶
class Car {
	// 加己
	String color;
	String gearType;
	int door;
	
	// 积己磊
	Car() {
		this("white", "auto", 4);
	}
	
	Car(String color, String gearType, int door) {
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}
}

public class Ex6_12 {
	public static void main(String[] args) {
		Car c1 = new Car();
		Car c2 = new Car("black", "auto", 4);
	
		System.out.println(c1.color+", "+c1.gearType+", "+c1.door);
		System.out.println(c2.color+", "+c2.gearType+", "+c2.door);
	}
}

