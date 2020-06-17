
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Menu {

	
	static File binOrder = new File("orders");
	static File binInventory = new File("inventory");
	static RandomAccessFile raf;
	
	public static Order orders = new Order();
	public static Inventory inventory = new Inventory();
	
	public static void main(String[] args) throws IOException {
		
		
		raf = new RandomAccessFile(binOrder,"rw");
		
		
		orders.addItem(null,"Cake",22,5);
		orders.addItem(null,"Ice",3,1);
		orders.addItem(null,"Water",10,2);
		orders.addItem(null,"Sand",11,7);

		
		orders.writeBinFile(raf);
		
		orders.removeItem(0);
		
		orders.addItem(null,"Bike",11,7);
		orders.addItem(null,"Fish",11,7);
		
//		//Scanner scan = new Scanner(System.in);
//		
//		orders.addItem(null, "Khathab", 55, 2.99);
//		orders.removeItem(2);
		

//		orders.readBinFile(raf);
		orders.printOrder();
	
	}
	
	public static  RandomAccessFile setRafBin(int x) throws IOException {
		raf.close();
		
		if(x==1) {
			binOrder.delete();
			raf = new RandomAccessFile(binOrder,"rw");
			
		}else if(x==2) {
			binInventory.delete();
			raf = new RandomAccessFile(binInventory,"rw");
		}
		return raf;
	}
	
	public static void addToOrder(Scanner s) throws IOException {
		boolean on = true;
		String resp = "";
		
		while(on) {
			System.out.println("Do you want to add to Order?(yes/no)");
			resp = s.next();
			if (resp.charAt(0)=='y') {
		
				orders.addItem();	
				
				System.out.println("Enter Name");
				resp = s.next();
				orders.inventory.getLast().setName(resp);
				
				System.out.println("Enter Image location");
				resp = s.next();
				orders.inventory.getLast().setLocation(resp);
				
				System.out.println("Enter Quantity");
				resp = Double.toString(s.nextDouble());
				orders.inventory.getLast().setQuantity(Double.parseDouble(resp));
				
				System.out.println("Enter Price");
				resp = Double.toString(s.nextDouble());
				orders.inventory.getLast().setPrice(Double.parseDouble(resp));
				
				orders.printOrder();
			}
			
			System.out.println("Do you want to delete an element?(yes/no)");
			resp = s.next();
			if (resp.charAt(0)=='y') {
				System.out.println("Enter the element #");
				resp = Integer.toString(s.nextInt());
				orders.removeItem(Integer.parseInt(resp)-1);
				orders.printOrder();
			}
			
			System.out.println("Do you want to exit?(yes/no)");
			resp = s.next();
			if (resp.charAt(0)=='y') {
				on = false;	
			}
		}
		
	}
}
