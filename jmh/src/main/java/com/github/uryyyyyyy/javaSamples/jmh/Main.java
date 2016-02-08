package com.github.uryyyyyyy.javaSamples.jmh;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws RunnerException {
		Options opt = new OptionsBuilder()
				.include(Main.class.getSimpleName())
				.forks(1)
				.build();
		new Runner(opt).run();
	}

	@Benchmark
	public void recursive() {
		List<Integer> defaultList = new ArrayList<>();
		for (int i = 0; i < 100000; i++) {
			defaultList.add(i);
		}
		defaultList.get(0);
	}
}
