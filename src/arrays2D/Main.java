package arrays2D;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Array2DSampler test = new Array2DSampler();
	}

	//PRECONDITION: i >= 0 and i < arr.length
	//increases the element at i by 1
	//decreases the elements at i - 1 and i +1 , if they exist
	//avoids ArrayIndexOutOfBoundsException
	//heavily tested concept on every exam : checking for ArrayIndexOutofBoundsException
	private static void changeNeighbors(int[] arr, int i) {
		arr[i] = arr[i] + 1;
		try {
			arr[i-1] = arr[i-1] - 1;
		} catch(ArrayIndexOutOfBoundsException e){
			
		}
		try {
			arr[i+1] = arr[i+1] - 1;
		} catch(ArrayIndexOutOfBoundsException e){
			
		}
		
	}

}
