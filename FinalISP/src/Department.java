
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.LinkedList;

public class Department {
public LinkedList<Employee> department = new LinkedList<Employee>();;
	
	public RandomAccessFile raf = null;

	public Department() {
		
	}
	
	public void addItem(String name,double pay,double overtimeHours,String employeeType,double hoursWorked,double payForTheWeek,double overtimePay,String location,schedule schedule) throws IOException {
		department.add(new Employee(name,pay,overtimeHours,employeeType,hoursWorked,payForTheWeek,overtimePay, location,schedule));
		if(raf!=null) {
			writeBinFile(department.size()-1);
		}
	}
	public void addItem(String name,double pay,double overtimeHours,String employeeType,double hoursWorked,double payForTheWeek,double overtimePay,String location) throws IOException {
		department.add(new Employee(name,pay,overtimeHours,employeeType,hoursWorked,payForTheWeek,overtimePay, location));
		if(raf!=null) {
			writeBinFile(department.size()-1);
		}
	}
	public void addItem() throws IOException {
		department.add(new Employee());
		if(raf!=null) {
			writeBinFile(department.size()-1);
		}
	}
	
	public void removeItem(Employee employee) throws IOException{
		department.remove(employee);
		if(raf!=null) {
			emptyBinFile();
			writeBinFile();
		}
	}
	

	public void removeItem(int employee) throws IOException{
		department.remove(employee);
		if(raf!=null) {
			emptyBinFile();
			writeBinFile();
		}
	}
	
	public void emptyBinFile() throws IOException {
		raf = Menu.setRafBin(3);
		
		
	}
	
	public void writeBinFile(RandomAccessFile rafs)throws IOException{
		raf = rafs;
		for(int x = 0 ; department.size()>x ; x++) {
			department.get(x).writeBinFile(raf, x);
			
		}
	}
	
	public void writeBinFile()throws IOException{

		for(int x = 0 ; department.size()>x ; x++) {
			department.get(x).writeBinFile(raf, x);
		}
	}
	
	public void writeBinFile(int x)throws IOException{
		department.get(x).writeBinFile(raf, x);
	}
	
	public void readBinFile(RandomAccessFile rafs)throws IOException{
		raf = rafs;
		for(int x =department.size(); raf.length()/328>x ; x++) {
			department.add(new Employee());
			department.getLast().readBinFile(raf, x);
		}
	}	
	
	public void update() throws IOException {
		if(raf!=null) {
			for(int x = 0 ; department.size()>x ; x++) {
				if(department.get(x).getUpdate()==true||department.get(x).getSchedule().getUpdate()==true) {
					writeBinFile(x);
					department.get(x).setUpdate(false);
					department.get(x).getSchedule().setUpdate(false);
					}
			}
		}
		
	}
	public void deleteAll() throws IOException {
		department.clear();
		emptyBinFile();
		}
	
	public void printList() {

		for(int x = 0 ; department.size()>x ; x++) {
			System.out.println("Item #"+(x+1));
			department.get(x).printData();
		}
	}
	
	public void setRaf(RandomAccessFile raf) {
		this.raf = raf;
	}
	
	public RandomAccessFile getRaf() {
		return raf;
	}
	



}
