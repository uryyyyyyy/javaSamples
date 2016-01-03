package com.github.uryyyyyyy.javaSamples.elasticsearch;

import static org.elasticsearch.node.NodeBuilder.*;

public class Main {

	public static void main(String[] args) throws IOException, GeoIp2Exception {
		// on startup

		Node node = nodeBuilder().node();
		Client client = node.client();

// on shutdown

		node.close();
	}

}