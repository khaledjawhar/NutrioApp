package com.khaled;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PatientMenu extends JMenuBar {

   String[ ] fileItems = new String[ ] {"Create"};
   String[ ] editItems = new String[ ] {"View", "update","delete"};

   public PatientMenu(  ) {

      JMenu fileMenu = new JMenu("File");
      JMenu editMenu = new JMenu("Edit");
      ActionListener createListener = new ActionListener(  ) {
         public void actionPerformed(ActionEvent event) {
            CreatePatient createPatient=new CreatePatient();
         }
      };
    
       ActionListener updateListener = new ActionListener(  ) {
           public void actionPerformed(ActionEvent event) {
               
           }
        };
        ActionListener viewListener = new ActionListener(  ) {
            public void actionPerformed(ActionEvent event) {
            	ViewPatient viewPatient=new ViewPatient();
            }
         };
         ActionListener deleteListener = new ActionListener(  ) {
             public void actionPerformed(ActionEvent event) {

             }
          };
      
         JMenuItem createItem = new JMenuItem(fileItems[0]);         
         createItem.addActionListener(createListener);
         fileMenu.add(createItem);
         JMenuItem viewItem = new JMenuItem(editItems[0]);
         viewItem.addActionListener(viewListener);
         editMenu.add(viewItem);
         JMenuItem updateItem = new JMenuItem(editItems[1]);
         updateItem.addActionListener(updateListener);
         editMenu.add(updateItem);
         JMenuItem deleteItem = new JMenuItem(editItems[2]);
         deleteItem.addActionListener(deleteListener);
         editMenu.add(deleteItem);
      // Insert a separator in the Edit menu in Position 1 after "Undo".
      editMenu.insertSeparator(1);
      // Finally, add all the menus to the menu bar.
      add(fileMenu);
      add(editMenu);
   }
}
