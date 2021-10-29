package suraj_pkg.myfinalproject.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import suraj_pkg.myfinalproject.entity.Employee;
@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	private EntityManager entityManager;
	@Autowired
	public EmployeeDaoImpl(EntityManager theentityManger)
	{
			entityManager=theentityManger;
	}
	@Override
	public List<Employee> findAll() {
		Session current=entityManager.unwrap(Session.class);
		Query<Employee> q=current.createQuery("from Employee",Employee.class);
		return q.getResultList();
	}

	@Override
	public Employee findById(int employeeId) {
		Session current=entityManager.unwrap(Session.class);
		Employee q=current.get(Employee.class, employeeId);
		return q;
	}

	@Override
	public void save(Employee employee) {
		Session current=entityManager.unwrap(Session.class);		
		current.saveOrUpdate(employee);		
	}

	@Override
	public void deleteById(int employeeId) {
		Session current=entityManager.unwrap(Session.class);
		// delete object with primary key
		Employee temp=current.get(Employee.class, employeeId);
		current.delete(temp);
					
	}

}
