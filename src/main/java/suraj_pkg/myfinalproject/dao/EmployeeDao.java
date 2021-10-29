package suraj_pkg.myfinalproject.dao;

import java.util.List;

import suraj_pkg.myfinalproject.entity.Employee;

public interface EmployeeDao {

	List<Employee> findAll();

	Employee findById(int employeeId);

	void save(Employee employee);

	void deleteById(int employeeId);

}
