package com.khaled;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
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
    	frame. setTitle("Nutrio App");
    	frame.setSize(770, 420);
        frame.setLayout(new FlowLayout());
        registerButton = new JButton("Signup");
        registerButton.setBounds(110, 250, 100, 25);
        // fixing all Buttons
        frame.add(registerButton);
        loginButton = new JButton("login");
        loginButton.setBounds(110, 250, 100, 25);
        // fixing all Buttons
        frame.add(loginButton);
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

