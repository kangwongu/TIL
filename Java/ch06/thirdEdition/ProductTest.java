package thirdEdition;


class Product {
	// �Ӽ�
	static int count = 0;
	int serialNum;
	
	{
		count++;
		serialNum = count;
	}
	
	// ������
	Product() {}
}


public class ProductTest {
	public static void main(String[] args) {
		// �ν��Ͻ� ����
		Product p1 = new Product();
		Product p2 = new Product();
		Product p3 = new Product();
		// serialNum ���
	
		System.out.println(p1.serialNum);
		System.out.println(p2.serialNum);
		System.out.println(p3.serialNum);
		System.out.println(Product.count);
	}
}
