import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;		//for graphics
import java.awt.event.WindowEvent;			//for graphics
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

//Graphics for Main Menu

public class HomeScreen extends JFrame implements ActionListener {




	public HomeScreen() {
		super("Home");
		
		JPanel homeIMG = new JPanel();					//jlabel that acts as jpanel. Where everything else is added
		JLabel Title = new JLabel("", SwingConstants.CENTER);			//Title of homescreen
		JPanel menubut = new JPanel();									//where buttons are added
		JButton PrtA = new JButton(" MANAGE EMPLOYEES");				//factorial section 
		JButton PrtC = new JButton(" MANAGE INVENTORY");				//fractal section button
		JButton PrtE= new JButton(" MANAGE ORDERS");					//fractal section button
		
		//sets back image for frame
		setContentPane(homeIMG);
		//layouts set for different parts of frame
		homeIMG.setLayout(new BorderLayout());
		Title.setLayout(new GridLayout());
	homeIMG.setBackground(Color.red);
	menubut.setBackground(Color.gray);
	Title.setIcon(new ImageIcon("./src/img/Title.jpg"));
		
		
		//stuff for PrtA button
		PrtA.setContentAreaFilled(false);
		PrtA.setIcon(new ImageIcon("./src/img/b1.jpg"));
		menubut.add(PrtA);
		
		
		//stuff for PrtC button
		PrtC.setContentAreaFilled(false);
		PrtC.setIcon(new ImageIcon("./src/img/b2.jpg"));
		menubut.add(PrtC);
	
		
		//stuff for PrtE button
		PrtE.setContentAreaFilled(false);
		PrtE.setIcon(new ImageIcon("./src/img/b3.jpg"));
		menubut.add(PrtE);
			
		//stuff for PrtF button
		PrtE.addActionListener(this);
	
		
		
		//added to parts of frame
		homeIMG.add(menubut, BorderLayout.SOUTH);
		homeIMG.add(Title, BorderLayout.CENTER);
		
		//makes display of frame possible
		pack();
		setVisible(true);
	}
	

	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case " MANAGE EMPLOYEES":
			//for reverse section
			GrafEmp fram2 = new GrafEmp();
			fram2.setSize(500, 300);
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
		case " MANAGE INVENTORY":
			//for fractal section
			GrafInv fram3 = new GrafInv();
				fram3.setSize(729, 729);
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
		case " MANAGE ORDERS":
			//for blob section
			GrafOrd fram4 = new GrafOrd();
			fram4.setSize(300, 200);
			fram4.setResizable(false);
			fram4.setLocationRelativeTo(null);
			fram4.addWindowListener(new WindowAdapter()
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