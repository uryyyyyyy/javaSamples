package com.github.uryyyyyyy.javaSamples.commonsIO;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class Main {

	public static void main(String args[]) throws IOException {
		InputStream in = new FileInputStream("./commonsIO/src.txt");
		OutputStream out = new FileOutputStream("dest.txt");
		IOUtils.copy(in, out);
		System.out.println("");
	}
}
