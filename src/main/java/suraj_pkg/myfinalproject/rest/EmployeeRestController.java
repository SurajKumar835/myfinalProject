package suraj_pkg.myfinalproject.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import suraj_pkg.myfinalproject.entity.Employee;
import suraj_pkg.myfinalproject.service.EmployeeService;


@RestController
@RequestMapping("/employee")
public class EmployeeRestController {
		private EmployeeService employeeservice;
		//constructor injection
		@Autowired
		public EmployeeRestController(EmployeeService employeeService) {
			this.employeeservice = employeeService;
		}
		@RequestMapping(value="/lists",method = RequestMethod.GET)
		public List<Employee> findAll(){			
			return employeeservice.findAll();			
		}
		
		@RequestMapping(value="/lists/{employeeId}",method=RequestMethod.GET)
		public Employee getEmployee(@PathVariable int employeeId)
		{
			Optional<Employee> result=Optional.ofNullable(employeeservice.findById(employeeId));
			Employee e;
			if(result.isPresent())
			{
				e=result.get();
			}else
			{
				throw new RuntimeException ("Employee id not found");
			}
			return e;
		}
		
		@RequestMapping(value = "/lists",method = RequestMethod.POST)
		public Employee saveEmployee(@RequestBody Employee employee)
		{
			employee.setEmployeeId(0);//not an update method
			employeeservice.save(employee);
			return employee;
		}
		
		@RequestMapping(value = "/lists",method = RequestMethod.PUT)
		public Employee updateEmployee(@RequestBody Employee employee)
		{		
				Optional<Employee> emp=Optional.ofNullable(employeeservice.findById(employee.getEmployeeId()));
				if(emp.isPresent())
					employeeservice.save(employee);
				else
					throw new RuntimeException("employeeId didnot exist in db");
			return employee;
		}
		
		@RequestMapping(value="/lists/{employeeId}",method=RequestMethod.DELETE)
		public String deleteEmployee(@PathVariable int employeeId)
		{
			Optional<Employee> result=Optional.ofNullable(employeeservice.findById(employeeId));
			if(result.isPresent())
			{
				employeeservice.deleteById(result.get().getEmployeeId());
			}
			else {
				throw new RuntimeException("EmployeeId didnot exist");
			}
			return "Employee deleted at "+employeeId;
		}
		
}
