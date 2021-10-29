package suraj_pkg.myfinalproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import suraj_pkg.myfinalproject.entity.Employee;
//custom repository using jpa (spring data jpa)
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
//no need to write any crud basic operation
}
