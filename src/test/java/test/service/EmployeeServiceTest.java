package test.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.virtusa.data.EmployeeRepository;
import com.virtusa.modles.DepartmentEnum;
import com.virtusa.modles.Employee;
import com.virtusa.service.EmployeeService;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeServiceTest {

	private EmployeeRepository empRepo;
	private EmployeeService empServ;
	
	@BeforeEach
	void setUpService() {
		empRepo = mock(EmployeeRepository.class);
		empServ = new EmployeeService(empRepo);
	}
	
	
	@Test
	public void addNewEmployee() {
		Employee emp = new Employee(1,"tim","tim", DepartmentEnum.Finance, "tim@mail.com");
		Employee empT = empServ.add(emp);
		
		assertThat(empT.getId() == 1);
		
	}
}
