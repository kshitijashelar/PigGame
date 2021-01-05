package pig.model;

/**
 * Date 18-Dec-2020
 * This class is used for storing players details like name, turn score (the score in a particular turn), 
 * and the total score. It also has functions which allows reset of total score in case of rolling a 1 and 
 * saving the score whenever the player holds his/her turn	
 * @author kshitija
 * @version 1.0
 * 
 */
public class Player {

	/**
	 * String value for the name of the player
	 */
	private String playerName;
	/**
	 * int value for the particular turn score 
	 */
	private int turnScore;
	
	/**
	 * int value for total score of the player
	 */
	private int totalScore;
	 
	/**
	 * This is a constructor which creates a new player of the name provided by it's parameter 
	 * @param name player name 
	 */
	public Player(String name) {
		this.playerName = name;
		turnScore=0;
		totalScore=0;
	}
	
	/**
	 * @return name of the player
	 */
	public String getName() {
		return playerName;
	}

	/**
	 * @param name sets the name of player
	 */
	public void setName(String name) {
		this.playerName = name;
	}

	/**
	 * @return turn score for that turn 
	 */
	public int getTurnScore() {
		return turnScore;
	}

	/**
	 * @param turnScore sets the turn score 
	 */
	public void setTurnScore(int turnScore) {
		this.turnScore = turnScore;
	}

	/**
	 * @return total score of that player 
	 */
	public int getTotalScore() {
		return totalScore;
	}

	/**
	 * @param totalScore sets total score of that player
	 */
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	/**
	 *  resets the turn score in case the player rolls a 1
	 */
	public void resetTurnScore() {
		this.turnScore=0;
	}
	/**
	 * resets the total score in case the player rolls a 1
	 */
	public void resetTotalScore() {
		this.totalScore=0;
	}
	/**
	 * This method updates the turn score of the player by adding the values of die1 and die2
	 * @param roll value of top of die1 after rolling the first die
	 * @param roll2 value of top of die2 after rolling the second die
	 */
	public void updateTurnOfPlayers(int roll, int roll2) {
		turnScore+=roll+roll2;
	}
	/**
	 * This method saves the turn score of player as total score when the player decides to hold the chance
	 * this also resets the turn score
	 */
	public void saveScore() {
		totalScore+=turnScore;
		resetTurnScore();
	}
}
