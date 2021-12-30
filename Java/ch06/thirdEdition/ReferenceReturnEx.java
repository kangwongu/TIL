package thirdEdition;


class Entity { int num; }

public class ReferenceReturnEx {
	public static void main(String[] args) {
		// 인스턴스 생성
		Entity e = new Entity();
		e.num = 100;
		
		// 반환타입이 Entity형이기 때문에 Entity객체를 새로 만들어서 받음
		Entity newEntity = change(e);
		System.out.println(e.num);
		System.out.println(newEntity.num);
		
	}
	
	// 반환타입이 참조형
	// 매개변수로 반환형을 받아 을 변경시키는 메소드
	static Entity change(Entity e) {
		// 반환타입을 매개변수로 받음
		// 새로운 반환타입 생성해 매개변수의 속성값 대입
		Entity newE = new Entity();
		newE.num = e.num;
		
		return newE;
	}

}
