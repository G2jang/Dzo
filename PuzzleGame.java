import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

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

class View extends JPanel implements MouseListener{
	public int[][] puzzle = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
	
	public View() {
		addMouseListener(this);
	}
	public void check()
	{
		int x,y;
		int num = 1;
		for(x = 0; x<5;x++) {
			for(y = 0;y<5;y++) {
				if(num!=puzzle[x][y])
				{
					return;
				}
				if(num == 8)
				{
					num =0;
				}
				else {num++;}
			}
		}
		JOptionPane.showMessageDialog(this, "Game win","GAMELOSE!",JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}
	
	public void mousePressed(MouseEvent e) {
		int size = 100;
		int x= e.getX()/size;
		int y= e.getY()/size;
		moving(x,y);
		check();
	}
	
	public void moving(int x, int y) {
		try {
			if((y-1) >=0) {
				if(puzzle[y-1][x] == 0) {
					puzzle[y-1][x] = puzzle[y][x];
					puzzle[y][x] =0;
					
					repaint();
					
					return;
				}
			}
			if((y+1)<=2) {
				if(puzzle[y+1][x] == 0) {
					puzzle[y+1][x] = puzzle[y][x];
					puzzle[y][x] = 0;
					
					repaint();
					
					return;
				}
			}
			
			if((x+1) <= 2) {
				if(puzzle[y][x+1] == 0) {
					puzzle[y][x+1] = puzzle[y][x];
					puzzle[y][x] = 0;
					
					repaint();
					
					return;
				}
			}
			
			if((x-1) >= 0) {
				if(puzzle[y][x-1] == 0) {
					puzzle[y][x-1] = puzzle[y][x];
					puzzle[y][x] = 0;
					
					repaint();
					
					return;
				}
			}
		} catch(Exception e) {
			System.out.println(e.toString());
		}
	}
	
	public void mouseReleased(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}
	
	public void paint(Graphics g) {
		paintComponent(g);
		int size = 100;
		for(int x=0;x<5;x++) {
			for(int y=0;y<5;y++) {
				String str = Integer.toString(puzzle[x][y]);
				int dx = x*size;
				int dy = y*size;
				g.drawRect(dx, dy, size, size);
				
				if(0 != puzzle[x][y]) {
					g.drawString(str, dy+size/2, dx+size/2);
				}
			}
		}
	}
}
