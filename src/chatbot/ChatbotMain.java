package chatbot;

import java.util.Scanner;

public class ChatbotMain {
	public static final Chatbot chatbot = new Chatbot();
	private static Scanner inputSource = new Scanner(System.in);

	
	public static void main(String[] args) {
		chatbot.startChatting();
	}
	/**
	 *Note: I wrote this class without a compiler, quickly. There are probably errors. I apologize. When I get Internet access with my own computer, I will revise.
	 */
	
	//return the index of the keyword after startPsn that is isolated and has no negations or -1 otherwise
	public static int findKeyword(String searchString, String keyword, int startPsn) {
		//make lowercase
		searchString = searchString.toLowerCase();
		keyword = keyword.toLowerCase();
		
		int psn = searchString.indexOf(keyword, startPsn);
		
		while(psn >= 0) {
			if(keywordIsIsolated(psn,keyword,searchString) && noNegations(searchString, psn)) {
				return psn;
			}else {
				psn = searchString.indexOf(keyword, psn+1); // returns the index of the NEXT keyword
			}
		}
		return -1;
	}



	public static boolean keywordIsIsolated(int psn, String keyword, String s) {
		if ((s.substring(keyword.length(), keyword.length() + 1).compareTo(" ") != 0)) {
			return false;
		}
		if (psn + keyword.length() == s.length()) {
			return true;
		} else {
			if (s.substring(psn - 1, psn).compareTo(" ") == 0
					&& s.substring(psn + keyword.length(), psn + keyword.length() + 1).compareTo(" ") == 0) {
				return true;
			}
		}
		return false;

	}

	public static boolean noNegations(String s, int psn) {
		int secondSpace = psn - 1;
		int firstSpace = -1;
		String word = "";
		for (int i = 0; i < secondSpace; i++) {
			if (s.substring(i, i + 1).compareTo(" ") == 0) {
				firstSpace = i;
			}
		}
		if (firstSpace == -1) {
			return true;
		}
		word = s.substring(firstSpace + 1, secondSpace);
		if (word.equals("not")) {
			return false;
		}
		return true;
	}

	public static String getInput() {
		return inputSource.nextLine();
	}

	public static void print(String s) {
		multiLinePrint(s);
	}

	public static void multiLinePrint(String s) {
		String printString = "";
		int cutoff = 25;
		// this while loop last as long as there are words left in the original String
		while (s.length() > 0) {

			String currentCut = "";
			String nextWord = "";

			// while the current cut is still less than the line length
			// AND there are still words left to add
			while (currentCut.length() + nextWord.length() < cutoff && s.length() > 0) {

				// add the next word
				currentCut += nextWord;

				// remove the word that was added from the original String
				s = s.substring(nextWord.length());

				// identify the following word, exclude the space
				int endOfWord = s.indexOf(" ");

				// if there are no more spaces, this is the last word, so add the whole thing
				if (endOfWord == -1) {
					endOfWord = s.length() - 1;// subtract 1 because index of last letter is one les than length
				}

				// the next word should include the space
				nextWord = s.substring(0, endOfWord + 1);
			}

			printString += currentCut + "\n";

		}
		System.out.print(printString);
	}

	public static int getIntegerInput() {
		print("Please enter an integer.");
		String integerString = getInput();
		boolean isInteger = false;
		int value = 0;
		while (!isInteger) {
			try {
				value = Integer.parseInt(integerString);
				// will not continue if an error above is thrown
				isInteger = true;// exits loop if entry is valid
			} catch (NumberFormatException e) {
				print("You must enter an integer. You better try again.");
				integerString = getInput();
			}
		}
		return value;
	}

	

}
