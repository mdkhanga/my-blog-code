package com.mj.msort.bubblesort;

import static com.mj.msort.utils.CheckUtils.* ;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

import com.mj.msort.Sort;
import com.mj.msort.bubblesort.impl.BubbleSortProvider;
import com.mj.msort.spi.SortProvider;
import com.mj.sort.comparators.IntegerComparator;

public class BubbleSortListTest {
	
	@Test
	public void testSimpleIntegerArray() {
		
		// {10,5,9,4,7,2,6,1,8,3}
		
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
		
		
		SortProvider sp = new BubbleSortProvider() ;
		Sort bs = sp.getInstance() ;
		Comparator<Integer> c = new IntegerComparator() ;
		
		bs.sort(l, c);
		
	
		assertSorted(l,c) ;
				
	}

	
	@Test(expected = IllegalArgumentException.class)
	public void testNullArray() {
		
		List<Integer> a = null ;
		
		SortProvider sp = new BubbleSortProvider() ;
		Sort bs = sp.getInstance() ;
		Comparator<Integer> c = new IntegerComparator() ;
		
		bs.sort(a, c);
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNullComparator() {
		
		List<Integer> l = new ArrayList<Integer>() ;
		l.add(10) ;
		l.add(5) ;
		l.add(9) ;
		
		SortProvider sp = new BubbleSortProvider() ;
		Sort bs = sp.getInstance() ;
				
		bs.sort(l, null);
		
	}
	
	@Test
	public void testIntegerArrayWithAllnulls() {
		
		List<Integer> l = new ArrayList<Integer>() ;
		l.add(null) ;
		l.add(null) ;
		l.add(null) ;
		
		SortProvider sp = new BubbleSortProvider() ;
		Sort bs = sp.getInstance() ;
		Comparator<Integer> c = new IntegerComparator() ;
		
		bs.sort(l, c);
		
		assertSorted(l,c) ;
				
	}
	
	
	
	
}
