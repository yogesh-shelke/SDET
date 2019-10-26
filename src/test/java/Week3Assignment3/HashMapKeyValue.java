package Week3Assignment3;

import java.util.HashMap;
import java.util.Map;

public class HashMapKeyValue {
	
	public static void main(String args[])
	{
	    HashMap<String,String> hm = new HashMap<String,String>();  
	    
	    System.out.println("Initial list of elements: " + hm);
	    
	
	    hm.put("Name1", "Hamad");
	    hm.put("Name2", "Naresh");
	    hm.put("Name3", "Siva");
	    hm.put("Name4", "Yogesh");
	    hm.put("Name5", "Vipul");
	    hm.put("Name6", "Charandeep");
	    
	    System.out.println("After invoking put() method ");  
	      
	    for(Map.Entry m: hm.entrySet()) //set of entries : key-value pair
	      {    
	    	System.out.println(m.getKey()+"- "+m.getValue());    
	      }
	} 
	      
}
