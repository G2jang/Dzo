import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PuzzleGame extends JFrame{
	View m_view;
	public PuzzleGame() {
		m_view = new View();
		setTitle("Puzzle Game");
		add(m_view);
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PuzzleGame m = new PuzzleGame();
	}

}

class View extends JPanel{
	public View() {
		
	}
	
	public void paint(Graphics g) {
		
	}
}