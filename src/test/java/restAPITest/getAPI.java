package restAPITest;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.client.restAPI;
import com.qa.util.TestUtil;

public class getAPI extends TestBase{
	TestBase testbase;
	String serviceURL;
	String apiURL;
	String URL;
	restAPI API;
	CloseableHttpResponse httpResponse;
	
	
	
	@BeforeMethod
	public void setup() throws ClientProtocolException, IOException
	{
		 testbase = new TestBase();
		 serviceURL = prop.getProperty("URL");
		 apiURL = prop.getProperty("serviceURL");
		 URL = serviceURL + apiURL;
	
			
	}
	
	@Test
	public void getTestWithoutHeaders() throws ClientProtocolException, IOException
	{
		API  = new restAPI();
		httpResponse = API.get(URL);
		
		int statusCode = httpResponse.getStatusLine().getStatusCode(); //statuscode 
		System.out.println("Status code" + statusCode);
		
		Assert.assertEquals(statusCode, RESPONSE_STATUS_CODE_200,"status code is not 200");
		
		String responseString = EntityUtils.toString(httpResponse.getEntity() ,"UTF-8");
		
		JSONObject responseJSON = new JSONObject(responseString);
		System.out.println("response JSON from API" +responseJSON); // JSONResponse
		
		String perPageValue = TestUtil.getValueByJPath(responseJSON, "/per_page");
		System.out.println("Value of per page" +perPageValue);
		Assert.assertEquals(Integer.parseInt(perPageValue), 6);
		
		String totalValue = TestUtil.getValueByJPath(responseJSON, "/total");
		System.out.println("Value of per page" +totalValue);
		Assert.assertEquals(Integer.parseInt(totalValue), 12);
		
		String lastName = TestUtil.getValueByJPath(responseJSON, "/data[0]/last_name");
		String id = TestUtil.getValueByJPath(responseJSON, "/data[0]/id");
		String avator = TestUtil.getValueByJPath(responseJSON, "/data[0]/avator");
		String firstName = TestUtil.getValueByJPath(responseJSON, "/data[0]/first_name");
		
		
		 Header[] header =  httpResponse.getAllHeaders();
		 HashMap<String,String> allHeaders = new HashMap<String,String>();
		 
		 for(Header headerdata :header)
		 {
			 allHeaders.put(headerdata.getName(),headerdata.getValue());
		 }
		System.out.println("Header Array-----" +allHeaders); // headers
		}
	
	public void getTestWithHeaders() throws ClientProtocolException, IOException
	{
		API  = new restAPI();
		httpResponse = API.get(URL);
		HashMap<String,String> headerMap = new HashMap<String,String>();
		headerMap.put("Content-Type", "application/json");
		int statusCode = httpResponse.getStatusLine().getStatusCode(); //statuscode 
		System.out.println("Status code" + statusCode);
		
		Assert.assertEquals(statusCode, RESPONSE_STATUS_CODE_200,"status code is not 200");
		
		String responseString = EntityUtils.toString(httpResponse.getEntity() ,"UTF-8");
		
		JSONObject responseJSON = new JSONObject(responseString);
		System.out.println("response JSON from API" +responseJSON); // JSONResponse
		
		String perPageValue = TestUtil.getValueByJPath(responseJSON, "/per_page");
		System.out.println("Value of per page" +perPageValue);
		Assert.assertEquals(Integer.parseInt(perPageValue), 6);
		
		String totalValue = TestUtil.getValueByJPath(responseJSON, "/total");
		System.out.println("Value of per page" +totalValue);
		Assert.assertEquals(Integer.parseInt(totalValue), 12);
		
		String lastName = TestUtil.getValueByJPath(responseJSON, "/data[0]/last_name");
		String id = TestUtil.getValueByJPath(responseJSON, "/data[0]/id");
		String avator = TestUtil.getValueByJPath(responseJSON, "/data[0]/avator");
		String firstName = TestUtil.getValueByJPath(responseJSON, "/data[0]/first_name");
		
		
		 Header[] header =  httpResponse.getAllHeaders();
		 HashMap<String,String> allHeaders = new HashMap<String,String>();
		 
		 for(Header headerdata :header)
		 {
			 allHeaders.put(headerdata.getName(),headerdata.getValue());
		 }
		System.out.println("Header Array-----" +allHeaders); // headers
		}
		
	}
 
