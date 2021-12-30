package thirdEdition;

// �������̽�
interface Parseable {
	void parse(String fileName);
}

// �������̽� ������ Ŭ����
class XMLParser implements Parseable {

	@Override
	public void parse(String fileName) {
		System.out.println(fileName+"- XML parsing completed.");
	}
	
}

class HTMLParser implements Parseable {

	@Override
	public void parse(String fileName) {
		System.out.println(fileName+"- HTML parsing completed");
	}
	
}

class ParserManager {
	// ����Ÿ���� �������̽� -> �������̽��� ������ Ŭ������ ��ȯ
	public static Parseable getParser(String fileName) {
		if(fileName.equals("XML")) {
			return new XMLParser();
		} else {
			return new HTMLParser();
		}
	}
}


public class ParseTest {
	public static void main(String[] args) {
		Parseable parser = ParserManager.getParser("XML");
		parser.parse("�������.txt");
		parser = ParserManager.getParser("HTML");
		parser.parse("�������2.txt");
	}

}
