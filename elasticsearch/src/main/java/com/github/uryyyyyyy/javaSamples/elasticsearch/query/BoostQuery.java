package com.github.uryyyyyyy.javaSamples.elasticsearch.query;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;

import com.github.uryyyyyyy.javaSamples.elasticsearch.data.Restaurant;
import com.github.uryyyyyyy.javaSamples.elasticsearch.util.ClientProvider;
import com.github.uryyyyyyy.javaSamples.elasticsearch.util.Formatter;
import com.github.uryyyyyyy.javaSamples.elasticsearch.util.RestaurantDTO;
import com.github.uryyyyyyy.javaSamples.elasticsearch.util.SearchExecuter;

public class BoostQuery {

	/**
	 * フリーワード検索する。</br>
	 *
	 * その際、〜〜の項目は重み付けする。(それぞれ2.0ずつ)
	 *
	 * @param keyword
	 * @param size
	 * @param offset
	 * @return
	 * @throws ExecutionException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws Exception {
		String keyword = "東京";
		
		QueryBuilder query = QueryBuilders
				.multiMatchQuery(keyword, Restaurant.ADDRESS)
				.field(Restaurant.NAME, 2.0f)
				.field(Restaurant.NAME_KANA, 2.0f);

		SearchRequestBuilder request = ClientProvider.searchForRestaurant()
				.setQuery(query);
		SearchResponse response = SearchExecuter.exec(request);
		List<RestaurantDTO> sourse = Formatter.sourceOf(response);
		Formatter.print(sourse);
	}

}
