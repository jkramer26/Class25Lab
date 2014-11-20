package ioexamples;

import java.io.*;
/**
 * TextReaderApp.java	1.00 Nov 25, 2003
 *
 * A class that reads data from a text file, with buffering. Uses
 * the file "test.txt" which is in this project. Try reading your
 * own text file stored in a different directory.
 */
public class TextReaderApp{
	
   public static void main(String[] args) {
	/* This uses System properties to extract the correct
	 * file path separator character.
	 * 
	 * Examples:
	 *    On Windows:  (absolute paths)
	 *                 C:\\temp\\FileName.txt ( \ = escape char in Java!)
	 *                 c:/temp/FileName.txt  (alternate)
	 * 
	 * 				   (relative path)
	 *                 resources/FileName.txt (path relative to class location)
	 * 
	 *    On Unix:     /usr/temp/filename.txt (always relative)
	 */
	 
	/* 
	 * Preferred way to reference a file path ... platform neutral. Line 30
	 * shows how to use a system dependent separator char in a portable way.
	 * Line 32 shows how to reference a file in the current classpath.
	 */
       //doesn't look for drive you are on looks for a directory on your project
       //we create a file object and then pass the path to the fil. go to line 55
	File data = new File("src" + File.separatorChar + "test.txt");
       //cant run on school computer cause it has a special drive
//	File data = new File(File.separatorChar + "temp" + File.separatorChar 
//                        + "test.txt");
//                + "test.txt");
	  		
	/* Here are Windows/Unix examples that tries to read a file
	 * in the temp directory. Notice that the path begins with a forward
	 * slash. This is an example of relative path syntax. In this case,
	 * the path begins with a slash, which means it is relative to 
	 * the root of the startup drive.
	 */
//	File data = new File("/temp/example.txt");  // Windows or Unix/Linux
//	File data = new File("C:\\temp\\example.txt");  // Windows only
	
//	System.out.println("Absolute Path: " + data.getAbsolutePath());
//	System.out.println("Canonical Path: " + data.getCanonicalPath()); // what's the difference?
////	
////	// This references the working directory
//	System.out.println("Working directory is: " + System.getProperty("user.home")); // set/get working directory

	// check if file exists, and if so, loop through and read each line of text
//    if (data.exists()){
        //create a buffered reader object outside of try catch 
        //need to do try catch because it is a checked exception
        //normally you would throw to something like the gui
        BufferedReader in = null;
        try {
            //FileReader is being decorated by BufferedReader to make it read faster
            //buffered allows us to talk to file
            //open the stream
	   in = new BufferedReader(new FileReader(data));
           //read the first line
	   String line = in.readLine();
           //so long as line we just read is not null then continue reading file
           //if line is null it's end of file
	   while(line != null){
               //in actual program you won't be just outputing to console. 
               //for example might be doing a calcualtion from file. 
		  System.out.println(line);
                  //reads next line
		  line = in.readLine();  // strips out any carriage return chars
	   }
	 
        } catch(IOException ioe) {
            System.out.println("Houston, we have a problem! reading this file");
            //want to close regardless  if there is an error or not
        } finally {
            try {
                //close the stream
                //closing the file throws a checked exception that has to be surrounded by try catch
                in.close();
            } catch(Exception e) {
                
            }
        }
//    } else
//	     System.out.println("File not found: test.txt");
    } // end main
} // end classd
