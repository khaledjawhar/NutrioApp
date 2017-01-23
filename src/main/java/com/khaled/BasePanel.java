package com.khaled;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BasePanel extends JPanel {

	ImageIcon backImage;
	public BasePanel(String s) {
	    backImage = new ImageIcon(s);
	}
    
	public BasePanel(InputStream s) {
	    try {
			backImage = new ImageIcon(ImageIO.read(s));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	protected void paintComponent(Graphics g) {
	    BufferedImage scaledImage = getScaledImage();
	    super.paintComponent(g);
	    g.drawImage(scaledImage, 0, 0, null);
	}

	private BufferedImage getScaledImage(){
	    BufferedImage image = new BufferedImage(getWidth(),getHeight(), BufferedImage.TYPE_INT_RGB);
	    Graphics2D g2d = (Graphics2D) image.createGraphics();
	    g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY));
	    g2d.drawImage(backImage.getImage(), 0, 0,getWidth(),getHeight(), null);

	    return image;
	}
}