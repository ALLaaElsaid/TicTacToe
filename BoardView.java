
//imports
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * class to display the game board
 * 
 */
public class BoardView extends JPanel implements Observer {
	private NoughtsCrossesModel model;
	public JButton[][] cell;

	/**
	 * constructor initializes game model, creates a buttons for the board, and
	 * add action listener to buttons
	 * 
	 * @param model
	 *            NoughtsCrosses model
	 */
	public BoardView(NoughtsCrossesModel model) {
		super();

		// initialise model
		this.model = model;

		// create array of buttons
		cell = new JButton[3][3];

		// set layout of panel
		setLayout(new GridLayout(3, 3));

		// for each square in grid:create a button; place on panel
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				cell[i][j] = new JButton(" ");
				final int x = i;
				final int y = j;
				cell[i][j].addActionListener(e -> model.turn(x, y));
				add(cell[i][j]);
			}
		}
	}

	/*
	 * update method of the class to update the board
	 * 
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */

	public void update(Observable obs, Object obj) {
		// for each square do the following:
		// if it's a NOUGHT, put O on button
		// if it's a CROSS, put X on button
		// else put on button
		// repaint();
		// System.out.println("Called");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				// if button is Cross add X, and disable
				if (model.get(i, j) == NoughtsCrosses.CROSS) {
					cell[i][j].setText("X");
					cell[i][j].setEnabled(false);
				}
				// if button is Nought add O, and disable
				else if (model.get(i, j) == NoughtsCrosses.NOUGHT) {
					cell[i][j].setText("O");
					cell[i][j].setEnabled(false);
				}
				// else leave the button blank, and enabled
				else {
					cell[i][j].setText(" ");
					boolean notOver = (model.whoWon() == NoughtsCrosses.BLANK);
					cell[i][j].setEnabled(notOver);
				}
			}
		}
		// repaint this component
		repaint();
	}

}
