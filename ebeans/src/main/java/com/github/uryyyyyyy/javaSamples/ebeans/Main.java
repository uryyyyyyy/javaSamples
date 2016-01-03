package com.github.uryyyyyyy.javaSamples.ebeans;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.EbeanServer;

public class Main {


	public static void main(String[] args) {
		EbeanServer server = Ebean.getServer("h2");
		insert(server);
		update(server);
		delete(server);
//		select(server);
	}

	private static void delete(EbeanServer server) {
		server.execute(() -> {

			// delete
			Customer customer = Ebean.find(Customer.class, 4);
			Ebean.delete(customer);

			// sql bulk update uses table and column names
			server.createSqlUpdate("delete from o_country").execute();
		});
	}

	private static void update(EbeanServer server) {
		server.execute(() -> {
			Customer customer = server.find(Customer.class, 4);
			customer.name = "New updated name";
			Ebean.save(customer);
		});
	}

	private static void select(EbeanServer server) {
		Customer customer1 = server.find(Customer.class, 4);
		System.out.println(customer1);
	}

	private static void insert(EbeanServer server) {
		server.execute(() -> {
			Customer customer = new Customer("name", "comment");
			server.save(customer);
		});
	}

}