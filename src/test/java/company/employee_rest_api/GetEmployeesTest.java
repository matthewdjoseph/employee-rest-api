package company.employee_rest_api;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.Test;

public class GetEmployeesTest {

	@Test
	public void getAllEmployees() throws ClientProtocolException, IOException, InterruptedException {

		// Given
		HttpUriRequest request = new HttpGet("http://localhost:8080/");

		// When
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
		
		// Then
		assertEquals(httpResponse.getStatusLine().getStatusCode(), 200);

	}
	
	@Test
	public void getEmployeeById() throws ClientProtocolException, IOException, InterruptedException {
		
		int employeeId = 1008;
		HttpUriRequest request = new HttpGet("http://localhost:8080/employee/" + employeeId);
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
		
		assertEquals(httpResponse.getStatusLine().getStatusCode(), 200);
	}

}
