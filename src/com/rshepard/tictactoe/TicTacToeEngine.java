/**
 * @author Richard Shepard
 * @version Mar 13, 2015
 */
package com.rshepard.tictactoe;

/**
 *TicTacToeEngine creates the players, UI,
 *and handles the logic for a game of 
 *tic tac toe
 */
public class TicTacToeEngine {

	private TicTacToeUI UI;
	private static Player player;
	private static boolean isGameOver;
	private int turnCount;


	/**
	 * Constructor creates a new TicTacToeEngine
	 * instance and initializes the GUI and sets
	 * the default turn count to zero and isGameOver
	 * to false.
	 */
	public TicTacToeEngine() {
		UI = new TicTacToeUI();
		turnCount = 0;
		isGameOver = false;
	}
	
	

	/**
	 * Creates a game loop that continues until a player
	 * wins or all the board spaces have been filled.
	 */
	public void play() {
		String winText = "";
		Mark winMark = null;
		
		while (!isGameOver) {
			player1Turn();
			isGameOver = checkWin(Mark.X);
			winText = "Player 1";
			winMark = Mark.X;
			if (turnCount >= 9) {
				isGameOver = true;
				winText = "Draw ";
			}
			if(!isGameOver) {
				player2Turn();
				isGameOver = checkWin(Mark.O);
				winText = "Player 2";
				winMark = Mark.O;
			} 
		}
		UI.disableButtons();
		UI.setWinText(winText);
		markWin(winMark);

	}

	/**
	 * Initializes the player field to 
	 * player one then waits for an
	 * input
	 */
	private void player1Turn() {
		player = Player.P1;
		turnCount++;
		while (player == Player.P1) {
			waitForInput();
		}

	}

	/**
	 * Initializes the player field to 
	 * player two then waits for an
	 * input
	 */
	private void player2Turn() {
		player = Player.P2;
		turnCount++;
		while (player == Player.P2) {
			waitForInput();
		}
	}

	/**Get player returns the object
	 * containing the current player. I 
	 * made this method static so that it 
	 * could be utilize in the TicTacToeUI class
	 * without creating an instance of the engine
	 * within that class
	 * @return Returns the current player
	 */
	public static Player getPlayer() {
		return player;
	}

	/**Resets the current player field after a
	 * player has taken their turn by an action 
	 * generated in the UI class. I 
	 * made this method static so that it 
	 * could be utilize in the TicTacToeUI class
	 * without creating an instance of the engine
	 * within that class
	 * @param player Sets the player field to the current player
	 */
	public static void setPlayer(Player player) {
		TicTacToeEngine.player = player;
	}
	
	/**Checks for a win for the given mark
	 * on the Tic Tac Toe board and returns 
	 * a boolean indicating if a win was found
	 * @param mark The current mark to check
	 * for win
	 * @return Returns the value of true if the given
	 * mark has won on the board. False if not.
	 */
	public boolean checkWin(Mark mark) {
		boolean win = false;
		Mark board[][];
		board = UI.getBoard().getBoard();
		for(int i = 0; i < board.length && !win; i ++) {
			if(board[i][0] == mark && board[i][1] == mark && board[i][2] == mark) {
				win = true;
			} else if(board[0][i] == mark && board[1][i] == mark && board[2][i] == mark) {
				win = true;
			} else if(board[0][0] == mark && board[1][1] == mark && board[2][2] == mark) {
				win = true;
			} else if(board[0][2] == mark && board[1][1] == mark && board[2][0] == mark) {
				win = true;
			} else {
				win = false;
			}
		}
		
		return win;
	}
	
	/**Highlights the winning moves for a 
	 * given Mark
	 * @param The mark to highlight for a win
	 */
	private void markWin(Mark mark) {
		Mark board[][];
		board = UI.getBoard().getBoard();
		for(int i = 0; i < board.length ; i ++) {
			if(board[i][0] == mark && board[i][1] == mark && board[i][2] == mark) {
				UI.markButton(i, 0, mark);
				UI.markButton(i, 1, mark);
				UI.markButton(i, 2, mark);
			} else if(board[0][i] == mark && board[1][i] == mark && board[2][i] == mark) {
				UI.markButton(0, i, mark);
				UI.markButton(1, i, mark);
				UI.markButton(2, i, mark);
			} else if(board[0][0] == mark && board[1][1] == mark && board[2][2] == mark) {
				UI.markButton(0, 0, mark);
				UI.markButton(1, 1, mark);
				UI.markButton(2, 2, mark);
			} else if(board[0][2] == mark && board[1][1] == mark && board[2][0] == mark) {
				UI.markButton(0, 2, mark);
				UI.markButton(1, 1, mark);
				UI.markButton(2, 0, mark);
			}
		}
	}
	
	/**Used by the UI class to disable event
	 * listeners if the game is over. I 
	 * made this method static so that it 
	 * could be utilize in the TicTacToeUI class
	 * without creating an instance of the engine
	 * within that class
	 * @return the isGameOver
	 */
	public static boolean isGameOver() {
		return isGameOver;
	}


	/**
	 * Pauses the thread for 20ms to wait for an 
	 * input. I found that if I did not do
	 * this, input loops would seem to hang
	 * while waiting for input
	 */
	private void waitForInput() {
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}