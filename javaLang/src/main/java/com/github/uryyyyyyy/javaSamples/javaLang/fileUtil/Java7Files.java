package com.github.uryyyyyyy.javaSamples.javaLang.fileUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Java7Files {

	public static void main(String[] args){
		try {
			List<String> list = readFromFile("./src/study/fileUtil/sample.txt");
			for(String str : list){
				System.out.println(str);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/** New style (Java 7) **/
	public static List<String> readFromFile(String fileName) throws IOException {
		return Files.readAllLines(Paths.get(fileName));
	}

}
