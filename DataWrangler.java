// Name: Michael Kukovec
// Email: kukovec@wisc.edu
// Team: AD
// TA: Sophie Stephenson
// Lecturer: Gary Dahl
// Notes to Grader: requires class BackEndHash to compile

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DataWrangler {
	public static boolean readInputFile(String file_name) throws FileNotFoundException {
		//Title, Author, Publisher, Publication Year, ISBN
		final int info_types = 5;
		
		//Assumes .csv if no extension provided
		if(file_name.substring(file_name.length() - 4) != ".csv" && file_name.substring(file_name.length() - 4) != ".txt") {
			file_name += ".csv";
		}
		
		//Open file
		 try {
		      File read_file = new File(file_name);
		      Scanner scan = new Scanner(read_file);
		      String line = scan.nextLine();
		      
		      while (scan.hasNextLine()) {
		    	  String[] info = new String[info_types];
		    	  for(int i = 0; i < info_types; i++) {
		    		  info[i] = "";
		    	  }
		    	  line = scan.nextLine();
		    	  
		    	  //Create book objects with line data
		    	  int i = 0;
		    	  for(int count = 0; count < info_types; count++) {
		    		  //checks for <","> delimiter
		    		  if(line.charAt(i) == '\"') {
		    			  i++;
		    			  while(line.charAt(i) != '\"') {
		    				  info[count] += line.charAt(i);
		    				  i++;
		    				  if(i > line.length() - 1) {
		    					  break;
		    				  }
		    			  }
		    			  i += 2;
		    			  //Default delimiter is <,>
		    		  } else {
		    			  while(line.charAt(i) != ',') {
		    				  info[count] += line.charAt(i);
		    				  i++;
		    				  if(i > line.length() - 1) {
		    					  break;
		    				  }
		    			  }
		    			  i++;
		    		  }
		    	  }
		    	  //Create book
		    	  Book newBook = new Book(info[0], info[1], info[2], Integer.parseInt(info[3]), info[4]);
		    	  //Back-End function, adds Book to hash table
		    	  BackEndHash.add(newBook);
		      }
		      
		      scan.close();
		      return true;
		    } catch (FileNotFoundException e) {
		      return false;
		    }
	}
}
