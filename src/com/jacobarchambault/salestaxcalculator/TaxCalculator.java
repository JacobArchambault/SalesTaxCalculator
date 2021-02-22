package com.jacobarchambault.salestaxcalculator;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class TaxCalculator extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private TaxPanel taxPanel; // A panel for sales tax data

	/**
	 * Constructor
	 */
	public TaxCalculator(
			String title) {
		super(
				title);
		// Specify what happens when the close button is clicked.
		setDefaultCloseOperation(
				WindowConstants.EXIT_ON_CLOSE);
		buildTaxPanel();
		// Pack and display the window.
		pack();
		setVisible(
				true);
	}


	private void buildTaxPanel() {
		// Create a MPGPanel object.
		taxPanel = new TaxPanel();
		// Add it to the content pane.
		add(
				taxPanel,
				BorderLayout.CENTER);
	}

}
