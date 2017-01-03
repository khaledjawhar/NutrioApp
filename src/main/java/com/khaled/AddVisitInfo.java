package com.khaled;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import com.khaled.AddPatient.handler;

public class AddVisitInfo  extends JFrame{
	 JButton insert;
	 JLabel l_name,l_number,l_note;
	 StringSearchable searchable;
	 AutocompleteJComboBox combo; 
	 JTextField t_number;
	 JTextArea visitNote;
	 JScrollPane scrollPaneVisitNote;
	 handler handle;
	 Connection con;
 	 PreparedStatement preStatement;
 	 ResultSet rs; 
	 AddVisitInfo()
	{
		 List<String> myWords = new ArrayList<String>();
			try{
				DataBase db= new DataBase();    
				con=db.connect(); 
				preStatement = con.prepareStatement("SELECT patient_name FROM nutriodb.patient");
				rs=preStatement.executeQuery();
		        while(rs.next())
		        {
		        	myWords.add(rs.getString("patient_name"));
		        }
			}
			catch (Exception e) {
		            // TODO Auto-generated catch block
		            System.out.println("error while inserting patient data"+e);
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
	     handle =new handler();
	     visitNote = new JTextArea();
		 scrollPaneVisitNote = new JScrollPane(visitNote); 
		 insert=new JButton("Insert Visit Info");
		 insert.addActionListener(handle);
		 l_name=new JLabel("Patient Name");
		 l_number=new JLabel("Visit Number");
		 l_note=new JLabel("Visit Note");
		 t_number=new JTextField();
		 setLayout(null);
		 searchable = new StringSearchable(myWords);
		 combo = new AutocompleteJComboBox(searchable);
		 l_name.setBounds(20, 20, 100, 20);
	     add(l_name);
	     combo.setBounds(124, 25, 200, 20);
	     add(combo);
	     l_number.setBounds(20, 40, 100, 20);
	     add(l_number);
	     t_number.setBounds(124, 45, 200, 20);
	     add(t_number);
	     l_note.setBounds(20, 60, 100, 20);
	     add(l_note);
	     scrollPaneVisitNote.setBounds(124, 65, 600, 200);
	     add(scrollPaneVisitNote);
	     insert.setBounds(400, 25, 150, 20);
	     add(insert);
	     setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	     setExtendedState(JFrame.MAXIMIZED_BOTH); 
		 setVisible(true);
	}
	
	   //an inner class .You can also write as a separate class
    class handler implements ActionListener
    {
    	Connection con;
    	PreparedStatement preStatement; 
        //must implement method
        //This is triggered whenever the user clicks the login button
        public void actionPerformed(ActionEvent ae)
        {
            //checks if the button clicked
            if(ae.getSource()==insert)
            {
            	 try {
            		 DataBase db= new DataBase();    
      	        	 con=db.connect(); 
            		 preStatement = con.prepareStatement("insert into patient_visit (patient_name,visit_number,visit_note) values (?,?,?)");
            		 preStatement.setString(1, combo.getSelectedItem().toString()); //this replaces the 1st  "?" in the query for username
      	        	 preStatement.setString(2, t_number.getText());    //this replaces the 2st  "?" in the query for password
      	        	 preStatement.setString(3, visitNote.getText());
      	        	 preStatement.executeUpdate();
       	             JOptionPane.showMessageDialog(null, "You have inserted patient visit info sucessfully","Success",
                             JOptionPane.INFORMATION_MESSAGE);
       	           preStatement.close();
       	           t_number.setText("");
       	           visitNote.setText("");
     	           
     	        } catch (Exception e) {
     	            // TODO Auto-generated catch block
     	            JOptionPane.showMessageDialog(null, "error in inserting patient visit info","Failed!!",
                           JOptionPane.ERROR_MESSAGE);
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
            }//if
        }//method
 
    }//inner class

}
