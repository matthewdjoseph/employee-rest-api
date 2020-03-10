package company.employee_rest_api;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import company.employeeRestApi.DAO.EmployeeService;
import company.employeeRestApi.entities.Employee;

public class DeleteEmployeeTest {

	@Autowired
	private EmployeeService employeeService;

	@Test
	public void deleteEmployee() throws ClientProtocolException, IOException, InterruptedException {

		// Generate an id
		Employee employeeToDelete = new Employee(0);
		int randomId = 0;
		System.out.println(employeeToDelete.getFirstName());
		while (employeeToDelete.getFirstName().length() < 1) {
			randomId = ThreadLocalRandom.current().nextInt(1006, 10001);
			employeeToDelete = employeeService.getEmployee(randomId);
		}

		// Given
		HttpDelete request = new HttpDelete("http://localhost:8080/employee/deleteEmployee/" + randomId);

		// When
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

		// Then
		assertEquals(httpResponse.getStatusLine().getStatusCode(), 200);

	}

}
