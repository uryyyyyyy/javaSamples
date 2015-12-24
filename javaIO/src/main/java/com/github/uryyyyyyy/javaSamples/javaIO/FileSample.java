package com.github.uryyyyyyy.javaSamples.javaIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class FileSample {

	public static void copy(Path target, Path dest){
		try {
			Files.copy(target, dest, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
