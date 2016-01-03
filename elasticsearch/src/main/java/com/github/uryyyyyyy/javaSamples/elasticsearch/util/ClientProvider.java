package com.github.uryyyyyyy.javaSamples.elasticsearch.util;

import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

import com.github.uryyyyyyy.javaSamples.elasticsearch.data.Restaurant;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ClientProvider {

	private static volatile TransportClient client;
	private static final String DEFAULT_SERVER_HOST = "localhost";
	private static final int DEFAULT_SERVER_PORT = 9300;
	private static final String DEFAULT_CLUSTER_NAME = "elasticsearch";

	private ClientProvider() {
	}

	public static Client getClient() throws UnknownHostException {
		if (client == null) {
			Settings settings = Settings.settingsBuilder()
					.put("cluster.name", DEFAULT_CLUSTER_NAME).build();
			client = TransportClient.builder().settings(settings).build();
			InetAddress address = InetAddress.getByName(DEFAULT_SERVER_HOST);
			client.addTransportAddress(new InetSocketTransportAddress(address, DEFAULT_SERVER_PORT));
		}
		return client;
	}
	
	public static SearchRequestBuilder searchForRestaurant() throws UnknownHostException {
		Client client = ClientProvider.getClient();
		return client.prepareSearch(Restaurant.INDEX).setTypes(Restaurant.TYPE);
	}

}