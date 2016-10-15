import java.awt.Color;
import java.awt.Component;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Random;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyMouseAdapter extends MouseAdapter {
	public static int grayRect;

	public void nrbyBombs(MyPanel myPanel, int x, int y){
		int counter = 0;
		if((x -1 >= 0 && x -1 < 9) &&  (y-1 >= 0 && y -1 < 9) && myPanel.locOfBomb(x -1, y -1 )){
			counter ++;
		} 
		if((x -1 >= 0 && x -1 < 9) &&  (y >= 0 && y < 9) && myPanel.locOfBomb(x -1, y)){
			counter ++;
		} 
		if((x -1 >= 0 && x -1 < 9) &&  (y + 1 >= 0 && y + 1 < 9) && myPanel.locOfBomb(x -1, y + 1)){
			counter ++;
		} 
		if((x  >= 0 && x < 9) &&  (y-1 >= 0 && y-1 < 9) && myPanel.locOfBomb(x, y-1)){
			counter ++;
		} 
		if((x >= 0 && x < 9) &&  (y + 1>= 0 && y + 1< 9) && myPanel.locOfBomb(x, y + 1)){
			counter ++;
		} 
		if((x + 1 >= 0 && x + 1 < 9) &&  (y - 1 >= 0 && y - 1 < 9) && myPanel.locOfBomb(x + 1, y - 1)){
			counter ++;
		} 
		if((x +1 >= 0 && x + 1< 9) &&  (y >= 0 && y < 9) && myPanel.locOfBomb(x + 1, y)){
			counter ++;
		} 
		if((x + 1 >= 0 && x + 1 < 9) &&  (y + 1>= 0 && y + 1 < 9) && myPanel.locOfBomb(x + 1, y + 1)){
			counter ++;
		} 

		//Set the number for near by bombs
		if (counter > 0) {
			Color newColor = Color.LIGHT_GRAY;
			myPanel.colorArray[x][y] = newColor;	
			myPanel.numForNrbyBombs[x][y] = counter;

		} else {
			//If no bombs are found
			if((x - 1 >= 0 && x - 1 < 9) &&  (y >= 0 && y < 9) && !myPanel.colorArray[x - 1][y].equals(Color.GRAY) && !myPanel.colorArray[x - 1][y].equals(Color.RED) && !myPanel.locOfBomb(x - 1, y)){
				Color newColor =  Color.GRAY;
				myPanel.colorArray[x - 1][y] = newColor;
				nrbyBombs(myPanel, x - 1, y);	
			} 
			if((x - 1 >= 0 && x - 1 < 9) &&  (y -1 >= 0 && y -1 < 9) && !myPanel.colorArray[x - 1][y -1].equals(Color.GRAY) && !myPanel.colorArray[x - 1][y -1].equals(Color.RED) && !myPanel.locOfBomb(x - 1, y -1)){
				Color newColor =  Color.GRAY;
				myPanel.colorArray[x - 1][y -1] = newColor;
				nrbyBombs(myPanel, x - 1, y -1);
			} 
			if((x - 1 >= 0 && x - 1 < 9) &&  (y + 1 >= 0 && y + 1 < 9) && !myPanel.colorArray[x - 1][y + 1].equals(Color.GRAY) && !myPanel.colorArray[x - 1][y + 1].equals(Color.RED) && !myPanel.locOfBomb(x - 1, y + 1)){
				Color newColor =  Color.GRAY;
				myPanel.colorArray[x - 1][y + 1] = newColor;
				nrbyBombs(myPanel, x - 1, y + 1);
			} 
			if((x >= 0 && x < 9) &&  (y -1 >= 0 && y -1 < 9) && !myPanel.colorArray[x][y -1].equals(Color.GRAY) && !myPanel.colorArray[x][y -1].equals(Color.RED) && !myPanel.locOfBomb(x, y -1)){
				Color newColor =  Color.GRAY;
				myPanel.colorArray[x][y -1] = newColor;
				nrbyBombs(myPanel, x, y -1);
			} 
			if((x >= 0 && x < 9) &&  (y + 1 >= 0 && y + 1 < 9) && !myPanel.colorArray[x][y + 1].equals(Color.GRAY) && !myPanel.colorArray[x][y + 1].equals(Color.RED) && !myPanel.locOfBomb(x, y + 1)){
				Color newColor =  Color.GRAY;
				myPanel.colorArray[x][y + 1] = newColor;
				nrbyBombs(myPanel, x, y + 1);
			} 
			if((x + 1 >= 0 && x + 1 < 9) &&  (y >= 0 && y < 9) && !myPanel.colorArray[x + 1][y].equals(Color.GRAY) && !myPanel.colorArray[x + 1][y].equals(Color.RED) && !myPanel.locOfBomb(x + 1, y)){
				Color newColor =  Color.GRAY;
				myPanel.colorArray[x + 1][y] = newColor;
				nrbyBombs(myPanel, x + 1, y);
			} 
			if((x + 1 >= 0 && x + 1 < 9) &&  (y - 1>= 0 && y -1 < 9) && !myPanel.colorArray[x + 1][y -1].equals(Color.GRAY) && !myPanel.colorArray[x + 1][y - 1].equals(Color.RED) && !myPanel.locOfBomb(x + 1, y - 1)){
				Color newColor =  Color.GRAY;
				myPanel.colorArray[x + 1][y - 1] = newColor;
				nrbyBombs(myPanel, x + 1, y - 1);
			} 
			if((x + 1 >= 0 && x + 1 < 9)&&  (y + 1 >= 0 && y + 1 < 9) && !myPanel.colorArray[x + 1][y + 1].equals(Color.GRAY) && !myPanel.colorArray[x + 1][y + 1].equals(Color.RED) && !myPanel.locOfBomb(x + 1, y + 1)){
				Color newColor =  Color.GRAY;
				myPanel.colorArray[x + 1][y + 1] = newColor;
				nrbyBombs(myPanel, x + 1, y + 1);
			} 
		}
	}
	private Random generator = new Random();
	MyPanel myPanel = new MyPanel();
	public void mousePressed(MouseEvent e) {
		switch (e.getButton()) {
		case 1:		//Left mouse button
			Component c = e.getComponent();
			while (!(c instanceof JFrame)) {
				c = c.getParent();
				if (c == null) {
					return;
				}
			}
			JFrame myFrame = (JFrame) c;
			MyPanel myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);
			Insets myInsets = myFrame.getInsets();
			int x1 = myInsets.left;
			int y1 = myInsets.top;
			e.translatePoint(-x1, -y1);
			int x = e.getX();
			int y = e.getY();
			myPanel.x = x;
			myPanel.y = y;
			myPanel.mouseDownGridX = myPanel.getGridX(x, y);
			myPanel.mouseDownGridY = myPanel.getGridY(x, y);
			break;
		case 3:		//Right mouse button
			//Do nothing
			break;
		default:    //Some other button (2 = Middle mouse button, etc.)
			//Do nothing
			break;
		}
	}
	public void mouseReleased(MouseEvent e) {
		switch (e.getButton()) {
		case 1:		//Left mouse button
			Component c = e.getComponent();
			while (!(c instanceof JFrame)) {
				c = c.getParent();
				if (c == null) {
					return;
				}
			}
			JFrame myFrame = (JFrame)c;
			MyPanel myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);  //Can also loop among components to find MyPanel
			Insets myInsets = myFrame.getInsets();
			int x1 = myInsets.left;
			int y1 = myInsets.top;
			e.translatePoint(-x1, -y1);
			int x = e.getX();
			int y = e.getY();
			myPanel.x = x;
			myPanel.y = y;
			int gridX = myPanel.getGridX(x, y);
			int gridY = myPanel.getGridY(x, y);
			if ((myPanel.mouseDownGridX == -1) || (myPanel.mouseDownGridY == -1)) {
				//Had pressed outside
				//Do nothing
			} else {
				if ((gridX == -1) || (gridY == -1)) {
					//Is releasing outside
					//Do nothing
				} else {
					if ((myPanel.mouseDownGridX != gridX) || (myPanel.mouseDownGridY != gridY)) {
						//Released the mouse button on a different cell where it was pressed
						//Do nothing
					} else {
						//Released the mouse button on the same cell where it was pressed
						if ((gridX >= 0) || (gridY >= 0)) {
							//On the grid:
							Color newColor = Color.BLACK;
							if(myPanel.locOfBomb(myPanel.mouseDownGridX, myPanel.mouseDownGridY)){
								//The losing message
								JOptionPane.showMessageDialog(myPanel, "You pressed a bomb!", "Game Over", JOptionPane.PLAIN_MESSAGE);
								myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] = newColor;
								myPanel.repaint();


							}
						}
						// Paints empty tiles gray
						Color newColor = Color.GRAY;
						myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] = newColor;
						nrbyBombs(myPanel, myPanel.mouseDownGridX, myPanel.mouseDownGridY);
						myPanel.repaint();
						grayRect++;
					}
				}
			}
			myPanel.repaint();
			break;
		case 3:		//Right mouse button
			Component d = e.getComponent();
			while (!(d instanceof JFrame)) {
				d = d.getParent();
				if (d == null) {
					return;
				}
			}
			JFrame myFrameRightClick = (JFrame)d;
			MyPanel myPanelRightClick = (MyPanel) myFrameRightClick.getContentPane().getComponent(0);  //Can also loop among components to find MyPanel
			Insets myInsetsRightClick = myFrameRightClick.getInsets();
			int x1RightClick = myInsetsRightClick.left;
			int y1RightClick = myInsetsRightClick.top;
			e.translatePoint(-x1RightClick, -y1RightClick);
			int xRightClick = e.getX();
			int yRightClick = e.getY();
			myPanelRightClick.x = xRightClick;
			myPanelRightClick.y = yRightClick;
			myPanelRightClick.mouseDownGridX = myPanelRightClick.getGridX(xRightClick, yRightClick);
			myPanelRightClick.mouseDownGridY = myPanelRightClick.getGridY(xRightClick, yRightClick);
			int gridXRightClick = myPanelRightClick.getGridX(xRightClick, yRightClick);
			int gridYRightClick = myPanelRightClick.getGridY(xRightClick, yRightClick);
			if ((myPanelRightClick.mouseDownGridX == -1) || (myPanelRightClick.mouseDownGridY == -1)) {
				//Had pressed outside
				//Do nothing
			} else {
				if ((gridXRightClick == -1) || (gridYRightClick == -1)) {
					//Is releasing outside
					//Do nothing
				} else {
					if ((myPanelRightClick.mouseDownGridX != gridXRightClick) || (myPanelRightClick.mouseDownGridY != gridYRightClick)) {
						//Released the mouse button on a different cell where it was pressed
						//Do nothing
					} else {
						//Released the mouse button on the same cell where it was pressed
						if ((gridXRightClick >= 0) || (gridYRightClick >= 0)) {
							//On the grid:

							Color newColor = null;
							Color newColor2 = null;
							do{
								newColor2 = myPanelRightClick.colorArray[myPanelRightClick.mouseDownGridX][myPanelRightClick.mouseDownGridY];
								switch (generator.nextInt(2)) {
								case 0:
									newColor = Color.RED;
									break;							
								case 1:
									newColor = Color.WHITE;
									break;
								}
							}while(newColor.equals(newColor2));
							myPanelRightClick.colorArray[myPanelRightClick.mouseDownGridX][myPanelRightClick.mouseDownGridY] = newColor;
							myPanelRightClick.repaint();
						}
					}
				}
			}
			myPanelRightClick.repaint();
			break;
		default:    //Some other button (2 = Middle mouse button, etc.)
			//Do nothing
			break;
		}
	}
}