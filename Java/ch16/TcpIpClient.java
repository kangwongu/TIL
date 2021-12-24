import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpIpClient {
	public static void main(String[] args) {
		try {
			String serverIp = "127.0.0.1";
			System.out.println("서버에 연결중입니다. 서버IP :"+ serverIp);
			// 소켓을 생성해 연결 요청
			Socket socket = new Socket(serverIp, 7777);
			
			// 소켓의 입력스트림을 얻어옮
			InputStream in = socket.getInputStream();
			DataInputStream dis = new DataInputStream(in);
			
			// 소켓으로부터 받은 데이터 출력
			System.out.println("서버로부터 받은 메시지 :"+dis.readUTF());
			System.out.println("연결 종료");
			
			socket.close();
			dis.close();
			System.out.println("연결 종료");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
