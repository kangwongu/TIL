import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex15_12 {
	public static void main(String[] args) {
		String line = "";
		
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			
			System.out.println("������� os ���ڵ�:"+isr.getEncoding());
			
			do {
				System.out.print("������ �Է��ϼ��� (q:����)");
				line = br.readLine();
				System.out.println("�Է��� ����:"+line);
			} while(!line.equalsIgnoreCase("q"));
			
			// System.in�� ���� ǥ��������� ���� �ʾƵ� ��
//			br.close();
			System.out.println("���α׷� ����");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
