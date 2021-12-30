package thirdEdition;

public class InsatanceofTest {
	public static void main(String[] args) {
		FireEngine fe = new FireEngine();
		
		if(fe instanceof FireEngine) {
			System.out.println("파이어엔진");
		}
		
		if(fe instanceof Car) {
			System.out.println("카");
		}
		
		if(fe instanceof Object) {
			System.out.println("오브젝트");
		}
		
		System.out.println(fe.getClass().getName());
	}

}

class Car {}
class FireEngine extends Car {}
