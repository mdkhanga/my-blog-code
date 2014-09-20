package com.mj.msort;

import static com.mj.msort.utils.CheckUtils.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

import com.mj.msort.bubblesort.impl.BubbleSort;
import com.mj.msort.exception.NoSuchProviderException;
import com.mj.msort.mergesort.impl.MergeSort;
import com.mj.sort.comparators.IntegerComparator;

public class SortServicesTest {

	@Test
	public void testLoad() {
		
		Sort s = SortServices.getSort() ;
		assertTrue(s instanceof MergeSort) ;
		Sort bs = SortServices.getSort("com.mj.msort.bubblesort") ;
		assertTrue(bs instanceof BubbleSort) ;
	}
	
	@Test
	public void testBubbleSortArray() {
		
		Integer a[] = {10,5,9,4,7,2,6,1,8,3} ;
		
		Sort bs = SortServices.getSort("com.mj.msort.bubblesort") ;
		assertTrue(bs instanceof BubbleSort) ;
		
		Comparator<Integer> c = new IntegerComparator() ;
		
		bs.sort(a, c);
		
		
		
		assertSorted(a,c) ;
				
	}

	@Test
	public void testMergeSortIntegerArray() {
		
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
		
		Sort ms = SortServices.getSort() ;
		assertTrue(ms instanceof MergeSort) ;
		
		Comparator<Integer> c = new IntegerComparator() ;
		
		ms.sort(l, c);
		
		
		assertSorted(l,c) ;
				
	}
	
	@Test (expected = NoSuchProviderException.class)
	public void testProviderNotFound() {
		
		SortServices.getSort("com.mj.msort.nosuchsort") ;
		
	}
	
}
