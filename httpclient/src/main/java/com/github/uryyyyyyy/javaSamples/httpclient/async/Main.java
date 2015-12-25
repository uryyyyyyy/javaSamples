package com.github.uryyyyyyy.javaSamples.httpclient.async;

import com.ning.http.client.*;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {

	public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {
		AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
		Future<Response> f = asyncHttpClient.prepareGet("http://www.ning.com/").execute();
		Response r = f.get();
		System.out.println(r.getStatusCode());
		System.out.println(r.getContentType());
		System.out.println(r.getResponseBody());
	}
}