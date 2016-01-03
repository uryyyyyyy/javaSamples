package com.github.uryyyyyyy.javaSamples.elasticsearch.query;

import java.util.List;

import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;

import com.github.uryyyyyyy.javaSamples.elasticsearch.util.ClientProvider;
import com.github.uryyyyyyy.javaSamples.elasticsearch.util.Formatter;
import com.github.uryyyyyyy.javaSamples.elasticsearch.util.RestaurantDTO;
import com.github.uryyyyyyy.javaSamples.elasticsearch.util.SearchExecuter;

public class MatchAllQuery {

	public static void main(String[] args) throws Exception {
		QueryBuilder query = QueryBuilders.matchAllQuery();
		SearchRequestBuilder request = ClientProvider.searchForRestaurant()
				.setQuery(query);
		SearchResponse response = SearchExecuter.exec(request);
		List<RestaurantDTO> sourse = Formatter.sourceOf(response);
		Formatter.print(sourse);
	}

}
