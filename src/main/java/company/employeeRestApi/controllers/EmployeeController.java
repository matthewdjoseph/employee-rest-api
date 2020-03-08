package company.employeeRestApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import company.employeeRestApi.DAO.EmployeeService;
import company.employeeRestApi.entities.Employee;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();

	}

	// Get employee by id
	@RequestMapping("/employee/{employeeId}")
	public Employee getEmployeeById(@PathVariable("employeeId") Integer employeeId) {
		return employeeService.getEmployee(employeeId);
	}

	// Add new employee
	@RequestMapping(method = RequestMethod.POST, value = "/employee/addEmployee")
	public void addEmployee(@RequestBody Employee employee) {
		employeeService.saveEmployee(employee);
	}

	// Update employee
	@RequestMapping(method = RequestMethod.POST, value = "/employee/updateEmployee/{employeeId}")
	public void updateEmployee(@PathVariable("employeeId") Integer employeeId, @RequestBody Employee updatedEmployee) {
		Employee employee = new Employee();

		employee.setId(employeeId);
		employee.setFirstName(updatedEmployee.getFirstName());
		employee.setMiddleInitial(updatedEmployee.getMiddleInitial());
		employee.setLastName(updatedEmployee.getMiddleInitial());
		employee.setDateOfBirth(updatedEmployee.getDateOfBirth());
		employee.setDateOfEmployment(updatedEmployee.getDateOfEmployment());

		employeeService.saveEmployee(employee);
	}

	// Delete employee
	@RequestMapping(method = RequestMethod.DELETE, value = "/employee/deleteEmployee/{employeeId}")
	public void deleteEmployee(@PathVariable("employeeId") Integer employeeId) {
		employeeService.deleteEmployee(employeeService.getEmployee(employeeId));
	}

	// Update Status
	@RequestMapping(method = RequestMethod.DELETE, value = "/employee/deactivateEmployee/{employeeId}")
	public void deactivateEmployee(@PathVariable("employeeId") Integer employeeId) {
		employeeService.deactivateEmployee(employeeService.getEmployee(employeeId));
	}

}
