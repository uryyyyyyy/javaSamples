package com.github.uryyyyyyy.javaSamples.elasticsearch.util;



public class RestaurantDTO {

	private final String Name;
	private final String Address;

	public RestaurantDTO(String name, String address) {
		assert(name != null);
		assert(address != null);
		Name = name;
		Address = address;
	}

	public String getName() {
		return Name;
	}

	public String getAddress() {
		return Address;
	}



}
