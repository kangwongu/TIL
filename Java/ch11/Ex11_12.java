import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Ex11_12 {
	public static void main(String[] args) {
		HashSet set = new HashSet();
		set.add("abc");
		set.add("abc");
		set.add(new Person("David",10));
		set.add(new Person("David",10));
		
		System.out.println(set);
	}
}

class Person {
	String name;
	int age;
	
	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String toString() { return name + ":" + age; }

	// equals(), hashCode() �������̵� �ؾ� HashSet�� �ߺ����� �ʰ� ���� ��
	@Override
	public int hashCode() {
		return Objects.hash(name, age);
	}

	@Override
	public boolean equals(Object obj) {
		// instanceof�� Ÿ��üũ ��, ����ȯ�ؼ� ��
		if(obj instanceof Person) {
			Person p = (Person)obj;
			return (name.equals(p.name)) && (age==p.age);
		}
		return false;
	}


	
}