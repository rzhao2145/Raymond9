package algorithms;

public class Hanoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		hanoi(3 , "a", "b", "c");
		
	}
	public static void hanoi(int n, String start, String helper, String end) {
		if(n == 1) {
			System.out.println(start + " to " + end);
		} else {
			hanoi(n-1, start, end , helper);
			System.out.println(start + " to " + end);
			hanoi(n - 1, helper, start , end);			
		}
	}
}
