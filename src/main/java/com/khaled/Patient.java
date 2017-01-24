package com.khaled;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Patient extends JFrame{
	Patient()
	{
		 setTitle("Nutrio App");
		 //BasePanel panel=new BasePanel("src/main/resources/nutrioAppImage.jpg");
		 InputStream image =this.getClass().getClassLoader().getResourceAsStream("nutrioAppImage.jpg");
		 BasePanel panel=new BasePanel(image);
		 this.add(panel);
	     setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	     setExtendedState(JFrame.MAXIMIZED_BOTH); 
		 setJMenuBar(new PatientMenu());
		 setVisible(true);
	}
	
}
