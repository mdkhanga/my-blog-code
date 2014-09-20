package com.mj.msort.mergesort.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.mj.msort.Sort;

public class MergeSort implements Sort {

	public <T> void sort(List<T> l, Comparator<? super T> c) {
		// TODO Auto-generated method stub
		if (l == null || c == null)
			throw new IllegalArgumentException("Arguments cannot be null") ;
		
		int size = l.size() ;
		
		if (size == 0)
			return ;
		
		// workspace does not have to be same kind of list
		List<T> workspace = new ArrayList<T>(size) ; 
		for(int i = 0 ; i < size ; i++) {
			workspace.add(null) ;
		}
		
		mergeSort(l,c,0 ,size-1,workspace) ;

	}

	public <T> void sort(T[] a, Comparator<? super T> c) {
		// TODO Auto-generated method stub
		
		if (a == null || c == null)
			throw new IllegalArgumentException("Arguments cannot be null") ;
		
		int size = a.length ;
		
		if (size == 0)
			return ;

		// workspace
		T[] workspace = (T[]) java.lang.reflect.Array.newInstance(
                a.getClass().getComponentType(),a.length) ;
		
		mergeSort(a,c,0 ,size-1,workspace) ;
	}

	private <T> void mergeSort(T[] a , Comparator<? super T> c, int start,int end, T[] buf) {
		
		if (start == end) 
			return ;
	
		int mid = start + (end - start)/2 ;
		
		mergeSort(a,c,start,mid,buf ) ;
		mergeSort(a,c,mid+1,end,buf) ;
		
		merge(a,c,start,mid,mid+1,end,buf) ;
		
	}
	
	private <T> void merge(T[] a, Comparator<? super T> c, int start1, int end1 ,
								int start2, int end2, T[] buf) {
		
		
		int i = start1 ;
		int j = start2 ;
		int k = start1 ;
		
		while( i <= end1 && j <= end2) {
			
			if (c.compare(a[i], a[j]) <= 0) 
				buf[k++] = a[i++] ;
			else
				buf[k++] = a[j++] ;
		}
		
		while( i <= end1) {
			buf[k++] = a[i++] ;
		}
		
		while( j <= end2) {
			buf[k++] = a[j++] ;
		}
		
		// copy back from workspace
		
		for(int l = start1 ; l <= end2 ; l++) {
			
			a[l] = buf[l] ;
		}
		
	}
	
	private <T> void mergeSort(List<T> a , Comparator<? super T> c, int start,int end, List<T> buf) {
		
		if (start == end) 
			return ;
	
		int mid = start + (end - start)/2 ;
		
		mergeSort(a,c,start,mid,buf ) ;
		mergeSort(a,c,mid+1,end,buf) ;
		
		merge(a,c,start,mid,mid+1,end,buf) ;
		
	}
	
	private <T> void merge(List<T> a, Comparator<? super T> c, int start1, int end1 ,
			int start2, int end2, List<T> buf) {


		int i = start1 ;
		int j = start2 ;
		int k = start1 ;

		while( i <= end1 && j <= end2) {

			if (c.compare(a.get(i), a.get(j)) <= 0) 
				buf.set(k++,a.get(i++)) ;
				//  buf[k++] = a[i++] ;
			else
				// buf[k++] = a[j++] ;
				buf.set(k++,a.get(j++)) ;
		}

		while( i <= end1) {
			// buf[k++] = a[i++] ;
			buf.set(k++, a.get(i++)) ;
		}

		while( j <= end2) {
			// buf[k++] = a[j++] ;
			buf.set(k++, a.get(j++)) ;
		}

		// copy back from workspace

		for(int l = start1 ; l <= end2 ; l++) {

			// a[l] = buf[l] ;
			a.set(l, buf.get(l)) ;
		}

	}
	
}
