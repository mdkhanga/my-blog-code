package com.mj.msort;

import java.util.Comparator;
import java.util.List;

/**
 * API for sorting an array or List of any type. The order is determined
 * by the Comparator provided.
 * 
 * 
 * @author manoj
 *
 */

public interface Sort {
	
	/**
	 * Sort a list based on order decided using a Comparator
	 * 
	 * @param l The list to be sorted
	 * @param c The comparator used to determine the order in the list
	 * 
	 * @throws IllegalArgumentException Thrown if either of the parameters are null
	 */
	
	public <T> void sort(List<T> l , Comparator<? super T> c) ;
	
	/**
	 * Sort the array based on order decided using a Comparator
	 * 
	 * @param a The array to be sorted
	 * @param c The comparator used to determine the order in the list
	 * 
	 * @throws IllegalArgumentException Thrown if either of the parameters are null
	 */
	
	
	
	public <T> void sort(T[] a, Comparator<? super T> c) ;

}
