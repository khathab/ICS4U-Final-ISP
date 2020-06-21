
import java.io.IOException;
import java.io.RandomAccessFile;



public class Item {


	private String name;
	private String location ;
	private String quantityType;
	private double quantity;
	private double price;
	private double lowCap;
	private String imagelocation;
	
	private int length = 144;
	private int maxStringLength = 20;
	public Item() {
		
	}

	public Item(String name,double quantity,double price,double lowCap,String quantityType,String location) {
		
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.lowCap = lowCap;
		this.quantityType = quantityType;
		this.location = location;
		imagelocation = "./Images/items/"+location+".jpg";
	}
	
	
	public String getName() {
		return this.name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	public String getLocation() {
		return this.location;
	}


	public void setLocation(String location) {
		this.location = location;
	}
	
	public double getQuantity() {
		return this.quantity;
	}


	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return this.price;
	}


	public void setPrice(double price) {
		this.price = price;
	}

	public double getLowCap() {
		return this.lowCap;
	}


	public void setLowCap(double lowCap) {
		this.lowCap = lowCap;
	}

	public String getQuanitityType() {
		return this.quantityType;
	}


	public void setQuanitityType(String quantityType) {
		this.quantityType = quantityType;
	}
	
	public String getImageLocation() {
		return this.imagelocation;
	}


	public void setImageLocation(String imagelocation) {
		this.imagelocation = imagelocation;
	}
	
	public void printData() {
		
		System.out.println("Name: " + name);
		System.out.println("Location: "+location);
		System.out.println("Quantity: "+ quantity);
		System.out.println("Quantity Type: "+ quantityType);
		System.out.println("Price: "+price);
		System.out.println("Low Cap: "+ lowCap);
		System.out.println();
		
	}
	
	public void readBinFile(RandomAccessFile raf, int rec)throws IOException{
		raf.seek (rec * length);      
		String temp = "";
		        
		for (int i = 0 ; i < maxStringLength ; i++) { temp = temp + raf.readChar();}
		        name =  temp.trim();
		        temp = "";
		        
		for (int i = 0 ; i < maxStringLength ; i++) { temp = temp + raf.readChar(); }
		        location = temp.trim();
		        temp = "";
		
		for (int i = 0 ; i < maxStringLength ; i++) { temp = temp + raf.readChar(); }
		        quantityType = temp.trim();
		        temp = "";
		
		quantity = raf.readDouble();        
		price = raf.readDouble();
		lowCap = raf.readDouble();
		imagelocation = "./Images/items/"+location+".jpg";
	}
	
	public void writeBinFile(RandomAccessFile raf, int rec)throws IOException{
		raf.seek (rec * length);
		
		 int nameLen = name.length (); 
		int padLen = 0;	
		
		 // pads record fields
			if (nameLen > maxStringLength)					
		        nameLen = maxStringLength;
		    else
		        padLen = maxStringLength - nameLen;
		    for (int i = 0 ; i < nameLen ; i++)	
		        raf.writeChar (name.charAt (i));
		    if (padLen > 0)	{					
		        for (int i = 0 ; i < padLen ; i++)
		            raf.writeChar (' ');
		    }
		 // pads record fields 
		    nameLen = location.length ();
			padLen = 0;						
		    if (nameLen > maxStringLength)					
		        nameLen = maxStringLength;
		    else
		        padLen = maxStringLength - nameLen;
		    for (int i = 0 ; i < nameLen ; i++)	
		        raf.writeChar (location.charAt (i));
		    if (padLen > 0)	{				
		        for (int i = 0 ; i < padLen ; i++)
		            raf.writeChar (' ');
		    }    
		    
		    nameLen = quantityType.length ();
			padLen = 0;		
			
		    if (nameLen > maxStringLength)					
		        nameLen = maxStringLength;
		    else
		        padLen = maxStringLength - nameLen;
		    for (int i = 0 ; i < nameLen ; i++)	
		        raf.writeChar (quantityType.charAt (i));
		    if (padLen > 0)	{				
		        for (int i = 0 ; i < padLen ; i++)
		            raf.writeChar (' ');
		    } 
		       
		    // writes rest of field to binary file
		       	raf.writeDouble (quantity);
		        raf.writeDouble (price);
		        raf.writeDouble (lowCap);
		
	}

}