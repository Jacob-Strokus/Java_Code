import java.util.ArrayList;
import java.util.Collections;

public class PeopleDriverArray {

	public static void main(String[] args) {

		People[] people = new People[10];

		people[0] = new People(1, "John", "Smith");
		people[1] = new People(2, "Jake", "Carlson");
		people[2] = new People(3, "Tony", "Stark");
		people[3] = new People(4, "Bruce", "Banner");
		people[4] = new People(5, "Steve", "Rodgers");
		people[5] = new People(6, "Peter", "Parker");
		people[6] = new People(7, "Peter", "Quill");
		people[7] = new People(8, "Michael", "Jackson");
		people[8] = new People(9, "Will", "Smith");
		people[9] = new People(10, "Bill", "Gates");

		ArrayList<People> peopleAL = new ArrayList<People>();
		Collections.addAll(peopleAL, people);

		print(people);
		Collections.sort(peopleAL);
		print(peopleAL);

	}

	public static void print(People[] p) {

		for (int i = 0; i < p.length; i++) {
			System.out.println(p[i].toString());
		}
		System.out.println();

	}

	public static void print(ArrayList<People> p) {

		for (int i = 0; i < p.size(); i++) {
			System.out.println(p.get(i).toString());
		}
		System.out.println();

	}

}
