package com.github.uryyyyyyy.javaSamples.httpclient;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class LibraryTest {

	@Test
	public void testSomeLibraryMethod() throws IOException {
		// configurations
		int socketTimeout = 3000;
		int connectionTimeout = 3000;
		String userAgent = "My Http Client 0.1";
		// request configuration
		RequestConfig requestConfig = RequestConfig.custom()
				.setConnectTimeout(connectionTimeout)
				.setSocketTimeout(socketTimeout)
				.build();
		// headers
		List<Header> headers = new ArrayList<>();
		headers.add(new BasicHeader("Accept-Charset","utf-8"));
		headers.add(new BasicHeader("Accept-Language","ja, en;q=0.8"));
		headers.add(new BasicHeader("User-Agent",userAgent));
		// create client
		HttpClient httpClient = HttpClientBuilder.create()
				.setDefaultRequestConfig(requestConfig)
				.setDefaultHeaders(headers).build();


		HttpGet httpGet = new HttpGet("http://qiita.com/uryyyyyyy");
		HttpResponse response = httpClient.execute(httpGet);
		int responseStatus = response.getStatusLine().getStatusCode();
		System.out.println(responseStatus);
		String body = EntityUtils.toString(response.getEntity(), "UTF-8");
		System.out.println(body);
	}

	@Test
	public void testRedirect() throws IOException {
		// configurations
		int socketTimeout = 3000;
		int connectionTimeout = 3000;
		String userAgent = "My Http Client 0.1";
		// request configuration
		RequestConfig requestConfig = RequestConfig.custom()
				.setConnectTimeout(connectionTimeout)
				.setSocketTimeout(socketTimeout)
				.build();
		// headers
		List<Header> headers = new ArrayList<>();
		headers.add(new BasicHeader("Accept-Charset","utf-8"));
		headers.add(new BasicHeader("Accept-Language","ja, en;q=0.8"));
		headers.add(new BasicHeader("User-Agent",userAgent));
		// create client
		HttpClient httpClient = HttpClientBuilder.create()
				.setDefaultRequestConfig(requestConfig)
				.setDefaultHeaders(headers).build();


		HttpPost method = new HttpPost("http://www.google.com");
		List<NameValuePair> requestParams = new ArrayList<>();
		requestParams.add(new BasicNameValuePair("foo","var"));
		method.setEntity(new UrlEncodedFormEntity(requestParams));
		HttpResponse response = httpClient.execute(method);
		int responseStatus = response.getStatusLine().getStatusCode();
		System.out.println(responseStatus);
		String body = EntityUtils.toString(response.getEntity(), "UTF-8");
		System.out.println(body);
	}
}