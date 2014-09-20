package com.mj.msort.mergesort.impl;

import com.mj.msort.Sort;
import com.mj.msort.spi.SortProvider;

public class MergeSortProvider implements SortProvider {
	
	private static final String name = "com.mj.msort.mergesort" ;
	
	public MergeSortProvider() {} ;

	public String getProviderName() {
		// TODO Auto-generated method stub
		return name;
	}

	public Sort getInstance() {
		// TODO Auto-generated method stub
		return new MergeSort();
	}

}
