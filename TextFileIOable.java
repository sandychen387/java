package fileIO;

import java.io.FileNotFoundException;

public interface TextFileIOable {
	
	void appendToFile(String fileName, String text);
	void copyFile(String oriFileName, String copieFileName );
	void createNewFile(String fileName);
	String readFile(String fileName);
	void writeToFileFromKeyboard(String fileName) throws FileNotFoundException;
	boolean deletefile(String fileName);
	void readFileWriteToConsole(String fileName);
	void writeToNewFile(String fileName,String text);
	String readFileChosenUsingFileChooser();
	void readFileWriteToConsoleUsingFileChooser();
	

}
