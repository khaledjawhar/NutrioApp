package com.khaled;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Registration  extends JFrame{
	 Connection con;
	 PreparedStatement preStatement;
     JLabel passwordLabel, nameLabel,emailAddressLabel, contactLabel;
     JTextField idField,passwordField, userNameField,addressField, contactField;
     JButton registerButton;
     
     
     public Registration() {
          // TODO Auto-generated constructor stub
          super("REGISTRATION FORM");
           // Defining Labels 
           nameLabel = new JLabel("UserName"); 
           nameLabel.setBounds(30, 50, 90, 30);
           passwordLabel = new JLabel("Password");
           passwordLabel.setBounds(30, 85, 90, 30);
           emailAddressLabel = new JLabel("email Address"); 
           emailAddressLabel.setBounds(30, 155, 90, 30); 
           contactLabel = new JLabel("Contact"); 
           contactLabel.setBounds(30, 190, 90, 30);
           // Defining Name field
           userNameField = new JTextField(); 
           userNameField.setBounds(125, 50, 130, 30);   
           //define password field
           passwordField = new JPasswordField(); 
           passwordField.setBounds(125, 85, 130, 30);
           addressField = new JTextField(); 
           addressField.setBounds(125, 155, 130, 30);
           contactField = new JTextField(); 
           contactField.setBounds(125, 190, 130, 30);
           BasePanel panel=new BasePanel("src/main/resources/registration image.jpg");
           // fixing all Label,TextField,RadioButton
           panel.setLayout(null);
           panel.add(nameLabel);
           panel.add(userNameField);
           panel.add(passwordLabel);
           panel.add(passwordField);         
           panel.add(emailAddressLabel);
           panel.add(addressField);
           panel.add(contactLabel);        
           panel.add(contactField);           
           // Defining Register Button
           registerButton = new JButton("Register");
           registerButton.setBounds(125, 250, 100, 25);
           // fixing all Buttons
           panel.add(registerButton);
           add(panel);
           setExtendedState(JFrame.MAXIMIZED_BOTH);
           setTitle("Nutrio App");
           setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
           setVisible(true);
           registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				DataBase db=new DataBase();
				con=db.connect();      
				try{
                    if (ae.getSource() == registerButton) {
                        if (userNameField.getText().equals(""))
                           JOptionPane.showMessageDialog(null, "Please provide Name_Field");
                        else if(addressField.getText().equals(""))
                           JOptionPane.showMessageDialog(null, "Please provide Address_Field");
                        else if(contactField.getText().equals(""))
                           JOptionPane.showMessageDialog(null, "Please provide Contact_Field");
                        else if(passwordField.getText().equals(""))
                            JOptionPane.showMessageDialog(null, "Please provide Password_Field");
                        else {
                         MessageDigest digest = MessageDigest.getInstance("SHA-1");	
                         preStatement = con.prepareStatement("insert into registration (name,address,contact,password) values (?,?,?,?)");	
                         //Fetching column values from Database
                         preStatement.setString(1,userNameField.getText());
                         preStatement.setString(2,addressField.getText());
                         preStatement.setString(3,contactField.getText());
                         preStatement.setString(4,passwordField.getText());
                       //preStatement MySQL Update Query
                         int i = preStatement.executeUpdate();
                         if(i==1){
                          JOptionPane.showMessageDialog(idField, "Successfully Registered");
                         }

                       }
                        userNameField.setText("");
                        passwordField.setText("");
                        addressField.setText("");
                        contactField.setText("");
                      }
                    
               }catch(Exception ex){
                      System.out.println(ex.getMessage()); 
               }
				finally 
				{  
				   if( con != null )
						try {
							con.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}  
				}  
				
			}
           });
           
     }
     
     
     
     

}
