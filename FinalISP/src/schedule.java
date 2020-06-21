import java.io.IOException;
import java.io.RandomAccessFile;

public class schedule {
	
	private int[][] workSchedule = new int[7][24]; 
	
	public schedule() {
		empty();
	}
	
	public void empty() {
		for(int day = 0;7>day;day++) {
			for(int hour = 0;24>hour;hour++ ) {
				workSchedule[day][hour] = 0;
			}
		}
	}
	
	public void removeDay(int day) {
		for(int hour = 0;24>hour;hour++ ) {
			workSchedule[day][hour] = 0;
		}
	}
	
	public void addShift(int day, int start, int end) {
		for(int x = start;end>x;x++) {
			workSchedule[day][x] = 1;
		}
	}
	
	public void setSchedule(int[][] workSchedule) {
		for(int day = 0;7>day;day++) {
			for(int hour = 0;24>hour;hour++ ) {
				this.workSchedule[day][hour] = workSchedule[day][hour];
			}
		}
	}
	
	public int[][] getSchedule(){
		return workSchedule;
	}
	
	public void readBinFile(RandomAccessFile raf)throws IOException{
		  
		        
		for(int day = 0;7>day;day++) {
			for(int hour = 0;24>hour;hour++ ) {
				workSchedule[day][hour] = raf.readInt();
			}
		}
		    
		
	}
	
	public void writeBinFile(RandomAccessFile raf)throws IOException{

		
		for(int day = 0;7>day;day++) {
			for(int hour = 0;24>hour;hour++ ) {
				raf.writeInt(workSchedule[day][hour]);
			}
		}
		
		
	}
	
	public void printData() {
		for(int day = 0;7>day;day++) {
			for(int hour = 0;24>hour;hour++ ) {
				System.out.print(workSchedule[day][hour]);
			}
			System.out.println();
		}
	}
}
