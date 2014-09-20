package com.mj.sort.comparators;
import java.util.Comparator;

import com.mj.sample.compound.Employee;


public class EmployeeComparator implements Comparator<Employee> {
 
	private static Comparator<String> s = new StringComparator() ;
	private static Comparator<Integer> i = new IntegerComparator() ;
	
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		if (o1 == null  && o2 == null)
			return 0 ;
		
		if (o1 != null && o2 == null)
			return -1 ;
		
		if (o1 == null && o2 != null)
			return 1 ;
		
		int ret = s.compare(o1.getName(), o2.getName()) ;
		 
		if ( ret != 0) 
			 return ret ;
		else 
			return i.compare(o1.getId(), o2.getId()) ;

	}

}
