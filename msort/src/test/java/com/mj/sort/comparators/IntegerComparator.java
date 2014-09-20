package com.mj.sort.comparators;
import java.util.Comparator;




public class IntegerComparator implements Comparator<Integer> {

	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		if (o1 == null  && o2 == null)
			return 0;
		
		if (o1 != null && o2 == null)
			return -1 ;
		
		if (o1 == null && o2 != null)
			return 1 ;
		
		int i1 = o1.intValue() ;
		int i2 = o2.intValue() ;
		
		if (i1 == i2)
			return 0 ;
		else if (i1 < i2)
			return -1 ;
		else 
			return 1 ;

	}

	

}
