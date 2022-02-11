import java.util.ArrayList;
import java.util.List;

public class TravelCustomerTest {

	public static void main(String[] args) {
		
		TravelCustomer customerPark = new TravelCustomer("������", 40, 100);
		TravelCustomer customerSon = new TravelCustomer("�����", 29, 100);
		TravelCustomer customerHwang = new TravelCustomer("Ȳ����", 24, 100);
		TravelCustomer customerCha = new TravelCustomer("������", 15, 50);
		
		List<TravelCustomer> customerList = new ArrayList<>();
		
		customerList.add(customerPark);
		customerList.add(customerSon);
		customerList.add(customerHwang);
		customerList.add(customerCha);
		
		// ��Ʈ��
		System.out.println("�� ��� ���");
		customerList.stream().forEach(s -> System.out.println(s));
		customerList.stream().map(c->c.getName()).forEach(s->System.out.println(s));
		System.out.println();
		
		System.out.println("���� ���");
		System.out.println(customerList.stream().mapToInt(c->c.getPrice()).sum());
		System.out.println();
		
		System.out.println("20�� �̻� ��");
		customerList.stream().filter(c->c.getAge() >= 20).map(c->c.getName()).forEach(s->System.out.println(s));
		
		
	}

}
