package pl.client;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pl.store.domain.Basket;
import pl.store.domain.Item;

public class AddOrderPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private double price;
	JLabel ItemPrice;
	JLabel priceLabel;
	int qty;
	double result;
	Basket basket;

	/**
	 * Create the panel.
	 */
	public AddOrderPanel(Basket basket1) {
		this.basket=basket1;
		setBackground(Color.YELLOW);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New Order");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(10, 11, 106, 27);
		add(lblNewLabel);
		
		JLabel lblName = new JLabel("Item");
		lblName.setBounds(10, 49, 46, 14);
		add(lblName);
		
		textField = new JTextField();
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				Random generator = new Random();
				int i = generator.nextInt(10);
				price=i*1.7;
				ItemPrice.setText(price+"");
			}
		});
		textField.setBounds(79, 46, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblQunatity = new JLabel("Qunatity");
		lblQunatity.setBounds(10, 80, 46, 14);
		add(lblQunatity);
		
		textField_1 = new JTextField();
		textField_1.setBounds(79, 77, 86, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(10, 162, 46, 14);
		add(lblPrice);
		
		 priceLabel = new JLabel("");
		priceLabel.setBackground(Color.PINK);
		priceLabel.setForeground(Color.BLACK);
		priceLabel.setBounds(70, 162, 46, 14);
		add(priceLabel);
		
		JButton btnAddorder = new JButton("AddItem");
		btnAddorder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item item=new Item();
				qty=Integer.parseInt(textField_1.getText());
				
				result=result+ price*qty;
				
				priceLabel.setText(result+"");
				
				item.setDescription(textField.getText());
				item.setPrice(price);
				item.setQuantity(qty);
				textField.setText("");
				textField_1.setText("");
				basket.addItem(item);
				
			}
		});
		btnAddorder.setBounds(76, 108, 89, 23);
		add(btnAddorder);
		
	 ItemPrice = new JLabel("");
		ItemPrice.setBounds(175, 49, 46, 14);
		add(ItemPrice);

	}
}
