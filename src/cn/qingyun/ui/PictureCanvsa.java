package cn.qingyun.ui;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PictureCanvsa extends JPanel implements MouseListener{

	private Cell[] cell;
	public static int pictureId = 1;
	public static int stepNum = 0;
	private Rectangle nullCell;
	
	private boolean isAddMouserListener = false;

	public PictureCanvsa(){
		this.setLayout(null);
		cell = new Cell[12];
		for(int i = 0;i < 4;i++){
			for(int j = 0;j < 3;j++){
				ImageIcon icon = new ImageIcon("picture\\"+pictureId+"_"+(i*3+j+1)+".gif");
				cell[i*3+j] = new Cell(icon);
				cell[i*3+j].setLocation(j*150+20, i*150+20);
				this.add(cell[i*3+j]);
			}
		}
		this.remove(cell[11]);
		nullCell = new Rectangle();
		nullCell.setBounds(320, 470, 150, 150);
	}

	
	public void reloadAddNumInfo() {
		for(int i = 0;i < 4;i++){
			for(int j = 0;j < 3;j++){
				ImageIcon icon = new ImageIcon("picture\\"+pictureId+"_"+(i*3+j+1)+".gif");
				cell[i*3+j].setIcon(icon);
				cell[i*3+j].setText(""+(i*3+j+1));
				cell[i*3+j].setHorizontalTextPosition(this.getX()/2);
				cell[i*3+j].setVerticalTextPosition(this.getY()/2);
			}
		}
	}


	public void reloadAddClearInfo() {
		
		
		for(int i = 0;i < 4;i++){
			for(int j = 0;j < 3;j++){
				ImageIcon icon = new ImageIcon("picture\\"+pictureId+"_"+(i*3+j+1)+".gif");
				cell[i*3+j].setIcon(icon);
				cell[i*3+j].setText("");
			}
		}
	}


	public void start() {
		
		if(!isAddMouserListener){
			for(int i = 0;i < 4;i++){
				for(int j = 0;j < 3;j++){
					cell[i*3+j].addMouseListener(this);
				}
			}
		}
		
		while(cell[0].getBounds().x <= 170 && cell[0].getBounds().y <= 170){
			int nullX = nullCell.getBounds().x;
			int nullY = nullCell.getBounds().y;
			int direction = (int) (Math.random()*4);
			switch (direction) {
			case 0:
				nullY -= 150;
				move(nullX,nullY,1);
				break;
			case 1:
				nullY += 150;
				move(nullX,nullY,0);
				break;
			case 2:
				nullX -= 150;
				move(nullX,nullY,3);
				break;
			case 3:
				nullX += 150;
				move(nullX,nullY,2);
				break;

			default:
				break;
			}
		}
		
		
	}


	private void move(int nullX, int nullY, int direction) {
		for(int i = 0;i < 4;i++){
			for(int j = 0;j < 3;j++){
				if(cell[i*3+j].getBounds().x == nullX &&cell[i*3+j].getBounds().y == nullY){
					nullCell.setLocation(nullX, nullY);
					cell[i*3+j].moveCell(direction);
					break;
				}
			}
		}
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		stepNum++;
	    MainFrame.step.setText("步数:"+stepNum);
	    
		int nullX = nullCell.getBounds().x;
		int nullY = nullCell.getBounds().y;
		Cell button = (Cell) e.getSource();
		int clickX = button.getBounds().x;
		int clickY = button.getBounds().y;
		
		if(clickX - nullX ==150 &&clickY == nullY){
			nullCell.setLocation(nullX+150, nullY);
			button.moveCell(2);
		}else if(clickX - nullX == -150 &&clickY == nullY){
			nullCell.setLocation(nullX-150, nullY);
			button.moveCell(3);
		}else if(clickX == nullX  &&clickY - nullY == 150){
			nullCell.setLocation(nullX, nullY+150);
			button.moveCell(0);
		}else if(clickX == nullX &&clickY - nullY == -150){
			nullCell.setLocation(nullX, nullY-150);
			button.moveCell(1);
		}else{
			
		}
		
		if(isFinal()){
			JOptionPane.showConfirmDialog(this,"您通关了！！！\n步数:"+stepNum);
			for(int i = 0;i < 4;i++){
				for(int j = 0;j < 3;j++){
					cell[i*3+j].removeMouseListener(this);
				}
			}
			isAddMouserListener = false;
		}
	}


	private boolean isFinal() {
        for(int i = 0;i < 4;i++){
        	for(int j = 0;j < 3;j++){
        		int x = cell[i*3+j].getBounds().x;
        		int y = cell[i*3+j].getBounds().y;
        		if((x-20)/150+(((y-20)/150)*3) != (i*3+j)){
        			return false;
        		}
        	}
        }
		return true;
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
