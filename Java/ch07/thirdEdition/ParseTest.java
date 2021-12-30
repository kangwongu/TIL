package thirdEdition;

// 인터페이스
interface Parseable {
	void parse(String fileName);
}

// 인터페이스 구현할 클래스
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
	// 리턴타입이 인터페이스 -> 인터페이스를 구현한 클래스를 반환
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
		parser.parse("제목없음.txt");
		parser = ParserManager.getParser("HTML");
		parser.parse("제목없음2.txt");
	}

}
