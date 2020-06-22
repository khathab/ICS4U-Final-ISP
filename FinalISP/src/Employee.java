
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;


public class Employee {
	

	private String name;
	private double pay;
	private double payForTheWeek;
	private schedule schedule = new schedule();; 
	private double overtimeHours;
	private String employeeType;
	private double hoursWorked;
	private double overtimePay;
	private String location;
	private int length = 328;
	private int maxStringLength = 20;
	private String imagelocation;
	private RandomAccessFile raf = null;
	private boolean update;
	public Employee() {
		
	}
	
	public Employee(String name,double pay,double overtimeHours,String employeeType,double hoursWorked,double payForTheWeek,double overtimePay,String location) {

			this.name	= name;
			this.pay=pay;
			this.overtimeHours=overtimeHours;
			this.employeeType=employeeType;
			this.hoursWorked=hoursWorked;
			this.payForTheWeek=payForTheWeek;
			this.overtimePay=overtimePay;
			this.location = location;
			imagelocation = "./Images/employees/"+location+".jpg";

			
	 }
	public Employee(String name,double pay,double overtimeHours,String employeeType,double hoursWorked,double payForTheWeek,double overtimePay,String location,schedule schedule) {

		this.name	= name;
		this.pay=pay;
		this.schedule=schedule;
		this.overtimeHours=overtimeHours;
		this.employeeType=employeeType;
		this.hoursWorked=hoursWorked;
		this.payForTheWeek=payForTheWeek;
		this.overtimePay=overtimePay;
		this.location = location;
		imagelocation = "./Images/employees/"+location+".jpg";

		
 }
	
   public String printData() {
		
		return "Name: " + name + "\n" + "Position: " + employeeType  + "\n" +"Pay: "+ pay  + "\n" +"Hours: "+hoursWorked + "\n" +"PayForTheWeek: "+payForTheWeek  + "\n" +"Overtime Pay: "+overtimePay + "\n" +"Overtime Hours: "+overtimeHours + "\n" +"Image location: "+imagelocation  + "\n" +"Schedule: " ;
		
	}
	
	
	public void readBinFile(RandomAccessFile rafs, int rec)throws IOException{
		raf = rafs;
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
		
		schedule.readBinFile(raf);
		
		imagelocation = "./Images/employees/"+location+".jpg";

		
		
	  
		
	
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
		    	
		    	schedule.writeBinFile(raf);

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
	
	
	public double getOvertimePay() {
		return overtimePay;
	}
	public void setOvertimePay(double overtimePay) {
		this.overtimePay = overtimePay;
		update = true;
	}
	
	public double getPayForTheWeek() {
			return payForTheWeek;
	}
	public void setPayForTheWeek(double payForTheWeek) {
			this.payForTheWeek = payForTheWeek;
			update = true;
	}
	public double getHoursWorked() {
		return hoursWorked;
	}
	public void setHoursWorked(double hoursWorked) {
		this.hoursWorked = hoursWorked;
		update = true;
	}
	public String getName() {
				return name;
			}
	public void setName(String name) {
				this.name = name;
				update = true;
	}
	public double getPay() {
				return pay;
	}
	public void setPay(double pay) {
				this.pay = pay;
				update = true;
	}
	public schedule getSchedule() {
				return schedule;
	}
	public void setSchedule(schedule schedule) {
				this.schedule = schedule;
				update = true;
	}
	public double getOvertimeHours() {
				return overtimeHours;
	}
	public void setOvertimeHours(double overtimeHours) {
				this.overtimeHours = overtimeHours;
				update = true;
	}
	public String getEmployeeType() {
				return employeeType;
	}
	public void setEmployeeType(String employeeType) {
				this.employeeType = employeeType;
				update = true;
	}
	
	public String getLocation() {
		return this.location;
	}


	public void setLocation(String location) {
		this.location = location;
		update = true;
	}
	
	
	public String getImageLocation() {
		return this.imagelocation;
	}


	public void setImageLocation(String imagelocation) {
		this.imagelocation = imagelocation;
		
	}
	
	public void setUpdate(boolean update) {
		this.update = update;
		
	}
	public boolean getUpdate() {
		return update;
	}
	
	
			
}
