import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class Ex16_5 {
	public static void main(String[] args) {
		URL url = null;
		InputStream in = null;
		FileOutputStream out = null;
		String address = "https://tree-19.tistory.com";
		
		int ch=0;
		
		try {
			url = new URL(address);
			in = url.openStream();
			out = new FileOutputStream("tistory.txt");
			
			while((ch=in.read())!=-1) {
				out.write(ch);
			}
			
			in.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
