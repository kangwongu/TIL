package thirdEdition;

class Document {
	// �Ӽ�
	static int count;
	String name;
	
	Document() {
		this("�������"+ ++count);	// ��ü������ �ڵ�
	}
	
	Document(String name) {
		this.name = name;
	}
	
}



public class DocumentTest {
	public static void main(String[] args) {
		Document d1 = new Document();
		Document d2 = new Document();
		Document d3 = new Document("�ѱ�.docs");
		Document d4 = new Document();
		
		System.out.println(d1.name);
		System.out.println(d2.name);
		System.out.println(d3.name);
		System.out.println(d4.name);
	}

}
