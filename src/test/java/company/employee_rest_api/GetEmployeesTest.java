package company.employee_rest_api;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;
import org.springframework.http.HttpStatus;

public class GetEmployeesTest {

	@Test
	public void test1() throws ClientProtocolException, IOException {

		// Given
		HttpUriRequest request = new HttpGet("https://localhost:8080/");

		// When
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

		// Then
		assertEquals(httpResponse.getStatusLine().getStatusCode(), equals(HttpStatus.FOUND));

	}

}