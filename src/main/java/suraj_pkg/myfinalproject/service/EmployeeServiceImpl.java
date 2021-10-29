package suraj_pkg.myfinalproject.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import suraj_pkg.myfinalproject.dao.EmployeeDao;
import suraj_pkg.myfinalproject.entity.Employee;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDao employeedao;
	@Autowired
	public EmployeeServiceImpl(EmployeeDao theemployeeDao)
	{
		this.employeedao=theemployeeDao;
	}
	
	@Override
	@Transactional
	public List<Employee> findAll() {
		return employeedao.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int employeeId) {
		return employeedao.findById(employeeId);
	}

	@Override
	@Transactional
	public void save(Employee employee) {
		employeedao.save(employee);
		
	}

	@Override
	@Transactional
	public void deleteById(int employeeId) {
		employeedao.deleteById(employeeId);
		
	}

}
