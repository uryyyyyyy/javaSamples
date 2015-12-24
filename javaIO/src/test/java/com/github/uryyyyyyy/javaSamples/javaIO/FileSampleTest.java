package com.github.uryyyyyyy.javaSamples.javaIO;

import org.junit.Test;

import java.io.File;
import java.nio.file.Path;

import static org.junit.Assert.assertTrue;

public class FileSampleTest {

	@Test
	public void testSomeLibraryMethod() {
		Path src = new File("javaIO/in.txt").toPath();
		Path dest = new File("./dest.txt").toPath();
		FileSample.copy(src, dest);
	}
}