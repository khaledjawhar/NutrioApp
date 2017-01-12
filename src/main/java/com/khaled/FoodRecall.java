package com.khaled;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import com.khaled.FilteredJList.FilterModel;

public class FoodRecall extends JFrame{
	Connection con;
 	PreparedStatement preStatement;
 	ResultSet rs; 
 	handler handle;
	StringSearchable searchable;
	AutocompleteJComboBox combo;
	JComboBox mealType;
	ArrayList<Food> food;
	ArrayList<String> defaultValues;
	JLabel l_patient_name,l_filter_by_name,l_food_type,l_number_of_units,l_food_recall_date,l_food_recall_number,l_visit_date,l_mealType;
	JTextField t_filter_by_name,t_number_of_units,t_food_recall_date,t_food_recall_number,t_visit_date;
	JButton addItemToTable,removeItemFromTable,searchItem,saveItems,loadItemsByPatientName,generateReport;
	JList foodList;
	DefaultListModel listModel;
	TableModel model;
	private DefaultListModel filteredModel = null;
	private int fieldLength = 0;
	JTable foodTable;
	FoodRecall()
	{
		 food=new ArrayList<Food>();
		 defaultValues=new ArrayList<String>();
		//headers for the table
	     model = new TableModel(food);
	     foodTable=new JTable(model);
		 JScrollPane scrollPane = new JScrollPane(foodTable,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		 Dimension tableSize = new Dimension(1000, 450);
		 foodTable.setPreferredSize(tableSize);
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
	     listModel = new DefaultListModel();
	     foodList=new JList(listModel);
	     JScrollPane pane =new JScrollPane (foodList,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
	     addItemToTable=new JButton("Add Item To Table");
	     addItemToTable.addActionListener(handle);
	     removeItemFromTable=new JButton("Remove Item from Table");
	     removeItemFromTable.addActionListener(handle);
	     searchItem=new JButton("Search Item");
	     searchItem.addActionListener(handle);
	     saveItems=new JButton("Save Items");
	     saveItems.addActionListener(handle);
	     loadItemsByPatientName=new JButton("Load Items by patient name");
	     loadItemsByPatientName.addActionListener(handle);
	     generateReport=new JButton("Generate Report");
	     generateReport.addActionListener(handle);
		 l_patient_name=new JLabel("Patient Name");
		 l_filter_by_name=new JLabel("Filter By Name");
		 l_number_of_units=new JLabel("Number of Units");
		 l_food_type=new JLabel("Food Type");
		 l_food_recall_date=new JLabel("Food Recall Date");
		 l_food_recall_number=new JLabel("Food Recall Number");
		 l_visit_date=new JLabel("Visit Date");
		 l_mealType=new JLabel("Meal Type");
		 t_filter_by_name=new JTextField();
		 t_filter_by_name.addActionListener(handle);
		 t_number_of_units=new JTextField();
		 t_food_recall_date=new JTextField();;
		 t_food_recall_number=new JTextField();;
		 t_visit_date=new JTextField();;
		 mealType=new JComboBox();
		 mealType.addItem("BreakFast");
		 mealType.addItem("Lunch");
		 mealType.addItem("Dinner");
		 setLayout(null);
		 searchable = new StringSearchable(myWords);
		 combo = new AutocompleteJComboBox(searchable);
		 l_patient_name.setBounds(20, 20, 100, 20);
	     add(l_patient_name);
	     combo.setBounds(124, 20, 200, 20);
	     add(combo);
	     searchItem.setBounds(20, 45, 120, 20);
	     add(searchItem);
	     t_filter_by_name.setBounds(145, 45, 175, 20);
	     add(t_filter_by_name);
	     l_food_type.setBounds(20, 70, 100, 20);
	     add(l_food_type);
	     pane.setBounds(124, 70, 200, 400);
	     add(pane);
	     l_number_of_units.setBounds(20, 500, 100, 20);
	     add(l_number_of_units);
	     t_number_of_units.setBounds(124,500,200,20);
	     add(t_number_of_units);
	     l_mealType.setBounds(20, 530, 100, 20);
	     add(l_mealType);
	     mealType.setBounds(124, 530, 200, 20);
	     add(mealType);
	     addItemToTable.setBounds(124,560,200,20);
	     add(addItemToTable);
	     removeItemFromTable.setBounds(124,590,200,20);
	     add(removeItemFromTable);
	     l_food_recall_number.setBounds(380,20,120,20);
		 add(l_food_recall_number);
		 t_food_recall_number.setBounds(520,20,200,20);
		 add(t_food_recall_number);
		 l_food_recall_date.setBounds(740, 20,120 ,20 );
		 add(l_food_recall_date);
		 t_food_recall_date.setBounds(880, 20,200 ,20 );
		 add(t_food_recall_date);
		 l_visit_date.setBounds(1100, 20, 100, 20);
		 add(l_visit_date);
		 t_visit_date.setBounds(1200, 20, 150, 20);
		 add(t_visit_date);
		 saveItems.setBounds(800,530,200,20);
		 add(saveItems);
		 saveItems.setBounds(600,530,200,20);
		 add(saveItems);
		 loadItemsByPatientName.setBounds(820,530,200,20);
		 add(loadItemsByPatientName);
		 generateReport.setBounds(1040,530,200,20);
		 add(generateReport);
		 scrollPane.setBounds(340,40,1000,450);
		 add(scrollPane);
		 setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	     setExtendedState(JFrame.MAXIMIZED_BOTH); 
		 setJMenuBar(new PatientMenu());
		 setVisible(true);
		 t_filter_by_name.getDocument().addDocumentListener(new DocumentListener(){
	            @Override public void insertUpdate(DocumentEvent e) { filter(); }
	            @Override public void removeUpdate(DocumentEvent e) { filter(); }
	            @Override public void changedUpdate(DocumentEvent e) {}
	            private void filter() {
	                String filter = t_filter_by_name.getText();
	                filterModel((DefaultListModel<String>)foodList.getModel(), filter);
	            }
	     });

	}
	
	 public void filterModel(DefaultListModel<String> model, String filter) {
	        for (String s : defaultValues) {
	            if (!s.startsWith(filter)) {
	                if (model.contains(s)) {
	                    model.removeElement(s);
	                }
	            } else {
	                if (!model.contains(s)) {
	                    model.addElement(s);
	                }
	            }
	        }
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
            if(ae.getSource()==saveItems)
            {
            	 try {
            		 DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            		 java.sql.Date food_recallDate = new java.sql.Date(formatter.parse(t_food_recall_date.getText().toString()).getTime());
            		 java.sql.Date visit_date = new java.sql.Date(formatter.parse(t_visit_date.getText().toString()).getTime());
            		 DataBase db= new DataBase();    
      	        	 con=db.connect(); 
            		 for(int row = 0;row < model.getRowCount();row++) {    			     
            			    	 //insert items from the table into the database
            			    	 preStatement = con.prepareStatement("insert into patient_foodrecall (patient_name,foodrecall_number,food_type,meal_serving,food_calories,food_protein,food_carbohydrate,food_fat,meal_type,visit_date,foodrecall_date,food_cholesterol,food_sodium,food_fiber,food_sugars,food_vitamin_a,food_vitamin_c,food_calcium,food_iron) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            	     	         preStatement.setString(1, combo.getSelectedItem().toString()); //this replaces the 1st  "?" in the query for username
            	     	       	 preStatement.setString(2, t_food_recall_number.getText());    //this replaces the 2st  "?" in the query for password
            	     	         preStatement.setString(3, model.getValueAt(row, 1).toString());
            	     	         preStatement.setString(4, model.getValueAt(row, 2).toString());
            	     	         preStatement.setString(5, model.getValueAt(row, 3).toString());     	 
            	     	         preStatement.setString(6, model.getValueAt(row, 4).toString()); 
            	     	         preStatement.setString(7, model.getValueAt(row, 5).toString()); 
            	     	         preStatement.setString(8, model.getValueAt(row, 6).toString()); 
            	     	         preStatement.setString(9, model.getValueAt(row, 0).toString());
            	     	         preStatement.setDate(10, food_recallDate);//visit date
            	     	         preStatement.setDate(11, visit_date);//recall date
            	     	         preStatement.setString(12, model.getValueAt(row, 7).toString());
            	     	         preStatement.setString(13, model.getValueAt(row, 8).toString());
            	     	         preStatement.setString(14, model.getValueAt(row, 9).toString());
            	     	         preStatement.setString(15, model.getValueAt(row, 10).toString());
            	     	         preStatement.setString(16, model.getValueAt(row, 11).toString());
            	     	         preStatement.setString(17, model.getValueAt(row, 12).toString());
            	     	         preStatement.setString(18, model.getValueAt(row, 13).toString());
            	     	         preStatement.setString(19, model.getValueAt(row, 14).toString());
            	     	         preStatement.executeUpdate();
            	     }
            		 JOptionPane.showMessageDialog(null, "You have inserted nutrition facts info sucessfully","Success",
                             JOptionPane.INFORMATION_MESSAGE);
            		 model.deleteData();
            		 t_food_recall_date.setText("");
            		 t_visit_date.setText("");
            		 t_food_recall_number.setText("");
       	             preStatement.close();
     	        } catch (Exception e) {
     	        	 JOptionPane.showMessageDialog(null, "error in inserting nutrition facts info","Failed!!",
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
            if(ae.getSource()==searchItem)
            {
            	 try {
            		listModel.removeAllElements(); 
            		defaultValues.clear();
            		ProcessNutritionixData pnd=new ProcessNutritionixData();
            		food=pnd.searchItem(t_filter_by_name.getText());
            		for (int counter = 0; counter < food.size(); counter++) {
            			 listModel.addElement(food.get(counter).getFood_type()+",brand: "+food.get(counter).getFood_brand());
            			 defaultValues.add(food.get(counter).getFood_type()+",brand: "+food.get(counter).getFood_brand());
            			 System.out.print("food name is "+food.get(counter).getFood_type()+"/"); 
            	         System.out.print("food brand is "+food.get(counter).getFood_brand()+"/"); 		
            	         System.out.print("food protein is "+food.get(counter).getFood_protein()+"/"); 	
            	         System.out.print("food carbohydrate is "+food.get(counter).getFood_carbohydrate()+"/"); 	
            	         System.out.print("food calories is "+food.get(counter).getFood_calories()+"/"); 	
            	         System.out.println("food fat is "+food.get(counter).getFood_fat()); 	
            	         System.out.println("food cholesterol is "+food.get(counter).getFood_cholesterol()); 
            	         System.out.println("food sodium is "+food.get(counter).getFood_sodium()); 
            	         System.out.println("food fiber is "+food.get(counter).getFood_dietary_fiber()); 
            	         System.out.println("food sugars is "+food.get(counter).getFood_sugars()); 
            	         System.out.println("food Vitamin A is "+food.get(counter).getFood_vitamin_a()); 
            	         System.out.println("food Vitamin C is "+food.get(counter).getFood_vitamin_c());
            	         System.out.println("food calcium is "+food.get(counter).getFood_calcium()); 
            	         System.out.println("food iron is "+food.get(counter).getFood_iron()); 
            	    }
     	        } catch (Exception e) {
     	            // TODO Auto-generated catch block
     	           
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
            if(ae.getSource()==generateReport)
            {
            	 try {
            	
     	        } catch (Exception e) {
     	            // TODO Auto-generated catch block
     	           
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
            if(ae.getSource()==loadItemsByPatientName)
            {
            	 try {

     	        } catch (Exception e) {
     	            // TODO Auto-generated catch block
     	           
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
            if(ae.getSource()==removeItemFromTable)
            {
            	 try {
            		   int rowIndex = foodTable.getSelectedRow();
            		   model.deleteRow(rowIndex);

     	        } catch (Exception e) {
     	            // TODO Auto-generated catch block
     	           
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
            if(ae.getSource()==addItemToTable)
            {
            	 try {
            		 String selected = (String) foodList.getSelectedValue();
            		 for (Food f : food) {
            			 if(selected.equals(f.getFood_type()+",brand: "+f.getFood_brand())){
            				 //add the food recall to the table
            				 Food food_iter=f;
            				 if(t_number_of_units.getText().equals(""))
            				 {
            					 t_number_of_units.setText("1");
            				 }         				 
            			     food_iter.setFood_servings(t_number_of_units.getText());
            				 food_iter.setMealType(mealType.getSelectedItem().toString());
            				 float quantity=Float.parseFloat(t_number_of_units.getText());
            				 if(f.getFood_calories().equals("null"))
            					 f.setFood_calories("0");
            				 food_iter.setFood_calories(Float.toString(quantity*Float.parseFloat(f.getFood_calories())));
            				 if(f.getFood_protein().equals("null"))
            					 f.setFood_protein("0");
            				 food_iter.setFood_protein(Float.toString(quantity*Float.parseFloat(f.getFood_protein())));
            				 if(f.getFood_carbohydrate().equals("null"))
            					 f.setFood_carbohydrate("0");
            				 food_iter.setFood_carbohydrate(Float.toString(quantity*Float.parseFloat(f.getFood_carbohydrate())));
            				 if(f.getFood_fat().equals("null"))
            					 f.setFood_fat("0");
            				 food_iter.setFood_fat(Float.toString(quantity*Float.parseFloat(f.getFood_fat())));
            				 if(f.getFood_cholesterol().equals("null"))
            					 f.setFood_cholesterol("0");
            				 food_iter.setFood_cholesterol(Float.toString(quantity*Float.parseFloat(f.getFood_cholesterol())));
            				 if(f.getFood_sodium().equals("null"))
            					 f.setFood_sodium("0");
            				 food_iter.setFood_sodium(Float.toString(quantity*Float.parseFloat(f.getFood_sodium())));
            				 if(f.getFood_dietary_fiber().equals("null"))
            					 f.setFood_dietary_fiber("0");
            				 food_iter.setFood_dietary_fiber(Float.toString(quantity*Float.parseFloat(f.getFood_dietary_fiber())));
            				 if(f.getFood_sugars().equals("null"))
            					 f.setFood_sugars("0");
            				 food_iter.setFood_sugars(Float.toString(quantity*Float.parseFloat(f.getFood_sugars())));
            				 if(f.getFood_vitamin_a().equals("null"))
            					 f.setFood_vitamin_a("0");
            				 food_iter.setFood_vitamin_a(Float.toString(quantity*Float.parseFloat(f.getFood_vitamin_a())));
            				 if(f.getFood_vitamin_c().equals("null"))
            					 f.setFood_vitamin_c("0");
            				 food_iter.setFood_vitamin_c(Float.toString(quantity*Float.parseFloat(f.getFood_vitamin_c())));
            				 if(f.getFood_calcium().equals("null"))
            					 f.setFood_calcium("0");
            				 food_iter.setFood_calcium(Float.toString(quantity*Float.parseFloat(f.getFood_calcium())));
            				 if(f.getFood_iron().equals("null"))
            					 f.setFood_iron("0");
            				 food_iter.setFood_iron(Float.toString(quantity*Float.parseFloat(f.getFood_iron())));
            				 model.addRow(food_iter);
            			 }
            		 }
     	           
     	        } catch (Exception e) {
     	            // TODO Auto-generated catch block
     	           
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
