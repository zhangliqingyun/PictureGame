package cn.qingyun.ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PicturePreview extends JPanel{

	@Override
	protected void paintComponent(Graphics g) {
	
		super.paintComponent(g);
		String filePath = "picture\\"+PictureCanvsa.pictureId+".jpg";
		ImageIcon icon = new ImageIcon(filePath);
		Image image = icon.getImage();
		g.drawImage(image, 20, 20, 450, 600, this);
	}

}
