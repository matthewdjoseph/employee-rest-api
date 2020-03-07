package company.employeeRestApi.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import company.employeeRestApi.entities.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		employeeRepository.findAll().forEach(employees::add);
		return employees;
	}
	
	public Employee getEmployee(Integer employeeId) {
		employeeRepository.findById(employeeId).orElse(null);
		return employeeRepository.findById(employeeId).orElse(null);
	}

	public void addEmployee(Employee employee) {
		employeeRepository.save(employee);
	}
}
