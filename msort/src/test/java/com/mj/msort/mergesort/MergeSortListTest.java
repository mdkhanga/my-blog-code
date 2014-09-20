package com.mj.msort.mergesort;


import static com.mj.msort.utils.CheckUtils.* ;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import org.junit.Test;

import com.mj.msort.Sort;
import com.mj.msort.SortServices;
import com.mj.msort.mergesort.impl.MergeSort;
import com.mj.msort.utils.StringGenerator;
import com.mj.sample.compound.Employee;
import com.mj.sort.comparators.EmployeeComparator;
import com.mj.sort.comparators.IntegerComparator;
import com.mj.sort.comparators.StringComparator;

public class MergeSortListTest {

	@Test
	public void testSimpleIntegerArray() {
		
		// Integer a[] = {10,5,9,4,7,2,6,1,8,3} ;
		List<Integer> l = new ArrayList<Integer>() ;
		l.add(10) ;
		l.add(5) ;
		l.add(9) ;
		l.add(4) ;
		l.add(7) ;
		l.add(2) ;
		l.add(6) ;
		l.add(1) ;
		l.add(8) ;
		l.add(3) ;
		
		Sort ms = new MergeSort() ;
		Comparator<Integer> c = new IntegerComparator() ;
		
		ms.sort(l, c);
		
		
		
		assertSorted(l,c) ;
				
	}

	@Test
	public void testRandomPopulateArray() {
		
		List<Integer> l = new ArrayList<Integer>(1000) ;
		
		
		Random r = new Random() ;
		
		for(int i = 0 ; i < 1000 ;i++) {
			l.add(r.nextInt(1000)) ;

		}
		
		Sort ms = new MergeSort() ;
		Comparator<Integer> c = new IntegerComparator() ;
		
		ms.sort(l, c);
		
		
		
		assertSorted(l,c) ;
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testNullArray() {
		
	
		List<Integer> l = null ;
		
		Sort ms = new MergeSort() ;
		Comparator<Integer> c = new IntegerComparator() ;
		
		ms.sort(l, c);
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNullComparator() {
		
	
		
		List<Integer> l = new ArrayList<Integer>() ;
		l.add(3) ;
		l.add(2) ;
		l.add(1) ;
		
		Sort ms = new MergeSort() ;
				
		ms.sort(l, null);
		
	}
	
	@Test
	public void testIntegerArrayWithAllnulls() {
		
		
		List<Integer> l = new ArrayList<Integer>() ;
		l.add(null) ;
		l.add(null) ;
		l.add(null) ;
		
		Sort ms = new MergeSort() ;
		Comparator<Integer> c = new IntegerComparator() ;
		
		ms.sort(l, c);
		
		assertSorted(l,c) ;
				
	}
	
	@Test
	public void testRandomStrings() {
		
		StringGenerator sg = new StringGenerator() ;
		
		List<String> s = new CopyOnWriteArrayList<String>() ;
		
		for (int i = 0 ; i < 25 ; i++) {
			s.add(sg.getRandomWord()) ;
			
		}
		
		
		
		Sort ms = new MergeSort() ;
		Comparator<String> c = new StringComparator() ;
		
		ms.sort(s,c) ;
		
		assertSorted(s,c) ;
		
		
		
		
	}
	
	@Test
	public void testsortEmployees() {
		
				
		List<Employee> s = new LinkedList<Employee>() ;
		
		s.add(new Employee("VogelSong",231)) ;
		s.add(new Employee("Crawford" ,112)) ;
		s.add(new Employee("BusterP",48)) ;
		s.add(new Employee("APagan",408)) ;
		s.add(new Employee("PabloS",11)) ;
		s.add(new Employee("VogelSong",230)) ;
		
		
		
		Sort ms = new MergeSort() ;
		Comparator<Employee> c = new EmployeeComparator() ;
		
		ms.sort(s,c) ;
		
		assertSorted(s,c) ;
		
				
		
	}
	
	@Test
	public void testReverse() {
		
		// Integer a[] = {10,5,9,4,7,2,6,1,8,3} ;
		List<Integer> l = new ArrayList<Integer>() ;
		l.add(10) ;
		l.add(9) ;
		l.add(8) ;
		l.add(7) ;
		l.add(6) ;
		l.add(5) ;
		l.add(4) ;
		l.add(3) ;
		l.add(2) ;
		l.add(1) ;
		
		Sort ms = SortServices.getSort() ;
		assertTrue(ms instanceof MergeSort) ;
		Comparator<Integer> c = new IntegerComparator() ;
		
		ms.sort(l, c);
		
				
		assertSorted(l,c) ;
				
	}
	
	@Test
	public void testAllSame() {
		
		// Integer a[] = {10,5,9,4,7,2,6,1,8,3} ;
		List<Integer> l = new ArrayList<Integer>() ;
		l.add(10) ;
		l.add(10) ;
		l.add(10) ;
		l.add(10) ;
		l.add(10) ;
		l.add(10) ;
		
		
		Sort ms = SortServices.getSort() ;
		assertTrue(ms instanceof MergeSort) ;
		Comparator<Integer> c = new IntegerComparator() ;
		
		ms.sort(l, c);
		
				
		assertSorted(l,c) ;
				
	}
	
	@Test
	public void testOneElement() {
		
		// Integer a[] = {10,5,9,4,7,2,6,1,8,3} ;
		List<Integer> l = new ArrayList<Integer>() ;
		l.add(10) ;
		
		
		
		Sort ms = SortServices.getSort() ;
		assertTrue(ms instanceof MergeSort) ;
		Comparator<Integer> c = new IntegerComparator() ;
		
		ms.sort(l, c);
		
				
		assertSorted(l,c) ;
				
	}
	
	@Test
	public void testNoElement() {
		
		// Integer a[] = {10,5,9,4,7,2,6,1,8,3} ;
		List<Integer> l = new ArrayList<Integer>() ;

		
		
		Sort ms = SortServices.getSort() ;
		assertTrue(ms instanceof MergeSort) ;
		Comparator<Integer> c = new IntegerComparator() ;
		
		ms.sort(l, c);
		
				
		assertSorted(l,c) ;
				
	}
	
}
