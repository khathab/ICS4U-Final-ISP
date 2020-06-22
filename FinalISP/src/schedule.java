import java.io.IOException;
import java.io.RandomAccessFile;

public class schedule {
	
	
	private boolean[][] workSchedule = new boolean[7][24]; 
	private boolean update;
	
	public schedule() {
		empty();
	}
	
	public void empty() {
		update = true;
		for(int day = 0;7>day;day++) {
			for(int hour = 0;24>hour;hour++ ) {
				workSchedule[day][hour] = false;
			}
		}
	}
	
	public void removeDay(int day) {
		update = true;
		for(int hour = 0;24>hour;hour++ ) {
			workSchedule[day][hour] = false;
		}
	}
	
	public void addShift(int day, int start, int end) {
		update = true;
		for(int x = start;end>x;x++) {
			workSchedule[day][x] = true;
		}
	}
	
	public void setSchedule(boolean[][] workSchedule) {
		update = true;
		for(int day = 0;7>day;day++) {
			for(int hour = 0;24>hour;hour++ ) {
				this.workSchedule[day][hour] = workSchedule[day][hour];
			}
		}
	}
	
	public boolean[][] getSchedule(){
		return workSchedule;
	}
	
	public void readBinFile(RandomAccessFile raf)throws IOException{
		  
		        
		for(int day = 0;7>day;day++) {
			for(int hour = 0;24>hour;hour++ ) {
				workSchedule[day][hour] = raf.readBoolean();
			}
		}
		    
		
	}
	
	public void writeBinFile(RandomAccessFile raf)throws IOException{

		
		for(int day = 0;7>day;day++) {
			for(int hour = 0;24>hour;hour++ ) {
				raf.writeBoolean(workSchedule[day][hour]);
			}
		}
		
		
	}
	
	public void printData() {
		for(int day = 0;7>day;day++) {
			for(int hour = 0;24>hour;hour++ ) {
				if(workSchedule[day][hour]== true) {
					System.out.print(1);
				}else if(workSchedule[day][hour]== false) {
					System.out.print(0);
				}
			}
			System.out.println();
		}
	}
	
	public void setUpdate(boolean update) {
		this.update = update;
		
	}
	public boolean getUpdate() {
		return update;
	}
}
