package com.khaled;

import javax.swing.JFrame;

public class Patient extends JFrame{
	Patient()
	{
	     setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	     setExtendedState(JFrame.MAXIMIZED_BOTH); 
		 setJMenuBar(new PatientMenu());
		 setVisible(true);
	}
}
