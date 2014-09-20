package com.mj.msort;

import java.util.Iterator;
import java.util.ServiceLoader;
import java.util.concurrent.ConcurrentHashMap;

import com.mj.msort.exception.NoSuchProviderException;
import com.mj.msort.mergesort.impl.MergeSortProvider;
import com.mj.msort.spi.SortProvider;

/**
 * This factory class provides instances of implementations of the Sort instances for developers
 * to use. It loads SortProvider SPI implementations using java.util.ServiceLoader. Users can
 * get either a default MergeSort implementation of the Sort API or they can request
 * a specific implementation using the name of the provider.
 * 
 * 
 * @author manoj
 *
 */

public class SortServices {
	
	private static ServiceLoader<SortProvider> sLoader = null ;
	
	private static final ConcurrentHashMap<String, SortProvider> sMap = 
			new ConcurrentHashMap<String,SortProvider>() ;
	
	private static final String DEFAULT_PROVIDER = "com.mj.msort.mergesort" ;
	
	static {
		
		init() ;
	}
	
	
	private SortServices() {} ;
	
	private static void init() {
		
		sLoader = ServiceLoader.load(SortProvider.class) ;
		
		Iterator<SortProvider> its = sLoader.iterator() ;
		
		while (its.hasNext()) {
			SortProvider sp = its.next() ;
			// System.out.println("Found provider " + sp.getProviderName()) ;
			sMap.put(sp.getProviderName(),sp) ;
		}
		
		
	}
	
	/**
	 * Returns a default MergeSort implementation of the Sort interface
	 * 
	 * 
	 * @return Sort default merge sort implementation of the Sort interface
	 */
	
	public static Sort getSort() {
		
		SortProvider sp = sMap.get(SortServices.DEFAULT_PROVIDER) ;
		
		// just in case Serviceloader did not work
		// #paranoid
		if (sp == null) {
			sp = new MergeSortProvider() ;
			sMap.put(SortServices.DEFAULT_PROVIDER, sp) ;						
		}
		return sp.getInstance() ;
	}
	
	/**
	 * Returns an implementation of the Sort interface provided by provider with
	 * the given name. SortProvider defines the contract with the provider. SortProvider
	 * must be installed as described in java.util.ServiceLoader
	 * 
	 * @param providerName Name that identifies provider implementation
	 * @return Sort Sort implementation from the provider
	 * 
	 * @throws RuntimeException Thrown if the provider could not be found
	 */
	
	public static Sort getSort(String providerName) {
		
		SortProvider sp = sMap.get(providerName) ;
		
		if (sp == null)
			throw new NoSuchProviderException("Provider " + providerName + " is not installed") ;
		
		return sp.getInstance() ;
	}

}
