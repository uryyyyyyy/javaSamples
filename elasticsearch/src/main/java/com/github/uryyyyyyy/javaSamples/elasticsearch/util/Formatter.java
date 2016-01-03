package com.github.uryyyyyyy.javaSamples.elasticsearch.util;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.elasticsearch.action.search.SearchResponse;

public class Formatter {

	public static List<RestaurantDTO> sourceOf(SearchResponse response) {
		return StreamSupport
				.stream(response.getHits().spliterator(), false)
				.map(s -> s.getSource())
				.map(s -> toRestaurantDTO(s))
				.collect(Collectors.toList());
	}

	public static RestaurantDTO toRestaurantDTO(Map<String, Object> s) {
		return new RestaurantDTO((String)s.get("name"), (String)s.get("address"));
	}

	public static void print(List<RestaurantDTO> responseList) {
		System.out.println("result name -----------------");
		responseList.stream().map(e -> e.getName()).forEach(System.out::println);
	}

}
