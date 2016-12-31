package com.khaled;

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
     JLabel title, idLabel,passwordLabel, nameLabel,emailAddressLabel, contactLabel;
     JTextField idField,passwordField, userNameField,addressField, contactField;
     JButton registerButton;
     
     
     public Registration() {
          // TODO Auto-generated constructor stub
          super("REGISTRATION FORM");
           setSize(770, 420);
           setLayout(null);
           // Defining Labels 
           title = new JLabel("Registration Form");
           title.setBounds(60, 7, 200, 30);
           passwordLabel = new JLabel("Password");
           passwordLabel.setBounds(30, 50, 60, 30);
           nameLabel = new JLabel("UserName"); 
           nameLabel.setBounds(30, 85, 60, 30);
           // Defining ID field
           idField = new JTextField(); 
           idField.setBounds(95, 50, 130, 30);
           idField.setEnabled(false);
           emailAddressLabel = new JLabel("email Address"); 
           emailAddressLabel.setBounds(30, 155, 90, 30); 
           contactLabel = new JLabel("Contact"); 
           contactLabel.setBounds(30, 190, 60, 30);
           //define password field
           passwordField = new JPasswordField(); 
           passwordField.setBounds(95, 50, 130, 30);

           // Defining Name field
           userNameField = new JTextField(); 
           userNameField.setBounds(95, 85, 130, 30);         
           addressField = new JTextField(); 
           addressField.setBounds(125, 155, 130, 30);
           contactField = new JTextField(); 
           contactField.setBounds(95, 190, 130, 30);

           // fixing all Label,TextField,RadioButton
           add(title);
           add(passwordLabel);
           add(nameLabel);
           add(idField);
           add(emailAddressLabel);
           add(contactLabel);
           add(passwordField);
           add(userNameField);
           add(addressField);
           add(contactField);           

           // Defining Register Button
           registerButton = new JButton("Register");
           registerButton.setBounds(110, 250, 100, 25);
           // fixing all Buttons
           add(registerButton);
           //Displaying Frame in Center of the Screen
           Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
           this.setLocation(dim.width/2-this.getSize().width/2,
                            dim.height/2-this.getSize().height/2);
           setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
           setResizable(false);
           setVisible(true);
           registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				DataBase db=new DataBase();
				con=db.connect();      
				try{
                    if (ae.getSource() == registerButton) {
                        if (userNameField.getText().equals(""))
                           JOptionPane.showMessageDialog(idField, "Please provide Name_Field");
                        else if(addressField.getText().equals(""))
                           JOptionPane.showMessageDialog(idField, "Please provide Address_Field");
                        else if(contactField.getText().equals(""))
                           JOptionPane.showMessageDialog(idField, "Please provide Contact_Field");
                        else if(passwordField.getText().equals(""))
                            JOptionPane.showMessageDialog(idField, "Please provide Password_Field");
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
