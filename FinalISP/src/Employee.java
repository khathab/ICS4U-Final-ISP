import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.LinkedList;

import javax.imageio.ImageIO;

public class Employee {
	


	private BufferedImage image;
	private String name;
	private double pay;
	private double payForTheWeek;
	private Object schedule;
	private double overtimeHours;
	private String employeeType;
	private double hoursWorked;
	private double overtimePay;
	private String location;
	private int length = 160;
	private int maxStringLength = 20;
	 
	
	public Employee() {
		
	}
	
	public Employee(BufferedImage image, String name,double pay,double overtimeHours,String employeeType,double hoursWorked,double payForTheWeek,double overtimePay,String location) {
		 	this.image = image;
			this.name	= name;
			this.pay=pay;
			//this.schedule=schedule;
			this.overtimeHours=overtimeHours;
			this.employeeType=employeeType;
			this.hoursWorked=hoursWorked;
			this.payForTheWeek=payForTheWeek;
			this.overtimePay=overtimePay;
			this.location = location;
	 }
	
	
	
	public void printData() {
		
		System.out.println("Name: " + name);
		System.out.println("Position: " + employeeType);
		System.out.println("Pay: "+ pay);
		System.out.println("Hours: "+hoursWorked);
		System.out.println("PayForTheWeek: "+payForTheWeek);
		System.out.println("Overtime Pay: "+overtimePay);
		System.out.println("Overtime Hours: "+overtimeHours);
		System.out.println("Image location: "+location);
		
		System.out.println();
		
	}
	
	public void readBinFile(RandomAccessFile raf, int rec)throws IOException{
		raf.seek (rec * length);      
		String temp = "";
		        
		for (int i = 0 ; i < maxStringLength ; i++) { temp = temp + raf.readChar();}
		        name =  temp.trim();
		        temp = "";
		        
		for (int i = 0 ; i < maxStringLength ; i++) { temp = temp + raf.readChar(); }
			employeeType = temp.trim();
		        temp = "";
		        
		for (int i = 0 ; i < maxStringLength ; i++) { temp = temp + raf.readChar(); }
			location = temp.trim();
			     temp = "";		        

		    
		
		pay = raf.readDouble();        
		payForTheWeek = raf.readDouble();
		overtimeHours = raf.readDouble();
		hoursWorked = raf.readDouble();
		overtimePay = raf.readDouble();
		
		
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
		    nameLen = employeeType.length ();
			padLen = 0;						
		    if (nameLen > maxStringLength)					
		        nameLen = maxStringLength;
		    else
		        padLen = maxStringLength - nameLen;
		    for (int i = 0 ; i < nameLen ; i++)	
		        raf.writeChar (employeeType.charAt (i));
		    if (padLen > 0)	{				
		        for (int i = 0 ; i < padLen ; i++)
		            raf.writeChar (' ');
		    }        
		
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
		       	raf.writeDouble (pay);
		        raf.writeDouble (payForTheWeek);
		    	raf.writeDouble (overtimeHours);
		        raf.writeDouble (hoursWorked);
		    	raf.writeDouble (overtimePay);

		
	}
	
	public  double calculatePay(){
		double earnings =0; 
		earnings = hoursWorked*pay;
				
		return earnings;	
	}
	
	public  double overtimePay() {
		double pay =0; 
		pay = overtimeHours*overtimePay;
		return pay;
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
	
	public double getOvertimePay() {
		return overtimePay;
	}
	public void setOvertimePay(double overtimePay) {
		this.overtimePay = overtimePay;
	}
	
	public double getPayForTheWeek() {
			return payForTheWeek;
	}
	public void setPayForTheWeek(double payForTheWeek) {
			this.payForTheWeek = payForTheWeek;
	}
	public double getHoursWorked() {
		return hoursWorked;
	}
	public void setHoursWorked(double hoursWorked) {
		this.hoursWorked = hoursWorked;
	}
	public String getName() {
				return name;
			}
	public void setName(String name) {
				this.name = name;
	}
	public double getPay() {
				return pay;
	}
	public void setPay(double pay) {
				this.pay = pay;
	}
	public Object getSchedule() {
				return schedule;
	}
	public void setSchedule(Object schedule) {
				this.schedule = schedule;
	}
	public double getOvertimeHours() {
				return overtimeHours;
	}
	public void setOvertimeHours(double overtimeHours) {
				this.overtimeHours = overtimeHours;
	}
	public String getEmployeeType() {
				return employeeType;
	}
	public void setEmployeeType(String employeeType) {
				this.employeeType = employeeType;
	}
			
}
