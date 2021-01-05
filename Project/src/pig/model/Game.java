package pig.model;

/**
 * Date 18-Dec-2020
 * This class is used for storing the game's state including players and the dies and information like who is currently playing etc., 
 * it has the end of game conditions and actions like rolling and holding of a die.	
 * @author kshitija
 * @version 1.0
 *
 */

import pig.gui.PigData;

public class Game {

	/**
	 * First die
	 */
	private Die die1;
	/**
	 * Second die
	 */
	private Die die2;

	/**
	 * Player one
	 */
	private Player player1;
	/**
	 * Player two
	 */
	private Player player2;
	/**
	 * To store which player is currently playing
	 */
	private Player currentPlayer;
	/**
	 * Target score for end of game. Can be 50 or 100
	 */
	private int targetScore;

	/**
	 * Initializes the game with player names and 2 dies and assigns player 1 as the
	 * current player
	 * 
	 * @param p1name Player 1 name
	 * @param p2name Player 2 name
	 */
	public Game(String p1name, String p2name) {
		die1 = new Die(6, 0);
		die2 = new Die(6, 0);

		player1 = new Player(p1name);
		player2 = new Player(p2name);
		currentPlayer = player1;
	}

	/**
	 * @return returns the first die
	 */
	public Die getDie1() {
		return die1;
	}

	/**
	 * @return returns the second die
	 */
	public Die getDie2() {
		return die2;
	}

	/**
	 * @return returns first player
	 */
	public Player getPlayer1() {
		return player1;
	}

	/**
	 * @return returns second player
	 */
	public Player getPlayer2() {
		return player2;
	}

	/**
	 * used to check if the game is over or still going
	 * 
	 * @return true or false depending on if the game's end condition is met or not
	 */
	public boolean gameOver() {
		if (this.targetScore == 50) {
			return currentPlayer.getTotalScore() >= 50;
		} else {
			return currentPlayer.getTotalScore() >= 100;
		}
	}

	/**
	 * This method is used to keep a track of player turn
	 * 
	 * @return true if current player is first player else returns false
	 */
	public boolean isP1Turn() {
		return currentPlayer == player1;
	}

	/**
	 * @return the target score set by the players which is either 50 or 100
	 */
	public int getTargetScore() {
		return targetScore;
	}

	/**
	 * @param targetScore sets the target score entered by the user to use as end of
	 *                    game condition
	 */
	public void setTargetScore(int targetScore) {
		this.targetScore = targetScore;
	}

	/**
	 * This method is used to switch between player turns it checks which player's
	 * turn it is and if the game is not over it switches to other player
	 */
	public void switchTurnOfPlayers() {
		if (!PigData.pig.gameOver()) {
			if (isP1Turn()) {
				currentPlayer = player2;
			} else {
				currentPlayer = player1;
			}
		}
	}

	/**
	 * This method is used to roll both the dies together and update the turn score depending upon the values of these die
	 * if either of the die rolls a 1 then reset both turn as well as total score of the current player and switch the player 
	 */
	public void rollDie() {
		die1.roll();
		die2.roll();
		int t = die1.getTop();
		int t2 = die2.getTop();
		currentPlayer.updateTurnOfPlayers(t, t2);
		if (t == 1 || t2 == 1) {
			currentPlayer.resetTurnScore();
			currentPlayer.resetTotalScore();
			switchTurnOfPlayers();
		}
	}

	/**
	 * This method is used to hold the current players turn and switch the turn to the next player
	 * it saves the score of current player before switching to next and the resets the die
	 */
	public void holdDie() {
		currentPlayer.saveScore();
		switchTurnOfPlayers();
		die1.setTop(0);
		die2.setTop(0);
	}

	/**
	 * @return current player
	 */
	public Player getCurrent() {
		return this.currentPlayer;
	}

	public static void main(String args[]) {
		Game g = new Game("John", "Mark");
		for (int i = 0; i < 10; i++) {
			g.rollDie();
			System.out.println("p1 Turn: " + g.getPlayer1().getTurnScore());
			System.out.println("p1 Total: " + g.getPlayer1().getTotalScore());
			g.rollDie();
			g.holdDie();
			System.out.println("p2 turn: " + g.getPlayer2().getTurnScore());
			System.out.println("p2 Total: " + g.getPlayer2().getTotalScore());
		}
	}
}
