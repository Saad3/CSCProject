import java.io.*;
//import java.util.Scanner;

import linkedList.LinkedList;

public class ReadFileByBuffer {

	private BufferedReader File;
	
		public ReadFileByBuffer(){
			File = null;
		}
		
		public void openFile(String fileName){
			try{
				File = new BufferedReader(new FileReader(fileName));			
				System.out.println("The File Is Open !!");
			}catch(Exception e){
				System.out.println("Problem in openFile method");
			}
		}
		
		public LinkedList<String> readFileByLines(){
			LinkedList<String> stringByLine = new LinkedList<String>();

			try {
				while(File.readLine() != null){
					stringByLine.insert(File.readLine());
				}
			} catch (IOException e) {
				System.out.println("Problem in Open File method !!");
			}
			System.out.println("The File read by line !!");
			
			return stringByLine;
		}
	
	
	
	
	
	
}
