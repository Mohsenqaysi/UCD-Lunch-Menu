package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Checkbox;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;

public class UserInterface {

	private JFrame frame;
	private JTextField URL;
	private JTextField name;
	private JTextField servedwith;
	private JTextField cost;
	private JTextField calories;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterface window = new UserInterface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void clearFields() {
		name.setText("");
		servedwith.setText("");
		cost.setText("");
		calories.setText("");

	}
	/**
	 * Create the application.
	 */
	public UserInterface() {
		initialize();
	}

	/**
	 * 
	 * Check if a string is a valid double
	 */
	private boolean isDouble(String str)  
	{  
		try  
		{  
			Double.parseDouble(str);
		}  
		catch(NumberFormatException nfe)  
		{  
			return false;  
		}  
		return true;  
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		MenuItem item = new MenuItem();
		frame = new JFrame();
		frame.setBounds(100, 100, 650, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);

		JLabel lblURL = new JLabel("URL:");
		panel.add(lblURL);

		URL = new JTextField();
		URL.setText("http://localhost:9001/menu");
		panel.add(URL);
		URL.setColumns(10);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Add Item", null, panel_1, null);
		tabbedPane.setEnabledAt(0, true);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, 1.0, 1.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);

		JLabel lblName = new JLabel("Name");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 3;
		gbc_lblName.gridy = 2;
		panel_1.add(lblName, gbc_lblName);

		name = new JTextField();
		GridBagConstraints gbc_name = new GridBagConstraints();
		gbc_name.insets = new Insets(0, 0, 5, 5);
		gbc_name.fill = GridBagConstraints.HORIZONTAL;
		gbc_name.gridx = 5;
		gbc_name.gridy = 2;
		panel_1.add(name, gbc_name);
		name.setColumns(10);

		JLabel lblServedwith = new JLabel("Servedwith");
		GridBagConstraints gbc_lblServedwith = new GridBagConstraints();
		gbc_lblServedwith.insets = new Insets(0, 0, 5, 5);
		gbc_lblServedwith.gridx = 3;
		gbc_lblServedwith.gridy = 3;
		panel_1.add(lblServedwith, gbc_lblServedwith);

		servedwith = new JTextField();
		GridBagConstraints gbc_servedwith = new GridBagConstraints();
		gbc_servedwith.insets = new Insets(0, 0, 5, 5);
		gbc_servedwith.fill = GridBagConstraints.HORIZONTAL;
		gbc_servedwith.gridx = 5;
		gbc_servedwith.gridy = 3;
		panel_1.add(servedwith, gbc_servedwith);
		servedwith.setColumns(10);

		JLabel lblCost = new JLabel("Cost");
		GridBagConstraints gbc_lblCost = new GridBagConstraints();
		gbc_lblCost.insets = new Insets(0, 0, 5, 5);
		gbc_lblCost.gridx = 3;
		gbc_lblCost.gridy = 4;
		panel_1.add(lblCost, gbc_lblCost);

		cost = new JTextField();
		GridBagConstraints gbc_cost = new GridBagConstraints();
		gbc_cost.insets = new Insets(0, 0, 5, 5);
		gbc_cost.fill = GridBagConstraints.HORIZONTAL;
		gbc_cost.gridx = 5;
		gbc_cost.gridy = 4;
		panel_1.add(cost, gbc_cost);
		cost.setColumns(10);

		JLabel lblCalories = new JLabel("Calories");
		GridBagConstraints gbc_lblCalories = new GridBagConstraints();
		gbc_lblCalories.insets = new Insets(0, 0, 5, 5);
		gbc_lblCalories.gridx = 3;
		gbc_lblCalories.gridy = 5;
		panel_1.add(lblCalories, gbc_lblCalories);

		calories = new JTextField();
		GridBagConstraints gbc_calories = new GridBagConstraints();
		gbc_calories.insets = new Insets(0, 0, 5, 5);
		gbc_calories.fill = GridBagConstraints.HORIZONTAL;
		gbc_calories.gridx = 5;
		gbc_calories.gridy = 5;
		panel_1.add(calories, gbc_calories);
		calories.setColumns(10);

		JLabel lblAllergies = new JLabel("Allergies:");
		GridBagConstraints gbc_lblAllergies = new GridBagConstraints();
		gbc_lblAllergies.insets = new Insets(0, 0, 5, 5);
		gbc_lblAllergies.gridx = 3;
		gbc_lblAllergies.gridy = 7;
		panel_1.add(lblAllergies, gbc_lblAllergies);

		Box verticalBox = Box.createVerticalBox();
		GridBagConstraints gbc_verticalBox = new GridBagConstraints();
		gbc_verticalBox.insets = new Insets(0, 0, 5, 5);
		gbc_verticalBox.gridx = 5;
		gbc_verticalBox.gridy = 7;
		panel_1.add(verticalBox, gbc_verticalBox);
		
		Checkbox dary = new Checkbox("Dairy");
		verticalBox.add(dary);
		
		Checkbox celery = new Checkbox("Celery");
		verticalBox.add(celery);
		
		Checkbox fish = new Checkbox("Fish");
		verticalBox.add(fish);
		
		Checkbox nuts = new Checkbox("Nuts");
		verticalBox.add(nuts);
		
		Checkbox sesame = new Checkbox("Sesame");
		verticalBox.add(sesame);
		
		Checkbox wheat = new Checkbox("Wheat");
		verticalBox.add(wheat);
		
		Checkbox soy = new Checkbox("Soy");
		verticalBox.add(soy);

		Box verticalBox_1 = Box.createVerticalBox();
		frame.getContentPane().add(verticalBox_1, BorderLayout.EAST);

		JButton btnAdd = new JButton("Add");
		btnAdd.setHorizontalAlignment(SwingConstants.RIGHT);
		verticalBox_1.add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(name.getText().equals("")) {
					name.setText("empty field");
				}
				if(servedwith.getText().equals("")) {
					name.setText("empty field");
				}
				if(cost.getText().equals("")) {
					name.setText("empty field");
				}
				if(calories.getText().equals("")) {
					name.setText("empty field");
				}
				item.name = name.getText();
				item.servedwith = "Servedwith: " + servedwith.getText();
				
				// Check if the cost is a valid double
				if(isDouble(cost.getText())) {
					item.cost = Double.parseDouble(cost.getText());
				} else {
					item.cost = 0.0;
				}
				
				// Check if the calories is a valid double
				if(isDouble(calories.getText())) {
					item.calories = Integer.parseInt(calories.getText());
				} else {
					item.calories = 0.0;
				}
				
				if(dary.getState() == true) {
					item.alergies.add("dary");
				}
				if(celery.getState() == true) {
					item.alergies.add("celery");
				}
				if(fish.getState() == true) {
					item.alergies.add("fish");
				}
				if(nuts.getState() == true) {
					item.alergies.add("nuts");
				}
				if(sesame.getState() == true) {
					item.alergies.add("sesame");
				}
				if(wheat.getState() == true) {
					item.alergies.add("wheat");
				}
				if(soy.getState() == true) {
					item.alergies.add("soy");
				}
				MenuManager manager = new MenuManager();
				manager.loadMenu(URL.getText());
				manager.addItem(item);
				item.alergies.clear();
				clearFields();
				dary.setState(false);
				celery.setState(false);
				fish.setState(false);
				nuts.setState(false);
				sesame.setState(false);
				wheat.setState(false);
				soy.setState(false);
			} 
		});
	}

}
