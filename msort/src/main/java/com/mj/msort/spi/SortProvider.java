package com.mj.msort.spi;

import com.mj.msort.Sort;

/**
 * Defines the contract with third party implementations of the Sort interface. SortProviders
 * will be found and loaded using java.util.Serviceloader. Implementors should comply
 * with the contract required by java.util.ServiceLoader.
 * 
 * @author manoj
 *
 */

public interface SortProvider {
	
	/**
	 * Returns the name of the provider. This name will be used by user to
	 * request your implementation
	 * 
	 * @return String name that identifies the provider
	 */
	
	public String getProviderName() ;
	
	
	/**
	 * Return an implementation of the Sort interface
	 * 
	 * @return Sort an implementation of Sort interface
	 */
	
	
	public Sort getInstance() ;

}
