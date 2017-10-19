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
	
	public Person(String first, String last, Borough home) {
		this.firstName = first;
		this.lastName = last;
		this.home = home;
		friends = new Person[3];
		hobby = Hobby.randomHobby();
	}
	
	public void stateYourFriends() {
		String friendString = "My friends are ";
		for(int i = 0; i < friends.length-1; i++) {
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
		return "My name is "+firstName+ " " + lastName + " and I am from " + home + ".";
	}

}
