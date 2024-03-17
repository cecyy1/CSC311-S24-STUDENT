package Research_Paper_Algorithms;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class MergeSort {
    public static void main(String[] args) throws IOException {
        
            FileWriter writer=new FileWriter("/Users/ceciliamartinez/CSC311-S24-STUDENT/CSC311-S24-STUDENT/src/Research_Paper_Algorithms/datasetoutputfile.txt");
            writer.write("Random Datasets:\n");

            Random random=new Random();
            for (int i=0; i<50; i++) {
                int dataSize=1000 + i*1000;
                int[] dataset=generateRandomDataset(dataSize, random);

                long startTime=System.nanoTime();
                int loopCycles=mergeSort(dataset);

                // Print dataset details on console
                System.out.println("Dataset " +(i+1) + ": Size = " +dataSize + ", Loop Cycles = " +loopCycles );

                //sorted dataset to output file
                writer.write("Dataset " +(i+1) + ":\n");
                for(int data:dataset) {
                    writer.write(data + "\n");
                }
                writer.write("\n");
            }

            writer.close();
            System.out.println("Data analysis completed and saved sorted datasets to datasetoutputfile.txt.");
    }

    private static int[] generateRandomDataset(int size, Random random){
        int[] dataset=new int[size];
        for (int i=0; i< size; i++){
            dataset[i]=random.nextInt(Integer.MAX_VALUE); // Generate positive random integers
        }
        return dataset;
    }

    private static int mergeSort(int[] array) {
        int loopCycles=0;
        if(array.length>1){
            int[] left=leftHalf(array);
            int[] right=rightHalf(array);

            loopCycles+=mergeSort(left);
            loopCycles+=mergeSort(right);

            loopCycles+=merge(array, left, right);
        }
        return loopCycles;
    }

    private static int[] leftHalf(int[] array){
        int size1=array.length / 2;
        int[] left=new int[size1];
        System.arraycopy(array, 0, left, 0, size1);
        return left;
    }

    private static int[] rightHalf(int[] array){
        int size1=array.length / 2;
        int size2=array.length - size1;
        int[] right=new int[size2];
        System.arraycopy(array, size1, right, 0, size2);
        return right;
    }

    private static int merge(int[] result, int[] left, int[] right) {
        int loopCycles=0;
        int i1=0;
        int i2=0;

        for(int i=0; i<result.length; i++){
            loopCycles++;
            if(i2 >=right.length || (i1 < left.length && left[i1] <=right[i2])) {
                result[i] = left[i1];
                i1++;
            } else {
                result[i] = right[i2];
                i2++;
            }
        }
        return loopCycles;
    }
}