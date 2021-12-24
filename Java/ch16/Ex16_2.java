import java.net.URL;

public class Ex16_2 {
	public static void main(String[] args) throws Exception {
		// URL°´Ã¼ »ý¼º
		URL url = new URL("https://tree-19.tistory.com/");
		
		System.out.println(url.getAuthority());
		System.out.println(url.getContent());
		System.out.println(url.getDefaultPort());
		System.out.println(url.getPort());
		System.out.println(url.getFile());
		System.out.println(url.getHost());
		System.out.println(url.getProtocol());
		System.out.println(url.getQuery());
		System.out.println(url.getRef());
		System.out.println(url.getUserInfo());
		System.out.println(url.toExternalForm());
		System.out.println(url.toURI());
	}

}
