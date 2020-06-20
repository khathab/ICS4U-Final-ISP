import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.imageio.ImageIO;



public class Product {

	private BufferedImage image;
	private String name;
	private String location ;
	private double quantity;
	private double price;
	private int length = 96;
	private int maxStringLength = 20;
	public Product() {
		
	}
	
	public Product(BufferedImage image,String name,double quantity,double price, String location) {
		this.image = image;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.location = location;
	}
	
	public BufferedImage getImage() {
		return this.image;
	}

	
	public void setImage(BufferedImage image) {
		this.image = image;
	}
	
	public void setImage() {
		try {
			image = ImageIO.read(new File(location));
		} catch (IOException e) {
			e.printStackTrace();
		}
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
	public void printData() {
	
		System.out.println("Name: " + name);
		System.out.println("Quantity: "+ quantity);
		System.out.println("Price: "+price);
		System.out.println("Location: "+location);
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
		
		quantity = raf.readDouble();        
		price = raf.readDouble();
		
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
		
		       
		    // writes rest of field to binary file
		       	raf.writeDouble (quantity);
		        raf.writeDouble (price);
		
	}
}
