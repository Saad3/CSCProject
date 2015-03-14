// This class is provided for your convenience and as a guidline. It will not be the class that will be used for evaluating your project.
import linkedList.*;
import java.util.Scanner;

public class TestPreprocessor {
	public static void main(String[] args) {
		Preprocessor p = new Preprocessor();

		// Load stop words and stemming list
		p.loadStopWords("replace/with/path/to/stop.txt");
		p.loadStemming("replace/with/path/to/stem.txt");

		// Load corpus
		p.loadCorpus("replace/with/path/to/corpus.txt");

		// Preprocess loaded corpus documents
		p.preprocess();

		int i;
		Scanner scanner = new Scanner(System.in);

		do {
			// Read i from the user
			System.out.print("Please enter your choice: ");
			i = scanner.nextInt();

			if (i > -1) {
				// Get the document i
				LinkedList<String> l = p.getDocument(i);

				// Print all the words in the document i
				if(!l.empty()) {
					l.findFirst();
					while(!l.last()) {
						System.out.println(l.retrieve());
						l.findNext();
					}
					System.out.println(l.retrieve());
				}
			}
		} while(i > -1);
		
		scanner.close();//I add it !!
	}
	
}
