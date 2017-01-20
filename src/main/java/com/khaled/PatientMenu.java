package com.khaled;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PatientMenu extends JMenuBar {

   String[ ] fileItems = new String[ ] {"Add Patient","Add Visit Info"};
   String[ ] editItems = new String[ ] {"View/Edit Patient Info", "View/Edit Visit Info"};
   String[ ] processItems=new String[ ] {"Food Recall"};
   String[ ] Others=new String[ ] {"Backup","Restore"};
   public PatientMenu(  ) {

      JMenu fileMenu = new JMenu("File");
      JMenu editMenu = new JMenu("Edit");
      JMenu processMenu = new JMenu("Process");
      JMenu othersMenu = new JMenu("Others");
      ActionListener addPatientListener = new ActionListener(  ) {
         public void actionPerformed(ActionEvent event) {
            AddPatient addPatient=new AddPatient();
         }
      };
      ActionListener addVisitInfoListener = new ActionListener(  ) {
          public void actionPerformed(ActionEvent event) {
             AddVisitInfo addVisit=new AddVisitInfo();
          }
       };
    
       ActionListener editPatientInfoListener = new ActionListener(  ) {
           public void actionPerformed(ActionEvent event) {
        	   EditPatientInfo editPatientInfo=new EditPatientInfo();
           }
        };
        ActionListener editVisitInfoListener = new ActionListener(  ) {
            public void actionPerformed(ActionEvent event) {
            	 EditVisitInfo editVisitInfo=new EditVisitInfo();
            }
         };
         ActionListener foodRecallListener = new ActionListener(  ) {
             public void actionPerformed(ActionEvent event) {
             	 FoodRecall foodRecall=new FoodRecall();
             }
          };
           ActionListener backupListener = new ActionListener(  ) {
               public void actionPerformed(ActionEvent event) {
               	
               }
            };
            
            ActionListener restoreListener = new ActionListener(  ) {
                public void actionPerformed(ActionEvent event) {
                	 
                }
             };

         JMenuItem addPatient = new JMenuItem(fileItems[0]);         
         addPatient.addActionListener(addPatientListener);
         fileMenu.add(addPatient);
         JMenuItem addVisit = new JMenuItem(fileItems[1]);         
         addVisit.addActionListener(addVisitInfoListener);
         fileMenu.add(addVisit);
         JMenuItem editPatientInfo = new JMenuItem(editItems[0]);
         editPatientInfo.addActionListener(editPatientInfoListener);
         editMenu.add(editPatientInfo);
         JMenuItem editVisitInfo = new JMenuItem(editItems[1]);
         editVisitInfo.addActionListener(editVisitInfoListener);
         editMenu.add(editVisitInfo);
         JMenuItem foodRecall = new JMenuItem(processItems[0]);
         foodRecall.addActionListener(foodRecallListener);
         processMenu.add(foodRecall);
         JMenuItem backup = new JMenuItem(Others[0]);
         backup.addActionListener(backupListener);
         othersMenu.add(backup);
         JMenuItem restore = new JMenuItem(Others[1]);
         restore.addActionListener(restoreListener);
         othersMenu.add(restore);
         
      // Insert a separator in the Edit menu in Position 1 after "Undo".
      editMenu.insertSeparator(1);
      // Finally, add all the menus to the menu bar.
      add(fileMenu);
      add(editMenu);
      add(processMenu);
      add(othersMenu);
      
   }
}
