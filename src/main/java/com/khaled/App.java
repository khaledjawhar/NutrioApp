package com.khaled;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.InputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	try 
        { 
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
        } 
        catch(Exception e){ 
        }

    	JButton registerButton;
    	JButton loginButton;
    	JFrame frame= new JFrame();
    	//BasePanel panel=new BasePanel("src/main/resources/nutrioAppImage.jpg");
    	Image image=new Image();
	    BasePanel panel=new BasePanel(image.image);
    	frame. setTitle("Nutrio App");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        registerButton = new JButton("Signup");
        registerButton.setBounds(110, 250, 100, 25);
        // fixing all Buttons
        panel.add(registerButton);
        loginButton = new JButton("login");
        loginButton.setBounds(110, 250, 100, 25);
        // fixing all Buttons
        panel.add(loginButton);
        frame.add(panel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				Registration registration=new Registration();
			}
        });
        loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				Login login=new Login();
			}
        });
	}
    
    
}

