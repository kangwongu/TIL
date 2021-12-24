import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpIpClient {
	public static void main(String[] args) {
		try {
			String serverIp = "127.0.0.1";
			System.out.println("������ �������Դϴ�. ����IP :"+ serverIp);
			// ������ ������ ���� ��û
			Socket socket = new Socket(serverIp, 7777);
			
			// ������ �Է½�Ʈ���� ����
			InputStream in = socket.getInputStream();
			DataInputStream dis = new DataInputStream(in);
			
			// �������κ��� ���� ������ ���
			System.out.println("�����κ��� ���� �޽��� :"+dis.readUTF());
			System.out.println("���� ����");
			
			socket.close();
			dis.close();
			System.out.println("���� ����");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
