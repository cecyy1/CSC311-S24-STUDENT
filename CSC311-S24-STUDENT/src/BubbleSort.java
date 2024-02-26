//Cecilia Martinez
// cmartinezlopez1@toromail.csudh.edu

import java.util.Arrays;
import java.util.List;

public class BubbleSort {
	//array
	private int[] array;
	private int loopCycles;
	//constructor 
	public BubbleSort(int[] firstList) {
		this.array=Arrays.copyOf(firstList, firstList.length);
		this.loopCycles=0;
		
	}
	
	
	
	
	//will return the array sorted in Ascending order--> means increasing numerical order
	public int[] sortAsc() {
		//iterating thru the array 
		for(int i=0; i<array.length-1; i++) {
			//inner loop--> comparing/swapping 
			for(int j=0; j<array.length-i-1; j++) {
				//compare the inner loop
				if(array[j] > array[j+1]) {
					//if they are in the wrong order-->swap them
					int temp=array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
				}
				//counter--> tracking 
				loopCycles++;
			}
		}
		//return sorted array 
		return Arrays.copyOf(array, array.length);
		
	}
	
	//will return the array sorted in Descending order --> means decreasing numerical order 
	public int[] sortDesc() {
		//iterating thru the array 
				for(int i=0; i<array.length-1; i++) {
					//inner loop--> comparing/swapping 
					for(int j=0; j<array.length-i-1; j++) {
						//compare the inner loop
						if(array[j] < array[j+1]) {
							//if they are in the wrong order-->swap them
							int temp=array[j];
							array[j]=array[j+1];
							array[j+1]=temp;
						}
						//counter--> tracking 
						loopCycles++;
					}
				}
				//return sorted array 
				return Arrays.copyOf(array, array.length);
				
			}
		
	
	//will return the loop cycle it took to sort the operation 
	public int loopCycle() {
		return loopCycles;
		
	}
	public static void main(String[] args) {
        int[] inputArray={23,2,3,1000,41,63};
        BubbleSort bubbleSort=new BubbleSort(inputArray);

        System.out.println("This is the original Array: "+Arrays.toString(inputArray));

        int[] sortedAsc=bubbleSort.sortAsc();
        System.out.println("Array Sorted Ascending: "+Arrays.toString(sortedAsc));
        System.out.println("Loop Cycles for Ascending Sort: "+bubbleSort.loopCycle());

        int[] sortedDesc=bubbleSort.sortDesc();
        System.out.println("Array Sorted Descending: "+Arrays.toString(sortedDesc));
        System.out.println("Loop Cycles for Descending Sort: "+bubbleSort.loopCycle());
    }


}
