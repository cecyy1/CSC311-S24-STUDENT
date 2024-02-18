//Cecilia Martinez
// cmartinezlopez1@toromail.csudh.edu

import java.util.ArrayList;

public class UnlimitedNumberArrayList {
	
	 private ArrayList<Integer> list;

	    public UnlimitedNumberArrayList() {
	        this.list =new ArrayList<>();
	    }

	    public int add(int number) {
	        list.add(number);
	        return list.size() - 1;
	    }

	    public int get(int index) {
	        if (index >= 0 && index < list.size()) {
	            return list.get(index);
	        } else {
	            System.out.println("INDEX OUT OF BOUND ");
	            return -1;
	        }
	    }

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
	        UnlimitedNumberArrayList MyList=new UnlimitedNumberArrayList();

	        MyList.add(1);
		    MyList.add(50);
		    MyList.add(3);
		    MyList.add(10);
		    MyList.add(20);
		    MyList.add(80);
		    MyList.add(20);
		    MyList.add(2);
		    MyList.add(20);
		    MyList.add(100);
		    MyList.add(20);
		    MyList.add(20);
		    MyList.add(300);
		    MyList.add(20);
		    MyList.add(220);
		    MyList.add(20);
		    MyList.add(20);
		    MyList.add(225);
		    MyList.add(25);
		    MyList.add(55);
		    MyList.add(10);
		    MyList.add(3);
		    MyList.add(7);


		    

		    
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


