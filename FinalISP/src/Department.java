
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.LinkedList;

public class Department {
public LinkedList<Employee> inventory = new LinkedList<Employee>();;
	
	private RandomAccessFile raf = null;

	public Department() {
		
	}
	
	public void addItem(String name,double pay,double overtimeHours,String employeeType,double hoursWorked,double payForTheWeek,double overtimePay,String location) throws IOException {
		inventory.add(new Employee(name,pay,overtimeHours,employeeType,hoursWorked,payForTheWeek,overtimePay, location));
		if(raf!=null) {
			writeBinFile(inventory.size()-1);
		}
	}
	
	public void addItem() throws IOException {
		inventory.add(new Employee());
		if(raf!=null) {
			writeBinFile(inventory.size()-1);
		}
	}
	
	public void removeItem(Employee employee) throws IOException{
		inventory.remove(employee);
		if(raf!=null) {
			emptyBinFile();
			writeBinFile();
		}
	}
	

	public void removeItem(int employee) throws IOException{
		inventory.remove(employee);
		if(raf!=null) {
			emptyBinFile();
			writeBinFile();
		}
	}
	
	public void emptyBinFile() throws IOException {
		raf = Menu.setRafBin(3);
		
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
		for(int x =inventory.size(); raf.length()/160>x ; x++) {
			inventory.add(new Employee());
			inventory.getLast().readBinFile(raf, x);
		}
	}	
	
	
	public void deleteAll() throws IOException {
		inventory.clear();
		emptyBinFile();
		}
	
	public void printList() {

		for(int x = 0 ; inventory.size()>x ; x++) {
			System.out.println("Item #"+(x+1));
			inventory.get(x).printData();
		}
	}
	
	public void setRaf(RandomAccessFile raf) {
		this.raf = raf;
	}
	
	public RandomAccessFile getRaf() {
		return raf;
	}
}
