package com.jacobarchambault.salestaxcalculator;

import java.awt.GridLayout;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TaxPanel extends JPanel implements ChangeListener {
	private static final long serialVersionUID = 1L;
	private JSlider jSlider;
	private JTextField purchaseValue; // To get purchase value
	private JTextField salesTaxValue; // for sales tax output

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

	public void showTax() {
		// Get the purchase value.
		// Get the tax value.
		int sliderValue = 0;
		if (!jSlider.getValueIsAdjusting()) {
			sliderValue = jSlider.getValue();
			double purchase = Double.parseDouble(
					purchaseValue.getText());
			// calculate tax
			double tax = sliderValue * (purchase / 100);
			// Display them.
			salesTaxValue.setText(
					String.valueOf(
							NumberFormat.getCurrencyInstance(
									Locale.US)
									.format(
											tax)));
		}
	}

	@Override
	public void stateChanged(
			ChangeEvent arg0) {
		showTax();

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

	private void addSalesTaxTextBox() {
		salesTaxValue = new JTextField(
				10);
		add(
				new JLabel(
						"Sales tax:"));
		add(
				salesTaxValue);
		salesTaxValue.setEditable(
				false);
	}

	private void addSlider() {
		add(
				new JLabel(
						"Sales Tax Slider:"));
		jSlider = new JSlider(
				SwingConstants.HORIZONTAL,
				0,
				10,
				0);
		add(
				jSlider);
		// Turn on labels at major tick marks.
		jSlider.setMajorTickSpacing(
				1);
		jSlider.setPaintTicks(
				true);
		jSlider.setPaintLabels(
				true);
		jSlider.setSnapToTicks(
				true);
		jSlider.addChangeListener(
				this);
	}
}
