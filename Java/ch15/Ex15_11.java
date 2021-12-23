import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex15_11 {
	public static void main(String[] args) {
		// ���۸� �̿��� ������ �о� ����
		try {
			FileReader fr = new FileReader("Ex15_11.java");
			BufferedReader br = new BufferedReader(fr);
			
			String line = "";
			for(int i=1; (line = br.readLine())!=null; i++) {
				if(line.indexOf(';')!=-1)
					System.out.println(i+":"+line);
			}
			
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
