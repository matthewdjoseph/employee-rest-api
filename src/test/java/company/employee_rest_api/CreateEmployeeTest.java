package company.employee_rest_api;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.Test;

public class CreateEmployeeTest {

	@Test
	public void createEmployee() throws ClientProtocolException, IOException, InterruptedException {

		String payload = "{\"firstName\":\"Matthew\"," + "\"middleInitial\":\"D\"," + "\"lastName\":\"Joseph\","
				+ "\"dateOfBirth\":\"1988-11-18\"," + "\"dateOfEmployment\":\"2020-03-07\"}";

		StringEntity entity = new StringEntity(payload, ContentType.APPLICATION_JSON);

		// Given
		HttpPost request = new HttpPost("http://localhost:8080/employee/addEmployee");
		request.setEntity(entity);

		// When
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

		// Then
		assertEquals(httpResponse.getStatusLine().getStatusCode(), 200);

	}

}
