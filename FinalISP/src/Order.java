
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.LinkedList;




public class Order {

	public LinkedList<Product> orders = new LinkedList<Product>();
	
	private String name;
	private String address;
	private String location;
	private double total;
	private int length = 228;
	private String fileLocation;
	private boolean update;
	
	private RandomAccessFile raf = null;
	
	public Order() {
		
	}
	
	public Order(String name,String address,String location,double total) {
		this.name = name;
		this.address = address;
		this.total = total;
		this.location = location;
		fileLocation = "./orderlist/"+location;
		
	}
			
	public void addItem(String name,double quantity,double price,String location) throws IOException {
		orders.add(new Product(name,quantity,price, location));
		if(raf!=null) {
			
			writeBinFileProduct(orders.size()-1);
		}
	}
	
	public void addItem() throws IOException {
		orders.add(new Product());
		if(raf!=null) {
			writeBinFileProduct(orders.size()-1);
		}
	}
	
	public void removeItem(Product item) throws IOException{
		orders.remove(item);
			emptyBinFile();
			writeBinFileProduct();

	}
	
	public void removeItem(int item) throws IOException{
		orders.remove(item);
			emptyBinFile();
			writeBinFileProduct();

	}
	
	public void emptyBinFile() throws IOException {
		if(new File(fileLocation).delete()) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
	
		
	}
	
	
	public void writeBinFileProduct()throws IOException{
		Menu.closeRaf();

		raf = new RandomAccessFile(fileLocation,"rw");
		for(int x = 0 ; orders.size()>x ; x++) {
			orders.get(x).writeBinFile(raf, x);
			
		}
		raf.close();
		Menu.setRaf(1);
	}
	
	public void writeBinFileProduct(int x)throws IOException{
		Menu.closeRaf();

		raf = new RandomAccessFile(fileLocation,"rw");
		orders.get(x).writeBinFile(raf, x);
		raf.close();
		Menu.setRaf(1);
	}
	
	public void writeBinFileOrders(RandomAccessFile rafs,int rec)throws IOException{
		this.raf = rafs;
		
		raf.seek (rec * length);
		
		 int nameLen = name.length (); 
			int padLen = 0;	
			
			 // pads record fields
				if (nameLen > 30)					
			        nameLen = 30;
			    else
			        padLen = 30 - nameLen;
			    for (int i = 0 ; i < nameLen ; i++)	
			        raf.writeChar (name.charAt (i));
			    if (padLen > 0)	{					
			        for (int i = 0 ; i < padLen ; i++)
			            raf.writeChar (' ');
			    }
			    
			    nameLen = address.length ();
				padLen = 0;						
			    if (nameLen > 60)					
			        nameLen = 60;
			    else
			        padLen = 60 - nameLen;
			    for (int i = 0 ; i < nameLen ; i++)	
			        raf.writeChar (address.charAt (i));
			    if (padLen > 0)	{				
			        for (int i = 0 ; i < padLen ; i++)
			            raf.writeChar (' ');
			    } 
			    
			    nameLen = location.length ();
				padLen = 0;						
			    if (nameLen > 20)					
			        nameLen = 20;
			    else
			        padLen = 20 - nameLen;
			    for (int i = 0 ; i < nameLen ; i++)	
			        raf.writeChar (location.charAt (i));
			    if (padLen > 0)	{				
			        for (int i = 0 ; i < padLen ; i++)
			            raf.writeChar (' ');
			    } 
	}
	
	public void readBinFileProduct(RandomAccessFile raf)throws IOException{
		this.raf = raf;
    	
    	for(int x =orders.size(); (raf.length()/96)>x ; x++) {
			orders.add(new Product());
			orders.getLast().readBinFile(raf, x);
		}

	}	
	
	public void readBinFileProduct()throws IOException{
		Menu.closeRaf();
		raf = new RandomAccessFile(fileLocation,"rw");
    	for(int x =orders.size(); (raf.length()/96)>x ; x++) {
			orders.add(new Product());
			orders.getLast().readBinFile(raf, x);
		}
    	raf.close();
    	
		Menu.setRaf(1);

	}
	public void readBinFile(RandomAccessFile raf, int rec)throws IOException{
		this.raf = raf;
		
		raf.seek (rec * length);
		
		String temp = "";
        
		for (int i = 0 ; i < 30 ; i++) { temp = temp + raf.readChar();}
		        name =  temp.trim();
		        temp = "";
		        
		for (int i = 0 ; i < 60 ; i++) { temp = temp + raf.readChar(); }
		        address = temp.trim();
		        temp = "";
		for (int i = 0 ; i < 20 ; i++) { temp = temp + raf.readChar(); }
		        location = temp.trim();
		        temp = "";
		        
		 total =  raf.readDouble();
		 
		fileLocation = "./orderlist/"+location;
		
	}	
	public void update() throws IOException {
		if(raf!=null) {
			for(int x = 0 ; orders.size()>x ; x++) {
				if(orders.get(x).getUpdate()==true) {
					writeBinFileProduct(x);
					orders.get(x).setUpdate(false);
				}
			}
		}
		
	}
	
	public double calculatTotal() {
		for(int x = 0 ; orders.size()>x ; x++) {
			total+= orders.get(x).getPrice();
		}
		return total;
	}
	
	public void deleteAll() throws IOException {
	orders.clear();
	emptyBinFile();
	}
	
	public void printList() {
		System.out.println("Name: " + name);
		System.out.println("Address: "+ address);
		System.out.println("Total: "+total);
		System.out.println();
		
		for(int x = 0 ; orders.size()>x ; x++) {
			System.out.println("Product #"+(x+1));
			orders.get(x).printData();
		}
	}
	
	public String getLocation() {
		return this.location;
	}

	
	
	public void setLocation(String location) {
		this.location = location;
		update = true;
	}
	
	public void setName(String name) {
		this.name = name;
		update = true;
	}
	
	public String getName() {
		return name;
	}
	
	public void setAddress(String address) {
		this.address = address;
		update = true;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setTotal(double total) {
		this.total = total;
		update = true;
	}
	
	public double getTotal() {
		return total;
	}
	
	public void setRaf(RandomAccessFile raf) {
		this.raf = raf;
	}
	
	public RandomAccessFile getRaf() {
		return raf;
	}
	
	public void setUpdate(boolean update) {
		this.update = update;
		
	}
	public boolean getUpdate() {
		return update;
	}
	

	
}
