import java.io.File;
import java.io.IOException;

public class Ex15_15 {
	public static void main(String[] args) throws IOException {
		File f = new File("C:\\BIBLE JAVA2\\CH15\\src\\Ex15_15.java");
		String fileName = f.getName();
		int pos = fileName.lastIndexOf('.');
		
		System.out.println(f.getName());				// 파일 이름
		System.out.println(fileName.substring(0,pos));	// 확장자 뺀 파일이름
		System.out.println(fileName.substring(pos+1));	// 확장자
		
		System.out.println(f.getPath());				// 경로
		System.out.println(f.getAbsolutePath());		// 절대경로
		System.out.println(f.getCanonicalPath());		// 정규경로
		System.out.println(f.getParent());				// 파일이 속해있는 디렉토리
		System.out.println(File.pathSeparator);			// 경로구분자
		System.out.println(File.pathSeparatorChar);		// 경로구분자
		System.out.println(File.separator);				// 이름구분자
		System.out.println(File.separatorChar);			// 이름구분자`
		System.out.println(System.getProperty("user.dir"));
		
		
	}
}
