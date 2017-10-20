package arrays;

public class Person {
	
	public static final String[] FIRST_START = {"Ra", "Chr", "Am", "L", "D", "Th", "Br", "B"};
	public static final String[] FIRST_MIDDLE = {"ala", "ima", "e", "o", "anna", "ola"};
	public static final String[] FIRST_END = {"na", "ck", "n","tt", "rian", "lius", "lion", "les", "nd"};
	
	public static final String[] LAST_START = {"Bl", "Gr", "Ph", "M", "Thr", "Sh", "Br"};
	public static final String[] LAST_MIDDLE = {"an", "in", "ast", "own", "il"};
	public static final String[] LAST_END = {"strom", "son", "rack","les", "vin", "ston"};
	
	private String firstName;
	private String lastName;
	private Borough home;
	private Hobby hobby;
	private Person[] friends;
	private String nickname;
	
	/*
	 * PASS BY VALUE
	 * the parameters of a method contain only values, not references
	 * therefore, when they are changed, the REFERENCE to the original
	 * object does not change
	 */
	
	
	public Person(String first, String last, Borough home) {
		this.firstName = first;
		this.lastName = last;
		this.home = home;
		friends = new Person[3];
		hobby = Hobby.randomHobby();
		nickname = createNickname(firstName);
	}
	
	
	
	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public static String createNickname(String name) {
		String nickname = "";
		int vowelCount = 0;
		int idx = 0;
		for(int i = 0; i < name.length(); i++) {
			String letter = name.substring(i,i+1);
			if(isVowel(letter)) {
				vowelCount++;
				if(vowelCount != 2) {
					nickname += letter;
				}else {
					return nickname;
				}
			}else {
				nickname += letter;
			}
		}
		return nickname;
	}
	
	public static boolean isVowel(String letter) {
		letter = letter.toLowerCase();
		if(letter.equals("a") || letter.equals("e") || letter.equals("i") || letter.equals("o") || letter.equals("u")) {
			return true;
		}
		return false;
	}
	
	public void stateYourFriends() {
		String friendString = "My friends are ";
		for(int i = 0; i < friends.length; i++) {
			friendString += friends[i].firstName + ", ";
		}
		friendString += " and " + friends[friends.length-1];
		System.out.println(friendString);
	}
	
	public void mingle(Person[] peers) {
		for(Person p: peers) {
			//you cannot friend yourself
			if(p != this) {
				setInFirstPlace(p);
			}
		}
	}
	
	public void setInFirstPlace(Person f ) {
		//go backwards through an array
		for(int i = friends.length - 1; i > 0; i--) {
			//move the friend from in front, back
			friends[i] = friends[i - 1];
		}
		friends[0] = f;
	}
	
	public String toString() {
		return "My name is "+firstName+ " " + lastName + ". Call me " + nickname+ " and I am from " + home + ".";
	}

}
