package company.employee_rest_api;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.Test;

public class DeleteEmployeeTest {

	@Test
	public void deleteEmployee() throws ClientProtocolException, IOException, InterruptedException {

		// Generate an id
		int randomId = ThreadLocalRandom.current().nextInt(1006, 10001);

		// Given
		HttpDelete request = new HttpDelete("http://localhost:8080/employee/deleteEmployee/" + randomId);

		// When
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

		// Then
		assertEquals(httpResponse.getStatusLine().getStatusCode(), 200);

	}

}
