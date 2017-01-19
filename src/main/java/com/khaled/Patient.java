package com.khaled;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Patient extends JFrame{
	Patient()
	{
		 setTitle("Nutrio App");
		 BasePanel panel=new BasePanel();
		 this.add(panel);
	     setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	     setExtendedState(JFrame.MAXIMIZED_BOTH); 
		 setJMenuBar(new PatientMenu());
		 setVisible(true);
	}
	
	public class BasePanel extends JPanel {

		ImageIcon backImage;
		public BasePanel() {
		    backImage = new ImageIcon("src/main/resources/nutrioAppImage.jpg");
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

}
