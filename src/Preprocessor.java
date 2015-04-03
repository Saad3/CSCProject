

public class Preprocessor {
	
	
	private LinkedList<String>stopWord;
	private LinkedList<LinkedList<String>>corpus;
	private LinkedList<String[]>stem;
	
	public Preprocessor() {
		// Initializes the required data structures.
		
		stopWord=null;
		corpus=null;
		stem=null;
	}
	
	public void loadStopWords(String stopWordsFilename) {
		// Loads the stop words list into appropriate data structure.
		
		try {
			ReadFileByScanner read = new ReadFileByScanner();
			
			read.openFile(stopWordsFilename);
			stopWord =read.readFileByLines();
			read.closeFile();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	public void loadStemming(String stemsFilename){
		loadStemmingprocessor Stemming = new loadStemmingprocessor();
		stem = Stemming.StemmingArray(stemsFilename);
	}
		
	public void loadCorpus(String corpusFilename) {
		// Loads the corpus into appropriate data structure.
		try {
			ReadFileByScanner read = new ReadFileByScanner();
			read.openFile(corpusFilename);
			corpus=read.readFileByWords();
			read.closeFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void preprocess() {
		// Runs preprocessing on all the documents.
		// Preprocessing includes applying the following on each document:
		// (1) Initial preprocessing (initialPreprocessing method).
		// (2) Stop words removal (removeStopWords method).
		// (3) Stemming (stemming method).
		// After each  of the 3 preprocessing steps, the appropriate data structre(s) should be updated .
	

		try {
			String /*initial , stop , stemm ,*/ corp;
			corpus.findFirst();
			
			if (corpus.empty())
				return;
			
			while(!corpus.last()){
				if(corpus.retrieve().equals(""))
					corpus.findNext();
				else{
				corp=initialPreprocessing(corpus.retrieve());
				if (stopWord !=null){					
				corp = removeStopWords(toLinkedList(corp));	
				}
				if((stem!=null)){
				corp = stemming(toLinkedList(corp));
				}
				corpus.update(toLinkedList(corp));		
				}
				corpus.findNext();
			}
			if(corpus.retrieve().equals(""))
				corpus.findNext();
			else{
			corp=initialPreprocessing(corpus.retrieve());
			if (stopWord !=null){					
			corp = removeStopWords(toLinkedList(corp));	
			}
			if((stem!=null)){
			corp = stemming(toLinkedList(corp));
			}
			corpus.update(toLinkedList(corp));		
			}
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	public String initialPreprocessing(LinkedList<String> document) {
		// Runs preprocessing on a single document passed as paramter.
		// The method returns the document as string after initial processing.
		String res;
		
		res="";
		document.findFirst();
		while(!document.last()){
				res =res+(document.retrieve()+" ");
			document.findNext();
		}
		res =res+(document.retrieve());
		res=res.replaceAll("\\s*\\bham\\b\\s*", "");
		res=res.replaceAll("\\s*\\bspam\\b\\s*", "");	

		res=res.replaceAll("[^a-zA-Z]", " ");
		res=res.toLowerCase();
		res=res.replaceAll("\\s+", " ");
		res=res.replaceAll("\\b\\w{1,2}\\b\\s?", "");
		
		if(res.endsWith(" ")) {

		    res= res.substring(0, res.length() - 1);
		 }
		return res;
	}

	public String removeStopWords(LinkedList<String> document) {
		// Remove stop words from a single document passed as paramter.
		// The method returns the document as string after stop word removal.
		String res;
		try {
			
			document.findFirst();
			while(!document.last()){
				stopWord.findFirst();
				while(!stopWord.last()){
					if(document.retrieve().equals(stopWord.retrieve()))
							document.update("");
					stopWord.findNext();
				}
				if(document.retrieve().equals(stopWord.retrieve()))
					document.update("");

				document.findNext();
			}
			stopWord.findFirst();
			while(!stopWord.last()){
				if(document.retrieve().equals(stopWord.retrieve()))
						document.update("");
				stopWord.findNext();
			}
			if(document.retrieve().equals(stopWord.retrieve()))
				document.update("");
	
			res = "";
			document.findFirst();
				while(!document.last()){
					if (!document.retrieve().equals(""))
						res =res+(document.retrieve()+ " ");
					document.findNext();
				}
				res =res+(document.retrieve());
		} catch (Exception e) {
			res=null;
			e.printStackTrace();
		}
		return res;

	}
	
	public String stemming(LinkedList<String> document){
		
		try {
			if (document.empty())
				return null;
			
			String res;
			boolean flag;
			document.findFirst();
			
			while(!document.last()){
				stem.findFirst();
				flag = true;
				while(!stem.last()){
				String[] tmp = stem.retrieve();
				for(int i = 1; i<tmp.length ; i++){
					
					if (document.retrieve().equals(tmp[i])){
						document.update(tmp[0]);
						flag=false;
						break;
					}
				}
				if(flag){
				stem.findNext();
				}
				else
					break;
			}
				if(stem.last()){
					String[] tmp = stem.retrieve();
					for(int i = 1; i<tmp.length ; i++){
					
						if (document.retrieve().equals(tmp[i])){
							document.update(tmp[0]);
							break;
						}
					}
				}
				document.findNext();
			}
			stem.findFirst();
			flag = true;
			while(!stem.last()){
			String[] tmp = stem.retrieve();
			for(int i = 1; i<tmp.length ; i++){
				
				if (document.retrieve().equals(tmp[i])){
					document.update(tmp[0]);
					flag=false;
					break;
				}
			}
			if(flag){
			stem.findNext();
			}
			else
				break;
}
			if(stem.last()){
				String[] tmp = stem.retrieve();
				for(int i = 1; i<tmp.length ; i++){
				
					if (document.retrieve().equals(tmp[i])){
						document.update(tmp[0]);
						break;
					}
				}
			}
			
			
		
			res = "";
			document.findFirst();
				while(!document.last()){
					if (!document.retrieve().equals(""))
					res =res+(document.retrieve()+ " ");
					document.findNext();
				}
				res =res+(document.retrieve()+ "" );
				return res;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			return null;
		}
		
	}
	
	public LinkedList<String> getDocument(int i) {
		// Returns document i in the form of a linked list.
		// Each element of the list contains a single word.
		// Spaces are not included. The order of the words must be the same as in the initial text document.
		
		try {
			int count =0;
			corpus.findFirst();
			LinkedList<String> Document1 ;

				while(!corpus.last()){
					if (count==i)
						break;
					corpus.findNext();
					count++;
				}
				
				if((!(i==count))&&(corpus.last())){
					System.out.println("Out of range");
					return Document1=new LinkedList<>();//case the LinkedList is empty
				}
				else
				{
					
					Document1 =corpus.retrieve();
					Document1.findFirst();	
					}

				if (Document1.empty()){
					System.out.print("");
					return Document1;
				}

				
				while(!Document1.last()){
					Document1.retrieve().replaceAll("\\s+","");
					Document1.findNext();
				}
				Document1.retrieve().replaceAll("\\s+","");
			
			return Document1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public LinkedList<String> toLinkedList(String document){
		try {
			String[] theDoc;
			LinkedList<String> res =new LinkedList<>();
			
			
			theDoc=document.split(" "); //
			for(int i=0 ; i< theDoc.length;i++){
				res.insert(theDoc[i]);
			}
			
			return res;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}



}



