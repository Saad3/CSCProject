import java.util.*;
import java.io.*;

import linkedList.LinkedList;

public class ReadFileByScanner {
	
	private Scanner File;
		
		public ReadFileByScanner() {
			this.File =null;
		}

		public void openFile(String fileName){
			try{
				File = new Scanner(new File(fileName));			
				System.out.println("The File Is Open !!");
			}catch(Exception e){
				System.out.println("Problem in openFile method");
			}	
		}
		
		public LinkedList<String> readFileByLines(){
			LinkedList<String> stringByLine = new LinkedList<String>();

			while(File.hasNextLine()){
				stringByLine.insert(File.nextLine());
			}
			System.out.println("The File read by line !!");
			
			return stringByLine;
		}
		
		public LinkedList<LinkedList<String>> readFileByWords(){
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
			System.out.println("The File read by Words!!");
			
			return linkOfStrings;
		}
		
		public void closeFile(){
			File.close();
			System.out.println("The File Is Closed !!");
			
		}
		
}
