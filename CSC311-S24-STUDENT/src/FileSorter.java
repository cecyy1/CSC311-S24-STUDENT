//Cecilia Martinez
// cmartinezlopez1@toromail.csudh.edu
import java.io.IOException;
import java.util.Scanner;

public class FileSorter {
	public static void main(String[] args) throws IOException {
	//input and ouput file from the user
	Scanner scanner=new Scanner(System.in);
    System.out.print("What's the inputFile: ");
    String inputFile=scanner.nextLine();
    System.out.print("What's the OutputFile ");
    String outputFile = scanner.nextLine();
    
    //read the input file-->NumberFileReader class
    NumberFileReader fileReader=new NumberFileReader(inputFile);
    int[] inputArray=fileReader.read();
    
    //sorting the array---> BubbleSort class
    BubbleSort bubbleSort=new BubbleSort(inputArray);
    int[] sortedArray=bubbleSort.sortAsc();
    
    //writing the outputFile-->NumberFileWriter
    NumberFileWriter fileWriter=new NumberFileWriter(outputFile);
    fileWriter.writer(sortedArray);
	}
}
