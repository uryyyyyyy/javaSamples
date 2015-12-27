package com.github.uryyyyyyy.javaSamples.commonsIO;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Ignore;
import org.junit.Test;

import java.io.*;

@Ignore
public class LibraryTest {

	@Test
	public void test1() throws IOException {
		InputStream in = new FileInputStream("src.txt");
		OutputStream out = new FileOutputStream("dest.txt");
		IOUtils.copy(in, out);
		System.out.println("");
	}

	@Test
	public void test2() throws IOException {
		InputStream in = null;
		try {
			in = new FileInputStream("input.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(in);
		}
	}

	@Test
	public void testDateUtils() {
		String filePath = "/path/to/sample.txt";
		String name = FilenameUtils.getBaseName(filePath); // "sample"
		System.out.println(name);
	}
}