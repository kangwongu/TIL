package thirdedition.exercise;

public class Exercise9_3 {
	public static void main(String[] args) {
		String fullPath = "c:\\jdk1.8\\work\\PathSeparateTest.java";
		String path = "";
		String fileName = "";
		
		// ������ ������ ã�Ƽ� ������
		int idx = fullPath.lastIndexOf("\\");
		path = fullPath.substring(0, idx+1);
		fileName = fullPath.substring(idx+1);
		
		System.out.println(fullPath);
		System.out.println(path);
		System.out.println(fileName);
	}
}