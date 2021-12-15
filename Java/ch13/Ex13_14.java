import java.util.ArrayList;

class Table {
	// 속성
	String[] dishNames = {"donut", "pizza", "chicken"};
	final int MAX_FOOD = 6;
	private ArrayList<String> dishes = new ArrayList<>();
	
	
	// 기능
	public synchronized void add(String dish) {
		// 유효성 검사
		if(dishes.size()>=MAX_FOOD)
			return;
		dishes.add(dish);
		System.out.println("Dishes:"+dishes.toString());
	}
	
	public boolean remove(String dishName) {
		synchronized(this) {			
			while(dishes.size()==0) {
				String name = Thread.currentThread().getName();
				System.out.println(name+" is waiting");
				try { Thread.sleep(500); } catch(InterruptedException e) {}
			}
			
			for(int i=0; i<dishes.size(); i++) {
				if(dishName.equals(dishes.get(i))) {
					dishes.remove(i);
					return true;
				}
			}
		}
		return false;
	}
	
	public int dishNum() { return dishNames.length; }
}

class Customer implements Runnable {
	private Table table;
	private String food;
	
	Customer(Table table, String food) {
		this.table = table;
		this.food = food;
	}
	
	boolean eatFood() {
		return table.remove(food);
	}
	
	@Override
	public void run() {
		while(true) {
			try { Thread.sleep(1000);} catch (InterruptedException e)  {e.printStackTrace(); }
			String name = Thread.currentThread().getName();
			
			if(eatFood()) 
				System.out.println(name + " ate a " + food);
			else
				System.out.println(name + " failed to eat. :(");
		} 
	}
	
	

}

class Cook implements Runnable {
	private Table table;
	
	Cook(Table table) { this.table = table; }
	
	@Override
	public void run() {
		while(true) {
			int idx = (int)(Math.random()*table.dishNum());
			table.add(table.dishNames[idx]);
			try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
		}
	}
	
}

public class Ex13_14 {	
	public static void main(String[] args) throws InterruptedException {
		Table table = new Table();
		
		new Thread(new Cook(table), "COOK").start();
		new Thread(new Customer(table, "donut"), "CUST1").start();
		new Thread(new Customer(table, "pizza"), "CUST2").start();
		new Thread(new Customer(table, "chicken"), "CUST3").start();
	}
}

