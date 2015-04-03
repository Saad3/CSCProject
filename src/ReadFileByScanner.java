import java.util.*;
import java.io.*;

public class ReadFileByScanner {
	
	private Scanner File;
		
		public ReadFileByScanner() {
			this.File =null;
		}

		public void openFile(String fileName){
			try{
				File = new Scanner(new File(fileName));			
			//	System.out.println("The File Is Open !!");
			}catch(Exception e){
				System.out.println("Problem in openFile method");
			}	
		}
		
		public LinkedList<String> readFileByLines(){
			LinkedList<String> stringByLine;
			try {
				stringByLine = new LinkedList<String>();

				while(File.hasNextLine()){
					stringByLine.insert(File.nextLine());
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				stringByLine = null;
				e.printStackTrace();
			}
	//		System.out.println("The File read by line !!");
			
			return stringByLine;
		}
		
		public LinkedList<LinkedList<String>> readFileByWords(){
			try {
				Scanner tmp;
				LinkedList<LinkedList<String>> linkOfStrings = new LinkedList<LinkedList<String>>();
				LinkedList<String> stringByWords;
				while (File.hasNextLine()){
					tmp = new Scanner(File.nextLine());
					stringByWords = new LinkedList<String>();
					while(tmp.hasNext()){
						stringByWords.insert(tmp.next());
					}
					tmp.close();
					linkOfStrings.insert(stringByWords);
				}
				//System.out.println("The File read by Words!!");
				
				return linkOfStrings;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		public void closeFile(){
			File.close();
		//	System.out.println("The File Is Closed !!");
			
		}
		
}
