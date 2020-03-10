package company.employeeRestApi.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

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
		employee.setStatus(true);
		employeeService.saveEmployee(employee);
	}

	// Update employee
	@RequestMapping(method = RequestMethod.POST, value = "/employee/updateEmployee/{employeeId}")
	public void updateEmployee(@PathVariable("employeeId") Integer employeeId, @RequestBody Employee updatedEmployee) {
		Employee employee = employeeService.getEmployee(employeeId);

		employee.setFirstName(updatedEmployee.getFirstName());
		employee.setMiddleInitial(updatedEmployee.getMiddleInitial());
		employee.setLastName(updatedEmployee.getMiddleInitial());
		employee.setDateOfBirth(updatedEmployee.getDateOfBirth());
		employee.setDateOfEmployment(updatedEmployee.getDateOfEmployment());

		employeeService.saveEmployee(employee);
	}

	// Delete employee
	@RequestMapping(method = RequestMethod.DELETE, value = "/employee/deleteEmployee/{employeeId}")
	public Employee deleteEmployee(@PathVariable("employeeId") Integer employeeId) {
		Employee employee = employeeService.getEmployee(employeeId);
		Employee employeecopy = employee;

		if (employee.getFirstName() != null) {
			employeeService.deleteEmployee(employee);
		}

		return employeecopy;
	}

	// Update Status
	@RequestMapping(method = RequestMethod.DELETE, value = "/employee/deactivateEmployee/{employeeId}")
	public void deactivateEmployee(@PathVariable("employeeId") Integer employeeId, HttpSession session) {
		employeeService.deactivateEmployee(employeeId);
	}

}
