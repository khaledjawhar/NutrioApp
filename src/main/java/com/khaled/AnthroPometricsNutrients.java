package com.khaled;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.math.BigDecimal;
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
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.apache.commons.lang3.StringUtils;

import com.khaled.FoodRecall.handler;

public class AnthroPometricsNutrients extends JFrame{
	Connection con;
 	PreparedStatement preStatement;
 	ResultSet rs; 
 	StringSearchable searchable;
 	handler handle;
 	AutocompleteJComboBox combo;
 	JComboBox paCombo;
 	JLabel l_foodrecallnumber,l_paType,l_patient_name,l_age,l_height,l_weight,l_bmi,l_pa_coefficient,l_gender,l_totalCalories,l_totalFat,l_totalCarbohydrate,l_totalProtein,l_calorieLimit,l_fatLimit,l_carbohydrateLimit,l_proteinLimit,l_deficiencyInCalories;
 	JTextField t_foodrecallnumber,t_age,t_height,t_weight,t_bmi,t_pa_coefficient,t_totalCalories,t_totalFat,t_totalCarbohydrate,t_totalProtein,t_calorieLimit,t_fatLimit,t_carbohydrateLimit,t_proteinLimit,t_deficiencyInCalories;
 	JRadioButton patient_gender_male,patient_gender_female;
 	JButton calculatePACoefficient,insert,view;
    public static float round(float d, int decimalPlace) {
        return BigDecimal.valueOf(d).setScale(decimalPlace,BigDecimal.ROUND_HALF_UP).floatValue();
   }
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
	     l_foodrecallnumber=new JLabel("Food Recall Number");
	     l_foodrecallnumber.setBounds(20,65, 200, 30);
	     panel.add(l_foodrecallnumber);	     
	     t_foodrecallnumber=new JTextField();
	     t_foodrecallnumber.setBounds(180,65, 100, 30);
	     panel.add(t_foodrecallnumber);
	     l_age=new JLabel("Age");
	     l_age.setBounds(20,110,100,30);
	     panel.add(l_age);
	     t_age=new JTextField();
	     t_age.setBounds(124,110,100,30);
	     panel.add(t_age);
	     l_height=new JLabel("Height In Meter");
	     l_height.setBounds(20,145,100,30);
	     panel.add(l_height);
	     t_height=new JTextField();
	     t_height.setBounds(124,145,100,30);
	     panel.add(t_height);
	     l_weight=new JLabel("Weight In KG");
	     l_weight.setBounds(20,180,100,30);
	     panel.add(l_weight);
	     t_weight=new JTextField();
	     t_weight.setBounds(124,180,100,30);
	     panel.add(t_weight);
	     l_gender=new JLabel("Gender");
	     l_gender.setBounds(20, 215, 100, 30);
	     panel.add(l_gender);
	     patient_gender_male = new JRadioButton("Male");
	     patient_gender_female = new JRadioButton("Female");
	     patient_gender_male.setBounds(124, 215, 100, 30);
	     patient_gender_female.setBounds(240, 215, 100, 30);
	     panel.add(patient_gender_male);
	     panel.add(patient_gender_female);
	     l_paType=new JLabel("PA Type");
	     l_paType.setBounds(20,250,100,30);
	     panel.add(l_paType);
	     paCombo=new JComboBox();
	     paCombo.addItem("Sedentary");
		 paCombo.addItem("Low Active");
		 paCombo.addItem("Active");
		 paCombo.addItem("Very Active");
	     paCombo.setBounds(124,250,150,30);
	     panel.add(paCombo);
	     l_bmi=new JLabel("BMI");
	     l_bmi.setBounds(20,285,100,30);
	     panel.add(l_bmi);
	     t_bmi=new JTextField();
	     t_bmi.setBounds(124,285,100,30);
	     panel.add(t_bmi);
	     l_pa_coefficient=new JLabel("PA Coefficient");
	     l_pa_coefficient.setBounds(20,320,100,30);
	     panel.add(l_pa_coefficient);
	     t_pa_coefficient=new JTextField();
	     t_pa_coefficient.setBounds(124,320,100,30);
	     panel.add(t_pa_coefficient);
	     calculatePACoefficient=new JButton("Calculate BMI/PA Coefficient");
	     calculatePACoefficient.setBounds(20,355 ,200 ,30);
	     panel.add(calculatePACoefficient);
	     insert=new JButton("Insert Data");
	     insert.setBounds(250,355,100 ,30);
	     panel.add(insert);
	     l_totalCalories=new JLabel("Total Calories");
	     l_totalCalories.setBounds(400, 30, 150, 30);
	     panel.add(l_totalCalories);
	     t_totalCalories=new JTextField();
	     t_totalCalories.setBounds(570, 30, 150, 30);
	     panel.add(t_totalCalories);
	     l_calorieLimit=new JLabel("Daily Calories");
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
	     l_fatLimit=new JLabel("Fat Range");
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
	     l_carbohydrateLimit=new JLabel("Carbohydrate Range");
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
	     l_proteinLimit=new JLabel("Protein Range");
	     l_proteinLimit.setBounds(740, 180, 150, 30);
	     panel.add(l_proteinLimit);
	     t_proteinLimit=new JTextField();
	     t_proteinLimit.setBounds(910, 180, 150, 30);
	     panel.add(t_proteinLimit);     
	     l_deficiencyInCalories=new JLabel("Deficiency In Calories in format [+/-] value");
	     l_deficiencyInCalories.setBounds(400, 230, 250, 30);
	     panel.add(l_deficiencyInCalories);
	     t_deficiencyInCalories=new JTextField();
	     t_deficiencyInCalories.setBounds(700, 230, 150, 30);
	     panel.add(t_deficiencyInCalories);
	     view=new JButton("View Anthropometrics & Nutrients");
	     view.setBounds(620,300 ,230 ,30);
	     panel.add(view);
	     insert.addActionListener(handle);
	     calculatePACoefficient.addActionListener(handle);
	     view.addActionListener(handle);
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
	        		 if(t_weight.getText().toString().equals("")){
            			 JOptionPane.showMessageDialog(null, "You must insert the weight","Success",
                                 JOptionPane.INFORMATION_MESSAGE);
            			 return;
            		 }
            		 if(t_height.getText().toString().equals("")){
            			 JOptionPane.showMessageDialog(null, "You must insert the height","Success",
                                 JOptionPane.INFORMATION_MESSAGE);
            			 return;
            		 }
            		 if(t_age.getText().toString().equals("")){
            			 JOptionPane.showMessageDialog(null, "You must insert the age","Success",
                                 JOptionPane.INFORMATION_MESSAGE);
            			 return;
            		 }
            		 if(!patient_gender_female.isSelected()&&!patient_gender_male.isSelected()){
            			 JOptionPane.showMessageDialog(null, "You must choose the gender","Success",
                                 JOptionPane.INFORMATION_MESSAGE);
            			 return;
            		 }
	        		float weight=Float.parseFloat(t_weight.getText().toString());
	        		float height=Float.parseFloat(t_height.getText().toString());
	        		float bmi=weight/height;
	        		float value=0;
	        		t_bmi.setText(Float.toString(bmi));
	        		 if(patient_gender_male.isSelected())
	        		 {
	        			 if(paCombo.getSelectedItem().toString().equals("Sedentary")){
	        				 t_pa_coefficient.setText("1");
	        			 }
	        			 else if(paCombo.getSelectedItem().toString().equals("Low Active")){
	        				 t_pa_coefficient.setText("1.11");
	        			 }
	        			 else if(paCombo.getSelectedItem().toString().equals("Active")){
	        				 t_pa_coefficient.setText("1.25");
	        			 }
	        			 else if(paCombo.getSelectedItem().toString().equals("Very Active")){
	        				 t_pa_coefficient.setText("1.48");
	        			 }
	        			 value=(float) ((662-(9.53*Float.parseFloat(t_age.getText().toString())))+(Float.parseFloat(t_pa_coefficient.getText().toString())*((15.91*weight)+(539.6*height))));
	        			 t_calorieLimit.setText(Float.toString(value));
	        		 }
	        		 
