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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import com.khaled.FoodRecall.handler;

public class AnthroPometricsNutrients extends JFrame{
	Connection con;
 	PreparedStatement preStatement;
 	ResultSet rs; 
 	StringSearchable searchable;
 	handler handle;
 	AutocompleteJComboBox combo;
 	JComboBox paCombo;
 	JLabel l_paType,l_patient_name,l_age,l_height,l_weight,l_bmi,l_pa_coefficient,l_gender,l_totalCalories,l_totalFat,l_totalCarbohydrate,l_totalProtein,l_calorieLimit,l_fatLimit,l_carbohydrateLimit,l_proteinLimit,l_deficiencyInCalories;
 	JTextField t_age,t_height,t_weight,t_bmi,t_pa_coefficient,t_totalCalories,t_totalFat,t_totalCarbohydrate,t_totalProtein,t_calorieLimit,t_fatLimit,t_carbohydrateLimit,t_proteinLimit,t_deficiencyInCalories;
 	JRadioButton patient_gender_male,patient_gender_female;
 	JButton calculatePACoefficient,insert,view;
	AnthroPometricsNutrients()
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
	     //BasePanel panel=new BasePanel("src/main/resources/foodrecall.png");
	     InputStream image =this.getClass().getClassLoader().getResourceAsStream("patient Records.jpg");
		 BasePanel panel=new BasePanel(image);
	     panel.setLayout(null);
	     searchable = new StringSearchable(myWords);
	     combo = new AutocompleteJComboBox(searchable);
	     l_patient_name=new JLabel("Patient Name");
		 l_patient_name.setBounds(20, 30, 100, 30);
	     panel.add(l_patient_name);
	     combo.setBounds(124, 30, 210, 30);
	     panel.add(combo);
	     l_age=new JLabel("Age");
	     l_age.setBounds(20,65,100,30);
	     panel.add(l_age);
	     t_age=new JTextField();
	     t_age.setBounds(124,65,100,30);
	     panel.add(t_age);
	     l_height=new JLabel("Height Meter");
	     l_height.setBounds(20,110,100,30);
	     panel.add(l_height);
	     t_height=new JTextField();
	     t_height.setBounds(124,110,100,30);
	     panel.add(t_height);
	     l_weight=new JLabel("Weight KG");
	     l_weight.setBounds(20,145,100,30);
	     panel.add(l_weight);
	     t_weight=new JTextField();
	     t_weight.setBounds(124,145,100,30);
	     panel.add(t_weight);
	     l_gender=new JLabel("Gender");
	     l_gender.setBounds(20, 180, 100, 30);
	     panel.add(l_gender);
	     patient_gender_male = new JRadioButton("Male");
	     patient_gender_female = new JRadioButton("Female");
	     patient_gender_male.setBounds(124, 180, 100, 30);
	     patient_gender_female.setBounds(240, 180, 100, 30);
	     panel.add(patient_gender_male);
	     panel.add(patient_gender_female);
	     l_paType=new JLabel("PA Type");
	     l_paType.setBounds(20,215,100,30);
	     panel.add(l_paType);
	     paCombo=new JComboBox();
	     paCombo.setBounds(124,215,150,30);
	     panel.add(paCombo);
	     l_bmi=new JLabel("BMI");
	     l_bmi.setBounds(20,250,100,30);
	     panel.add(l_bmi);
	     t_bmi=new JTextField();
	     t_bmi.setBounds(124,250,100,30);
	     panel.add(t_bmi);
	     l_pa_coefficient=new JLabel("PA Coefficient");
	     l_pa_coefficient.setBounds(20,285,100,30);
	     panel.add(l_pa_coefficient);
	     t_pa_coefficient=new JTextField();
	     t_pa_coefficient.setBounds(124,285,100,30);
	     panel.add(t_pa_coefficient);
	     calculatePACoefficient=new JButton("Calculate PA Coefficient/BMI");
	     calculatePACoefficient.setBounds(20,320 ,200 ,30);
	     panel.add(calculatePACoefficient);
	     insert=new JButton("Insert Data");
	     insert.setBounds(250,320,100 ,30);
	     panel.add(insert);
	     l_totalCalories=new JLabel("Total Calories");
	     l_totalCalories.setBounds(400, 30, 150, 30);
	     panel.add(l_totalCalories);
	     t_totalCalories=new JTextField();
	     t_totalCalories.setBounds(570, 30, 150, 30);
	     panel.add(t_totalCalories);
	     l_calorieLimit=new JLabel("Calories Limit");
	     l_calorieLimit.setBounds(740, 30, 150, 30);
	     panel.add(l_calorieLimit);
	     t_calorieLimit=new JTextField();
	     t_calorieLimit.setBounds(910, 30, 150, 30);
	     panel.add(t_calorieLimit);	     
	     l_totalFat=new JLabel("Total Fat");
	     l_totalFat.setBounds(400, 80, 150, 30);
	     panel.add(l_totalFat);
	     t_totalFat=new JTextField();
	     t_totalFat.setBounds(570, 80, 150, 30);
	     panel.add(t_totalFat);
	     l_fatLimit=new JLabel("Fat Limit");
	     l_fatLimit.setBounds(740, 80, 150, 30);
	     panel.add(l_fatLimit);
	     t_fatLimit=new JTextField();
	     t_fatLimit.setBounds(910, 80, 150, 30);
	     panel.add(t_fatLimit);	     
	     l_totalCarbohydrate=new JLabel("Total Carbohydrate");
	     l_totalCarbohydrate.setBounds(400, 130, 150, 30);
	     panel.add(l_totalCarbohydrate);
	     t_totalCarbohydrate=new JTextField();
	     t_totalCarbohydrate.setBounds(570, 130, 150, 30);
	     panel.add(t_totalCarbohydrate);
	     l_carbohydrateLimit=new JLabel("Carbohydrate Limit");
	     l_carbohydrateLimit.setBounds(740, 130, 150, 30);
	     panel.add(l_carbohydrateLimit);
	     t_carbohydrateLimit=new JTextField();
	     t_carbohydrateLimit.setBounds(910, 130, 150, 30);
	     panel.add(t_carbohydrateLimit);	     
	     l_totalProtein=new JLabel("Total Protein");
	     l_totalProtein.setBounds(400, 180, 150, 30);
	     panel.add(l_totalProtein);
	     t_totalProtein=new JTextField();
	     t_totalProtein.setBounds(570, 180, 150, 30);
	     panel.add(t_totalProtein);
	     l_proteinLimit=new JLabel("Protein Limit");
	     l_proteinLimit.setBounds(740, 180, 150, 30);
	     panel.add(l_proteinLimit);
	     t_proteinLimit=new JTextField();
	     t_proteinLimit.setBounds(910, 180, 150, 30);
	     panel.add(t_proteinLimit);     
	     l_deficiencyInCalories=new JLabel("Deficiency In Calories");
	     l_deficiencyInCalories.setBounds(400, 230, 150, 30);
	     panel.add(l_deficiencyInCalories);
	     t_deficiencyInCalories=new JTextField();
	     t_deficiencyInCalories.setBounds(570, 230, 150, 30);
	     panel.add(t_deficiencyInCalories);
	     view=new JButton("View Pometrics Nutrients");
	     view.setBounds(620,300 ,200 ,30);
	     panel.add(view);
	     setTitle("Nutrio App");
		 add(panel);
		 setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	     setExtendedState(JFrame.MAXIMIZED_BOTH); 
		 setJMenuBar(new PatientMenu());
		 setVisible(true);
	}
	
	  class handler implements ActionListener
	    {
	    	Connection con;
	    	PreparedStatement preStatement; 
	    	

	        //must implement method
	        //This is triggered whenever the user clicks the login button
	        public void actionPerformed(ActionEvent ae)
	        {
	        	if(ae.getSource()==calculatePACoefficient)
	             {
	        		 
	             }
	        	
	        	else if(ae.getSource()==insert)
	             {
	        		 
	             }
	        	
	        	else if(ae.getSource()==view)
	             {
	        		 
	             }
	             
	        	
	        }
	    }
	        

}
