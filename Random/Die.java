package jStrokus_csc201_Final;

public class Die {
	//fields
	private final int MAX = 6;
	private int faceValue;
	
	
	//constructors
	public Die() {
		faceValue = 1;
	}
	
	public Die(int faceValue) {
		this.faceValue = faceValue;
	}
	
	//create random integer 1-6
	public void roll() {
		faceValue = (int)(Math.random() * MAX) +1;

	}
	//toString
	public String toString() {
		
		return "You rolled a " + faceValue;
	}
	//getter setters
	public int getFaceValue() {
		return faceValue;
	}

	public void setFaceValue(int faceValue) {
		this.faceValue = faceValue;
	}

	
}
