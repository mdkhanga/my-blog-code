package com.mj.msort.utils;

import java.util.Random;

public class StringGenerator {
	
	private static char[] alpha = {'a','b','c','d','e','f','g','h','i','j',
		  'k','l','n','o','p','q','r','s','t','u',
		  'v','w','x','y','z' } ;
	
	private final Random r = new Random() ;
	
	
	public String getRandomWord() {
		
		int size = 0 ;
		
		while (size == 0)
		 size = r.nextInt(10) ;
		
		StringBuilder b = new StringBuilder() ;
		
		for (int i = 0 ; i < size ; i++) {
			
			int next = r.nextInt(25) ;
			b.append(alpha[next]) ;
			
		}
		
		
		return b.toString() ;
		
		
	}

}
