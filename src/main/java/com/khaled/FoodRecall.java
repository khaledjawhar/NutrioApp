package com.khaled;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
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

import com.khaled.FilteredJList.FilterModel;

public class FoodRecall extends JFrame{
	Connection con;
 	PreparedStatement preStatement;
 	ResultSet rs; 
 	handler handle;
	StringSearchable searchable;
	AutocompleteJComboBox combo;
	ArrayList<Food> food;
	JLabel l_patient_name,l_filter_by_name,l_food_type,l_number_of_units,l_food_recall_date,l_food_recall_number,l_visit_date;
	JTextField t_filter_by_name,t_number_of_units,t_food_recall_date,t_food_recall_number,t_visit_date;
	JButton AddItemToTable,searchItem,saveItems,loadItemsByPatientName,generateReport;
	JList foodList;
	DefaultListModel listModel;
	private DefaultListModel filteredModel = null;
	private int fieldLength = 0;
	//headers for the table
	String[] columns = new String[] {
			"meal Type","Food Type", "Weight", "Calories", "Protein","Carbohydrate","Fats"
	};
    Object[][] data = new Object[][] {
	};
	JTable foodTable;
	FoodRecall()
	{
		 food=new ArrayList<Food>();
		 foodTable = new JTable(data, columns);
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
	     AddItemToTable=new JButton("Add Item To Table");
	     AddItemToTable.addActionListener(handle);
	     searchItem=new JButton("Search Item");
	     searchItem.addActionListener(handle);
	     saveItems=new JButton("Save Items in Table");
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
		 t_filter_by_name=new JTextField();
		 t_filter_by_name.addActionListener(handle);
		 t_number_of_units=new JTextField();
		 t_food_recall_date=new JTextField();;
		 t_food_recall_number=new JTextField();;
		 t_visit_date=new JTextField();;
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
	     AddItemToTable.setBounds(124,530,200,20);
	     add(AddItemToTable);
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
	}
	
	
	
	private void filterList() {
		// Setting up the environment for the logic
		int start = 0;
		int itemIx = 0;
		// Here the glitch that one should remeber
		// Sets hold NO DUPLICATE values... :)
		Set resultSet = new HashSet();
		filteredModel = new DefaultListModel();
		// Following logic is used to find an item in JList
		String prefix = t_filter_by_name.getText();
		javax.swing.text.Position.Bias direction = javax.swing.text.Position.Bias.Forward;
		for (int i = 0; i < foodList.getModel().getSize(); i++) {
			itemIx = foodList.getNextMatch(prefix, start, direction);
			// Following try-catch blog will enhance the user friendliness
			try {
				resultSet.add(foodList.getModel().getElementAt(itemIx));
			} catch(ArrayIndexOutOfBoundsException e) {
				JOptionPane.showMessageDialog(this, "No entry is matched with your query....");
				t_filter_by_name.setText("");
				return;
			}
			start++;
		}
		Iterator itr = resultSet.iterator();
		// Adding the filtered results to the new model
		while (itr.hasNext()) {
			filteredModel.addElement(itr.next());
		}
		// Setting the model to the list again
		foodList.setModel(filteredModel);
		}
	
	
	   //an inner class .You can also write as a separate class
    class handler implements ActionListener
    {
    	Connection con;
    	PreparedStatement preStatement; 
    	public void keyReleased(KeyEvent e) {
    		// In case of deleting a previously entered character by hitting backspace maybe...
    		 if(e.getSource()==t_filter_by_name)
    		 {	 
    			 if (fieldLength > t_filter_by_name.getText().length()) {
    				 foodList.setModel(listModel);
    				 filterList();
    			 } 
    			 else {
    				 filterList();
    			 }
    		 }
    	}
    	
    	// Here is the implementation of keyReleased method
    	public void keyPressed(KeyEvent e) {
    	// Just getting the length of the text field
    	// before key is pressed...
    		if(e.getSource()==t_filter_by_name)
    		{	
    			fieldLength = t_filter_by_name.getText().length();
    		}
    	}

        //must implement method
        //This is triggered whenever the user clicks the login button
        public void actionPerformed(ActionEvent ae)
        {
            //checks if the button clicked
            if(ae.getSource()==saveItems)
            {
            	 try {
            		
            		
     	           
     	        } catch (Exception e) {
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
            		ProcessNutritionixData pnd=new ProcessNutritionixData();
            		food=pnd.searchItem(t_filter_by_name.getText());
            		for (int counter = 0; counter < food.size(); counter++) {
            			 listModel.addElement(food.get(counter).getFood_type()+",brand: "+food.get(counter).getFood_brand());
            			 System.out.print("food name is "+food.get(counter).getFood_type()+"/"); 
            	         System.out.print("food brand is "+food.get(counter).getFood_brand()+"/"); 		
            	         System.out.print("food protein is "+food.get(counter).getFood_protein()+"/"); 	
            	         System.out.print("food carbohydrate is "+food.get(counter).getFood_carbohydrate()+"/"); 	
            	         System.out.print("food calories is "+food.get(counter).getFood_calories()+"/"); 	
            	         System.out.println("food fat is "+food.get(counter).getFood_fat()); 	
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
            if(ae.getSource()==AddItemToTable)
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
        }//method
 
    }//inner class
	
	
}
