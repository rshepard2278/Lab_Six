/**
 * @author Richard Shepard
 * @version Mar 13, 2015
 */
package com.rshepard.tictactoe;

/**
 *	Player Enum provides two
 *	values, one for each of 
 *	the players in a tic tac
 *	toe game
 */
public enum Player {
	
	P1("1"),
	P2("2");
	
	private String number;
	
	/**Assigns the current player
	 * number to the field number to
	 * be converted to a string
	 * @param number The current player
	 * number to be converted to a
	 * string
	 */
	Player(String number) {
		this.number = number;
	}

	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	/**
	 * Converts the current player
	 * number held in the number field
	 * to a string
	 * @return Returns a string value of the
	 * current player
	 */
	public String toString(){
		return this.number;
	}
}
