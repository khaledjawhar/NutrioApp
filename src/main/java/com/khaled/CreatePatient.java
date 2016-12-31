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
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CreatePatient extends JFrame{
	 JButton insert;
	 JLabel l_name,l_address,l_phone,l_medicalHistory,l_medications,l_supplements,l_allergies,l_previousDiets,l_workOccupation;
	 JTextField t_name,t_address,t_phone,t_workOccupation;
	 JTextArea medicalHisotry,medications,supplements;
	 JScrollPane scrollPaneMedicalhisotry,scrollPaneMedications,scrollPaneSupplements;
	 JRadioButton patient_allergies_yes,patient_allergies_no,patient_previousDiets_yes,patient_previousDiets_no;
	 ButtonGroup group_allergies,group_previousdiets;
	 handler handle;
	CreatePatient()
	{
	     handle =new handler();
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
		 insert=new JButton("Create");
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
		 setLayout(null);
		 l_name.setBounds(20, 20, 100, 20);
	     add(l_name);
	     t_name.setBounds(124, 25, 200, 20);
	     add(t_name);
	     l_address.setBounds(20, 40, 100, 20);
	     add(l_address);
	     t_address.setBounds(124, 45, 200, 20);
	     add(t_address);
	     l_phone.setBounds(20, 60, 100, 20);
	     add(l_phone);
	     t_phone.setBounds(124, 65, 200, 20);
	     add(t_phone);
	     l_workOccupation.setBounds(20, 80, 100, 20);
	     add(l_workOccupation);
	     t_workOccupation.setBounds(124, 85, 200, 20);
	     add(t_workOccupation);
	     l_allergies.setBounds(20, 110, 100, 20);
	     add(l_allergies);
	     patient_allergies_yes.setBounds(124, 110, 100, 20);
	     patient_allergies_no.setBounds(240, 110, 100, 20);
	     add(patient_allergies_yes);
	     add(patient_allergies_no);
	     l_previousDiets.setBounds(20, 130, 100, 20);
	     add(l_previousDiets);
	     patient_previousDiets_yes.setBounds(124, 130, 100, 20);
	     patient_previousDiets_no.setBounds(240, 130, 100, 20);
	     add(patient_previousDiets_yes);
	     add(patient_previousDiets_no);
	     l_medicalHistory.setBounds(20, 175, 100, 20);
	     add(l_medicalHistory);
	     scrollPaneMedicalhisotry.setBounds(124, 175, 600, 200);
	     add(scrollPaneMedicalhisotry);
	     l_medications.setBounds(20, 400, 100, 20);
	     add(l_medications);
	     scrollPaneMedications.setBounds(124, 400, 600, 100);
	     add(scrollPaneMedications);
	     l_supplements.setBounds(20, 595, 100, 20);
	     add(l_supplements);
	     scrollPaneSupplements.setBounds(124, 595, 600, 100);
	     add(scrollPaneSupplements);
	     insert.setBounds(400, 25, 100, 20);
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
     	        	preStatement.setString(4, medicalHisotry.getText());
     	        	preStatement.setString(5, t_workOccupation.getText());     	 
     	        	preStatement.setString(6, patient_allergies); 
     	        	preStatement.setString(7, patient_previousDiets); 
     	        	preStatement.setString(8, medications.getText());
     	        	preStatement.setString(9, supplements.getText());
     	        	//executes the prepared statement
     	            preStatement.executeUpdate();
     	           
     	        } catch (Exception e) {
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
            }//if
        }//method
 
    }//inner class

}
