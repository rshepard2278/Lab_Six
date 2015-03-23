/**
 * @author Richard Shepard
 * @version Mar 13, 2015
 */
package com.rshepard.tictactoe;

/**
 *	Start a game of tic tac 
 *	toe for two human players
 */
public class StartGame {

	/**Initializes a TicTacToeEngine object
	 * and starts a 2 (human) player game of
	 * tic tac toe
	 * @param args Command line arguments
	 */
	public static void main(String[] args) {
		TicTacToeEngine game = new TicTacToeEngine();
		game.play();
	}

}
