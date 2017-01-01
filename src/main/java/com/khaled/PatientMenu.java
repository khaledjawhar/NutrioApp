package com.khaled;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PatientMenu extends JMenuBar {

   String[ ] fileItems = new String[ ] {"Add Patient","Add Visit Info"};
   String[ ] editItems = new String[ ] {"View/Edit Patient Info", "View/Edit Visit Info"};
   String[ ] processItems=new String[ ] {"Food Recall"};
   String[ ] report=new String[ ] {"patient Report","Visit Report","Food Recall Report"};
   public PatientMenu(  ) {

      JMenu fileMenu = new JMenu("File");
      JMenu editMenu = new JMenu("Edit");
      JMenu processMenu = new JMenu("process");
      JMenu reportMenu = new JMenu("report");
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
          ActionListener patientReportListener = new ActionListener(  ) {
              public void actionPerformed(ActionEvent event) {
              	
              }
           };
           ActionListener visitReportListener = new ActionListener(  ) {
               public void actionPerformed(ActionEvent event) {
               	
               }
            };
            
            ActionListener foodRecallReportListener = new ActionListener(  ) {
                public void actionPerformed(ActionEvent event) {
                	 
                }
             };

         JMenuItem addPatient = new JMenuItem(fileItems[0]);         
         addPatient.addActionListener(addPatientListener);
         fileMenu.add(addPatient);
         JMenuItem addVisitInfo = new JMenuItem(fileItems[1]);         
         addVisitInfo.addActionListener(addVisitInfoListener);
         fileMenu.add(addVisitInfo);
         JMenuItem editPatientInfo = new JMenuItem(editItems[0]);
         editPatientInfo.addActionListener(editPatientInfoListener);
         editMenu.add(editPatientInfo);
         JMenuItem editVisitInfo = new JMenuItem(editItems[1]);
         editVisitInfo.addActionListener(editVisitInfoListener);
         editMenu.add(editVisitInfo);
         JMenuItem foodRecall = new JMenuItem(processItems[0]);
         foodRecall.addActionListener(foodRecallListener);
         processMenu.add(foodRecall);
         JMenuItem patientReport = new JMenuItem(report[0]);
         patientReport.addActionListener(patientReportListener);
         reportMenu.add(patientReport);
         JMenuItem VisitReport = new JMenuItem(report[1]);
         VisitReport.addActionListener(visitReportListener);
         reportMenu.add(VisitReport);
         JMenuItem FoodRecallReport = new JMenuItem(report[2]);
         FoodRecallReport.addActionListener(foodRecallReportListener);
         reportMenu.add(FoodRecallReport);
         
      // Insert a separator in the Edit menu in Position 1 after "Undo".
      editMenu.insertSeparator(1);
      // Finally, add all the menus to the menu bar.
      add(fileMenu);
      add(editMenu);
      add(processMenu);
      add(reportMenu);
      
   }
}
