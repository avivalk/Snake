import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class EndGameFrame extends JFrame {
	private JLabel label;
	private JLabel question;
	private JButton newGame;
	private JButton close;
	private JPanel buttonPanel;

	public EndGameFrame() {
		this.setTitle("Game Over");
		this.setSize(300, 200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.setLayout(new BorderLayout());
		label = new JLabel("GAME OVER!");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Arial", Font.PLAIN, 20));
		question = new JLabel("Do you want to start a new game?");
		question.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Arial", Font.PLAIN, 18));
		this.add(label, BorderLayout.NORTH);
		this.add(question, BorderLayout.CENTER);
		buttonPanel = new JPanel();
		newGame = new JButton("NEW GAME");
		close = new JButton("CLOSE");
		buttonPanel.add(newGame);
		buttonPanel.add(close);
		this.add(buttonPanel, BorderLayout.SOUTH);
		newGame.addActionListener(new NewGameListener(this));
		close.addActionListener(new CloseListener(this));
	}

	private class NewGameListener implements ActionListener {
		private JFrame frame;

		public NewGameListener(JFrame frame) {
			this.frame = frame;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			Window f1 = new Window();

			// Setting up the window settings
			f1.setTitle("Snake");
			f1.setSize(300, 300);
			f1.setVisible(true);
			f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.dispose();
		}
	}

	private class CloseListener implements ActionListener {
		private JFrame frame;

		public CloseListener(JFrame frame) {
			this.frame = frame;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
		}

	}

}
