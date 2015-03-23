package com.rshepard.tictactoe;

/**
 * TicTacToeBoard creates an 2d array
 * that simulates a Tic Tac Toe board
 * @author Richard Shepard
 * @version Mar 13, 2015
 */
public class TicTacToeBoard {

	private Mark[][] board;

	/**
	 * Constructor initializes a 3X3 array of type
	 * Mark for a game of Tic Tac Toe. All spaces
	 * are set to the default of empty.
	 */
	public TicTacToeBoard() {
		board = new Mark[][] { {Mark.EMPTY, Mark.EMPTY, Mark.EMPTY},
							   {Mark.EMPTY, Mark.EMPTY, Mark.EMPTY},
							   {Mark.EMPTY, Mark.EMPTY, Mark.EMPTY}
		};

	}
	
	/**Sets a mark on the board array. 
	 * @param row The row number of the mark to be placed.
	 * @param col The column number of the mark to be placed.
	 * @param mark The type of mark to be placed(X or O)
	 * @return Returns the value of true if the mark was placed
	 * False if the spot is not empty.
	 */
	public boolean setMark(int row, int col, Mark mark ) {
		boolean didMark = false;
		
		if(board[row][col] == Mark.EMPTY) {
			board[row][col] = mark;
			didMark = true;
		} else {
			didMark = false;
		}
		
		return didMark;
	}
	
	
	/**Get board returns a mark array consisting of
	 * the current state of the game
	 * @return Returns a 3X3 array of type Mark (The state of the board)
	 */
	public Mark[][] getBoard() {
		return board;
	}

}
