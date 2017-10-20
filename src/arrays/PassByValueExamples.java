package arrays;

import java.util.Arrays;

public class PassByValueExamples {

	public static void main(String[] args) {
		String s = "Hello";
		Person p = new Person("Random", "Dude", Borough.NY_BOROUGHS[0]);
		int x = 5;
		int[] arr = {1,2,3};
		test3(arr);
		System.out.println("p is now " + p + ", x is now " + x + ", arr is now " + Arrays.toString(arr));
	}

	private static void test1(Person p, int x, int[] arr) {
		String name = p.getFirstName();
		name = "Original";
	}
	
	private static void test2(Person p) {
		p.setFirstName("Original");
	}

	//change arrays via the local variable through its references(indices)
	//primitives cannot be changed via a local variable since they don't reference other data
	private static void test3(int[] arr) {
		arr[0] = 999;
		arr[1] = 998;
	}
	
	private static void changeEVERYTHING(String s, int x, int[] arr) {
		s = "Goodbye";
		x = -5;
		arr = new int[2];
		arr[0] = -1;
		arr[1] = -2;		
	}

}
