package ioexamples;

import java.io.*;
import java.util.*;

/**
 * TextWriterApp.java	1.00 Nov 25, 2003
 *
 * A class that writes data to a text file, with buffering.
 */
public class TextWriterApp{
	//throwing the exception
   public static void main(String[] args) throws IOException{
   	  //when append is false it overwrite previous file
          //when append is true then it will add to existing file
          boolean append = false;   // you can change this
          

	  // This references the file in the working directory
	  File data = new File("src/test.out");
	  		
      // This is where we setup our streams (append = false means overwrite)
      // new FileWriter() creates the file if doesn't exit
          //printwriter wraps bufferedwriter and buffer wraps file
          //filewriter writes integer by interger
          //buffered writes character by character
          //prints by line to file
          //create a printwriter object
	  PrintWriter out = new PrintWriter(
						new BufferedWriter(
						new FileWriter(data, append)));
	  
	  // print statements do actual work of writing data
	  // note that print statements work similar to Sytem.out.println,
	  // where data is converted to strings
	  out.print(5.25);
	  out.print('c');
	  out.print(true);
	  out.println("Java");
          //printing a dog object. IN dog class we have a name of an address
          //it prints out the toString method of the class
	  out.println( new Dog() );
	  out.print("End of file");
	  out.close();  // be sure you close your streams when done!!
	
	  System.out.println("Wrote file to: " + data.getAbsolutePath());
   }
}
