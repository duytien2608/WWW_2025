package iuh.fit.se.baitap02;


import iuh.fit.se.baitap02.enties.Employee;
import iuh.fit.se.baitap02.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class BaiTap02Application {
	public static void main(String[] args) {
		SpringApplication.run(BaiTap02Application.class, args);
		ApplicationContext context = SpringApplication.run(BaiTap02Application.class, args);
		EmployeeService employeeService = context.getBean(EmployeeService.class);
		Employee employee = new Employee("Giao vien", "Le Thi B");
		Employee employee1 = new Employee("Sinh vien","Nguyen Duy Tien");
		employeeService.save(employee);
		employeeService.save(employee1);
		List<Employee> employeeList = employeeService.getAll();
		Employee employee2 = employeeService.getById(1);
		System.out.println(employeeList);
		System.out.println(employee2);
	}
}
