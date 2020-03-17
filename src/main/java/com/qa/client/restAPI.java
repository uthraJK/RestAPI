package com.qa.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;



public class restAPI {
	
	//get method
	

	public CloseableHttpResponse get(String url) throws ClientProtocolException, IOException
	{
	CloseableHttpClient httpClient = HttpClients.createDefault(); // create the http connection 
	HttpGet httpGet = new HttpGet(url); // get method 
	CloseableHttpResponse httpResponse = httpClient.execute(httpGet); // hit the request
	return httpResponse;
	
}
	

	public CloseableHttpResponse get(String url , HashMap<String,String> headerMap) throws ClientProtocolException, IOException
	{
	CloseableHttpClient httpClient = HttpClients.createDefault(); // create the http connection 
	HttpGet httpGet = new HttpGet(url); // get method 
	
	CloseableHttpResponse httpResponse = httpClient.execute(httpGet); // hit the request
	return httpResponse;
	
}
}