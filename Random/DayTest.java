package jStrokus_csc201_Final;

import java.util.ArrayList;

public class DayTest extends Day{

	public static void main(String[] args) {

		ArrayList<Integer> days = new ArrayList<>();
	
		Day day = new Day();
		Day Halloween = new Day();
		
		Halloween.advance(321);
		
		days.add(day.daysBetween(Halloween));
		
		
		
		System.out.println("Halloween is on "+Halloween.toStringF());
		//What day is Halloween on next year?
		//How many days until Halloween?
		System.out.println("Number of days until Halloween: " +days);
		
		System.out.println("Today is "+day.toString());
		day.advance(200);
		System.out.println("Date 200 days from today: "+day);
	}

}
