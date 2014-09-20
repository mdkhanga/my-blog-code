package com.mj.msort.utils;

import static org.junit.Assert.assertTrue;

import java.util.Comparator;
import java.util.List;

public class CheckUtils {
	
	public static <T> void assertSorted(T[] a, Comparator<? super T> c) {
		
		for(int i = 0 ; i < a.length -1 ; i++) {
			
			assertTrue(c.compare(a[i],a[i+1]) <= 0) ;
		}
		
		
	}
	
	public static <T> void assertSorted(List<T> l, Comparator<? super T> c) {
		
		for(int i = 0 ; i < l.size() -1 ; i++) {
			
			assertTrue(c.compare(l.get(i),l.get(i+1)) <= 0) ;
		}
		
		
	}

}
