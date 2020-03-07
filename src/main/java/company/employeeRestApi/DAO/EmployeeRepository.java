package company.employeeRestApi.DAO;

import org.springframework.data.repository.CrudRepository;

import company.employeeRestApi.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
