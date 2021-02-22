package com.jacobarchambault.salestaxcalculator;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MPGPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField gallonsValue; // To get gallons value
	private JTextField milesValue; // for miles input

	/**
	 * Constructor
	 */
	public MPGPanel() {
		// Initialize text fields.
		gallonsValue = new JTextField(
				10);
		milesValue = new JTextField(
				10);
		// Create a GridLayout manager.
		setLayout(
				new GridLayout(
						2,
						2));
		// Add the labels and text fields to this panel.
		add(
				new JLabel(
						"Total number of gallons:"));
		add(
				gallonsValue);
		add(
				new JLabel(
						"Number of miles driven:"));
		add(
				milesValue);
	}

	public void showMPG() {
		// Get the gallons value.
		double gallons = Double.parseDouble(
				gallonsValue.getText());
		// Get the miles value.
		double miles = Double.parseDouble(
				milesValue.getText());
		// calculate mpg
		double mpg = miles / gallons;
		// Display them.
		JOptionPane.showMessageDialog(
				null,
				String.format(
						"You got %,.2f miles per gallon",
						mpg));
	}
}
