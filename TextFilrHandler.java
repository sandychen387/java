package fileIO;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class TextFilrHandler {
	public void createNewFile(String fileName) {
		PrintWriter outStream = null;
		try {
			outStream = new PrintWriter(fileName);
		}
		catch(FileNotFoundException e) {
			System.out.println("Could not create the empty file " + fileName
					+ " the message was " + e.getMessage());
		}
		finally {
			if(outStream != null) {
				outStream.close();
			}
			System.out.println("Don't trying to create new file");
		}
	}
	
	public void writeToNewFile(String fileName, String text) {
		PrintWriter outStream = null;
		try {
			outStream = new PrintWriter(fileName);
			outStream.println(text);
		}
		catch(FileNotFoundException e) {System.err.println("Could not create the empty file "
				+ fileName + " the massage was " + e.getMessage());
			}
		finally {
			if(outStream != null) {
				outStream.close();
			}
			System.out.println("Don't trying to write to new file");
		}
	}
	public void appendToFile(String fileName, String text) {
		PrintWriter outStream = null;
		try {
			outStream = new PrintWriter(new FileOutputStream(fileName,true));
			outStream.println(text);
		}
		catch(FileNotFoundException e) {
			System.err.println("Could not create the empty file " + fileName
			+ " the message was " + e.getMessage());
		}
		finally {
			if(outStream != null) {
				outStream.close();
			}
			System.out.println("Done trying to append to the file");
		}
	}
	 public String readFile(String fileName) {
		 Scanner inStream = null;
		 String fileContents = "";
		 File theFile = null;
		 try {
			 theFile = new File(fileName);
			 inStream = new Scanner(theFile);
			 while(inStream.hasNextLine()) {
				 fileContents += inStream.nextLine() + "\n";
			 }
		 }
		 catch(FileNotFoundException e) {
			 System.err.println("Could not read from file " + fileName + "\n" + e.getMessage());
		 }
		 finally {
			 if(inStream != null) {
				 inStream.close();
			 }
			 System.out.println("Done trying to read from file "+fileName);
		 }
		 return fileContents;
	 }
	 public void readFileWriteToConsole(String fileName) {
		 Scanner inStream = null;
		 File theFile = null;
		 try {
			 theFile = new File(fileName);
			 inStream = new Scanner(theFile);
			 String theLine = "";
			 while(inStream.hasNextLine()) {
				 System.out.println(inStream.nextLine());
			 }
		 }
			 catch(FileNotFoundException e) {
				 System.err.println("Could not read from file " + fileName + "\n"+e.getMessage());
			}
		 	finally {
		 		if(inStream != null) {
		 			inStream.close();
		 		}
		 		System.out.println("Done trying to read from "+fileName);
		 	}
	 }
	 public void copyFile(String fileNameOriginal, String fileNameCopy) {
		 Scanner inStream = null;
		 PrintWriter outStream = null;
		 try {
			 inStream = new Scanner(new File(fileNameOriginal));
			 outStream = new PrintWriter(new FileOutputStream(fileNameCopy, true));
			 int lineNumber = 1;
			 while(inStream.hasNextLine()) {
				 String theLine = inStream.nextLine();
				 outStream.println((lineNumber ++)+""+theLine);
				 }
			 }
		 catch(FileNotFoundException e){
			 System.err.println("Could not copy from file "+ fileNameOriginal +" to"
					 +fileNameCopy +"\n"+e.getMessage());
		 }
		 finally {
			 if(inStream != null) {
				 inStream.close();
			 }
			 if(outStream != null) {
				 outStream.close();
			 }
			 System.out.println("Done trying to copy from file "+ fileNameOriginal + " to "+fileNameCopy);
		 }
	 }
}
