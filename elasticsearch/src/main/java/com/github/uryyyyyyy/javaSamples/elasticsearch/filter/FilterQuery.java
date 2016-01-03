package com.github.uryyyyyyy.javaSamples.elasticsearch.filter;

import com.github.uryyyyyyy.javaSamples.elasticsearch.data.Restaurant;
import com.github.uryyyyyyy.javaSamples.elasticsearch.util.ClientProvider;
import com.github.uryyyyyyy.javaSamples.elasticsearch.util.Formatter;
import com.github.uryyyyyyy.javaSamples.elasticsearch.util.RestaurantDTO;
import com.github.uryyyyyyy.javaSamples.elasticsearch.util.SearchExecuter;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.FilteredQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;

import java.util.List;

public class FilterQuery {

	public static void main(String[] args) throws Exception {
//		String keyword = "東京";
//		int category_id1 = 505;
//
//		QueryBuilder query = QueryBuilders
//				.boolQuery(QueryBuilders.disMaxQuery()
//						.add(QueryBuilders.matchQuery(Restaurant.NAME, keyword))
//						.add(QueryBuilders.matchQuery(Restaurant.NAME_KANA, keyword)),
//						FilterBuilders.termFilter(Restaurant.CATEGORY_ID1, category_id1));
//
//		SearchRequestBuilder request = ClientProvider.searchForRestaurant()
//				.setQuery(query);
//		SearchResponse response = SearchExecuter.exec(request);
//		List<RestaurantDTO> sourse = Formatter.sourceOf(response);
//		Formatter.print(sourse);
	}

}
