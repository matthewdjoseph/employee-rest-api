package company.employeeRestApi.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import company.employeeRestApi.entities.Employee;

/*
 * Using the @Service annotation for this service ensures that this class is 
 * only instantiated once on build and isn't created over and over again. 
 * This is an example of the Singleton design pattern. Using this service,
 * there is just one point of access to the database to separate business
 * logic from the controllers.
 * 
 */

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		employeeRepository.findAll().forEach(e -> {
			if (e.isStatus()) {
				employees.add(e);
			}
		});
		return employees;
	}

	public Employee getEmployee(Integer employeeId) {
		Employee employee = employeeRepository.findById(employeeId).get();
		if (employee.isStatus() == false) {
			employee = new Employee(0);
		}
		return employee;
	}

	public Employee saveEmployee(Employee employee) {
		employeeRepository.save(employee);
		return employee;
	}

	public Employee deleteEmployee(Employee employee) {
		Employee employeeCopy = employee;
		employeeRepository.delete(employee);
		return employeeCopy;
	}

	public Employee deactivateEmployee(Integer employeeId) {
		Employee employee = employeeRepository.findById(employeeId).orElse(null);
		Employee employeeCopy = employee;
		if (!employee.isStatus()) {
			employee = null;
			System.gc();
			return employeeCopy;
		} else {
			employee.setStatus(false);
			employeeRepository.save(employee);
			return employeeCopy;
		}
	}

}
