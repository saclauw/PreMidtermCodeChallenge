
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {
		String directoryString = "resources";
		createDirectory(directoryString);
		// createDirectory("resources");
		// createFile(directoryString, "Steven.txt");
		// writeToFile(directoryString, "Steven.txt");
		// readFromFile(directoryString, "Steven.txt");
	}

	public static void createDirectory(String dirString) {

		Path dirPath = Paths.get(dirString);
		System.out.println(dirPath.toAbsolutePath());

		// this will only execute if the file is not there
		if (Files.notExists(dirPath)) {
			try {
				Files.createDirectory(dirPath);
			} catch (Exception e) {
				System.out.println("I'm not sure what happened, contact customer service.");
			} // end catch statement
		} // end if statement
	} // end method

	public static void createFile(String fileString) {

		Path filePath = Paths.get(fileString);
		// if you don't want the file to go into the folder just use the method with
		// only a file parameter
		if (Files.notExists(filePath)) {
			try {
				Files.createFile(filePath);
				System.out.println("The file was created successfully");
			} catch (Exception e) {
				System.out.println("Hey something went wrong with the file creation.");
			} // end catch
		} // end if statement
	} // end method

	public static void writeToFile(String fileString, Employees employee) {
		Employees steve = new Employees("Steve", 29, "Popcorn");

		Path writeFile = Paths.get(fileString);

		File file = writeFile.toFile(); // the toFile() converts path to a file object

		try {
			// PrintWriter out = new PrintWriter(new FileOutputStream(file)); // this
			// overwrites a file every time
			PrintWriter out = new PrintWriter(new FileOutputStream(file, true)); // the true parameter allows us to
																					// append the file
			out.println(employee);

			out.close(); // closes the stream and flushes the data
		} catch (FileNotFoundException e) {
			System.out.println("Yo There was an error!");
		} // end catch statement
	} // end method
		// @Overloaded

	public static void writeToFile(String fileString, String name) {
		Employees steve = new Employees("Steve", 29, "Popcorn");

		Path writeFile = Paths.get(fileString);

		File file = writeFile.toFile(); // the toFile() converts path to a file object

		try {
			// PrintWriter out = new PrintWriter(new FileOutputStream(file)); // this
			// overwrites a file every time
			PrintWriter out = new PrintWriter(new FileOutputStream(file, true)); // the true parameter allows us to
																					// append the file
			out.println(name);

			out.close(); // closes the stream and flushes the data
		} catch (FileNotFoundException e) {
			System.out.println("Yo There was an error!");
		} // end catch statement
	} // end method

	public static void readFromFile(String filePath) {

		Path readFile = Paths.get(filePath); // you can hardcode in the file location within the folder for
												// the parameters
		// Path readFile = Paths.get("resources/Steven.txt");

		File file = readFile.toFile();

		try {
			FileReader fr = new FileReader(file);
			// the benefit of using the buffer is to help us store a block of memory that we
			// can go back to and read date from later --this is more efficient than scanner
			BufferedReader reader = new BufferedReader(fr);
			String line = reader.readLine();

			while (line != null) {
				System.out.println(line);
				line = reader.readLine();
			}
			reader.close(); // flushes buffer and closes
		} catch (FileNotFoundException e) {
			System.out.println("There is an error, Dude! File not found");
		} catch (IOException e) {
			System.out.println("Something went wrong with this!");
		} // end catch
	} // end method
	// @overloaded
	public static void readFromFile(String filePath, int userChoice) {

		Path readFile = Paths.get(filePath); // you can hardcode in the file location within the folder for
												// the parameters
		// Path readFile = Paths.get("resources/Steven.txt");

		File file = readFile.toFile();

		try {
			FileReader fr = new FileReader(file);
			// the benefit of using the buffer is to help us store a block of memory that we
			// can go back to and read date from later --this is more efficient than scanner
			BufferedReader reader = new BufferedReader(fr);
			String line = reader.readLine();

//			
//			BufferedReader oBuffer = new BufferedReader(new FileReader(szPath))) {
//				String szLine;
//				int nCount = 0;
//				while ((szLine = oBuffer.readLine()) != null) {
//				  nCount++;
//
//				  if(nCount > 3) break;
//				}
			
			while (line != null) {
				int lineCount = userChoice;
				System.out.println(line);
				line = reader.readLine();
				if (lineCount > userChoice) break;
			}
			reader.close(); // flushes buffer and closes
		} catch (FileNotFoundException e) {
			System.out.println("There is an error, Dude! File not found");
		} catch (IOException e) {
			System.out.println("Something went wrong with this!");
		} // end catch
	} // end method

}
