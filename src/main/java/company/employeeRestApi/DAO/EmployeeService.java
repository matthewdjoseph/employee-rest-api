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
		employeeRepository.findAll().forEach(e -> {
			if(e.isStatus()) {
				employees.add(e);
			}
		});
		return employees;
	}
	
	public Employee getEmployee(Integer employeeId) {
		Employee employee = employeeRepository.findById(employeeId).orElse(null);
		if(!employee.isStatus()) {
			employee = null;
		}
		return employee;
	}

	public String saveEmployee(Employee employee) {
		employeeRepository.save(employee);
		return "Employee Saved Successfully";
	}
	
	public String deleteEmployee(Employee employee) {
		employeeRepository.delete(employee);
		return "Employee Deleted Successfully";
	}
	
	public String deactivateEmployee(Employee employee) {
		employee.setStatus(false);
		employeeRepository.save(employee);
		return "Employee Status Updated";
	}
	
}
