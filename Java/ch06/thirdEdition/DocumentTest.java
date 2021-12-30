package thirdEdition;

class Document {
	// 속성
	static int count;
	String name;
	
	Document() {
		this("제목없음"+ ++count);	// 객체지향적 코드
	}
	
	Document(String name) {
		this.name = name;
	}
	
}



public class DocumentTest {
	public static void main(String[] args) {
		Document d1 = new Document();
		Document d2 = new Document();
		Document d3 = new Document("한글.docs");
		Document d4 = new Document();
		
		System.out.println(d1.name);
		System.out.println(d2.name);
		System.out.println(d3.name);
		System.out.println(d4.name);
	}

}
