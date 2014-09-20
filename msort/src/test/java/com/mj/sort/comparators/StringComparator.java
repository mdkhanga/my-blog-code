package com.mj.sort.comparators;
import java.util.Comparator;


public class StringComparator implements Comparator<String> {

	
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		if (o1 == null  && o2 == null)
			return 0 ;
		
		if (o1 != null && o2 == null)
			return -1 ;
		
		if (o1 == null && o2 != null)
			return 1 ;
		
		return o1.compareToIgnoreCase(o2) ;

	}

}
