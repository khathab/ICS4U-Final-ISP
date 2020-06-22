import java.awt.event.WindowAdapter;		//for graphics
import java.awt.event.WindowEvent;			//for graphics	
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Menu {

	static boolean running = true;
	
	static File binOrder = new File("orders");
	static File binInventory = new File("inventory");
	static File binDepartment = new File("department");
	static RandomAccessFile raf;
	
	public static Orders orders = new Orders();
	public static Inventory inventory = new Inventory();
	public static Department department = new Department();
	
	public static void main(String[] args) throws IOException {
		run();
	
		raf = new RandomAccessFile(binOrder,"rw");
		setRaf(1);
//		orders.addItem("A","27 Crecent St","A",0);
//		orders.addItem("B","19 Annadae","B",0);
//		orders.addItem("C","19 ","C",0);
//		orders.addItem("D","19 ","D",0);
//		
//		
//		orders.inventory.get(0).addItem("Cake",22,5,"");
//		orders.inventory.get(1).addItem("Ice Cream",3,1,"");
//		orders.inventory.get(1).addItem("Water",3,1,"");
//		orders.inventory.get(1).addItem("Eggs",3,1,"");
//		orders.inventory.get(1).inventory.get(1).setName("Watered");
//		
//		orders.addItem("E","19 ","E",0);
//		orders.update();
		orders.readBinFile(raf);
		

	
//		orders.inventory.get(0).inventory.get(0).setPrice(0);
//		orders.inventory.get(0).removeItem(1);
		orders.printList();
		
		
		
	

		
//		raf = new RandomAccessFile(binDepartment,"rw");
//		setRaf(3);
//		
//		department.addItem("Khathab", 17.5, 20, "Worker", 100, 0, 23, "Khathab");
//		department.addItem("Adnan", 11.5, 20, "Worker", 0, 0, 15, "Adnan");
//
//		
//		department.inventory.get(0).getSchedule().addShift(2, 3, 17);
//		department.inventory.get(1).getSchedule().addShift(4, 6, 15);
//		department.update();
//		department.removeItem(0);
//		department.printList();


//		run();
		
//		setRaf(1);		
//		orders.addItem("Cake",22,5,"");
//		orders.addItem("Ice Cream",3,1,"");
//		orders.addItem("Donuts",10,2,"");
//		orders.addItem("Hotdog",11,7,"");
//		
//		orders.inventory.get(0).setName("Ass");
//		orders.update();
//		
//
//		setRaf(2);
//		
//		inventory.addItem( "Flour", 40, 20, 10, "Kg", "df");
//		inventory.addItem( "Water", 20, 5, 10, "L", "ds");
//		inventory.addItem( "Butter", 40, 20, 10, "Kg", "ds");
//		inventory.removeItem(1);
//		inventory.printList();
//		setRaf(3);
//		

	
	}
	
	public static void init() throws IOException {
		
		
		raf = new RandomAccessFile(binOrder,"rw");
		orders.readBinFile(raf);
		orders.printList();
		
		setRaf(2);
		inventory.readBinFile(raf);
		inventory.printList();
		
		
		setRaf(3);
		department.readBinFile(raf);
		department.printList();

		
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
	}
	
	
	
	private static void tick() {
			
	}
	
	private static void render(){
		
	}
	
	public static void run() {
		
		try {
			init();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(running) {
			tick();
			render();
			
		}
		
	}
	
	
	
	public static  RandomAccessFile setRafBin(int x) throws IOException {
		raf.close();
		
		if(x==1) {
			binOrder.delete();
			raf = new RandomAccessFile(binOrder,"rw");
			orders.setRaf(raf);
		}else if(x==2) {
			binInventory.delete();
			raf = new RandomAccessFile(binInventory,"rw");
			inventory.setRaf(raf);
		}else if(x==3) {
			binDepartment.delete();
			raf = new RandomAccessFile(binDepartment,"rw");
			department.setRaf(raf);
		}
		return raf;
	}
	
	

	public static  RandomAccessFile setRaf(int x) throws IOException {
		raf.close();
		
		if(x==1) {
			
			raf = new RandomAccessFile(binOrder,"rw");
			orders.setRaf(raf);
		}else if(x==2) {
			raf = new RandomAccessFile(binInventory,"rw");
			inventory.setRaf(raf);
		}else if(x==3) {
			raf = new RandomAccessFile(binDepartment,"rw");
			department.setRaf(raf);
		}
		return raf;
	}
	
	public static  void closeRaf() throws IOException {
		raf.close();
	}
	
	
//	public static void addToOrder(Scanner s) throws IOException {
//		boolean on = true;
//		String resp = "";
//		
//		while(on) {
//			System.out.println("Do you want to add to Order?(yes/no)");
//			resp = s.next();
//			if (resp.charAt(0)=='y') {
//		
//				orders.addItem();	
//				
//				System.out.println("Enter Name");
//				resp = s.next();
//				orders.inventory.getLast().setName(resp);
//				
//				System.out.println("Enter Image location");
//				resp = s.next();
//				orders.inventory.getLast().setLocation(resp);
//				
//				System.out.println("Enter Quantity");
//				resp = Double.toString(s.nextDouble());
//				orders.inventory.getLast().setQuantity(Double.parseDouble(resp));
//				
//				System.out.println("Enter Price");
//				resp = Double.toString(s.nextDouble());
//				orders.inventory.getLast().setPrice(Double.parseDouble(resp));
//				
//				orders.printList();
//			}
//			
//			System.out.println("Do you want to delete an element?(yes/no)");
//			resp = s.next();
//			if (resp.charAt(0)=='y') {
//				System.out.println("Enter the element #");
//				resp = Integer.toString(s.nextInt());
//				orders.removeItem(Integer.parseInt(resp)-1);
//				orders.printList();
//			}
//			
//			System.out.println("Do you want to exit?(yes/no)");
//			resp = s.next();
//			if (resp.charAt(0)=='y') {
//				on = false;	
//			}
//		}
//		
//	}
	
}
