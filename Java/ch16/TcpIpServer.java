import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TcpIpServer {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		
		try {
			// �������� ����, 7777�� ��Ʈ�� ����(���ε�)
			serverSocket = new ServerSocket(7777);
			System.out.println(getTime()+"������ �غ�Ǿ����ϴ�.");
		} catch (IOException e) {e.printStackTrace();}
		
		while(true) {
			try {
				System.out.println(getTime()+"�����û�� ��ٸ��ϴ�.");
				// ���������� Ŭ���̾�Ʈ�� �����û�� �� �� ���� ������ ���߰� ��ٸ�
				// Ŭ���̾�Ʈ�� ��û�� ���� Ŭ���̾�Ʈ ���ϰ� ����� ���ο� ������ ����
				Socket socket = serverSocket.accept();
				System.out.println(getTime()+socket.getInetAddress()+"�κ��� �����û");
				
				// ������ ��½�Ʈ���� ����
				OutputStream out = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(out);
				
				// �����͸� ����
				dos.writeUTF("[Notice] Test Message1 from Server.");
				System.out.println(getTime()+"�����͸� �����߽��ϴ�");
				
				
				dos.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	static String getTime() {
		SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
		return f.format(new Date());
	}
}
