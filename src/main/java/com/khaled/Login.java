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
    Container c;
 
    //a inner class to handling ActionEvents
    handler handle;
 
    //a separate class for processing database connection and authentication
    LoginHandler handler;
 
    Login()
    {
        super("Login form");
 
        c=getContentPane();
        c.setLayout(new FlowLayout());
 
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
 
        //add to contaienr
        c.add(l_name);
        c.add(t_name);
        c.add(l_pass);
        c.add(t_pass);
        c.add(button);
        //visual
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(770, 420);
 
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