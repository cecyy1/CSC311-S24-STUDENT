package Research_Paper_Algorithms;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class RadixSort {
	public static void main(String[] args) throws IOException {
        
            FileWriter writer=new FileWriter("/Users/ceciliamartinez/CSC311-S24-STUDENT/CSC311-S24-STUDENT/src/Research_Paper_Algorithms/datasetoutputfile.txt");
            writer.write("Random Datasets:\n");

            Random random=new Random();
            for (int i=0; i<50; i++){
                int dataSize=1000 + i*1000;
                int[] dataset=generateRandomDataset(dataSize, random);

                long startTime=System.nanoTime();
                int loopCycles=radixSort(dataset);

                // Print dataset details on console
                System.out.println("Dataset " + (i+1) + ": Size = " + dataSize + ", Loop Cycles = " + loopCycles );

                // Write random dataset to output file
                writer.write("Dataset " +(i+1) + ":\n");
                for(int data:dataset){
                    writer.write(data + "\n");
                }
                writer.write("\n");
            }

            writer.close();
            System.out.println("Data analysis completed and saved random datasets to datasetoutputfile.txt.");
        
    }

    private static int[] generateRandomDataset(int size, Random random){
        int[] dataset=new int[size];
        for (int i=0; i<size; i++){
            dataset[i]=random.nextInt(Integer.MAX_VALUE); // Generate positive random integers
        }
        return dataset;
    }

    private static int radixSort(int[] array){
        int loopCycles=0;
        int max=getMax(array);
        for(int exp=1; max / exp > 0; exp *= 10){
        	// Increment loop cycle count for each iteration of the outer loop
            loopCycles+=countSort(array, exp); 
        }
        return loopCycles;
    }

    private static int getMax(int[] array){
        int max=array[0];
        for(int i=1; i < array.length; i++){
            if(array[i]>max){
                max = array[i];
            }
        }
        return max;
    }

    private static int countSort(int[] array, int exp){
        int n=array.length;
        int[] output=new int[n];
        int[] count=new int[10];
        int loopCycles=0;

        // Store count of occurrences in count[]
        for(int i=0; i<n; i++){
            count[(array[i] / exp) % 10]++;
        }

        // Change count[i] so that count[i] contains the actual
        // position of this digit in output[]
        for (int i=1; i<10; i++){
            count[i] += count[i-1];
        }

        // Build the output array
        for(int i=n-1; i>=0; i--){
            output[count[(array[i] / exp) % 10]-1]=array[i];
            count[(array[i] /exp) % 10]--;
            loopCycles++; // Increment loop cycle count for each iteration of the sorting loop
        }

        // Copy the output array to array[], so that array[] now
        // contains sorted numbers according to the current digit
        System.arraycopy(output, 0, array, 0, n);

        return loopCycles;
    }
}