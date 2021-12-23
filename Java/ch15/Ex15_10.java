import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class Ex15_10 {
	public static void main(String[] args) {
		String inputData = "하하호호";
		StringReader sr = new StringReader(inputData);
		StringWriter sw = new StringWriter();
		
		int data = 0;
		try {
			while((data=sr.read())!=-1) {
				sw.write(data);
			}
			
			sr.close();
			sw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(inputData);
		System.out.println(sw.toString());
	}
}
