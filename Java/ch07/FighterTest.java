abstract class Unit2 {
	int x, y;
	abstract void move(int x, int y);
	void stop() { System.out.println("∏ÿ√‰¥œ¥Ÿ."); }
}

interface Fightable {
	void move(int x, int y);
	void attack(Fightable f);
}

class Fighter extends Unit2 implements Fightable {
	@Override
	public void attack(Fightable f) {
		System.out.println(f+"∏¶ ∞¯∞›");
	}
	
	@Override
	public void move(int x, int y) {
		System.out.println("["+x+","+y+"]∑Œ ¿Ãµø");
	}
	
	Fightable getFightable() {
		Fighter f = new Fighter();
		return f;
	}
	
}


public class FighterTest {
	public static void main(String[] args) {
//		Fighter f = new Fighter();
		Fightable f = new Fighter();
//		Unit2 f = new Fighter();
		f.move(100, 200);
		f.attack(new Fighter());
	}

}
