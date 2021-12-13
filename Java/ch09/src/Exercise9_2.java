
class Point3D { 
	// 속성
	int x, y, z;
	
	// 생성자
	Point3D(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	Point3D() {
		this(0,0,0);
	}
	
	// 기능
	@Override
	public boolean equals(Object obj) {
		// instanceof로 타입체크 후, 형변환하고 비교
		if(obj instanceof Point3D) {
			// 형변환
			Point3D p = (Point3D)obj;
			return (x==p.x) && (y==p.y) && (z==p.z);
		}
		return false;
	}

	@Override
	public String toString() {
		return "["+x+","+y+","+z+"]";
	}
}


public class Exercise9_2 {
	public static void main(String[] args) {
		Point3D p1 = new Point3D(1,2,3);
		Point3D p2 = new Point3D(1,2,3);
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p1==p2);
		System.out.println(p1.equals(p2));
	}
}
