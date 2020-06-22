import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GrafEdit extends JFrame implements ActionListener{

	
	JTextField res = new JTextField();
	JTextField[] res0 = new JTextField[6];
	
	public GrafEdit(int i, int j) {
		super("Edit");
		
		
		JPanel sort = new JPanel();
		
		
		
		setContentPane(sort);
		if (j == 0) {
			JButton back = new JButton("Back to Employees");
			if (i == 0) {
				sort.setLayout(new GridLayout(4,6));
				JLabel[] mes = new JLabel[6];
				JButton red = new JButton("Ok, add employees");
				mes[0] = new JLabel("Name?");
				mes[1] = new JLabel("Quantity?");
				mes[2] = new JLabel("Price?");
				mes[3] = new JLabel("Low Cap?");
				mes[4] = new JLabel("Quantity Type?");
				mes[5] = new JLabel("Location?");
				
				
				
				for (int x = 0; x < 6; x++) {
					res0[x] = new JTextField();
					sort.add(mes[x]);
					sort.add(res0[x]);	
				}
				sort.add(red);
				sort.add(back);
				
				red.addActionListener(this);
				
				pack();
				setVisible(true);
			} else {
				
			}
			
			back.addActionListener(this);
			
		} else if (j == 1) {
			JButton back = new JButton("Back to Inventory");
			if (i == 0) {
				sort.setLayout(new GridLayout(4,6));
				JLabel[] mes = new JLabel[6];
				JButton red = new JButton("Ok, add item");
				mes[0] = new JLabel("Name?");
				mes[1] = new JLabel("Quantity?");
				mes[2] = new JLabel("Price?");
				mes[3] = new JLabel("Low Cap?");
				mes[4] = new JLabel("Quantity Type?");
				mes[5] = new JLabel("Location?");
				
				
				
				for (int x = 0; x < 6; x++) {
					res0[x] = new JTextField();
					sort.add(mes[x]);
					sort.add(res0[x]);	
				}
				sort.add(red);
				sort.add(back);
				
				red.addActionListener(this);
				
				pack();
				setVisible(true);
				
				
			} else {
				sort.setLayout(new GridLayout(2,6));
				JLabel mes = new JLabel("Item number?");
				
				JButton red = new JButton("Ok, remove item");
				
				sort.add(mes);
				sort.add(res);
				sort.add(red);
				sort.add(back);
				
				red.addActionListener(this);
				
				
				pack();
				setVisible(true);
			}
			
			back.addActionListener(this);
			
		} else {
			JButton back = new JButton("Back to Orders");
			if (i == 0) {
				sort.setLayout(new GridLayout(5,2));
				JLabel[] mes = new JLabel[6];
				JButton red = new JButton("Ok, add product");
				mes[0] = new JLabel("Name?");
				mes[1] = new JLabel("Quantity?");
				mes[2] = new JLabel("Price?");
				mes[3] = new JLabel("Location?");
				
				
				
				for (int x = 0; x < 4; x++) {
					res0[x] = new JTextField();
					sort.add(mes[x]);
					sort.add(res0[x]);	
				}
				sort.add(red);
				sort.add(back);
				
				red.addActionListener(this);
				
				pack();
				setVisible(true);
				
				
			} else {
				sort.setLayout(new GridLayout(2,6));
				JLabel mes = new JLabel("Product number?");
				
				JButton red = new JButton("Ok, remove product");
				
				sort.add(mes);
				sort.add(res);
				sort.add(red);
				sort.add(back);
				
				red.addActionListener(this);
				
				
				pack();
				setVisible(true);
			}
			
			back.addActionListener(this);
		}
		
		
		
		
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "Ok, add item":
			//for reverse section

			try {
				Menu.inventory.addItem(res0[0].getText(), Double.parseDouble(res0[1].getText()), Double.parseDouble(res0[2].getText()), Double.parseDouble(res0[3].getText()), res0[4].getText(), res0[5].getText());
			} catch (NumberFormatException e2) {
				JOptionPane.showMessageDialog(null, 
                        "ERROR, TRY AGAIN", 
                        "OUTCOME", 
                        JOptionPane.ERROR_MESSAGE);
			} catch (IOException e2) {
				JOptionPane.showMessageDialog(null, 
                        "ERROR, TRY AGAIN", 
                        "OUTCOME", 
                        JOptionPane.ERROR_MESSAGE);			}
				
			
			
			break;
		case "Ok, remove item":
			//for fractal section
			try {
				Menu.inventory.removeItem(Integer.parseInt(res.getText()));
				GrafInv fram3 = new GrafInv();
				fram3.setSize(500, 500);
				fram3.setResizable(false);
				fram3.setLocationRelativeTo(null);
				fram3.addWindowListener(new WindowAdapter()
				{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
				}
		);
			
			dispose();
				
				
			} catch (NumberFormatException | IOException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, 
                        "ERROR, TRY AGAIN", 
                        "OUTCOME", 
                        JOptionPane.ERROR_MESSAGE);
			}
			
			
			break;
			
			
		case "Ok, add product":
			//for reverse section

			try {
				Menu.orders.addItem(res0[0].getText(), Double.parseDouble(res0[1].getText()), Double.parseDouble(res0[2].getText()), res0[3].getText());
			} catch (NumberFormatException e2) {
				JOptionPane.showMessageDialog(null, 
                        "ERROR, TRY AGAIN", 
                        "OUTCOME", 
                        JOptionPane.ERROR_MESSAGE);
			} catch (IOException e2) {
				JOptionPane.showMessageDialog(null, 
                        "ERROR, TRY AGAIN", 
                        "OUTCOME", 
                        JOptionPane.ERROR_MESSAGE);
			}
				
			
			
			break;
		case "Ok, remove product":
			//for fractal section
			try {
				Menu.orders.removeItem(Integer.parseInt(res.getText()));
				GrafOrd fram3 = new GrafOrd();
				fram3.setSize(500, 500);
				fram3.setResizable(false);
				fram3.setLocationRelativeTo(null);
				fram3.addWindowListener(new WindowAdapter()
				{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
				}
		);
			
			dispose();
				
				
			} catch (NumberFormatException | IOException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, 
                        "ERROR, TRY AGAIN", 
                        "OUTCOME", 
                        JOptionPane.ERROR_MESSAGE);
			}
			
			
			break;
			
		case "Ok, add employee":
			//for reverse section

			try {
				Menu.orders.addItem(res0[0].getText(), Double.parseDouble(res0[1].getText()), Double.parseDouble(res0[2].getText()), res0[3].getText());
			} catch (NumberFormatException e2) {
				JOptionPane.showMessageDialog(null, 
                        "ERROR, TRY AGAIN", 
                        "OUTCOME", 
                        JOptionPane.ERROR_MESSAGE);
			} catch (IOException e2) {
				JOptionPane.showMessageDialog(null, 
                        "ERROR, TRY AGAIN", 
                        "OUTCOME", 
                        JOptionPane.ERROR_MESSAGE);
			}
				
			
			
			break;
		case "Ok, remove employee":
			//for fractal section
			try {
				Menu.orders.removeItem(Integer.parseInt(res.getText()));
				GrafOrd fram3 = new GrafOrd();
				fram3.setSize(500, 500);
				fram3.setResizable(false);
				fram3.setLocationRelativeTo(null);
				fram3.addWindowListener(new WindowAdapter()
				{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
				}
		);
			
			dispose();
				
				
			} catch (NumberFormatException | IOException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, 
                        "ERROR, TRY AGAIN", 
                        "OUTCOME", 
                        JOptionPane.ERROR_MESSAGE);
			}
			
			
			break;
			
			
		case "Back to Inventory":
			
			
			GrafInv fram3 = new GrafInv();
			fram3.setSize(500, 500);
			fram3.setResizable(false);
			fram3.setLocationRelativeTo(null);
			fram3.addWindowListener(new WindowAdapter()
			{
		public void windowClosing(WindowEvent e)
		{
			System.exit(0);
		}
			}
	);
		
		
		dispose();
			break;
case "Back to Employees":
			
			
			GrafEmp fram2 = new GrafEmp();
			fram2.setSize(500, 500);
			fram2.setResizable(false);
			fram2.setLocationRelativeTo(null);
			fram2.addWindowListener(new WindowAdapter()
			{
		public void windowClosing(WindowEvent e)
		{
			System.exit(0);
		}
			}
	);
		
		
		dispose();
			break;
case "Back to Orders":
	
	
	GrafOrd fram1 = new GrafOrd();
	fram1.setSize(500, 500);
	fram1.setResizable(false);
	fram1.setLocationRelativeTo(null);
	fram1.addWindowListener(new WindowAdapter()
	{
public void windowClosing(WindowEvent e)
{
	System.exit(0);
}
	}
);


dispose();
	break;
		}
	}
	
}
