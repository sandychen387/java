package fileIO;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JFileChooser;


public class TextFileHandler implements TextFileIOable,TextFileDelimitedIOable{
	
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
		catch(FileNotFoundException e) {
			System.err.println("Could not create the empty file "
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
	 
	@Override
	public boolean deleteFile(String fileName) {
		File theFile = new File(fileName);
		if(theFile.exists()) {
			if(theFile.delete()) {
				System.out.println("The file "+fileName + " was deleted");
				return true;
			}
		
		else {
			System.out.println("The file "+fileName + " was not deleted");
			return false;
		}
		}
		System.out.println("The file "+fileName + " was not exist");
		return false;
	}
	
	@Override
	public void readFileWriteToConsoleUsingFileChooser() {
		JFileChooser fc = new JFileChooser();
		int yesNo = fc.showDialog(null,null);
		if(yesNo == JFileChooser.APPROVE_OPTION) {
			File theFile = fc.getSelectedFile();
			if(theFile.isFile()) {
				readFileWriteToConsole(theFile.getAbsolutePath());
			}
		}
	}
	
	@Override
	public void writeToFileFromKeyboard(String fileName) throws FileNotFoundException {
		String s = "STOP_SPYING";
		System.out.println("To shop writhing to the file type\""+s +"\".");
		Scanner sc = new Scanner(System.in);
		PrintWriter outStream = null;
		String theLine = "";
		
		try {
			outStream = new PrintWriter(new FileOutputStream(fileName, true));
			do {
				theLine = sc.nextLine();
				if(theLine.equals(s)) {
					break;
				}
				outStream.println(theLine);
			}
			while(true);
		}
		catch(FileNotFoundException e) {
			System.out.println("Could not write to file "+ fileName +"\n message wa " + e.getMessage());
		}
		finally {
			if(sc!=null) {
				sc.close();
		}
			System.out.println("DONE SPYING and writhing to the file "+ fileName);
			}
	}

	@Override
	public void readDelimitedFileDisplayOnConsole(String fileName) {
		Scanner inStream = null;
		String token = "";
		
		try {
			File theFile = new File(fileName);
			if(theFile.exists()&& theFile.canRead()) {
				inStream = new Scanner(theFile);
				inStream.useDelimiter(",");
				while(inStream.hasNext()) {
					token = inStream.next();
					System.out.print(token+"");
					System.out.print(token+"$");
				}
			}	
		}
		catch(FileNotFoundException e) {
			System.out.println("Could not read from file "+fileName+"\n message was "+e.getMessage());
		}
		finally {
			if(inStream != null) {
				inStream.close();
			}
			System.out.println("Done reading from delimited file " + fileName);
		}
	}

	@Override
	public boolean deletefile(String fileName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void readDelimitedFileDisplayOnConsole(String fileName, String delimiter) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String readDelimitedFile(String fileName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String readDelimitedFile(String fileName, String delimiter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String readFileChosenUsingFileChooser() {
		// TODO Auto-generated method stub
		return null;
	}

	
}


