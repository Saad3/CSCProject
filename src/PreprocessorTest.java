import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PreprocessorTest {

	protected Preprocessor p;

	// Utility methods

	public static LinkedList<String> getList(String line) {
		String[] words = line.split("\\s+");
		LinkedList<String> document = new LinkedList<String>();
		for(int i = 0; i < words.length; i++)
			document.insert(words[i]);
		return document;
	}

	public static String getString(LinkedList<String> l) {
		String result = "";

		if(!l.empty()) {
			l.findFirst();
			while(!l.last()) {
				result += l.retrieve() + " ";
				l.findNext();
			}
			result += l.retrieve();
		}

		return result;
	}

	@Before
	public void setUp() throws Exception {
		p = new Preprocessor();
	}

	@Test
	public void testLoadStopWords() {
		p.loadStopWords("stop.txt");

		assertTrue(true);
	}

	@Test
	public void testLoadStemming() {
		p.loadStemming("stem.txt");

		assertTrue(true);
	}

	@Test
	public void testLoadCorpus() {
		p.loadCorpus("corpus.txt");

		assertTrue(true);
	}

	@Test
	public void testPreprocess1() {
		p.loadStopWords("stop.txt");
		p.loadStemming("stem.txt");
		p.loadCorpus("corpus.txt");
		p.preprocess();

		assertTrue(true);
	}

	@Test
	public void testPreprocess2() {
		p.loadStopWords("stop.txt");
		p.loadStemming("stem.txt");
		p.loadCorpus("corpus.txt");
		p.preprocess();

		assertEquals("jurong point crazi bugis great world buffet cine amor wat", getString(p.getDocument(0)));
	}

	@Test
	public void testPreprocess3() {
		p.loadStopWords("stop.txt");
		p.loadStemming("stem.txt");
		p.loadCorpus("corpus.txt");
		p.preprocess();

		assertEquals("lar joke wif oni", getString(p.getDocument(1)));
	}

	@Test
	public void testPreprocess4() {
		p.loadStopWords("stop.txt");
		p.loadStemming("stem.txt");
		p.loadCorpus("corpus.txt");
		p.preprocess();

		assertEquals("free entri wkly comp win cup final tkts text receiv entri question std txt rate appli", getString(p.getDocument(2)));
	}

	@Test
	public void testPreprocess5() {
		p.loadStopWords("stop.txt");
		p.loadStemming("stem.txt");
		p.loadCorpus("corpus.txt");
		p.preprocess();

		assertEquals("dun earli hor", getString(p.getDocument(3)));
	}

	@Test
	public void testPreprocess6() {
		p.loadStopWords("stop.txt");
		p.loadStemming("stem.txt");
		p.loadCorpus("corpus.txt");
		p.preprocess();

		assertEquals("nah don usf live", getString(p.getDocument(4)));
	}

	@Test
	public void testPreprocess7() {
		p.loadStopWords("stop.txt");
		p.loadStemming("stem.txt");
		p.loadCorpus("corpus.txt");
		p.preprocess();

		assertEquals("freemsg hei darl week word back fun xxx std chgs send rcv", getString(p.getDocument(5)));
	}

	@Test
	public void testPreprocess8() {
		p.loadStopWords("stop.txt");
		p.loadStemming("stem.txt");
		p.loadCorpus("corpus.txt");
		p.preprocess();

		assertEquals("winner valu network custom select receivea prize reward claim call claim code valid hour", getString(p.getDocument(8)));
	}

	@Test
	public void testPreprocess9() {
		p.loadStopWords("stop.txt");
		p.loadStemming("stem.txt");
		p.loadCorpus("corpus.txt");
		p.preprocess();

		assertEquals("lor", getString(p.getDocument(15)));
	}

	@Test
	public void testPreprocess10() {
		p.loadStopWords("stop.txt");
		p.loadStemming("stem.txt");
		p.loadCorpus("corpus.txt");
		p.preprocess();

		assertEquals("yup", getString(p.getDocument(17)));
	}

	@Test
	public void testInitialPreprocess() {
		p.loadStopWords("stop.txt");
		p.loadStemming("stem.txt");
		p.loadCorpus("corpus.txt");

		assertEquals("there need testing", p.initialPreprocessing(getList("There iS Need 4 testing!")));
	}

	@Test
	public void testRemoveStopWords() {
		p.loadStopWords("stop.txt");
		p.loadStemming("stem.txt");
		p.loadCorpus("corpus.txt");

		assertEquals("testing", p.removeStopWords(getList("there need testing")));
	}

	@Test
	public void testStemming() {
		p.loadStopWords("stop.txt");
		p.loadStemming("stem.txt");
		p.loadCorpus("corpus.txt");

		assertEquals("abdulrahman test", p.stemming(getList("abdulrahman testing")));
	}

	@Test
	public void testPreprocessWithoutStemming() {
		p.loadStopWords("stop.txt");
		p.loadCorpus("corpus.txt");
		p.preprocess();

		assertEquals("jurong point crazy bugis great world buffet cine amore wat", getString(p.getDocument(0)));
	}

	@Test
	public void testPreprocessWithoutStopWords() {
		p.loadStemming("stem.txt");
		p.loadCorpus("corpus.txt");
		p.preprocess();

		assertEquals("until jurong point crazi avail onli bugis great world buffet cine there got amor wat", getString(p.getDocument(0)));
	}

	@Test
	public void testPreprocessWithoutStopWordsAndStemming() {
		p.loadCorpus("corpus.txt");
		p.preprocess();

		assertEquals("until jurong point crazy available only bugis great world buffet cine there got amore wat", getString(p.getDocument(0)));
	}
}
