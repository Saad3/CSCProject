import linkedList.LinkedList;
//import java.io.*;
//import java.util.*;



public class Preprocessor {
	
	
	LinkedList<String>StopWord;
	LinkedList<String>stem;
	LinkedList<LinkedList<String>>corpus;
	
	public Preprocessor() {
		// Initializes the required data structures.
		
		StopWord=null;
		stem=null;
		corpus=null;
	}

	public void loadStopWords(String stopWordsFilename) {
		// Loads the stop words list into appropriate data structure.
		ReadFileByScanner read = new ReadFileByScanner();
		
		read.openFile(stopWordsFilename);
		StopWord =read.readFileByLines();
		read.closeFile();
	
	}

	public void loadStemming(String stemsFilename) {
		// Loads the stemming list into appropriate data structure.
		ReadFileByScanner read = new ReadFileByScanner();
		read.openFile(stemsFilename);
		stem=read.readFileByLines();
		read.closeFile();
	}

	public void loadCorpus(String corpusFilename) {
		// Loads the corpus into appropriate data structure.
		ReadFileByScanner read = new ReadFileByScanner();
		read.openFile(corpusFilename);
		corpus=read.readFileByWords();
		read.closeFile();
	}

	public void preprocess() {
		// Runs preprocessing on all the documents.
		// Preprocessing includes applying the following on each document:
		// (1) Initial preprocessing (initialPreprocessing method).
		// (2) Stop words removal (removeStopWords method).
		// (3) Stemming (stemming method).
		// After each  of the 3 preprocessing steps, the appropriate data structre(s) should be updated .
	}

	public String initialPreprocessing(LinkedList<String> document) {
		// Runs preprocessing on a single document passed as paramter.
		// The method returns the document as string after initial processing.
		
		return "Hi";
	}

	public String removeStopWords(LinkedList<String> document) {
		// Remove stop words from a single document passed as paramter.
		// The method returns the document as string after stop word removal.
		
		return "Hi";

	}

	public String stemming(LinkedList<String> document) {
		// Stemming a single document passed as paramter.
		// The method returns the document as string after stemming.
		
		return "Hi";

	}

	public LinkedList<String> getDocument(int i) {
		// Returns document i in the form of a linked list.
		// Each element of the list contains a single word.
		// Spaces are not included. The order of the words must be the same as in the initial text document.
		
		
		LinkedList<String> Hi =null;
		
		return Hi;
	}

}
