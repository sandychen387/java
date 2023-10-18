package fileIO;

public interface TextFileDelimitedIOable {
	
	void readDelimitedFileDisplayOnConsole(String fileName);
	void readDelimitedFileDisplayOnConsole(String fileName,String delimiter);
	String readDelimitedFile(String fileName);
	String readDelimitedFile(String fileName, String delimiter);
	boolean deleteFile(String fileName);
}
