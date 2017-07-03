package com.dogvacay.datastructure

import groovy.util.GroovyTestCase;

class RecordsTest extends GroovyTestCase {
	
	void testGetUniqueRecords() {
		def list = [['a', 'b', 'c'],['d', 'e', 'f'],['f', 'b', 'c']]
		
		def dict = Records.getUniqueRecords(list, 1)
		assertNotNull(dict)
		assert dict.size() == 2
		assert dict.keySet().size() == 2
		assert dict.get('b') != null
		assert dict.get('e') != null
	}
	
	void testGetUniqueRecordsAndDup() {
		def list = [['a', 'b', 'c'],['d', 'e', 'f'],['f', 'b', 'c']]
		def dups = [:]
		
		def dict = Records.getUniqueRecords(list, 1, dups)
		assertNotNull(dict)
		assert dict.size() == 2
		assert dict.keySet().size() == 2
		assert dict.get('b') != null
		assert dict.get('e') != null
		assert dups.get('b') != null
	}
	
	void testGetIntersectRecords() {
		def listA = ['a', 'b', 'c']
		def listB = ['a', 'd', 'c']
		
		def list = Records.getIntersectRecords(listA, listB)
		
		assert list.size() == 2
		assert 'a' in list
		assert 'c' in list
	}
	
	void testGetUnionRecords() {
		def listA = ['a', 'b', 'c']
		def listB = ['a', 'd', 'c']
		
		def list = Records.getUnionRecords(listA, listB)
		
		assert list.size() == 4
		assert 'a' in list
		assert 'b' in list 
		assert 'c' in list
	}
	
	void testGetRecordsFromListA() {
		def listA = ['a', 'b', 'c']
		def listB = ['d', 'e', 'c']
		
		def list = Records.getRecordsFromListA(listA, listB)
		
		assert list.size() == 2
		assert 'a' in list
		assert 'b' in list
	}
	
	void testGetIntersectMaps() {
		def mapA = ['a':'val', 'b':'val', 'c':'val']
		def mapB = ['a':'val', 'd':'val', 'c':'val']
		
		def interMap = Records.getIntesectMaps(mapA, mapB)
		
		assert interMap.size() == 2
		assert interMap['a'] != null
		assert interMap['c'] != null
		assert interMap['b'] == null
	}
	
	void testGetUnionMaps() {
		def mapA = ['a':'val', 'b':'val', 'c':'val']
		def mapB = ['a':'val', 'd':'val', 'c':'val']
		
		def interMap = Records.getUnionMaps(mapA, mapB)
		
		assert interMap.size() == 4
		assert interMap['a'] != null
		assert interMap['b'] != null
		assert interMap['c'] != null
		assert interMap['d'] != null
	}
	
	void testGetRecordsFromMapA() {
		def mapA = ['a':'val', 'b':'val', 'c':'val']
		def mapB = ['a':'val', 'd':'val', 'c':'val']
		
		def interMap = Records.getRecordsFromMapA(mapA, mapB)
		
		assert interMap.size() == 1
		assert interMap['b'] != null
		assert interMap['d'] == null
	}
}
