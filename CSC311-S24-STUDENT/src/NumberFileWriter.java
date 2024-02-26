//Cecilia Martinez
// cmartinezlopez1@toromail.csudh.edu
import java.io.FileWriter;
import java.io.IOException;
public class NumberFileWriter {
	private String filename;
	
	//constructor 
	public NumberFileWriter(String filename) {
		this.filename=filename;
	}
	
	 //will write content of the array to a file, one value per line



public void writer(int[] arrayOfNumbers) throws IOException {
		FileWriter writer= new FileWriter(filename);
		for(int numbers: arrayOfNumbers) {
			writer.write(String.valueOf(numbers));
			writer.write(System.lineSeparator());
		}
		writer.close();
		System.out.println("CHECK FILE IT HAS BEEN WRITTEN THERE!");

	}



public static void main(String[] args) throws IOException {
    // Example usage
    NumberFileWriter fileWriter=new NumberFileWriter("/Users/ceciliamartinez/CSC311-S24-STUDENT/CSC311-S24-STUDENT/src/numberFileOut.txt");
    int[] numbers={1, 2, 3, 4, 5};
    fileWriter.writer(numbers);
}
}
