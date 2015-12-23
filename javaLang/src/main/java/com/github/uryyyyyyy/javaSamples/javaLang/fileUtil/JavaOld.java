package com.github.uryyyyyyy.javaSamples.javaLang.fileUtil;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaOld {

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

	public static List<String> readFromFile(String fileName) throws IOException {
		FileReader fr = null;
		BufferedReader br = null;
		Scanner scanner = null;
		try {
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);
			scanner = new Scanner(br);

			List<String> result = new ArrayList<String>();
			while (scanner.hasNextLine()) {
				result.add(scanner.nextLine());
			}
			return result;
		} finally {
			closeSilently(scanner);
			closeSilently(br);
			closeSilently(fr);
		}
	}

	private static void closeSilently(Closeable target) {
		try {
			target.close();
		} catch (IOException e) {}
	}

}
