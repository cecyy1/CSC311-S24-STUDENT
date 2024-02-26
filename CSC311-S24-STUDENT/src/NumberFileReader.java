//Cecilia Martinez
// cmartinezlopez1@toromail.csudh.edu
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
public class NumberFileReader {
	private String filename;
	//constructor 
	public NumberFileReader(String filename) {
		this.filename=filename;
		
	}
	//will return the array of numbers read form the file  
	public int[] read() throws IOException {
		 // first check if the file exists to make sure not working with no file
        File file=new File(filename);
        if (!file.exists()) {
            System.out.println("FILE NOT FOUND");
        }

        List<Integer> numbers=new ArrayList<>();

        List<String> lines=Files.readAllLines(Paths.get(filename));
        for (String line:lines) {
            // Convert each line to an integer and add it to the list
            numbers.add(Integer.parseInt(line.trim()));
        }

        // Convert the list of integers to an array
        int[] result = new int[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
            result[i] = numbers.get(i);
        }

        return result;
    }
	
	public static void main(String[] args) throws IOException {
		// Example usage
        NumberFileReader reader=new NumberFileReader("/Users/ceciliamartinez/CSC311-S24-STUDENT/CSC311-S24-STUDENT/src/numberFile.txt");
        int[] numbers=reader.read();

        // Print the numbers
        for (int number: numbers) {
            System.out.println(number);
            
		
	}

        
	}
}
