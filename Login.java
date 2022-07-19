import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Scrollbar;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.Box;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JSplitPane;
import javax.swing.JTable;

public class Login {

	private JFrame frame;
	private static String username;
	private static int userId;
	private JPasswordField pass;

	/**
	 * Create the application.
	 */

	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public Login() {
		JFrame frame = new JFrame();
		frame.getContentPane().setBackground(new Color(102, 204, 255));
		frame.getContentPane().setForeground(Color.BLACK);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		frame.getContentPane().setLayout(gridBagLayout);

		JLabel lblNewLabel = new JLabel("Login page");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBackground(Color.RED);
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 25));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.gridwidth = 10;
		gbc_lblNewLabel.gridheight = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 13;
		gbc_lblNewLabel.gridy = 4;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("Username:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_2.gridwidth = 9;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 11;
		gbc_lblNewLabel_2.gridy = 7;
		frame.getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);

		JTextField username_1 = new JTextField();
		username_1.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_username_1 = new GridBagConstraints();
		gbc_username_1.gridwidth = 10;
		gbc_username_1.insets = new Insets(0, 0, 5, 5);
		gbc_username_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_username_1.gridx = 11;
		gbc_username_1.gridy = 8;
		frame.getContentPane().add(username_1, gbc_username_1);
		username_1.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Password:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.gridwidth = 10;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 11;
		gbc_lblNewLabel_3.gridy = 9;
		frame.getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);

		JPasswordField pass_1 = new JPasswordField();
		pass_1.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_pass_1 = new GridBagConstraints();
		gbc_pass_1.gridwidth = 10;
		gbc_pass_1.insets = new Insets(0, 0, 5, 5);
		gbc_pass_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_pass_1.gridx = 11;
		gbc_pass_1.gridy = 10;
		frame.getContentPane().add(pass_1, gbc_pass_1);
		pass_1.setColumns(10);

		JButton btnNewButton_1 = new JButton("Signup");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "root");

					Statement stmt = conn.createStatement();
					String sql = "INSERT INTO users (username,pass) VALUES (\"" + username_1.getText() + "\" ,\""
							+ pass_1.getText().toString() + "\");";

					stmt.execute(sql);
					System.out.println("New user registered successfully");
					conn.close();

				} catch (SQLIntegrityConstraintViolationException ex) {
					JOptionPane.showMessageDialog(null, "Username already exists!");
				} catch (Exception e2) {
					System.out.println(e2);
				}
			}
		});

		JButton btnNewButton = new JButton("Login");
		btnNewButton.setForeground(Color.BLACK);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "root");

					Statement stmt = conn.createStatement();
					String sql = "select * from users where username = \"" + username_1.getText() + "\" and pass =\""
							+ pass_1.getText().toString() + "\";";

					ResultSet rs = stmt.executeQuery(sql);

					username = username_1.getText();

					if (rs.next()) {
						JOptionPane.showMessageDialog(null, "Welcome back " + username_1.getText().toUpperCase());
						// Orders orders = new Orders(username_1.getText());
						userId = rs.getInt("user_id");
						System.out.println("userid " + userId);
						orders();

					} else {
						JOptionPane.showMessageDialog(null, "Incorrect username or password");
					}
					conn.close();

				} catch (Exception e1) {
					System.out.println(e1);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));

		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridheight = 2;
		gbc_btnNewButton.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton.gridwidth = 9;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 11;
		gbc_btnNewButton.gridy = 11;
		frame.getContentPane().add(btnNewButton, gbc_btnNewButton);

		JLabel lblNewLabel_1 = new JLabel("New user?");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.gridwidth = 3;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 14;
		gbc_lblNewLabel_1.gridy = 14;
		frame.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 19;
		gbc_btnNewButton_1.gridy = 14;
		frame.getContentPane().add(btnNewButton_1, gbc_btnNewButton_1);
		frame.setVisible(true);
	}

	private static void orders() {

		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		frame.getContentPane().setLayout(gridBagLayout);

		JPanel panel_orders = new JPanel(new GridBagLayout());
		panel_orders.setLayout(new GridLayout(1, 4));
		frame.add(panel_orders);

		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 4;
		gbc_verticalStrut.gridy = 0;
		frame.getContentPane().add(verticalStrut, gbc_verticalStrut);

		JLabel lblNewLabel = new JLabel("shopping history");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridheight = 2;
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		
		//event not firing
		//ArrayList <String> pnamesList= new ArrayList<String>();
		ArrayList <Product> productsList= new ArrayList<Product>();
		//JList<String> products = new JList<>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "root");
			System.out.println("userid2 " + userId);
			//String sql = "select p.product_name from products p JOIN orders o ON o.product_id = p.product_id \r\n"
			//		+ "Join users u ON o.user_id = u.user_id where u.user_id = ? Order by p.product_name;";
			String sql = "select p.product_name,p.product_desc,p.product_value from products p JOIN orders o ON o.product_id = p.product_id Join users u ON o.user_id = u.user_id "
					+ "WHERE u.user_id=\"" + userId + "\" ";
			Statement stmt = conn.createStatement();
			
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			
			
			while(rs.next()) {
				Product p = new Product();
				p.setProductName(rs.getString(1));
				p.setProdDesc(rs.getString(2));
				p.setProdValue(rs.getInt(3));
				
				productsList.add(p);
				//pnamesList.add(rs.getString(1));
				
			}
			
			/*
			 * String[] productsArray = new String[pnamesList.size()]; productsArray =
			 * pnamesList.toArray(productsArray); products = new JList<>(productsArray);
			 */
			
			
			
			conn.close();
		} catch (Exception e1) {
			System.out.println(e1);
		}
		
		//Productmodel
		ProductTableModel model = new ProductTableModel(productsList);
		JTable table = new JTable(model);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new JScrollPane(table));
		frame.add(panel_orders);
		frame.pack();
		frame.setVisible(true);
		
		/*
		 * products.addListSelectionListener(new ListSelectionListener() { public void
		 * valueChanged(ListSelectionEvent e) { } });
		 */
		
		/*
		 * products.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		 * panel_orders.add(products);
		 */
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.gridheight = 3;
		gbc_list.gridwidth = 5;
		gbc_list.insets = new Insets(0, 0, 5, 5);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 7;
		gbc_list.gridy = 1;
		//frame.getContentPane().add(products, gbc_list);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.gridwidth = 16;
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalStrut.gridx = 0;
		gbc_horizontalStrut.gridy = 4;
		frame.getContentPane().add(horizontalStrut, gbc_horizontalStrut);

		JScrollBar scrollBar = new JScrollBar();
		GridBagConstraints gbc_scrollBar = new GridBagConstraints();
		gbc_scrollBar.gridheight = 4;
		gbc_scrollBar.gridwidth = 5;
		gbc_scrollBar.insets = new Insets(0, 0, 5, 5);
		gbc_scrollBar.gridx = 6;
		gbc_scrollBar.gridy = 5;
		frame.getContentPane().add(scrollBar, gbc_scrollBar);

		JLabel lblNewLabel_3 = new JLabel("Add to cart");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.gridwidth = 3;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 6;
		frame.getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);

		JButton btnNewButton = new JButton("Order");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 12;
		gbc_btnNewButton.gridy = 6;
		frame.getContentPane().add(btnNewButton, gbc_btnNewButton);

		frame.setVisible(true);
	}

	;
};