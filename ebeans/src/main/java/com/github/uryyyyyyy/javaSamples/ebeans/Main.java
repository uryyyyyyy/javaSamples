package com.github.uryyyyyyy.javaSamples.ebeans;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import java.io.IOException;
import java.util.List;

public class Main {


	public static void main(String[] args) throws IOException {
		Config config = ConfigFactory.load("application.conf");
		int s = config.getInt("foo.bar");
		System.out.println(s);

		Config ss = config.getConfig("foo");
		System.out.println(ss);

		List<String> sss = config.getStringList("foo.list");
		System.out.println(sss);
	}

}