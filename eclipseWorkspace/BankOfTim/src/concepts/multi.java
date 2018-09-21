package concepts;

public class multi {

	class first implements Runnable{
		public first() {
			Thread t = new Thread(this);
			t.start();
		}
		public void run() {
			for(int i = 0; i < 100; i++) {
				System.out.println("Value of i is : " + i);
			}
		}
	}

	class second implements Runnable{
		public second() {
			Thread t = new Thread(this);
			t.start();
		}
		public void run() {
			for(int j = 0; j < 100; j++) {
				System.out.println("Value of j is :   " + j);
			}
		}
	}
	
	public void fun() {
		first f = new first();
		
		second s = new second();

		
	}
	
	public static void main(String args[]) {
		multi m = new multi();
		m.fun();
	}
}
