package Research_Paper_Algorithms;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class BubbleSort {
	public static void main(String[] args) throws IOException {
        
            FileWriter writer=new FileWriter("/Users/ceciliamartinez/CSC311-S24-STUDENT/CSC311-S24-STUDENT/src/Research_Paper_Algorithms/datasetoutputfile.txt");
            writer.write("Random Datasets:\n");

            Random random=new Random();
            for (int i=0; i<50; i++) {
                int dataSize=1000+i *1000;
                int[] dataset=generateRandomDataset(dataSize, random);

                long startTime=System.nanoTime();
                int loopCycles=bubbleSort(dataset);
                
                // Print dataset details on console
                System.out.println("Dataset "+(i+1) + ": Size = " + dataSize+", Loop Cycles = " +loopCycles );

                // Write random dataset to output file
                writer.write("Dataset " +(i+1) + ":\n");
                for(int data:dataset) {
                    writer.write(data +"\n");
                }
                writer.write("\n");
            }

            writer.close();
            System.out.println("Data analysis completed and saved random datasets to datasetoutputfile.txt.");
	}
      

	private static int[] generateRandomDataset(int size, Random random) {
	    int[] dataset=new int[size];
	    for (int i=0; i<size; i++) {
	    	// Generate positive random integers
	        dataset[i]=random.nextInt(Integer.MAX_VALUE); 
	    }
	    return dataset;
	}

	private static int bubbleSort(int[] array){
	    int n=array.length;
	    int loopCycles=0;
	    for (int i=0; i<n-1; i++){
	        for (int j=0; j<n-i-1; j++){
	            if(array[j]>array[j+1]) {
	                // Swap array[j] and array[j+1]
	                int temp=array[j];
	                array[j]=array[j + 1];
	                array[j + 1]=temp;
	            }
	        }
	        // Increment loop cycle count for each iteration of the outer loop
	        loopCycles++; 
	    }
	    return loopCycles;
	}
}