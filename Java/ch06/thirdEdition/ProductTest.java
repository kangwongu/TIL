package thirdEdition;


class Product {
	// 속성
	static int count = 0;
	int serialNum;
	
	{
		count++;
		serialNum = count;
	}
	
	// 생성자
	Product() {}
}


public class ProductTest {
	public static void main(String[] args) {
		// 인스턴스 생성
		Product p1 = new Product();
		Product p2 = new Product();
		Product p3 = new Product();
		// serialNum 출력
	
		System.out.println(p1.serialNum);
		System.out.println(p2.serialNum);
		System.out.println(p3.serialNum);
		System.out.println(Product.count);
	}
}
