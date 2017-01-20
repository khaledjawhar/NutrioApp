package com.khaled;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class Login extends JFrame
{
    //declaring our swing components
    JLabel l_name,l_pass;
    JTextField t_name;
    JPasswordField t_pass;     //A special JTextField but hides input text
    JButton button;
 
    //a inner class to handling ActionEvents
    handler handle;
 
    //a separate class for processing database connection and authentication
    LoginHandler handler;
 
    Login()
    {
        super("Login form");
    	BasePanel panel=new BasePanel("src/main/resources/login image.jpg");
        //extra classes
        handler=new LoginHandler();
        handle =new handler();
 
                //swing components
        l_name=new JLabel("Username");
        l_pass=new JLabel("Password");
        t_name=new JTextField(10);
        t_pass=new JPasswordField(10);
        button=new JButton("Login");
 
        //adding actionlistener to the button
        button.addActionListener(handle);
 
        //add to container
        panel.add(l_name);
        panel.add(t_name);
        panel.add(l_pass);
        panel.add(t_pass);
        panel.add(button);
        add(panel);
        //visual
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setTitle("Nutrio App");
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
 
    }
   
    //an inner class .You can also write as a separate class
    class handler implements ActionListener
    {
        //must implement method
        //This is triggered whenever the user clicks the login button
        public void actionPerformed(ActionEvent ae)
        {
            //checks if the button clicked
            if(ae.getSource()==button)
            {
                char[] temp_pwd=t_pass.getPassword();
                String pwd=null;
                pwd=String.copyValueOf(temp_pwd);
                //The entered username and password are sent via "checkLogin()" which return boolean
                if(handler.checkLogin(t_name.getText(), pwd))
                {
                    //a pop-up box
                    JOptionPane.showMessageDialog(null, "You have logged in successfully","Success",
                                        JOptionPane.INFORMATION_MESSAGE);
                    Patient patient=new Patient();  
                    setVisible(false); 
                    dispose(); 
                }
                else
                {
                    //a pop-up box
                    JOptionPane.showMessageDialog(null, "Login failed!","Failed!!",
                                        JOptionPane.ERROR_MESSAGE);
                }
            }//if
        }//method
 
    }//inner class
}//class