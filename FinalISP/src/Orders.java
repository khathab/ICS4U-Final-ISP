import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.LinkedList;

public class Orders {
	public LinkedList<Order> inventory = new LinkedList<Order>();
	
	private RandomAccessFile raf = null;
	
	public Orders() {
		
	}
	
	public void addItem(String name,String address,String location,double total) throws IOException {
		inventory.add(new Order(name,address,location, total));
		if(raf!=null) {
			writeBinFile(inventory.size()-1);
		}
	}
	
	public void addItem() throws IOException {
		inventory.add(new Order());
		if(raf!=null) {
			writeBinFile(inventory.size()-1);
		}
	}
	
	public void removeItem(Order item) throws IOException{
		inventory.remove(item);
		if(raf!=null) {
			emptyBinFile();
			writeBinFile();
		}
	}
	
	public void removeItem(int item) throws IOException{
		inventory.remove(item);
		if(raf!=null) {
			emptyBinFile();
			writeBinFile();
		}
	}
	
	public void emptyBinFile() throws IOException {
		raf = Menu.setRafBin(1);
		
	}
	
	public void writeBinFile(RandomAccessFile rafs)throws IOException{
		this.raf = rafs;
		for(int x = 0 ; inventory.size()>x ; x++) {
			inventory.get(x).writeBinFileOrders(raf, x);
			
		}
		for(int x = 0 ; inventory.size()>x ; x++) {
			inventory.get(x).writeBinFileProduct();
		}
	}
	
	public void writeBinFile()throws IOException{
		
		for(int x = 0 ; inventory.size()>x ; x++) {
			inventory.get(x).writeBinFileOrders(raf, x);
		}
		for(int x = 0 ; inventory.size()>x ; x++) {
			inventory.get(x).writeBinFileProduct();
		}
		
	}
	
	public void writeBinFile(int x)throws IOException{
			inventory.get(x).writeBinFileOrders(raf, x);
	}
	
	public void readBinFile(RandomAccessFile rafs)throws IOException{
		this.raf = rafs;
		for(int x =inventory.size(); raf.length()/228>x ; x++) {
			inventory.add(new Order());
			inventory.getLast().readBinFile(raf, x);
		}
		
		for(int x = 0 ; inventory.size()>x ; x++) {
			inventory.get(x).readBinFileProduct();
		}
	}	
	
	public void update() throws IOException {
		if(raf!=null) {
			for(int x = 0 ; inventory.size()>x ; x++) {
				
				if(inventory.get(x).getUpdate()==true) {
					inventory.get(x).writeBinFileOrders(raf,x);
					inventory.get(x).setUpdate(false);
				}
				
					inventory.get(x).update();
					
				
			}
		}
		
	}
	
	public void deleteAll() throws IOException {
		for(int x = 0 ; inventory.size()>x ; x++) {
		
			inventory.get(x).deleteAll();
		}
	inventory.clear();
	emptyBinFile();
	
	}
	
	public void calculatTotal() {
		for(int x = 0 ; inventory.size()>x ; x++) {
			inventory.get(x).calculatTotal();
		}
	}
	
	public void printList() {

		
		for(int x = 0 ; inventory.size()>x ; x++) {
			System.out.println("Order #"+(x+1));
			inventory.get(x).printList();
		}
	}
	
	public void setRaf(RandomAccessFile raf) {
		this.raf = raf;
	}
	
	public RandomAccessFile getRaf() {
		return raf;
	}
	
}
