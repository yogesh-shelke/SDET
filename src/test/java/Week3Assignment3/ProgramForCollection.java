package Week3Assignment3;

import java.util.ArrayList;

public class ProgramForCollection {

	public static void main(String[] args) 
	{
	// TODO Auto-generated method stub
		ArrayList<Integer> arr =  myNumbers();
	    for(int i=0;i<arr.size();i++)
	    {
	    	System.out.println(arr.get(i));    
	    }
	        
	}    
	public static ArrayList<Integer> myNumbers()    
	{
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add(5);
		numbers.add(11);
		numbers.add(3);
		return(numbers);
	}
		

}
	