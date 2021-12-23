import java.io.File;

public class Ex15_18 {
	public static void main(String[] args) {
		File dir = new File(args[0]);
		
		if(!dir.exists() || !dir.isDirectory()) {
			System.out.println("��ȣ���� ���� ���丮");
			System.exit(0);
		}
		
		File[] list = dir.listFiles();
		
		for(int i=0; i<list.length; i++) {
			String fileName = list[i].getName();
			String newFileName = "0000" + fileName;
			newFileName = newFileName.substring(newFileName.length() - 7);
			list[i].renameTo(new File(dir, newFileName));
		}
	}

}
