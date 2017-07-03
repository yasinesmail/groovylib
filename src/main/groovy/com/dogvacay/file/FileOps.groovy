package com.dogvacay.file

import au.com.bytecode.opencsv.*
import static au.com.bytecode.opencsv.CSVWriter.DEFAULT_SEPARATOR

/**
 * Class to read and write to files
 */
class FileOps {
	
	/**
	 * Returns list of entries in a file
	 *
	 * @param String file
	 * @return List items in file
	 */
	public static List readCsvEntries(String file) {
		File csvFile = new File(file)
		def entries = []
		csvFile.splitEachLine(",") {fields ->
			entries.add(fields)
		}
		return entries
	}

	/**
	 * Writes list of entries to a file
	 *
	 * @param List of entries
	 * @param String file name to write to
	 */
	public static void writeEntriesToFile(List entries, String file) {
		def csvWriter = new CSVWriter(new FileWriter(file, false), DEFAULT_SEPARATOR)
		entries.each {
			csvWriter.writeNext(it as String[])
		}
		csvWriter.close()
	}
	
	/**
	 * Writes list of entries to a file
	 *
	 * @param List of entries
	 * @param String file writer name to write to
	 */
	public static void writeEntriesToFile(List entries, FileWriter file) {
		def csvWriter = new CSVWriter(file, DEFAULT_SEPARATOR)
		entries.each {
			csvWriter.writeNext(it as String[])
		}
		csvWriter.close()
	}

	/**
	 * Returns true if file exists
	 *
	 * @param file name
	 */
	public static boolean FileExists(String file) {
		File fileObj = new File(file);
		return fileObj.exists();
	}

}
