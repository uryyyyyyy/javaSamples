package com.github.uryyyyyyy.javaSamples.javaLang.fileUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8UseStream {

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

	/** New style (Java 8) **/
	public static List<String> readFromFile(String fileName) throws IOException {
		try (Stream<String> lines = Files.lines(Paths.get(fileName))) {
			return lines.collect(Collectors.toList());
		}
	}

}
