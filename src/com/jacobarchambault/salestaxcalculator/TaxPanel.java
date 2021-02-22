package com.jacobarchambault.salestaxcalculator;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class TaxPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField purchaseValue; // To get gallons value
	private JTextField salesTaxValue; // for miles input

	/**
	 * Constructor
	 */
	public TaxPanel() {
		// Create a GridLayout manager.
		setLayout(
				new GridLayout(
						3,
						2));
		// Add the labels and text fields to this panel.
		addPurchaseValueField();
		addSlider();
		addSalesTaxTextBox();
	}

	private void addSalesTaxTextBox() {
		salesTaxValue = new JTextField(
				10);
		add(
				new JLabel(
						"Sales tax:"));
		add(
				salesTaxValue);
		salesTaxValue.setEditable(false);
	}

	private void addSlider() {
		add(
				new JLabel(
						"Sales Tax Slider:"));
		JSlider jSlider = new JSlider(
				JSlider.HORIZONTAL,
				0,
				10,
				0);
		add(jSlider);
		//Turn on labels at major tick marks.
		jSlider.setMajorTickSpacing(1);
		jSlider.setPaintTicks(true);
		jSlider.setPaintLabels(true);
		jSlider.setSnapToTicks(true);
	}

	private void addPurchaseValueField() {
		add(
				new JLabel(
						"Enter the amount of the purchase:"));
		purchaseValue = new JTextField(
				10);
		add(
				purchaseValue);
	}

	public void showMPG() {
		// Get the gallons value.
		double gallons = Double.parseDouble(
				purchaseValue.getText());
		// Get the miles value.
		double miles = Double.parseDouble(
				salesTaxValue.getText());
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
