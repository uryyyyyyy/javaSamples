package com.github.uryyyyyyy.javaSamples.elasticsearch.util;

import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchScrollRequestBuilder;

public class SearchExecuter {
	
	public static SearchResponse exec(SearchRequestBuilder request){
		System.out.println("request body -----------------");
		System.out.println(request);
		System.out.println("response body -----------------");
		SearchResponse response = request.get();
		System.out.println(response);
		System.out.println("-----------------");
		return response;
	}
	
	public static SearchResponse exec(SearchScrollRequestBuilder request){
		System.out.println("request body -----------------");
		System.out.println(request);
		System.out.println("response body -----------------");
		SearchResponse response = request.execute().actionGet();;
		System.out.println(response);
		System.out.println("-----------------");
		return response;
	}

}
