package pig.model;

/**
 * Date 18-Dec-2020
 * This class is used for storing the die's state \, 
 * it has a roll method which randomly generates a number between 1 and 6	
 * @author kshitija
 * @version 1.0
 *
 */
public class Die {

	/**
	 * to specify the sides of die
	 */
	private int sides;
	/**
	 * specifies top of the die
	 */
	private int top;

	/**
	 * Default constructor which assigns 6 sides and top as 0
	 */
	public Die() {
		sides=6;
		top=0;
	}

	/**
	 * @param sides makes a new die with number of sides provided
	 * @param top top value of the die
	 */
	public Die(int sides, int top) {
		this.sides=sides;
		this.top=top;
	}
	
	
	/**
	 * @return sides of the die
	 */
	public int getSides() {
		return sides;
	}

	/**
	 * @param sides sets the number of sides of die
	 */
	public void setSides(int sides) {
		this.sides = sides;
	}

	/**
	 * @return top of the die
	 */
	public int getTop() {
		return top;
	}

	/**
	 * @param top sets the top value on a die
	 */
	public void setTop(int top) {
		if(top>0 && top<=sides) {
			this.top = top;
		}
	}
	
	/**
	 * This method is used to roll the die and randomly generate a number between 1 and 6 using math function
	 */
	public void roll() {
		top = 1+(int)(Math.random() * sides);
	}
	
	public static void main(String args[]) {
		Die d = new Die(6, 1);
		System.out.println(d.top);
		d.roll();
		System.out.println(d.top);
	}
}
