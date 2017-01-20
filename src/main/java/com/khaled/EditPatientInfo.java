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

public class EditPatientInfo extends JFrame{
	 JButton view,delete,update;
	 StringSearchable searchable;
	 AutocompleteJComboBox combo; 
	 JLabel l_name,l_address,l_phone,l_medicalHistory,l_medications,l_supplements,l_allergies,l_previousDiets,l_workOccupation;
	 JTextField t_address,t_phone,t_workOccupation;
	 JTextArea medicalHisotry,medications,supplements;
	 JScrollPane scrollPaneMedicalhisotry,scrollPaneMedications,scrollPaneSupplements;
	 JRadioButton patient_allergies_yes,patient_allergies_no,patient_previousDiets_yes,patient_previousDiets_no;
	 ButtonGroup group_allergies,group_previousdiets;
	 handler handle;
	 Connection con;
 	 PreparedStatement preStatement; 
 	 ResultSet rs; 

	EditPatientInfo()
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
	     BasePanel panel=new BasePanel("src/main/resources/patient Records.jpg");
	     panel.setLayout(null);
		 medicalHisotry = new JTextArea();
		 scrollPaneMedicalhisotry = new JScrollPane(medicalHisotry); 
		 medications = new JTextArea();
		 scrollPaneMedications = new JScrollPane(medications); 
		 supplements = new JTextArea();
		 scrollPaneSupplements = new JScrollPane(supplements); 
		 patient_allergies_yes = new JRadioButton("Yes");
		 patient_allergies_no = new JRadioButton("No");
		 patient_previousDiets_yes = new JRadioButton("Yes");
		 patient_previousDiets_no = new JRadioButton("No");
		 group_allergies = new ButtonGroup();
		 group_allergies.add(patient_allergies_yes);
		 group_allergies.add(patient_allergies_no);
		 group_previousdiets = new ButtonGroup();
		 group_previousdiets.add(patient_previousDiets_yes);
		 group_previousdiets.add(patient_previousDiets_no);
		 view=new JButton("View patient info");
		 view.addActionListener(handle);
		 delete=new JButton("Delete patient info");
		 delete.addActionListener(handle);
		 update=new JButton("Update patient info");
		 update.addActionListener(handle);
		 searchable = new StringSearchable(myWords);
		 combo = new AutocompleteJComboBox(searchable);
		 t_address=new JTextField();
		 t_phone=new JTextField();
		 t_workOccupation=new JTextField();
		 l_name=new JLabel("Patient Name");
		 l_address=new JLabel("Patient Address");
		 l_phone=new JLabel("Patient Phone");
		 l_workOccupation=new JLabel("Work Occupation");
		 l_medicalHistory=new JLabel("Medical History");
		 l_medications=new JLabel("Medications");
		 l_supplements=new JLabel("Supplements");
		 l_allergies=new JLabel("Allergies");
		 l_previousDiets=new JLabel("Previous Diets");
		 l_name.setBounds(20, 20, 100, 25);
	     panel.add(l_name);
	     combo.setBounds(124, 25, 200, 25);
	     panel.add(combo);
	     l_address.setBounds(20, 50, 100, 25);
	     panel.add(l_address);
	     t_address.setBounds(124, 50, 200, 25);
	     panel.add(t_address);
	     l_phone.setBounds(20, 75, 100, 25);
	     panel.add(l_phone);
	     t_phone.setBounds(124, 75, 200, 25);
	     panel.add(t_phone);
	     l_workOccupation.setBounds(20, 100, 100, 25);
	     panel.add(l_workOccupation);
	     t_workOccupation.setBounds(124, 100, 200, 25);
	     panel.add(t_workOccupation);
	     l_allergies.setBounds(20, 125, 100, 20);
	     panel.add(l_allergies);
	     patient_allergies_yes.setBounds(124, 125, 100, 20);
	     patient_allergies_no.setBounds(240, 125, 100, 20);
	     panel.add(patient_allergies_yes);
	     panel.add(patient_allergies_no);
	     l_previousDiets.setBounds(20, 145, 100, 20);
	     panel.add(l_previousDiets);
	     patient_previousDiets_yes.setBounds(124, 145, 100, 20);
	     patient_previousDiets_no.setBounds(240, 145, 100, 20);
	     panel.add(patient_previousDiets_yes);
	     panel.add(patient_previousDiets_no);
	     l_medicalHistory.setBounds(20, 185, 100, 20);
	     panel.add(l_medicalHistory);
	     scrollPaneMedicalhisotry.setBounds(124, 185, 600, 200);
	     panel.add(scrollPaneMedicalhisotry);
	     l_medications.setBounds(20, 410, 100, 20);
	     panel.add(l_medications);
	     scrollPaneMedications.setBounds(124, 410, 600, 100);
	     panel.add(scrollPaneMedications);
	     l_supplements.setBounds(20, 590, 100, 20);
	     panel.add(l_supplements);
	     scrollPaneSupplements.setBounds(124, 590, 600, 100);
	     panel.add(scrollPaneSupplements);
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
         			 preStatement = con.prepareStatement("SELECT * FROM nutriodb.patient where patient_name=?");
         			 preStatement.setString(1,combo.getSelectedItem().toString());
         			 rs=preStatement.executeQuery();
         	         if(rs.next())
         	         {
         	        	t_address.setText(rs.getString("patient_address"));
         	        	t_phone.setText(rs.getString("patient_phone"));
         	        	t_workOccupation.setText(rs.getString("patient_workoccupation"));
         	        	medicalHisotry.setText(rs.getString("patient_medicalhistory"));
         	        	medications.setText(rs.getString("patient_medications"));
         	        	supplements.setText(rs.getString("patient_supplements"));
         	        	if(rs.getString("patient_previousdiets").equals("Yes"))
         	        		patient_previousDiets_yes.setSelected(true);
         	        	else
         	        		patient_previousDiets_no.setSelected(true);
         	        	if(rs.getString("patient_allergies").equals("Yes"))
         	        		patient_allergies_yes.setSelected(true);
         	        	else
         	        		patient_allergies_no.setSelected(true);
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
            if(ae.getSource()==delete)
            {
            	try {
           		     DataBase db= new DataBase();    
        			 con=db.connect(); 
        			 preStatement = con.prepareStatement("DELETE FROM nutriodb.patient where patient_name=?");
        			 preStatement.setString(1,combo.getSelectedItem().toString());
        			 preStatement.executeUpdate();
      	             t_address.setText("");
      	             t_phone.setText("");
      	             medicalHisotry.setText("");
      	             t_workOccupation.setText("");
      	             medications.setText("");
      	             supplements.setText("");
        			 JOptionPane.showMessageDialog(null, "You have deleted patient info sucessfully","Success",
                             JOptionPane.INFORMATION_MESSAGE);
    	        } catch (Exception e) {
    	            // TODO Auto-generated catch block
    	        	 JOptionPane.showMessageDialog(null, "error in deleting patient info","Failed!!",
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
            	     String patient_allergies,patient_previousDiets;	
           		     DataBase db= new DataBase();    
        			 con=db.connect(); 
        			 preStatement = con.prepareStatement("UPDATE nutriodb.patient SET patient_address=?,patient_phone=?,patient_medicalhistory=?,patient_workoccupation=?,patient_allergies=?,patient_previousdiets=?,patient_medications=?,patient_supplements=? WHERE patient_name=?");
        			 if(patient_allergies_yes.isSelected())
      	        		patient_allergies=patient_allergies_yes.getText();
      	        	else
      	        		patient_allergies=patient_allergies_no.getText();
      	        	if(patient_previousDiets_yes.isSelected())
      	        		patient_previousDiets=patient_previousDiets_yes.getText();
      	        	else
      	        		patient_previousDiets=patient_previousDiets_no.getText();
      	        	preStatement.setString(1, t_address.getText());    //this replaces the 2st  "?" in the query for password
      	        	preStatement.setString(2, t_phone.getText());
      	        	preStatement.setString(3, medicalHisotry.getText());
      	        	preStatement.setString(4, t_workOccupation.getText());     	 
      	        	preStatement.setString(5, patient_allergies); 
      	        	preStatement.setString(6, patient_previousDiets); 
      	        	preStatement.setString(7, medications.getText());
      	        	preStatement.setString(8, supplements.getText()); 
      	        	preStatement.setString(9, combo.getSelectedItem().toString());
      	        	preStatement.executeUpdate();
      	        	 JOptionPane.showMessageDialog(null, "You have updated patient info sucessfully","Success",
                             JOptionPane.INFORMATION_MESSAGE);
      	        	preStatement.close();
    	        } catch (Exception e) {
    	            // TODO Auto-generated catch block
    	        	 JOptionPane.showMessageDialog(null, "error in updating patient info","Failed!!",
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
