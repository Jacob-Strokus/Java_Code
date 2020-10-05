import java.util.ArrayList;
import java.util.Scanner;

public class DiceGame extends Game {

	public static void main(String[] args) {

		ArrayList<Player> players = new ArrayList<>();
		Die d1 = new Die();
		Die d2 = new Die();

		numPlayers(players);
		System.out.println(" -------------------------------------------------");
		System.out.print("|Each players starts out with an initial score of 30.	\n"
				+ "|As you roll your dice, the total will be subtracted from "
				+ "your starting value (ex. 3,5 = 8. 30 -8 =22)\n"
				+ "|Winner is whomever reaches a score of 6 or lower.	\n"
				+ "|BE CAREFUL! if you are close to 6 and your total makes a negative number,\n"
				+ "|the total is then added back instead of subtracted. Good luck!!	\n"
				+ " -------------------------------------------------------------");
		
	}

	public static ArrayList<Player> numPlayers(ArrayList<Player> players) {
		Scanner scan = new Scanner(System.in);

		System.out.println("How many players are there? (Max of 4)");
		int numberOfPlayers = scan.nextInt();
		while (numberOfPlayers < 2 || numberOfPlayers > 4) {
			

			if (numberOfPlayers == 2) {
				Player p1 = new Player();
				Player p2 = new Player();

				players.add(p1);
				players.add(p2);
			} else if (numberOfPlayers == 3) {
				Player p1 = new Player();
				Player p2 = new Player();
				Player p3 = new Player();

				players.add(p1);
				players.add(p2);
				players.add(p3);
			} else if (numberOfPlayers == 4) {
				Player p1 = new Player();
				Player p2 = new Player();
				Player p3 = new Player();
				Player p4 = new Player();

				players.add(p1);
				players.add(p2);
				players.add(p3);
				players.add(p4);
			} else {
				System.out.println("Invalid amount of players. input players (2-4)");
				System.out.println("How many players are there? (Max of 4)");
				numberOfPlayers = scan.nextInt();
			}
		} // end while
		return players;

	}
}
