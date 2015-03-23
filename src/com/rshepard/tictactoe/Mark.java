/**
 * @author Richard Shepard
 * @version Mar 13, 2015
 */
package com.rshepard.tictactoe;


/**Mark Enum provides the 
 * different types of marks
 * on a tic tac toe board
 *
 */
public enum Mark {

	X("X"), 
	O("O"), 
	EMPTY("");
	
	private String mark;
	
	/**Applies the current mark
	 * to the field mark to 
	 * be converted to String
	 * @param mark The current mark to 
	 * be stored in the mark feild
	 */
	Mark(String mark) {
		this.mark = mark;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	/**
	 * Converts the current mark
	 * to a string and returns
	 * that value
	 * @return Returns the current mark converted
	 * to a string
	 */
	public String toString() {
		return this.mark;
	}
}
