import java.util.ArrayList;
import java.util.List;

public class TravelCustomerTest {

	public static void main(String[] args) {
		
		TravelCustomer customerPark = new TravelCustomer("박지성", 40, 100);
		TravelCustomer customerSon = new TravelCustomer("손흥민", 29, 100);
		TravelCustomer customerHwang = new TravelCustomer("황희찬", 24, 100);
		TravelCustomer customerCha = new TravelCustomer("차범근", 15, 50);
		
		List<TravelCustomer> customerList = new ArrayList<>();
		
		customerList.add(customerPark);
		customerList.add(customerSon);
		customerList.add(customerHwang);
		customerList.add(customerCha);
		
		// 스트림
		System.out.println("고객 명단 출력");
		customerList.stream().forEach(s -> System.out.println(s));
		customerList.stream().map(c->c.getName()).forEach(s->System.out.println(s));
		System.out.println();
		
		System.out.println("여행 비용");
		System.out.println(customerList.stream().mapToInt(c->c.getPrice()).sum());
		System.out.println();
		
		System.out.println("20세 이상 고객");
		customerList.stream().filter(c->c.getAge() >= 20).map(c->c.getName()).forEach(s->System.out.println(s));
		
		
	}

}
