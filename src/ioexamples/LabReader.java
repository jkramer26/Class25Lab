/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ioexamples;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author jkramer26
 */
public class LabReader {

    public static void main(String[] args) {
        //File data = new File("src" + File.separatorChar + "test.txt");
        File data = new File("C:" + File.separatorChar + "temp" + File.separatorChar 
                        + "labFile.txt");
                
        BufferedReader in = null;
        int count = 0;
        int recordCount = 0;
        try {
            //FileReader is being decorated by BufferedReader to make it read faster
            //buffered allows us to talk to file
            //open the stream
            in = new BufferedReader(new FileReader(data));
            //read the first line
            String line = in.readLine();
            //so long as line we just read is not null then continue reading file
            //if line is null it's end of file
            while (line != null) {
               
                
                if (count == 0) {
                    String[] myStringArray = line.split(" ");
                    
                    System.out.println("First Name: " + myStringArray[0]);
                    System.out.println("Last Name: " +  myStringArray[1]);                    
                } else if (count == 1) {
                    
                    System.out.println("Street Address: " + line);                    
                } else if (count == 2) {
                    
                    String[] myStringArray = line.split(" ");
                    System.out.println("City: " + myStringArray[0].replace(",", " "));
                    System.out.println("State: " + myStringArray[1]);
                    System.out.println("Zip: " + myStringArray[2]);
                    
                    count = -1;
                    recordCount++;
                    System.out.println("");
                    System.out.println("Number of records read: " + recordCount);
                    System.out.println("");
                } 
                count++;
                                
                //reads next line
                line = in.readLine();  // strips out any carriage return chars
                
            }

        } catch (IOException ioe) {
            System.out.println("Houston, we have a problem! reading this file");
            //want to close regardless  if there is an error or not
        } finally {
            try {
                //close the stream
                //closing the file throws a checked exception that has to be surrounded by try catch
                in.close();
            } catch (Exception e) {

            }
        }
    }
}
