package suraj_pkg.myfinalproject.service;

import java.util.List;
import java.util.Optional;

import suraj_pkg.myfinalproject.entity.Employee;

public interface EmployeeService {

	List<Employee> findAll();

	Employee findById(int employeeId);

	void save(Employee employee);

	void deleteById(int employeeId);

}
