package Research_Paper_Algorithms;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class QuickSort {
	public static void main(String[] args) throws IOException {
        
            FileWriter writer=new FileWriter("/Users/ceciliamartinez/CSC311-S24-STUDENT/CSC311-S24-STUDENT/src/Research_Paper_Algorithms/datasetoutputfile.txt");
            writer.write("Random Datasets:\n");

            Random random=new Random();
            for (int i=0; i<50; i++){
                int dataSize=1000 + i*1000;
                int[] dataset=generateRandomDataset(dataSize, random);

                int loopCycles=quickSort(dataset, 0, dataset.length - 1);

                // Print dataset details on console
                System.out.println("Dataset " + (i + 1) + ": Size = "+dataSize + ", Loop Cycles = "+loopCycles);

                // sorted dataset to output file
                writer.write("Dataset " + (i + 1) + ":\n");
                for(int data:dataset){
                    writer.write(data+"\n");
                }
                writer.write("\n");
            }

            writer.close();
            System.out.println("Data analysis completed and saved sorted datasets to datasetoutputfile.txt.");
        
    }

    private static int[] generateRandomDataset(int size, Random random){
        int[] dataset=new int[size];
        for(int i=0; i<size; i++){
            dataset[i]=random.nextInt(Integer.MAX_VALUE); // Generate positive random integers
        }
        return dataset;
    }

    private static int quickSort(int[] array, int low, int high){
        if(low <high){
            int pivotIndex=partition(array, low, high);

            int leftCycles=quickSort(array, low, pivotIndex - 1);
            int rightCycles=quickSort(array, pivotIndex + 1, high);

            return leftCycles + rightCycles + 1;
        }
        return 0;
    }

    private static int partition(int[] array, int low, int high) {
        int pivot =array[high];
        int i = low - 1;

        for(int j= low; j<high; j++){
            if (array[j]<=pivot) {
                i++;
                int temp=array[i];
                array[i]=array[j];
                array[j]=temp;
            }
        }

        int temp=array[i + 1];
        array[i + 1]=array[high];
        array[high]=temp;

        return i + 1;
    }
}