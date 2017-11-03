package com.bharath.java8.examples;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FileFeatures {

	void countFileStatistics(File file) {
		try {
			FileInputStream fin = new FileInputStream(file);
			FileReader fread = new FileReader(file);
			FileWriter fw = new FileWriter(new File("A.txt"));
			BufferedReader bread = new BufferedReader(fread);
			int paraCount = 0;
			int sentenceCount = 0;
			int lineCount = 0;
			int wordCount = 0;
			int charCount = 0;
			String temp = "";
			while( (temp = bread.readLine()) != null) {
				lineCount++;
				fw.write(temp);
				if(temp.equalsIgnoreCase("")) {
					paraCount++;
				}else {
					String[] words = temp.split("\\s+");
					wordCount+= words.length;
					String[] sentence = temp.split("[.?;]");
					sentenceCount+= sentence.length;
					charCount+=temp.length();
				}
			}
			    System.out.println("Number of paragraphs = " + paraCount);
			    System.out.println("Total number of sentences = " + sentenceCount);
			    System.out.println("Total number of lines = " + lineCount);
			    System.out.println("Total word count = " + wordCount);
		        System.out.println("Total number of characters = " + charCount);
		        fw.flush();
		        fw.close();
		        bread.close();
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(IOException ie) {
			ie.printStackTrace();
		}
	}
	public static void main(String[] args) {
		BufferedReader read = null;
		try {
			List<String> lines = Files.readAllLines(Paths.get("C://Users//dawson//Desktop//Career//sample.txt"));
			/*for(String line : lines) {
				System.out.println(line);
			}*/
			Map<String,Long> map = lines.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
			System.out.println(map);
			//lines.forEach(System.out::println);*/

			/*read = new BufferedReader(new FileReader("C://Users//dawson//Desktop//Career//notes.txt"));
			String temp;

			while((temp = read.readLine())!=null) {
				System.out.println(temp);
			}*/
			// Creating a File object that represents the disk file.
			// Java program to demonstrate redirection in System.out.println()
			/*PrintStream o = new PrintStream(new File("A.txt"));

			// Store current System.out before assigning a new value
			PrintStream console = System.out;

			// Assign o to output stream
			System.setOut(o);
			System.out.println("This will be written to the text file");
			// Use stored value for output stream
			System.setOut(console);
			System.out.println("This will be written on the console!");
			System.in.read();
*/			FileFeatures ff = new FileFeatures();
			ff.countFileStatistics(new File("B.txt"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(read!=null)
					read.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
