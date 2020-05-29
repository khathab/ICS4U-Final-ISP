package src;


/**
***********************************************
@Author : Khathab Hamed 
@First Created: 2/28/2020
@Last Modified: 3/10/2020
@Description: This program allow the user in input book record from a binary or ASCII file and allows them to maintain it 
by editing, sort, adding and deleting record while constantly storing the record

***********************************************
*/
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Bookstore {
	
	/*
	* Method Name:  inputNonBinData()
	*Author: Khathab Hamed
	* Creation Date; 2 28, 2020
	* Modified Date: 3 2, 2020
	*Description: inputs record from ASCII file
	* @Parameters: String fileName, int numBooks
	* @Return Value: Book[]
	* Data Type: example: record of books
	* Dependencies: n/a
	*Throws/Exceptions: n/a 
	*/
	public static Book[] inputNonBinData (String fileName, int numBooks) {
		int i=0;	
		Book[] bookShelf = new Book[numBooks];
		try{
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
            while(in.ready()==true){                       
					bookShelf[i] = new Book();
					bookShelf[i].setBookName(in.readLine());
					bookShelf[i].setAuthor(in.readLine());
					bookShelf[i].setPublisher(in.readLine());
					bookShelf[i].setISBN(Long.parseLong(in.readLine()));
					bookShelf[i].setPrice(Double.parseDouble(in.readLine()));
					bookShelf[i].setQuantity(Integer.parseInt(in.readLine()));
					bookShelf[i].setRecordNumber(i);
					i++;
				}	
			in.close();
		} catch (IOException e) {};	
		return bookShelf;
	}	
	
	/*
	* Method Name:  findBookRec()
	*Author: Khathab Hamed
	* Creation Date; 3 2, 2020
	* Modified Date: 3 4, 2020
	*Description: finds number of record in an ASCII file
	* @Parameters: String fileName, int recSize
	* @Return Value: integer
	* Data Type: example: size of recs
	* Dependencies: n/a
	*Throws/Exceptions: n/a 
	*/
	public static int findBookRec (String fileName, int recSize) {
		int i=0;	
		try{
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
            while(in.ready()==true){                       
					in.readLine();
					i++;
				}	
			in.close();
		} catch (IOException e) {};	
		i = i/recSize;
		return i;
	}	
	/*
	* Method Name:  findBookRecBin()
	*Author: Khathab Hamed
	* Creation Date; 2 30, 2020
	* Modified Date: 3 1, 2020
	*Description: finds number of record in a binary file
	* @Parameters: String fileName, int recSize
	* @Return Value: integer
	* Data Type: example: size of recs
	* Dependencies: n/a
	*Throws/Exceptions: IOException 
	*/
	public static int findBookRecBin (String fileName, int recSize) throws IOException {
		long i=0;	
		RandomAccessFile raf = new RandomAccessFile(fileName,"rw");
		i = raf.length();
		i = i/recSize;
		raf.close();
		return (int)i;
	}	
	/*
	* Method Name:  addRAF()
	*Author: Khathab Hamed
	* Creation Date; 3 1, 2020
	* Modified Date: 3 3, 2020
	*Description: adds to  a record
	* @Parameters: String filename, Book bookShelf[], Book bookTemp
	* @Return Value: n/a
	* Data Type: example: n/a
	* Dependencies: n/a
	*Throws/Exceptions: IOException
	*/
	public static void addRAF(String filename, Book bookShelf[], Book bookTemp) throws IOException{
		bookShelf[bookShelf.length-1] = new Book();
		bookShelf[bookShelf.length-1].setAuthor(bookTemp.getAuthor()) ;
		bookShelf[bookShelf.length-1].setBookName(bookTemp.getBookName()) ;
		bookShelf[bookShelf.length-1].setISBN(bookTemp.getISBN()) ;
		bookShelf[bookShelf.length-1].setPrice(bookTemp.getPrice()) ;
		bookShelf[bookShelf.length-1].setPublisher(bookTemp.getPublisher()) ;
		bookShelf[bookShelf.length-1].setQuantity(bookTemp.getQuantity()) ;
		bookShelf[bookShelf.length-1].setRecordNumber(bookShelf.length-1);
		
		RandomAccessFile raf = new RandomAccessFile(filename,"rw");
					
		bookShelf[bookShelf.length-1].writeBinFile(raf);
		
	    raf.close();
	}
	/*
	* Method Name:  printToConsole()
	*Author: Khathab Hamed
	* Creation Date; 3 2, 2020
	* Modified Date: 3 10, 2020
	*Description: prints an array to the console
	* @Parameters: Book bookShelf[], int numrecs
	* @Return Value: n/a
	* Data Type: example: n/a
	* Dependencies: n/a
	*Throws/Exceptions: n/a
	*/
	public static void printToConsole (Book bookShelf[], int numrecs) {
		System.out.format("%2s %60s %20s %20s %16s %10s %10s %20s", "#","Title" ,"Author" , "Publisher", "ISBN", "Price $" , "Quantity", "Total"); 
		System.out.println();

		for (int f= 0; f< numrecs; f++)
			
			if(bookShelf[f].getBookName().compareTo("#1#") == 0) {
				
			}else {
				System.out.format("%2s %60s %20s %20s %16s %10s %10s %20s", f+1 +".", bookShelf[f].getBookName() ,bookShelf[f].getAuthor() , bookShelf[f].getPublisher(), bookShelf[f].getISBN(), bookShelf[f].getPrice() , bookShelf[f].getQuantity(), bookShelf[f].getQuantity()*bookShelf[f].getPrice()); 
				System.out.println();
			}
		      	
		      	
			}
	/*
	* Method Name:  writeNewBinFile()
	*Author: Khathab Hamed
	* Creation Date; 2 29, 2020
	* Modified Date: 3 1, 2020
	*Description: writes an array of record to a binary file
	* @Parameters: String filename, Book bookShelf[], int numrecs
	* @Return Value: n/a
	* Data Type: example: n/a
	* Dependencies: n/a
	*Throws/Exceptions: IOException
	*/		
	public static void writeNewBinFile(String filename, Book bookShelf[], int numrecs) throws IOException{
		RandomAccessFile raf = new RandomAccessFile(filename,"rw");
		for (int i=0; i < numrecs; i++) {			
			bookShelf[i].writeBinFile(raf);
		}
	    raf.close();
	}
	/*
	* Method Name:  readNewBinFile()
	*Author: Khathab Hamed
	* Creation Date; 2 29, 2020
	* Modified Date: 3 1, 2020
	*Description: reads an array of record from a binary file
	* @Parameters: String filename,int  numrecs
	* @Return Value: Book[]
	* Data Type: example: array of books
	* Dependencies: n/a
	*Throws/Exceptions: IOException
	*/
	public static Book[] readNewBinFile(String filename,int  numrecs) throws IOException{
		RandomAccessFile raf = new RandomAccessFile(filename,"rw");
		Book[] bookShelf = new Book[numrecs];
		for (int i=0; i < numrecs; i++) {
			bookShelf[i] = new Book();
			bookShelf[i].readBinFile(raf, i);
		} //end for
		raf.close();
		return bookShelf;
	}
	/*
	* Method Name:  searchISBN()
	*Author: Khathab Hamed
	* Creation Date; 3 6, 2020
	* Modified Date: 3 6, 2020
	*Description: searches for an ISBN from an array of Books
	* @Parameters: Book bookShelf[], long ISBN
	* @Return Value: integer
	* Data Type: example: location of record with same ISBN
	* Dependencies: n/a
	*Throws/Exceptions: -1
	*/
	public static int searchISBN(Book bookShelf[], long ISBN) {
		int i = -1;
		for(int p = 0; p < bookShelf.length; p++) {
			if(bookShelf[p].getISBN()== ISBN) {
				i = p;
				break;
			}
		}
		return i;
	}
	/*
	* Method Name:  searchAuthor()
	*Author: Khathab Hamed
	* Creation Date; 3 7, 2020
	* Modified Date: 3 9, 2020
	*Description: searches for an author's books
	* @Parameters: Book bookShelf[], String author
	* @Return Value: int[]
	* Data Type: example: location of books by authors
	* Dependencies: n/a
	*Throws/Exceptions: -1
	*/
	public static int[] searchAuthor(Book bookShelf[], String author) {
		
		int count = 0;
		int booksWritten = 0;
		for(int j = 0;j<bookShelf.length;j++) {
			if(bookShelf[j].getAuthor().compareTo(author)==0) {
				booksWritten++;
			}
		}
		if(booksWritten>0) {
		int[] holdPositions = new int[booksWritten];
		for(int p = 0; p < bookShelf.length; p++) {
			if(bookShelf[p].getAuthor().compareTo(author)== 0) {
				holdPositions[count] = p;
				count++;
				if(count==booksWritten) {
				break;	
				}
			}
		}
		return holdPositions;
		}else {
			int[] negative = new int[1];
			negative[0] = -1;
		return negative;	
		}
		
		
	}
	/*
	* Method Name:  sortBooks()
	*Author: Khathab Hamed
	* Creation Date; 3 2, 2020
	* Modified Date: 3 2, 2020
	*Description: sorts books by ISBN
	* @Parameters: Book bookShelf[],int numBooks
	* @Return Value: int[]
	* Data Type: example: sorted array of Books
	* Dependencies: n/a
	*Throws/Exceptions: n/a
	*/
	public static Book[] sortBooks(Book bookShelf[],int numBooks) { 
        int n = numBooks; 
        for (int i = 1; i < n; ++i) { 
            long keyISBN = bookShelf[i].getISBN(); 
            Book holdbook = bookShelf[i];
            int j = i - 1; 
  
            while (j >= 0 && (bookShelf[j].getISBN() >= keyISBN)) { 

            	bookShelf[j+1] = bookShelf[j];

                  j = j - 1; 
            } 
            bookShelf[j+1] = holdbook;
        } 
       
        return bookShelf;
    } 
	/*
	* Method Name:  ReAlignBooks()
	*Author: Khathab Hamed
	* Creation Date; 3 10, 2020
	* Modified Date: 3 10, 2020
	*Description: puts deleted records that are empty at the bottom of the array
	* @Parameters: Book bookShelf[]
	* @Return Value: Book[]
	* Data Type: example: array with empty record at the bottom
	* Dependencies: n/a
	*Throws/Exceptions: n/a
	*/
	public static Book[] ReAlignBooks(Book bookShelf[]) { 
      
        for (int i = 0; i < bookShelf.length; i++){
           for (int j = 0; j < bookShelf.length-1; j++){
              if (bookShelf[j].getBookName().compareTo("#1#") == 0){
            	  Book holdbook = bookShelf[j+1];
            	  bookShelf[j+1] = bookShelf[j];
            	  bookShelf[j] = holdbook;
            	  
              }
           }
        }
        return bookShelf;
    }
	/*
	* Method Name:  printARecord()
	*Author: Khathab Hamed
	* Creation Date; 3 1, 2020
	* Modified Date: 3 1, 2020
	*Description: prints a single record
	* @Parameters: Book bookShelf[], int i
	* @Return Value: n/a
	* Data Type: example: n/a
	* Dependencies: n/a
	*Throws/Exceptions: n/a
	*/
	public static void printARecord(Book bookShelf[], int i) {
		System.out.println (bookShelf[i].getBookName() + "\t" + bookShelf[i].getAuthor() + "\t" + bookShelf[i].getPublisher()+ "\t" + bookShelf[i].getISBN()+ "\t" + bookShelf[i].getPrice() + "\t" + bookShelf[i].getQuantity()); 
	 }
	/*
	* Method Name:  deleteRecord()
	*Author: Khathab Hamed
	* Creation Date; 3 2, 2020
	* Modified Date: 3 2, 2020
	*Description: deletes a record from array and replaces the bin file by blanks
	* @Parameters: Book bookShelf[], int i,String filename
	* @Return Value: n/a
	* Data Type: example: n/a
	* Dependencies: n/a
	*Throws/Exceptions: IOException
	*/
	public static void deleteRecord(Book bookShelf[], int i,String filename) throws IOException {
		System.out.println(bookShelf[i-1].getBookName()+" has been Deleted!!");
		RandomAccessFile raf = new RandomAccessFile(filename,"rw");
				
		bookShelf[i-1].deleteRec(raf);
	    raf.close();
	}
	/*
	* Method Name:  editRecord()
	*Author: Khathab Hamed
	* Creation Date; 3 2, 2020
	* Modified Date: 3 2, 2020
	*Description: changes record with edited record and replaces it in the bin file
	* @Parameters: Book bookShelf[], int i,String filename
	* @Return Value: n/a
	* Data Type: example: n/a
	* Dependencies: n/a
	*Throws/Exceptions: IOException
	*/
	public static void editRecord(Book bookShelf[], int i,String filename) throws IOException {
		System.out.println(filename + " " +bookShelf[i].getRecordNumber());
		RandomAccessFile raf = new RandomAccessFile(filename,"rw");
		i = bookShelf[i].getRecordNumber();
		bookShelf[i].writeBinFile(raf);
		raf.close();
	}
	/*
	* Method Name:  addNewRec()
	*Author: Khathab Hamed
	* Creation Date; 3 1, 2020
	* Modified Date: 3 2, 2020
	*Description: copies array records to new array record with a 1 higher array length
	* @Parameters: Book bookShelf[], int i,String filename
	* @Return Value: Book[]
	* Data Type: example: array of record with bigger size
	* Dependencies: n/a
	*Throws/Exceptions: n/a
	*/
	public static Book[] addNewRec(Book[] tempBooks) {
		Book[] bookShelf = new Book[tempBooks.length+1];
		
		for(int i=0; i<tempBooks.length;i++) {
			bookShelf[i] = tempBooks[i];
		}
		return bookShelf;
	}
	
	public static void main(String[] args) throws IOException {
		int lengthrecord = 260; // constant that specifies the recordlength
		 int numBooks = 0; // stores the number of record that exist
		 int recAt = 0; // stores a record current location
		 long ISBNHold = 0; //stores the ISBN number to be searched for
		 String response; // stores user response
		 boolean end = false; //  stores if the user is exiting
		 boolean canStore = false; // stores if the user inputed data 
		 int option = 0; // stores selected menu option by user
		 String txtFileName, binFileName="BinFile"; // stores bin and ascii file names
 		 Scanner scan = new Scanner(System.in);  // scanner initialized
	     Book[] books = null; // stores book record
	     Book	tempBook = new Book(); // stores temporary book record
	     
	     do {
	    	 // menu options
	    	 System.out.println("1. to read an ASCII file\n" +
	    			 			"2. to read a binary file.\n" +
	    			 			"3. to store the array in a binary file.\n" +
	    			 			"4. to sort the array by the ISBN.\n" +
	    			 			"5. to print the data on the books.\n" +
	    			 			"6. to add a new record.\n" +
	    			 			"7. to delete a record.\n" +
	    			 			"8. to edit a field of a record.\n" +
								"9. to search by ISBN\n" +
								"10. to search by Author\n" +
								"11. to quit");
	    	 
	    response = scan.nextLine(); // stores user response
	    
	    // try catch for vetting option number
	    try {
	    	
	    	if((Integer.parseInt(response)>0)&&(Integer.parseInt(response)<12)) {
				option = Integer.parseInt(response);
			}
	    }catch(NumberFormatException e) {
	    	
	    }
		
	    // case statment for all menu options
		  switch(option) {
		  // if user didn't properly input option menu
		  case 0: System.out.println("This option number doesn't exist! Try Again");
		  			break;
		  // reading ascii file
		  case 1:	System.out.println("Please enter an ASCII file name to read");
					txtFileName= scan.nextLine(); // input file name
					numBooks = findBookRec(txtFileName,6); // find number of record in the ascii file
					books = inputNonBinData(txtFileName, numBooks); //  store book record from ascii file in books
					printToConsole(books, numBooks); // print records
					canStore = true; // user can user other menu options
					break;
				
		  case 2:
		// reading bin file	  
				System.out.println("Please enter a Binary file name to read");
				binFileName= scan.nextLine();	// input file name
				numBooks = findBookRecBin(binFileName,lengthrecord); // find number of record in bin file
				books = readNewBinFile(binFileName, numBooks); //store book record from bin file in books
				books = ReAlignBooks(books); // moves empty record to the top of the record in books
				printToConsole(books, numBooks); //  print records
				canStore = true; // user can user other menu options
				break;
		  case 3:
			  // if data has been inputed
			  if(canStore) {
				System.out.println("Please enter a Binary file name to write to");
				binFileName= scan.nextLine(); // input bin file name
  	  			writeNewBinFile(binFileName, books, numBooks);  // write record to bin file
			  }else {
				  System.out.println("Data Base Empty, Please Read in any File First");
			  }
				
  	  			break;
  	  	
		 //sorts ISBN
		  case 4:
			  // if data has been inputed
			  if(canStore) {
				  books = sortBooks(books,numBooks); // sorts books using ISBN
				  books = ReAlignBooks(books); // moves empty record to the top of the record in books
				  System.out.println("Sorted!!");
					printToConsole(books, numBooks);  // print record
				  }else {
					  System.out.println("Data Base Empty, Please Read in any File First");
				  }
				
				break;
		  
 		//prints records
		  case 5:
			  // if data has been inputed
			  if(canStore) {
				  
				  printToConsole(books, numBooks); // print records
				  }else {
					  System.out.println("Data Base Empty, Please Read in any File First");
				  }
			  
			  break;
		// adds record
		  case 6:
			  // if data has been inputed
			  if(canStore) {
				  numBooks++; 
				  // inputs record fields one by one
					books = addNewRec(books);
					System.out.println("Enter Title");
					tempBook.setBookName(scan.nextLine());
					System.out.println("Enter Author");
					tempBook.setAuthor(scan.nextLine());
					System.out.println("Enter Publisher");
					tempBook.setPublisher(scan.nextLine());
					System.out.println("Enter ISBN");
					tempBook.setISBN(Long.parseLong(scan.nextLine()));
					System.out.println("Enter Quantity");
					tempBook.setQuantity(Integer.parseInt(scan.nextLine()));
					System.out.println("Enter Price");
					tempBook.setPrice(Double.parseDouble(scan.nextLine()));
					addRAF(binFileName,books,tempBook); //writes new book record to bin file
					books = ReAlignBooks(books); // // moves empty record to the top of the record in books
				  }else {
					  System.out.println("Data Base Empty, Please Read in any File First");
				  }
				
				break;
		// deletes record
		  case 7:
			  // if data has been inputed
			  if(canStore) {
				  printToConsole(books, numBooks); //prints record
					System.out.println("Please enter the record number you want to delete from the list?");
					recAt = Integer.parseInt(scan.nextLine()); // record number to delete
					deleteRecord(books,recAt,binFileName); // deletes record by replacing it with blanks in bin file
					books = ReAlignBooks(books); // moves empty record to the top of the record in books
					printToConsole(books, numBooks); // prints records
				  }else {
					  System.out.println("Data Base Empty, Please Read in any File First");
				  }
				
				break;
		// edit record
		  case 8:
			  // if data has been inputed
			  if(canStore) {
				  printToConsole(books, numBooks); // prints records
					System.out.println("Please enter the record number you want to edit from the list?");
					recAt = Integer.parseInt(scan.nextLine()); // usr inputs what record they want to edit
					recAt--; 
					
					// one by one checks if user wants to edit a field and what they want to edit it to
					System.out.println("Do you want to edit the Title?(yes/no)");
					response = scan.nextLine();
		 			if (response.charAt(0)=='y') {
		 				System.out.println("Enter title");
		 				response = scan.nextLine();
		 				books[recAt].setBookName(response);
		 			}
		 			
		 			System.out.println("Do you want to edit the Author Name?(yes/no)");
					response = scan.nextLine();
		 			if (response.charAt(0)=='y') {
		 				System.out.println("Enter Author Name");
		 				response = scan.nextLine();
		 				books[recAt].setAuthor(response);
		 			}
		 			
		 			System.out.println("Do you want to edit the Publisher Name?(yes/no)");
					response = scan.nextLine();
		 			if (response.charAt(0)=='y') {
		 				System.out.println("Enter Publisher Name");
		 				response = scan.nextLine();
		 				books[recAt].setPublisher(response);
		 			}
		 			
		 			System.out.println("Do you want to edit the ISBN?(yes/no)");
					response = scan.nextLine();
		 			if (response.charAt(0)=='y') {
		 				System.out.println("Enter ISBN");
		 				response = scan.nextLine();
		 				books[recAt].setISBN(Long.parseLong(response));
		 			}
		 			
		 			System.out.println("Do you want to edit the Price?(yes/no)");
					response = scan.nextLine();
		 			if (response.charAt(0)=='y') {
		 				System.out.println("Enter Price");
		 				response = scan.nextLine();
		 				books[recAt].setPrice(Double.parseDouble(response));
		 			}
		 			
		 			System.out.println("Do you want to edit the Quantity?(yes/no)");
					response = scan.nextLine();
		 			if (response.charAt(0)=='y') {
		 				System.out.println("Enter Quantity");
		 				response = scan.nextLine();
		 				books[recAt].setQuantity(Integer.parseInt(response));
		 			}
		 			
					editRecord(books,recAt,binFileName); // changes record in bin file
					printToConsole(books, numBooks); // prints records
				  }else {
					  System.out.println("Data Base Empty, Please Read in any File First");
				  }
 				
				break;
 			
		  
 			
 			//search using ISBN
		  case 9:
			  // if data has been inputed
			  if(canStore) {
				  
				  System.out.println("Please enter the ISBN?");
					response= scan.nextLine(); 
					ISBNHold = Long.parseLong(response); //stores user inputed ISBN 
					recAt = searchISBN(books, ISBNHold); // searches if ISBN matches any others
				// if found prints rest of record for ISBN
					if(recAt >-1) {
						printARecord(books, recAt);
					}else {
						System.out.println("The Book you are looking for doesn't exist!!");
					}
				  }else {
					  System.out.println("Data Base Empty, Please Read in any File First");
				  }
				
				
				break;
			// searches using Author
		  case 10:
			  // data has been inputed
			  if(canStore) {
				  System.out.println("Please enter the Author's full name?");
					response= scan.nextLine(); // stores inputed author name
					int[] holdPosition = null; // stores positions of books written by author
					holdPosition = searchAuthor(books, response); // checks if author has written any books
				// if author books it prints all of them
					if(holdPosition[0] >-1) {
						System.out.println("Book written by "+response+":");
						for(int q=0;q<holdPosition.length;q++) {
							printARecord(books, holdPosition[q]);
						}
						
					}else {
						System.out.println("The Book you are looking for doesn't exist!!");
					}
				  }else {
					  System.out.println("Data Base Empty, Please Read in any File First");
				  }
				
				
				break;
		//exits
		  case 11:
			 
 			System.out.println("Are you sure you want to Quit?(yes/no)"); // if user confirmation prompt
 			response = scan.nextLine();
 			if(response.charAt(0)=='y') {
 				end = true;
 			}
 			break;
		  }
		 
	     }while(end== false); // user didn't exit then go again
	     scan.close(); //Close the Text File
	}

}
