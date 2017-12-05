package algorithms;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int  x = fibonacci(7);
		System.out.println(x);
	}
	public static int fibonacci(int n ) {
		if(n <= 1) {
			return 1;
		}
		return fibonacci(n - 1) + fibonacci(n-2);
	}
}
