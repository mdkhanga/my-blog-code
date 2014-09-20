package com.mj.msort.bubblesort.impl;

import java.util.Comparator;
import java.util.List;

import com.mj.msort.Sort;

public class BubbleSort implements Sort {
	
	protected BubbleSort() {
		
		
	}

	public <T> void sort(List<T> l , Comparator<? super T> c) {
	
		if (l == null || c == null)
			throw new IllegalArgumentException("Arguments cannot be null") ;
		
		int size = l.size() ;
		
		if (size == 0)
			return ;
		
		for (int outer = size -1 ; outer > 1 ; outer--) {
			
			for (int inner = 0 ; inner < outer ; inner++) {
				
				if (c.compare(l.get(inner),l.get(inner+1)) > 0 ) {
					
					swap(l,inner,inner+1) ;
				}
				
			}
			
		}
	
	}
	
	public <T> void sort(T[] a, Comparator<? super T> c)  {
		
		if (a == null || c == null)
			throw new IllegalArgumentException("Arguments cannot be null") ;
		
		int size = a.length ;
		
		if (size == 0)
			return ;
		
		for (int outer = size -1 ; outer > 1 ; outer--) {
			
			for (int inner = 0 ; inner < outer ; inner++) {
				
				if (c.compare(a[inner],a[inner+1]) > 0 ) {
					
					swap(a,inner,inner+1) ;
				}
				
			}
			
		}
	}
	
	
	private <T> void swap(List<T> l, int f, int s) {
		
		T temp = l.get(f);
		l.set(f, l.get(s)) ;
 		l.set(s, temp)  ;
	}
	
	
	private <T> void swap(T[] a, int f, int s) {
		
		T temp = a[f];
		a[f] = a[s] ;
 		a[s] = temp ;
	}
}
