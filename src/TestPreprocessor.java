// This class is provided for your convenience and as a guidline. It will not be the class that will be used for evaluating your project.
import java.util.Scanner;

public class TestPreprocessor {
	public static void main(String[] args) {
		Preprocessor p = new Preprocessor();
		
		/*
		LinkedList<String>x =new LinkedList<String>();
		x.insert("There");
		x.insert("iS");
		x.insert("Need");
		x.insert("4");
		x.insert("testing!");
		*/
		String s = "spam	WINNER!! As a valued network customer you have been selected to receivea £900 prize reward! To claim call 09061701461. Claim code KL341. Valid 12 hours only.";
		String[] x = s.split("\\t");
	     
		System.out.println(x[1]);

		// Load stop words and stemming list
		p.loadStopWords("stop.txt");
		//System.out.println("here1");
		p.loadStemming("stem.txt");
	//	System.out.println("here2");

		// Load corpus
		p.loadCorpus("corpus.txt");
	//	System.out.println("here3");

		// Preprocess loaded corpus documents
		p.preprocess();
		//System.out.println("here4");

		int i;
		Scanner scanner = new Scanner(System.in);

		do {
			// Read i from the user
			System.out.println();
			System.out.print("Please enter your choice: ");
			i = scanner.nextInt();

			if (i > -1) {
				// Get the document i
				LinkedList<String> l = p.getDocument(i);

				// Print all the words in the document i
				
				if(!l.empty()) {
					l.findFirst();
					while(!l.last()) {
						System.out.print(l.retrieve()+" ");
						l.findNext();
					}
					System.out.print(l.retrieve());
				}
			}
		} while(i > -1);
		
		scanner.close();//I add it !!
	}
	
}