	        		 if(patient_gender_female.isSelected())
	        		 {
	        			 if(paCombo.getSelectedItem().toString().equals("Sedentary")){
	        				 t_pa_coefficient.setText("1");
	        			 }
	        			 else if(paCombo.getSelectedItem().toString().equals("Low Active")){
	        				 t_pa_coefficient.setText("1.12");
	        			 }
	        			 else if(paCombo.getSelectedItem().toString().equals("Active")){
	        				 t_pa_coefficient.setText("1.27");
	        			 }
	        			 else if(paCombo.getSelectedItem().toString().equals("Very Active")){
	        				 t_pa_coefficient.setText("1.45");
	        			 }
	        			 value=(float) ((354-(6.91*Float.parseFloat(t_age.getText().toString())))+(Float.parseFloat(t_pa_coefficient.getText().toString())*((9.36*weight)+(726*height))));
	        			 t_calorieLimit.setText(Float.toString(value));
	        		 }
	             }
	        	
	        	else if(ae.getSource()==insert)
	             {	        		 
        			 try {
        				 if( combo.getSelectedIndex() == -1){
                			 JOptionPane.showMessageDialog(null, "You must insert the name of the patient","Success",
                                     JOptionPane.INFORMATION_MESSAGE);
                			 return;
                		 }
                		 if(t_foodrecallnumber.getText().toString().equals("")){
                			 JOptionPane.showMessageDialog(null, "You must insert the food recall number","Success",
                                     JOptionPane.INFORMATION_MESSAGE);
                			 return;
                		 }
                		 if(t_weight.getText().toString().equals("")){
                			 JOptionPane.showMessageDialog(null, "You must insert the weight","Success",
                                     JOptionPane.INFORMATION_MESSAGE);
                			 return;
                		 }
                		 if(t_height.getText().toString().equals("")){
                			 JOptionPane.showMessageDialog(null, "You must insert the height","Success",
                                     JOptionPane.INFORMATION_MESSAGE);
                			 return;
                		 }
                		 if(t_age.getText().toString().equals("")){
                			 JOptionPane.showMessageDialog(null, "You must insert the age","Success",
                                     JOptionPane.INFORMATION_MESSAGE);
                			 return;
                		 }
                		 if(t_deficiencyInCalories.getText().toString().equals("")){
                			 JOptionPane.showMessageDialog(null, "Please enter a number for calorie deficiency or 0 otherwise","Success",
                                     JOptionPane.INFORMATION_MESSAGE);
                			 return;
                		 }
                		 if(!patient_gender_female.isSelected()&&!patient_gender_male.isSelected()){
                			 JOptionPane.showMessageDialog(null, "You must choose the gender","Success",
                                     JOptionPane.INFORMATION_MESSAGE);
                			 return;
                		 }
        				 float totalCalories=0;
        				 float totalCarbohydrate=0;
        				 float totalProtein=0;
        				 float totalFat=0;
        				 float calorieLimit=Float.parseFloat( t_calorieLimit.getText().toString());
        				 String deficiency=t_deficiencyInCalories.getText().toString();
        				 String patientGender="";
        				 String totalCarbohydrateLimit="";
        				 String totalProteinLimit="";
        				 String totalFatLimit="";
        				 if(deficiency.contains("+")){
        					 deficiency=deficiency.replace("+","");
        					 if(StringUtils.isNumeric(deficiency))
        						 calorieLimit+=Float.parseFloat(deficiency);
        				 }
        				 if(deficiency.contains("-")){
        					 deficiency=deficiency.replace("-","");
        					 if(StringUtils.isNumeric(deficiency))
        						 calorieLimit-=Float.parseFloat(deficiency);
        				 }      				 
        				 DataBase db= new DataBase();  
            			 con=db.connect(); 
            			 preStatement = con.prepareStatement("SELECT * FROM nutriodb.patient_descreption where patient_name=? and foodrecallnumber=?");
         	        	 preStatement.setString(1, combo.getSelectedItem().toString()); 
         	        	 preStatement.setString(2, t_foodrecallnumber.getText());    
         	             //executes the prepared statement
         	             rs=preStatement.executeQuery();
         	             if(rs.next())
         	             {
         	            	 JOptionPane.showMessageDialog(null, "The name with the chosen food recall number already exists","Success",
                                     JOptionPane.INFORMATION_MESSAGE);
                			 return;
         	             }
            			 preStatement = con.prepareStatement("SELECT * FROM nutriodb.patient_foodrecall where patient_name=? and foodrecall_number=?");
            			 preStatement.setString(1,combo.getSelectedItem().toString()); 
						 preStatement.setString(2,t_foodrecallnumber.getText());
						 rs=preStatement.executeQuery();
				         while(rs.next()){
				        	 totalCalories+=Float.parseFloat(rs.getString("food_calories"));
				        	 totalCarbohydrate+=Float.parseFloat(rs.getString("food_carbohydrate"));
				        	 totalProtein+=Float.parseFloat(rs.getString("food_protein"));
				        	 totalFat+=Float.parseFloat(rs.getString("food_fat"));
				         }
				         if(patient_gender_male.isSelected())
				        	 patientGender=patient_gender_male.getText();
		     	         else if(patient_gender_female.isSelected())
		     	        	 patientGender=patient_gender_female.getText();
				         t_totalCalories.setText(Float.toString(totalCalories));
				         t_totalFat.setText(Float.toString(totalFat));
				         t_totalCarbohydrate.setText(Float.toString(totalCarbohydrate));
				         t_totalProtein.setText(Float.toString(totalProtein));	
				         totalCarbohydrateLimit=Float.toString(round(((float)((calorieLimit*0.45)/4)),2))+"-"+Float.toString(round(((float)((calorieLimit*0.65)/4)),2));
				         totalProteinLimit=Float.toString(round(((float)((calorieLimit*0.1)/4)),2))+"-"+Float.toString(round(((float)((calorieLimit*0.35)/4)),2));
				         totalFatLimit=Float.toString(round(((float)((calorieLimit*0.2)/4)),2))+"-"+Float.toString(round(((float)((calorieLimit*0.35)/4)),2));
				         preStatement = con.prepareStatement("insert into patient_descreption (patient_name,patient_bmi,patient_fat_limit,patient_calorie_limit,patient_carbohydrate_limit,patient_total_fat,patient_total_calorie,patient_total_carbohydrate,patient_calorie_deficiency,patient_age,patient_height,patient_weight,patient_gender,patient_pa_coefficient,foodrecallnumber,patient_protein_limit,patient_total_protein) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
    	     	         preStatement.setString(1, combo.getSelectedItem().toString()); 
    	     	       	 preStatement.setString(2,t_bmi.getText());    
    	     	         preStatement.setString(3,totalFatLimit);
    	     	         preStatement.setString(4, t_calorieLimit.getText().toString());
    	     	         preStatement.setString(5, totalCarbohydrateLimit);     	 
    	     	         preStatement.setString(6,t_totalFat.getText().toString()); 
    	     	         preStatement.setString(7, t_totalCalories.getText().toString()); 
    	     	         preStatement.setString(8, t_totalCarbohydrate.getText().toString()); 
    	     	         preStatement.setString(9, t_deficiencyInCalories.getText().toString());
    	     	         preStatement.setString(10, t_age.getText().toString());
    	     	         preStatement.setString(11, t_height.getText().toString());
    	     	         preStatement.setString(12, t_weight.getText().toString().toString());
    	     	         preStatement.setString(13, patientGender);
    	     	         preStatement.setString(14, t_pa_coefficient.getText().toString());
    	     	         preStatement.setString(15, t_foodrecallnumber.getText().toString());
    	     	         preStatement.setString(16, totalProteinLimit);
    	     	         preStatement.setString(17, t_totalProtein.getText().toString());
    	     	         preStatement.executeUpdate();   	
    	     	         t_bmi.setText("");
    	     	         t_totalFat.setText("");
    	     	         t_totalCalories.setText("");
    	     	         t_totalCarbohydrate.setText("");
    	     	         t_deficiencyInCalories.setText("");
    	     	         t_age.setText("");
    	     	         t_height.setText("");
    	     	         t_weight.setText("");
    	     	         t_pa_coefficient.setText("");
    	     	         t_foodrecallnumber.setText("");
    	     	         t_totalProtein.setText("");
    	     	         t_calorieLimit.setText("");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "error in inserting data","Failed!!",
	                             JOptionPane.ERROR_MESSAGE);
						e.printStackTrace();
					}
	             }
	        	
	        	else if(ae.getSource()==view)
	             {
	        		 
	             }
	             
	        	
	        }
	    }
	        

}
