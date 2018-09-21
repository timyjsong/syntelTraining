package bl;

public class Calculator {
	public int add(int a, int b) {
		return a+b;
	}
	public int sub(int a, int b) {
		return a-b;
	}
	public static void main(String args[]) {
		Calculator cal = new Calculator();
		int ret = cal.add(10, 20);
		
		if(ret == 30) {
			
		}
	}
}
