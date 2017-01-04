package com.khaled;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import com.khaled.EditVisitInfo.handler;

public class FoodRecall extends JFrame{
	Connection con;
 	PreparedStatement preStatement;
 	ResultSet rs; 
 	handler handle;
	StringSearchable searchable;
	AutocompleteJComboBox combo;
	 String[] listItems = {
		        "Chris", "Joshua", "Daniel", "Michael",
		        "Don", "Kimi", "Kelly", "Keagan"
		    };

	JLabel l_patient_name,l_filter_by_name,l_food_type,l_item_name,l_number_of_units;
	JTextField t_filter_by_name,t_number_of_units,t_item_name;
	JButton AddItemToTable,chooseItemFromList,saveItems,loadItemsByPatientName,generateReport;
	FilteredJList foodList;
	//headers for the table
	String[] columns = new String[] {
			"Id", "Name", "Hourly Rate", "Part Time"
	};
    Object[][] data = new Object[][] {
	};
	JTable foodTable;
	FoodRecall()
	{
		 foodTable = new JTable(data, columns);
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
	     foodList = new FilteredJList();
	     for (int i=0; i<listItems.length; i++)
	    	 foodList.addItem (listItems[i]);
	     // add to gui
	     JScrollPane pane =
	         new JScrollPane (foodList, 
	                          ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, 
	                          ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

	     AddItemToTable=new JButton("Add Item To Table");
	     AddItemToTable.addActionListener(handle);
	     chooseItemFromList=new JButton("Choose Item From List");
	     chooseItemFromList.addActionListener(handle);
	     saveItems=new JButton("Save Items in Table");
	     saveItems.addActionListener(handle);
	     loadItemsByPatientName=new JButton("Load Items by patient name");
	     loadItemsByPatientName.addActionListener(handle);
	     generateReport=new JButton("Generate Report");
	     generateReport.addActionListener(handle);
		 l_patient_name=new JLabel("Patient Name");
		 l_filter_by_name=new JLabel("Filter By Name");
		 l_food_type=new JLabel("Visit Note");
		 t_filter_by_name=new JTextField();
		 setLayout(null);
		 searchable = new StringSearchable(myWords);
		 combo = new AutocompleteJComboBox(searchable);
		 l_patient_name.setBounds(20, 20, 100, 20);
	     add(l_patient_name);
	     combo.setBounds(124, 25, 200, 20);
	     add(combo);
	     l_filter_by_name.setBounds(20, 40, 100, 20);
	     add(l_filter_by_name);
	     foodList.getFilterField().setBounds(124, 45, 200, 20);
	     add(foodList.getFilterField());
	     l_food_type.setBounds(20, 60, 100, 20);
	     add(l_food_type);
	     pane.setBounds(124, 65, 200, 400);
	     add(pane);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setJMenuBar(new PatientMenu());
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
            if(ae.getSource()==chooseItemFromList)
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
