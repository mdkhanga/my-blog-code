package com.mj.msort.bubblesort.impl;

import com.mj.msort.Sort;
import com.mj.msort.spi.SortProvider;

public class BubbleSortProvider implements SortProvider {
	
	private static final String name = "com.mj.msort.bubblesort" ;
	
	public BubbleSortProvider() {} ;

	public Sort getInstance() {
		// TODO Auto-generated method stub
		return new BubbleSort();
	}

	public String getProviderName() {
		
		return name ;
	}
	
}
