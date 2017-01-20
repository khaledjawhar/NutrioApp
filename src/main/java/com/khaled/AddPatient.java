package com.khaled;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AddPatient extends JFrame{
	 JButton insert;
	 JLabel l_name,l_address,l_phone,l_medicalHistory,l_medications,l_supplements,l_allergies,l_previousDiets,l_workOccupation;
	 JTextField t_name,t_address,t_phone,t_workOccupation;
	 JTextArea medicalHistory,medications,supplements;
	 JScrollPane scrollPaneMedicalhisotry,scrollPaneMedications,scrollPaneSupplements;
	 JRadioButton patient_allergies_yes,patient_allergies_no,patient_previousDiets_yes,patient_previousDiets_no;
	 ButtonGroup group_allergies,group_previousdiets;
	 handler handle;
	AddPatient()
	{
	     handle =new handler();
	     BasePanel panel=new BasePanel("src/main/resources/patient Records.jpg");
	     panel.setLayout(null);
		 medicalHistory = new JTextArea();
		 scrollPaneMedicalhisotry = new JScrollPane(medicalHistory); 
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
		 insert=new JButton("AddPAtient");
		 insert.addActionListener(handle);
		 t_name=new JTextField();
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
		 panel.setLayout(null);
		 l_name.setBounds(20, 25, 100, 25);
	     panel.add(l_name);
	     t_name.setBounds(124, 25, 200, 25);
	     panel.add(t_name);
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
	     l_allergies.setBounds(20, 120, 100, 30);
	     panel.add(l_allergies);
	     patient_allergies_yes.setBounds(124, 120, 100, 30);
	     patient_allergies_no.setBounds(240, 120, 100, 30);
	     panel.add(patient_allergies_yes);
	     panel.add(patient_allergies_no);
	     l_previousDiets.setBounds(20, 140, 100, 30);
	     panel.add(l_previousDiets);
	     patient_previousDiets_yes.setBounds(124, 140, 100, 30);
	     patient_previousDiets_no.setBounds(240, 140, 100, 30);
	     panel.add(patient_previousDiets_yes);
	     panel.add(patient_previousDiets_no);
	     l_medicalHistory.setBounds(20, 185, 100, 30);
	     panel.add(l_medicalHistory);
	     scrollPaneMedicalhisotry.setBounds(124, 185, 600, 200);
	     panel.add(scrollPaneMedicalhisotry);
	     l_medications.setBounds(20, 400, 100, 20);
	     panel.add(l_medications);
	     scrollPaneMedications.setBounds(124, 400, 600, 100);
	     panel.add(scrollPaneMedications);
	     l_supplements.setBounds(20, 595, 100, 20);
	     panel.add(l_supplements);
	     scrollPaneSupplements.setBounds(124, 595, 600, 100);
	     panel.add(scrollPaneSupplements);
	     insert.setBounds(400, 25, 100, 20);
	     panel.add(insert);
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
            if(ae.getSource()==insert)
            {
            	 try {
            		String patient_allergies,patient_previousDiets; 
     	        	DataBase db= new DataBase();    
     	        	con=db.connect(); 
     	        	if(patient_allergies_yes.isSelected())
     	        		patient_allergies=patient_allergies_yes.getText();
     	        	else
     	        		patient_allergies=patient_allergies_no.getText();
     	        	if(patient_previousDiets_yes.isSelected())
     	        		patient_previousDiets=patient_previousDiets_yes.getText();
     	        	else
     	        		patient_previousDiets=patient_previousDiets_no.getText();
     	        	preStatement = con.prepareStatement("insert into patient (patient_name,patient_address,patient_phone,patient_medicalhistory,patient_workoccupation,patient_allergies,patient_previousdiets,patient_medications,patient_supplements) values (?,?,?,?,?,?,?,?,?)");
     	        	preStatement.setString(1, t_name.getText()); //this replaces the 1st  "?" in the query for username
     	        	preStatement.setString(2, t_address.getText());    //this replaces the 2st  "?" in the query for password
     	        	preStatement.setString(3, t_phone.getText());
     	        	preStatement.setString(4, medicalHistory.getText());
     	        	preStatement.setString(5, t_workOccupation.getText());     	 
     	        	preStatement.setString(6, patient_allergies); 
     	        	preStatement.setString(7, patient_previousDiets); 
     	        	preStatement.setString(8, medications.getText());
     	        	preStatement.setString(9, supplements.getText());
     	        	//executes the prepared statement
     	            preStatement.executeUpdate();
     	           JOptionPane.showMessageDialog(null, "You have inserted patient info sucessfully","Success",
                           JOptionPane.INFORMATION_MESSAGE);
     	           preStatement.close();
     	           t_name.setText("");
    	           t_address.setText("");
    	           t_phone.setText("");
    	           medicalHistory.setText("");
    	           t_workOccupation.setText("");
    	           medications.setText("");
    	           supplements.setText("");
     	           
     	        } catch (Exception e) {
     	            // TODO Auto-generated catch block
     	            JOptionPane.showMessageDialog(null, "error in inserting patient info","Failed!!",
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
