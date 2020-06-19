import java.util.LinkedList;

public class Employee {
	
	
	public LinkedList<Employee> inventory = new LinkedList<Employee>();;
	
public void employeeList() {
		
	}
public void addItem(String name, double pay, double payForTheWeek, Object schedule, double overtimeHours,String employeeType,double hoursWorked ) {
	inventory.add(new Employee(name,pay,payForTheWeek,schedule,overtimeHours,employeeType,hoursWorked));
}


	String name;
	   double pay;
	   double payForTheWeek;
	  
	Object schedule;
	 double overtimeHours;
	 String employeeType;
	 double hoursWorked;
	 double overtimePay;
	public Employee(double pay,String name,Object schedule,double overtimeHours,String employeeType,double hoursWorked,double payForTheWeek,double overtimePay) {
		 this.pay=pay;
			this.name	= name;
			this.schedule=schedule;
			this.overtimeHours=overtimeHours;
			this.employeeType=employeeType;
			this.hoursWorked=hoursWorked;
			this.payForTheWeek=payForTheWeek;
			this.overtimePay=overtimePay;
	 }
	 public double getOvertimePay() {
		return overtimePay;
	}
	public void setOvertimePay(double overtimePay) {
		this.overtimePay = overtimePay;
	}
	public Employee() {
			pay = 0;
		    name = "";
		    schedule = "";
		    overtimeHours= 0;
		    employeeType = "";
		    hoursWorked = 0;
		    payForTheWeek=0;
		   overtimePay=0;
		}
	 public Employee(String name2, double pay2, double payForTheWeek2, Object schedule2, double overtimeHours2,
			String employeeType2, double hoursWorked2) {
		// TODO Auto-generated constructor stub
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
