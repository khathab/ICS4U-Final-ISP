import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

//Graphics for Orders

public class GrafOrd extends JFrame implements ItemListener, ActionListener {

	
	JPanel Card;
	int inv = Menu.orders.size();
	
	public GrafOrd() {
		super("Orders Management");
		
		
		JTextArea[] Inv = new JTextArea[100];
		JTextArea Orderer = new JTextArea();
		JPanel Pane = new JPanel();
		JButton PrtA = new JButton("ADD PRODUCT");				//factorial section 
		JButton PrtC = new JButton("REMOVE PRODUCT");				//fractal section button
		JButton PrtE= new JButton("SAVE");					//fractal section button
		JButton PrtG= new JButton("BACK");					//fractal section button

		setContentPane(Pane);
		Pane.setLayout(new GridLayout(3,3));
		
		JPanel comboBoxPane = new JPanel(); //use FlowLayout
        String comboBoxItems[] = { "Orders", "Edit Products" };
        @SuppressWarnings("unchecked")
		JComboBox cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        cb.addItemListener(this);
        comboBoxPane.add(cb);
         
        //Create the "cards".
        JPanel card1 = new JPanel();
        card1.setLayout(new FlowLayout());
        System.out.println(inv);
        Double y = 0.00;
        for (int x = 0; x < inv; x++) {
        	Inv[x] = new JTextArea("Product Number: " + x + "\n" + Menu.orders.get(x).printData());
        	y += Menu.orders.get(x).getPrice();
        	card1.add(Inv[x]);
        }
        Orderer.setText("Name: " + Menu.orders.getName() + "\n" + "Address: " + Menu.orders.getAddress() + "\n" + "Total: " + y);
        
        card1.add(Orderer);
        for (int x = 0; x < inv; x++) {
        	card1.add(Inv[x]);
        }
        
        
        JPanel card2 = new JPanel();
        card2.setLayout(new GridLayout(3,3));
        card2.add(PrtA);
        card2.add(PrtC);
        card2.add(PrtE);
        card2.add(PrtG);
        PrtA.addActionListener(this);
        PrtC.addActionListener(this);
        PrtE.addActionListener(this);
        PrtG.addActionListener(this);
         
        //Create the panel that contains the "cards".
        Card = new JPanel(new CardLayout());
        Card.add(card1, "Orders");
        Card.add(card2, "Edit Products");
         
        Pane.add(comboBoxPane);
        Pane.add(Card);
		
		
		
		
		
		//stuff for PrtA button
		PrtA.setContentAreaFilled(false);
		
		
		
		//stuff for PrtC button
		PrtC.setContentAreaFilled(false);
		
	
		
		//stuff for PrtE button
		PrtE.setContentAreaFilled(false);
		
		//stuff for PrtG button
		PrtG.setContentAreaFilled(false);
		
		
		
		
				pack();
				setVisible(true);
		
		
		
		
	}

	@Override
	public void itemStateChanged(ItemEvent x) {
		CardLayout cl = (CardLayout)(Card.getLayout());
        cl.show(Card, (String) x.getItem());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch (e.getActionCommand()) {
		case "ADD PRODUCT":
			//for reverse section
			GrafEdit fram2 = new GrafEdit(0, 2);
			fram2.setSize(300, 500);
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
		case "REMOVE PRODUCT":
			//for fractal section
			GrafEdit fram3 = new GrafEdit(1, 2);
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
		case "SAVE":
			//for blob section
			try {
				Menu.orders.update();
				JOptionPane.showMessageDialog(null, 
                        "SUCCESS", 
                        "OUTCOME", 
                        JOptionPane.DEFAULT_OPTION);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, 
                        "ERROR, TRY AGAIN", 
                        "OUTCOME", 
                        JOptionPane.ERROR_MESSAGE);
			}
			break;
		case "BACK":
			
			HomeScreen framer = new HomeScreen(); // frame for homescreen
			// sets size of homescreen, centers, makes it unresizable
			framer.setSize(1300, 700);
			framer.setResizable(false);
			framer.setLocationRelativeTo(null);
			// makes x button work
			framer.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			});
			dispose();
			break;
			
		}
	}
	

}
