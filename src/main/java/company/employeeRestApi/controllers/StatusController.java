package company.employeeRestApi.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {
	
	// Test the status of the server
	@RequestMapping("status")
	public String tellStatus() {
		return "We are up!";
	}

}
