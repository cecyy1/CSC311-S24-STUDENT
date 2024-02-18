//Cecilia Martinez
// cmartinezlopez1@toromail.csudh.edu

import java.util.ArrayList;
import java.util.Arrays;

public class NumberArrayList {

	
		private ArrayList<Integer>list;
		private int maxSize;
		
		//methods
		
		public NumberArrayList(int size){
			this.maxSize=size;
			this.list=new ArrayList<>(size);
		}
		
		//return the index/location of the new entry
		public int add(int Number) {
			if(list.size()>= maxSize) {
				System.out.println("This has reach its max side");
				return -1;
			}
			list.add(Number);
			return list.size()-1;
			
		}
		
		//return number stored at the given location in the NumberArraylist 
		public int get(int index) {
			if(index >=0 && index<list.size()) {
				return list.get(index);
			}else {
				System.out.println("INDEX OUT OF BOUND ");
				return -1;
			}
			
			
		}
		
		//return the total number of elements currently in the list 
		public int size() {
			return list.size();
			
			
		}
		
		//return an array of indices of matching numbers. return empty array if not number were found 
		
		public int[] find(int number) {
			ArrayList<Integer> indices=new ArrayList<>();
			for(int i=0; i<list.size(); i++) {
				if(list.get(i)==number) {
					indices.add(i);
				}
			}
			
		
			int [] result=new int [indices.size()];
			for(int i=0; i<indices.size(); i++) {
				result[i]=indices.get(i);
			}
			return result;
			
			
			
		}
		//return larges number from the array 
		public int getLargest() {
			if(list.isEmpty()) {
				return -1;
			}
			int largest=list.get(0);
			//iterating thru the arraylist 
			for(int i=1; i<list.size(); i++) {
				int current =list.get(i);
				if(current>largest) {
					largest=current;
				}
				
			}
			return largest;
			
		}
		
		
		//return smallest number from the array
		public int getSmallest() {
			if(list.isEmpty()) {
				return -1;
			}
			//initializing 
			int smallest=list.get(0);
			for(int i=1; i<list.size(); i++) {
				int current =list.get(i);
				if(current<smallest) {
					smallest=current;
				}
				
			}
			return smallest;
			
		}
		
		//return the average of all numbers store in the array 
		public int getAverage() {
			if(list ==null || list.isEmpty()) {
				return -1;
			}
			int sum=0;
			for(int i=0; i<list.size(); i++) {
				sum+=list.get(i);
			}
			return sum/list.size();
		}
		
		public String toString() {
	        StringBuilder result = new StringBuilder("[");
	        for (int i = 0; i < list.size(); i++) {
	            result.append(list.get(i));
	            if (i < list.size() - 1) {
	                result.append(", ");
	            }
	        }
	        result.append("]");
	        return result.toString();
	    }

	
		
		public static void main(String[] args) {
			//list store up to 500 integers 
			NumberArrayList MyList=new NumberArrayList(500);
			
			MyList.add(1);
		    MyList.add(50);
		    MyList.add(3);
		    MyList.add(10);
		    MyList.add(20);

		    
		    System.out.println("List: " + MyList);
		    System.out.println("Size: " + MyList.size());
		    System.out.println("Largest: " + MyList.getLargest());
		    System.out.println("Smallest: " + MyList.getSmallest());
		    System.out.println("Average: " + MyList.getAverage());

		    int[] indicesOf2 = MyList.find(20);
		    if (indicesOf2.length > 0) {
		        System.out.println("Indice of 20: " + indicesOf2[0]);
		    } else {
		        System.out.println("Number 2 not found in the list.");
		    }
		}
}
