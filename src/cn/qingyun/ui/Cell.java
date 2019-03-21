package cn.qingyun.ui;

import javax.swing.Icon;
import javax.swing.JButton;

public class Cell extends JButton{


	public Cell(Icon icon) {
		super(icon);
		this.setSize(150,150);
	}

	public Cell(String text, Icon icon) {
		super(text, icon);
		this.setSize(150,150);
		this.setHorizontalTextPosition(CENTER);
		this.setVerticalTextPosition(CENTER);
	}

	public void moveCell(int direction) {
		switch (direction) {
		case 0:
			 this.setLocation(this.getBounds().x, this.getBounds().y-150);
			break;
		case 1:
			 this.setLocation(this.getBounds().x, this.getBounds().y+150);
			break;
		case 2:
			 this.setLocation(this.getBounds().x-150, this.getBounds().y);
			break;
	 	case 3:
	 		 this.setLocation(this.getBounds().x+150, this.getBounds().y);
	 		break;

		default:
			break;
		}
	}

	
}
