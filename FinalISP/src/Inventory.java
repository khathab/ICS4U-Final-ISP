import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.LinkedList;

public class Inventory {

	public LinkedList<Item> inventory = new LinkedList<Item>();;
	
	private RandomAccessFile raf = null;

	public Inventory() {
		
	}
	
	public void addItem(BufferedImage image,String name,double quantity,double price,double lowCap,String quantityType,String location) {
		inventory.add(new Item(image,name,quantity,price,lowCap,quantityType,location));
	}
	
	public void addItem() throws IOException {
		inventory.add(new Item());
		if(raf!=null) {
			writeBinFile(inventory.size()-1);
		}
	}
	
	public void removeItem(Item item) throws IOException{
		inventory.remove(item);
		if(raf!=null) {
			writeBinFile();
		}
	}
	

	public void removeItem(int item) throws IOException{
		inventory.remove(item);
		if(raf!=null) {
			
			writeBinFile();
		}
	}
	
	public void emptyBinFile() throws IOException {
		raf = Menu.setRafBin(2);
		
	}
	
	public void writeBinFile(RandomAccessFile raf)throws IOException{
		this.raf = raf;
		for(int x = 0 ; inventory.size()>x ; x++) {
			inventory.get(x).writeBinFile(raf, x);
			
		}
	}
	
	public void writeBinFile()throws IOException{

		for(int x = 0 ; inventory.size()>x ; x++) {
			inventory.get(x).writeBinFile(raf, x);
		}
	}
	
	public void writeBinFile(int x)throws IOException{
		inventory.getLast().writeBinFile(raf, x);
	}
	
	public void readBinFile(RandomAccessFile raf)throws IOException{
		this.raf = raf;
		for(int x =inventory.size(); raf.length()/96>x ; x++) {
			inventory.add(new Item());
			inventory.getLast().readBinFile(raf, x);
		}
	}	
	
	public void printOrder() {

		for(int x = 0 ; inventory.size()>x ; x++) {
			System.out.println("Item #"+(x+1));
			inventory.get(x).printProduct();
		}
	}
	
}