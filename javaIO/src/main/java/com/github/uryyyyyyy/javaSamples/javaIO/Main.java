package com.github.uryyyyyyy.javaSamples.javaIO;

import java.io.File;
import java.nio.file.Path;

public class Main {

	public static void main(String args[]){
		Path src = new File("./javaIO/in.txt").toPath();
		Path dest = new File("./dest.txt").toPath();
		FileSample.copy(src, dest);
	}
}
