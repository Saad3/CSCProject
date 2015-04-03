
public class loadStemmingprocessor {
	
	private LinkedList<String> stem;
	
	public void loadStemming(String stemsFilename) {
		// Loads the stemming list into appropriate data structure.
		try {
			ReadFileByScanner read = new ReadFileByScanner();
			read.openFile(stemsFilename);
			stem=read.readFileByLines();
			read.closeFile();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public LinkedList<String[]> StemmingArray(String stemFile){
		LinkedList<String[]> stringArray = new LinkedList<String[]>();
		
		loadStemming(stemFile);
		stem.findFirst();

		String[] toString;
		String[] stemWord;
		String[] stemo;
		
		
		while(!stem.last()){
			toString = stem.retrieve().split(":");
			stemWord = toString[1].split(",");
			stemo=new String[stemWord.length+1];
			stemo[0] = toString[0];
			int x=1;
			for (int i=0 ; i< stemWord.length;i++ ){
				stemo[x]=stemWord[i];
				x++;
			}
			stringArray.insert(stemo);
			stem.findNext();
		}
		toString = stem.retrieve().split(":");
		stemWord = toString[1].split(",");
		stemo=new String[stemWord.length+1];
		stemo[0] = toString[0];
		int x=1;
		for (int i=0 ; i< stemWord.length;i++ ){
			stemo[x]=stemWord[i];
			x++;
		}
		stringArray.insert(stemo);
		
		
		stringArray.findFirst();
		return stringArray;
	}

}
