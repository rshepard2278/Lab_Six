/**
 * @author Richard Shepard
 * @version Mar 13, 2015
 */
package com.rshepard.tictactoe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.sun.media.jfxmedia.events.PlayerTimeListener;

/**
 *	TicTacToeUI creates the GUI for the Tic Tac Toe
 *	board and handles all the inputs with an ActionListener
 */
public class TicTacToeUI implements ActionListener {

	private JFrame frame;
	private JLabel title;
	private JLabel turn;
	private JLabel playerButton;
	private JButton buttons[][];
	private TicTacToeBoard board;
	private int gap = 8;
	private int pad = 10;
	private int fontSize = 50;
	private Font bigBoldFont = new Font("SansSerif", Font.BOLD, fontSize);
	private final static String TITLE = "Tic Tac Toe";
	private final static String p1 = "Player 1";
	private final static String p2 = "Player 2";
	private final static int WIDTH = 500;
	private final static int HEIGHT = 500;

	/**
	 * Creates two 3x3 arrays. One for the marks on the
	 * board and another one for the 
	 * graphical representation of the board.
	 * The JFrame is used to represent the
	 * board on the screen and to handle the 
	 * inputs from the users. 
	 */
	public TicTacToeUI() {
		buttons = new JButton[3][3];
		board = new TicTacToeBoard();
		createFrame();
	}

	/**
	 * Creates a graphical representation
	 * of the board within a JFrame including
	 * the buttons and the text.
	 */
	private void createFrame() {
		frame = new JFrame(TITLE);
		frame.setSize(WIDTH, HEIGHT);

		JPanel panel = (JPanel) frame.getContentPane();
		panel.setLayout(new BorderLayout(gap, gap));
		panel.setBorder(new EmptyBorder(pad, pad, pad, pad));
		title = new JLabel(TITLE);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(bigBoldFont);
		panel.add(title, BorderLayout.NORTH);
		
		JPanel bottomText = new JPanel(new GridLayout(1, 1));
		turn = new JLabel("TURN :");
		turn.setHorizontalAlignment(SwingConstants.RIGHT);
		bottomText.add(turn);
		
		playerButton = new JLabel(p1);
		playerButton.setHorizontalAlignment(SwingConstants.LEFT);
		playerButton.setFont(new Font("SansSerif", Font.BOLD, 25));
		playerButton.setForeground(Color.RED);
		bottomText.add(playerButton);

		panel.add(bottomText, BorderLayout.SOUTH);
		panel.add(addButtons(), BorderLayout.CENTER);
		panel.setVisible(true);
		frame.setVisible(true);
	}

	/**Adds the interactive buttons and
	 * enables actionlisteners for each
	 * @return Returns a JPanel containing
	 * the buttons for the board
	 */
	private JPanel addButtons() {
		JPanel buttonPanel = new JPanel(new GridLayout(3, 3));

		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons.length; j++) {
				JButton button = new JButton(board.getBoard()[i][j].toString());
				button.setFont(bigBoldFont);
				button.addActionListener(this);
				buttons[i][j] = button;
				buttonPanel.add(button);
			}
		}
		return buttonPanel;
	}


	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	/**
	 * Called when an action is performed by the users and applies
	 * the appropriate marks to the screen. Once a mark has been applied
	 * that button is disabled so that another mark cannot be placed
	 * over it. It checks with the engine class for game over and also
	 * checks to see which player is currently taking a turn so that
	 * it can mark the proper mark
	 */
	public void actionPerformed(ActionEvent e) {
		if(!TicTacToeEngine.isGameOver()) {
			Player player = TicTacToeEngine.getPlayer();
			JButton testButton = (JButton) e.getSource();
			if(player == Player.P1) {
				testButton.setText(Mark.X.toString());
				TicTacToeEngine.setPlayer(Player.P2);
				playerButton.setText(p2);
			} else if(player == Player.P2) {
				testButton.setText(Mark.O.toString());
				TicTacToeEngine.setPlayer(Player.P1);
				playerButton.setText(p1);
			}
			testButton.setEnabled(false);
			updateBoard();
		}
	}

	/**
	 * This method updates the board according to the
	 * Marks stored in the Mark array for the board
	 */
	private void updateBoard() {
		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons.length; j++) {
				String test = buttons[i][j].getActionCommand();
				Mark mark = null;
				switch (test) {
				case "X":
					mark = Mark.X;
					break;
				case "O":
					mark = Mark.O;
					break;
				default:
					mark = Mark.EMPTY;
					break;
				}
				board.setMark(i, j, mark);
			}
		}
	}
	
	/**
	 * @return Returns an instantance of the
	 * current board
	 */
	public TicTacToeBoard getBoard() {
		return board;
	}
	
	/**
	 * Disables all the buttons at the
	 * end of the game so that the winning
	 * marks can be shown.
	 */
	public void disableButtons() {
		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons.length; j++) {
				 buttons[i][j].setEnabled(false);
			}
		}
	}
	
	/**Sets the name of the winner or a draw on
	 * the screen
	 * @param text The String of text that displays the 
	 * winner on the screen
	 */
	public void setWinText(String text) {
		turn.setText("Win : ");
		playerButton.setFont(new Font("SansSerif", Font.BOLD, 25));
		playerButton.setForeground(Color.blue);
		playerButton.setText(text);
	}
	
	/**Marks a specific Mark and location
	 * on the GUI of the board
	 * @param row The row number of the given Mark to be placed
	 * @param col The column number of the given Mark to be placed
	 * @param mark The type of Mark that is to be displayed
	 */
	public void markButton(int row, int col, Mark mark) {
		buttons[row][col].setEnabled(true);
		buttons[row][col].setForeground(Color.red);
	}
}