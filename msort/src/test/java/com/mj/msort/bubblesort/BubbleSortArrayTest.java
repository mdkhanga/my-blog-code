package com.mj.msort.bubblesort;

import static com.mj.msort.utils.CheckUtils.*; 

import java.util.Comparator;

import org.junit.Test;

import com.mj.msort.Sort;
import com.mj.msort.bubblesort.impl.BubbleSortProvider;
import com.mj.msort.spi.SortProvider;
import com.mj.sort.comparators.IntegerComparator;

public class BubbleSortArrayTest {
	
	@Test
	public void testSimpleIntegerArray() {
		
		Integer a[] = {10,5,9,4,7,2,6,1,8,3} ;
		
		SortProvider sp = new BubbleSortProvider() ;
		Sort bs = sp.getInstance() ;
		Comparator<Integer> c = new IntegerComparator() ;
		
		bs.sort(a, c);
		
		
		
		assertSorted(a,c) ;
				
	}

	
	@Test(expected = IllegalArgumentException.class)
	public void testNullArray() {
		
		Integer a[] = null ;
		
		SortProvider sp = new BubbleSortProvider() ;
		Sort bs = sp.getInstance() ;
		Comparator<Integer> c = new IntegerComparator() ;
		
		bs.sort(a, c);
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNullComparator() {
		
		Integer a[] = {3,2,1} ;
		
		SortProvider sp = new BubbleSortProvider() ;
		Sort bs = sp.getInstance() ;
				
		bs.sort(a, null);
		
	}
	
	@Test
	public void testIntegerArrayWithAllnulls() {
		
		Integer a[] = {null,null,null} ;
		
		SortProvider sp = new BubbleSortProvider() ;
		Sort bs = sp.getInstance() ;
		Comparator<Integer> c = new IntegerComparator() ;
		
		bs.sort(a, c);
		
		assertSorted(a,c) ;
				
	}
	
	@Test
	public void testIntegerArrayWithSomenulls() {
		
		Integer a[] = {null,9,null,11} ;
		
		SortProvider sp = new BubbleSortProvider() ;
		Sort bs = sp.getInstance() ;
		Comparator<Integer> c = new IntegerComparator() ;
		
		bs.sort(a, c);
		
		assertSorted(a,c) ;
				
	}
	
}
