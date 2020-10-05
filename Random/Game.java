package jStrokus_csc201_Final;

public class Game extends Die  {

	//fields
	protected Die d1, d2;
	private int total;
	private final int startingPoints = 30;
	
	//getters setters
	public Die getD1() {
		return d1;
	}

	public void setD1(Die d1) {
		this.d1 = d1;
	}

	public Die getD2() {
		return d2;
	}

	public void setD2(Die d2) {
		this.d2 = d2;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
}
