package thirdEdition;

public class InsatanceofTest {
	public static void main(String[] args) {
		FireEngine fe = new FireEngine();
		
		if(fe instanceof FireEngine) {
			System.out.println("���̾��");
		}
		
		if(fe instanceof Car) {
			System.out.println("ī");
		}
		
		if(fe instanceof Object) {
			System.out.println("������Ʈ");
		}
		
		System.out.println(fe.getClass().getName());
	}

}

class Car {}
class FireEngine extends Car {}
