

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Menu {

	boolean running = true;
	
	static File binOrder = new File("orders");
	static File binInventory = new File("inventory");
	static File binDepartment = new File("department");
	static RandomAccessFile raf;
	
	public static Order orders = new Order();
	public static Inventory inventory = new Inventory();
	public static Department department = new Department();
	
	public static void main(String[] args) throws IOException {
		
		init();
	
		
//		raf = new RandomAccessFile(binOrder,"rw");
//
//		orders.setRaf(raf);
//		orders.addItem(null,"Cake",22,5,"");
//		orders.addItem(null,"Ice Cream",3,1,"");
//		orders.addItem(null,"Donuts",10,2,"");
//		orders.addItem(null,"Hotdog",11,7,"");
//		
//
//		setRaf(2);
//		
//		inventory.addItem(null, "Flour", 40, 20, 10, "Kg", "df");
//		inventory.addItem(null, "Water", 20, 5, 10, "L", "ds");
//		inventory.addItem(null, "Butter", 40, 20, 10, "Kg", "ds");
//		
//		setRaf(3);
//		
//		department.addItem(null, "Khathab", 11.5, 0, "Manager", 0, 100, 14.5, "");
//		department.addItem(null, "Adnan", 11.5, 0, "Employee", 0, 100, 14.5, "");
//		department.addItem(null, "Kieran", 11.5, 0, "Manager", 0, 100, 14.5, "");
//		department.addItem(null, "Brayden", 11.5, 0, "Manager", 0, 100, 14.5, "");
//		
//		orders.printList();
//		inventory.printList();
//		department.printList();
	
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
		
		
	}
	
	
	
	private void tick() {
		
		
	}
	
	private void render(){
		
	}
	public void run() {
		
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
			
		}else if(x==2) {
			binInventory.delete();
			raf = new RandomAccessFile(binInventory,"rw");
			
		}else if(x==3) {
			binDepartment.delete();
			raf = new RandomAccessFile(binDepartment,"rw");
			
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
				
				orders.printList();
			}
			
			System.out.println("Do you want to delete an element?(yes/no)");
			resp = s.next();
			if (resp.charAt(0)=='y') {
				System.out.println("Enter the element #");
				resp = Integer.toString(s.nextInt());
				orders.removeItem(Integer.parseInt(resp)-1);
				orders.printList();
			}
			
			System.out.println("Do you want to exit?(yes/no)");
			resp = s.next();
			if (resp.charAt(0)=='y') {
				on = false;	
			}
		}
		
	}
}
