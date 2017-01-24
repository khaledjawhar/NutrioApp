package com.khaled;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
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

public class EditVisitInfo  extends JFrame{
	 JButton view,update,delete;
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
	 EditVisitInfo()
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
	     //BasePanel panel=new BasePanel("src/main/resources/patient Records.jpg");
	     InputStream image = this.getClass().getClassLoader().getResourceAsStream("patient Records.jpg");
	     BasePanel panel=new BasePanel(image);
	     panel.setLayout(null);
	     visitNote = new JTextArea();
		 scrollPaneVisitNote = new JScrollPane(visitNote); 
		 view=new JButton("View Visit Info");
		 view.addActionListener(handle);
		 update=new JButton("Update Visit Info");
		 update.addActionListener(handle);
		 delete=new JButton("Delete Visit Info");
		 delete.addActionListener(handle);
		 l_name=new JLabel("Patient Name");
		 l_number=new JLabel("Visit Number");
		 l_note=new JLabel("Visit Note");
		 t_number=new JTextField();
		 searchable = new StringSearchable(myWords);
		 combo = new AutocompleteJComboBox(searchable);
		 l_name.setBounds(20, 25, 100, 20);
	     panel.add(l_name);
	     combo.setBounds(124, 25, 200, 30);
	     panel.add(combo);
	     l_number.setBounds(20, 65, 100, 20);
	     panel.add(l_number);
	     t_number.setBounds(124, 65, 200, 30);
	     panel.add(t_number);
	     l_note.setBounds(20, 95, 100, 20);
	     panel.add(l_note);
	     scrollPaneVisitNote.setBounds(124, 95, 600, 200);
	     panel.add(scrollPaneVisitNote);
	     view.setBounds(400, 25, 150, 20);
	     panel.add(view);
	     delete.setBounds(600, 25, 150, 20);
	     panel.add(delete);
	     update.setBounds(800, 25, 150, 20);
	     panel.add(update);
	     add(panel);
	     setTitle("Nutrio App");
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
            if(ae.getSource()==view)
            {
            	 try {
            		 DataBase db= new DataBase();    
         			 con=db.connect(); 
         			 preStatement = con.prepareStatement("SELECT * FROM nutriodb.patient_visit where patient_name=? and visit_number=?");
         			 preStatement.setString(1,combo.getSelectedItem().toString());
         			 preStatement.setString(2,t_number.getText().toString());
         			 rs=preStatement.executeQuery();
         	         if(rs.next())
         	         {
         	        	visitNote.setText(rs.getString("visit_note"));
         	         }
            		
     	           
     	        } catch (Exception e) {
     	            // TODO Auto-generated catch block
     	            JOptionPane.showMessageDialog(null, "error in pulling patient info","Failed!!",
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
            
          //checks if the button clicked
            if(ae.getSource()==update)
            {
            	 try {
            		 DataBase db= new DataBase();    
        			 con=db.connect(); 
        			 preStatement = con.prepareStatement("UPDATE nutriodb.patient_visit SET visit_number=?,visit_note=? WHERE patient_name=?");
        			 preStatement.setString(1, t_number.getText());    //this replaces the 2st  "?" in the query for password
       	        	 preStatement.setString(2, visitNote.getText());
       	        	 preStatement.setString(3, combo.getSelectedItem().toString());
      	        	 preStatement.executeUpdate();
      	        	 JOptionPane.showMessageDialog(null, "You have updated patient visit info sucessfully","Success",
                             JOptionPane.INFORMATION_MESSAGE);
      	        	preStatement.close();
     	        } catch (Exception e) {
     	            // TODO Auto-generated catch block
     	            JOptionPane.showMessageDialog(null, "error in updating patient visit info","Failed!!",
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
            
          //checks if the button clicked
            if(ae.getSource()==delete)
            {
            	 try {
            		 DataBase db= new DataBase();    
        			 con=db.connect(); 
        			 preStatement = con.prepareStatement("DELETE FROM nutriodb.patient_visit where patient_name=?");
        			 preStatement.setString(1,combo.getSelectedItem().toString());
        			 preStatement.executeUpdate();
        			 t_number.setText("");
          	         visitNote.setText("");
        			 JOptionPane.showMessageDialog(null, "You have deleted patient visit info sucessfully","Success",
                             JOptionPane.INFORMATION_MESSAGE);
            		
     	           
     	        } catch (Exception e) {
     	            // TODO Auto-generated catch block
     	            JOptionPane.showMessageDialog(null, "error in deleting patient visit info","Failed!!",
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
