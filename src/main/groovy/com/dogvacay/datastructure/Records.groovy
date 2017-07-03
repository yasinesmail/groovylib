package com.dogvacay.datastructure

import java.util.List;
import java.util.Map;

/**
 * Class to manipulate or create lists or maps.
 * This helps separate items from one list to another.
 */
class Records {
	
	/**
	 * Returns a hashmap from list.
	 *
	 * @param List records
	 * @param int index - index to use to create a hashmap
	 * @param Hashmap duplicates - put duplicate items here if needed
	 * @return Hashmap
	 */
	public static Map getUniqueRecords(List records, int index, Map duplicates=null) {
		
		Map recordList = new HashMap()
		def dups = {rec, ind -> }
		if (duplicates != null) {
			dups = { rec, ind -> 
				     if (recordList.containsKey(rec[ind])) {
						  duplicates.put(rec[ind], rec)
				     }
			       }
		}
		records.each { rec ->
			dups(rec, index)
	        recordList.put(rec[index], rec)
		}
		return recordList
	}
	
	/**
	 * Returns a hashmap of items 
	 * common to two hashmps provided.
	 *
	 * @param Hashmap A
	 * @param Hashmap B
	 * @return Hashmap common to both
	 */
	public static Map getIntesectMaps(Map A, Map B) {
		Map C = new HashMap();
		A.each { k, v ->
			if (B.containsKey(k)) C.put(k, v)
		}
		return C
	}
	
	/**
	 * Returns a hashmap of all items in 
	 * two hashmaps provided
	 *
	 * @param Hashmap A
	 * @param Hashmap B
	 * @return Hashmap union of two maps
	 */
	public static Map getUnionMaps(Map A, Map B) {
		Map cMap = new HashMap();
		cMap.putAll(A)
		B.each { k, v ->
			if (A.get(k) == null) cMap.put(k, v)
		}
		return cMap
	}
	
	/**
	 * Returns a hashmap of all items in
	 * only the Map A
	 *
	 * @param HashMap A
	 * @param HashMap B
	 * @return Hashmap items in Map A
	 */
	public static Map getRecordsFromMapA(Map A, Map B) {
		Map cMap = new HashMap()
		A.each { k, v ->
			if (B.containsKey(k) == false) {
				cMap.put(k, v)
			}
		}
		return cMap
	}
	
	/**
	 * Returns a list of items shared by the two lists.
	 *
	 * @param List A
	 * @param List B
	 * @return List of common items.
	 */
	public static Set getIntersectRecords(List A, List B) {
		HashSet setA = new HashSet(A);
		HashSet setB = new HashSet(B);
		Set setC = setA.intersect(setB)
		return setC
	}
	
	/**
	 * Returns a list of all items in two lists.
	 *
	 * @param List A
	 * @param List B
	 * @return List of union items.
	 */
	public static Set getUnionRecords(List A, List B) {
		HashSet setA = new HashSet(A)
		HashSet setB = new HashSet(B)
		Set setC = setA.plus(setB)
		return setC
	}
	
	/**
	 * Returns a list of items only in list A.
	 *
	 * @param List A
	 * @param List B
	 * @return List of items in List A only.
	 */
	public static Set getRecordsFromListA(List A, List B) {
		HashSet setA = new HashSet(A)
		HashSet setB = new HashSet(B)
		Set setC = setA.minus(setB)
		return setC
	}
	
	/**
	 * Returns a unique list.
	 *
	 * @param List records
	 * @return unique list
	 */
	public static Set getUniqueRecords(List records) {
		return new HashSet(records)
	}
	
	static void main(String[] args) {
		println "hello"
		def list = [['a', 'b', 'c'],['d', 'e', 'f'],['f', 'b', 'c']]
		def dups = [:]
		
		def dict = Records.getUniqueRecords(list, 1, dups)
		println dups
	}
	
	
}

