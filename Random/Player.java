package jStrokus_csc201_Final;

public class Player {

	//fields
	private int playerScore;
	private String playerName;
	
	//constructors
	public Player() {
		
	}
	public Player(int score, String name) {
		this.playerName = name;
		this.playerScore = score;
	}
	
	//getters setters
	public int getPlayerScore() {
		return playerScore;
	}

	public void setPlayerScore(int playerScore) {
		this.playerScore = playerScore;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	
}
