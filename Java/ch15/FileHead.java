import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileHead {

	public static void main(String[] args) {

		try {
			int lineNum = Integer.parseInt(args[0]);
			String fileName = args[1];
			
			File f = new File(fileName);
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			
			String line = "";
			for(int i=1; (line=br.readLine())!=null && i<=lineNum; i++) {
				System.out.println(line);
			}
			 
		} catch(Exception e) {}
	}

}
