package com.github.uryyyyyyy.javaSamples.elasticsearch.query;

import java.net.UnknownHostException;
import java.util.List;

import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchScrollRequestBuilder;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;

import com.github.uryyyyyyy.javaSamples.elasticsearch.util.ClientProvider;
import com.github.uryyyyyyy.javaSamples.elasticsearch.util.Formatter;
import com.github.uryyyyyyy.javaSamples.elasticsearch.util.Pair;
import com.github.uryyyyyyy.javaSamples.elasticsearch.util.RestaurantDTO;
import com.github.uryyyyyyy.javaSamples.elasticsearch.util.SearchExecuter;

public class ScrollQuery {

	public static void main(String[] args) throws Exception {
		int sizeParShard = 1;//defaultで5シャードあるらしいので1*5件返ってくる。

		QueryBuilder query = QueryBuilders.matchAllQuery();
		SearchRequestBuilder request = ClientProvider.searchForRestaurant()
				.setSearchType(SearchType.SCAN)
				.setScroll(new TimeValue(10))
				.setQuery(query)
				.setSize(sizeParShard);
		SearchResponse response = SearchExecuter.exec(request);
		Pair<List<RestaurantDTO>, String> pair = Pair.create(Formatter.sourceOf(response), response.getScrollId());
		Formatter.print(pair.first);

		Pair<List<RestaurantDTO>, String> pair2 = scroll(pair.second);
		Formatter.print(pair2.first);

		Pair<List<RestaurantDTO>, String> pair3 = scroll(pair2.second);
		Formatter.print(pair3.first);
	}

	private static Pair<List<RestaurantDTO>, String> scroll(String scrollId) throws UnknownHostException {

		SearchScrollRequestBuilder request = ClientProvider.getClient()
				.prepareSearchScroll(scrollId)
				.setScroll(new TimeValue(10));

		SearchResponse response = SearchExecuter.exec(request);
		List<RestaurantDTO> sourse = Formatter.sourceOf(response);
		return Pair.create(sourse, response.getScrollId());
	}

}
