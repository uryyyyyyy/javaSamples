package com.github.uryyyyyyy.javaSamples.javaLang.fileUtil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Java7TryWithResources {

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

	/** Old style (Java 7 without java.nio package) **/
	public static List<String> readFromFile(String fileName) throws IOException {
		try (
				FileReader fr = new FileReader(fileName);
				BufferedReader br = new BufferedReader(fr);
				Scanner scanner = new Scanner(br)
		) {
			List<String> result = new ArrayList<String>();
			while (scanner.hasNextLine()) {
				result.add(scanner.nextLine());
			}
			return result;
		}
	}

}
