package com.mj.msort.mergesort;


import static com.mj.msort.utils.CheckUtils.* ;

import java.util.Comparator;
import java.util.Random;

import org.junit.Test;

import com.mj.msort.Sort;
import com.mj.msort.mergesort.impl.MergeSort;
import com.mj.msort.utils.StringGenerator;
import com.mj.sort.comparators.IntegerComparator;
import com.mj.sort.comparators.StringComparator;

public class MergeSortArrayTest {

	@Test
	public void testSimpleIntegerArray() {
		
		Integer a[] = {10,5,9,4,7,2,6,1,8,3} ;
		
		Sort ms = new MergeSort() ;
		Comparator<Integer> c = new IntegerComparator() ;
		
		ms.sort(a, c);
		
		
		assertSorted(a,c) ;
				
	}

	@Test
	public void testRandomPopulateArray() {
		
		Integer a[] = new Integer[1000] ;
		
		Random r = new Random() ;
		
		for(int i = 0 ; i < 1000 ;i++) {
			
			a[i] = r.nextInt(1000) ;
			
		}
		
		Sort ms = new MergeSort() ;
		Comparator<Integer> c = new IntegerComparator() ;
		
		ms.sort(a, c);
		
		
		assertSorted(a,c) ;
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testNullArray() {
		
		Integer a[] = null ;
		
		Sort ms = new MergeSort() ;
		Comparator<Integer> c = new IntegerComparator() ;
		
		ms.sort(a, c);
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNullComparator() {
		
		Integer a[] = {3,2,1} ;
		
		Sort ms = new MergeSort() ;
				
		ms.sort(a, null);
		
	}
	
	@Test
	public void testIntegerArrayWithAllnulls() {
		
		Integer a[] = {null,null,null} ;
		
		Sort ms = new MergeSort() ;
		Comparator<Integer> c = new IntegerComparator() ;
		
		ms.sort(a, c);
		
		assertSorted(a,c) ;
				
	}
	
	@Test
	public void testRandomStrings() {
		
		StringGenerator sg = new StringGenerator() ;
		
		String[] s = new String[25] ;
		
		for (int i = 0 ; i < 25 ; i++) {
			s[i] = sg.getRandomWord() ;
		
		}
		
		
		Sort ms = new MergeSort() ;
		Comparator<String> c = new StringComparator() ;
		
		ms.sort(s,c) ;
		
		assertSorted(s,c) ;
		
				
		
	}
	
	@Test
	public void testReverse() {
		
		Integer a[] = {10,9,8,7,6,5,4,3,2,1} ;
		
		Sort ms = new MergeSort() ;
		Comparator<Integer> c = new IntegerComparator() ;
		
		ms.sort(a, c);
		
		
		assertSorted(a,c) ;
				
	}
	
	@Test
	public void testOneElement() {
		
		Integer a[] = {10} ;
		
		Sort ms = new MergeSort() ;
		Comparator<Integer> c = new IntegerComparator() ;
		
		ms.sort(a, c);
		
		
		
		assertSorted(a,c) ;
				
	}
	
	
	@Test
	public void testNoElement() {
		
		Integer a[] = new Integer[1] ;
		
		Sort ms = new MergeSort() ;
		Comparator<Integer> c = new IntegerComparator() ;
		
		ms.sort(a, c);
		
		
		assertSorted(a,c) ;
				
	}
	
	
	
}
