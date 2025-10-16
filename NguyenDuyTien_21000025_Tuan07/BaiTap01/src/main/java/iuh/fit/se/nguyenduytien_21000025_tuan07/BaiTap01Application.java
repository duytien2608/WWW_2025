package iuh.fit.se.nguyenduytien_21000025_tuan07;


import iuh.fit.se.nguyenduytien_21000025_tuan07.daos.EmployeeDao;
import iuh.fit.se.nguyenduytien_21000025_tuan07.enties.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication(scanBasePackages = {"iuh.fit.se.daos","iuh.fit.se.daos.impl"})
public class BaiTap01Application {
    public static void main(String[] args) {
        SpringApplication.run(BaiTap01Application.class, args);
    }
    @Bean
    CommandLineRunner runner (EmployeeDao employeeDao){
        return args -> {
            Employee employee = new Employee("Nguyen Duy Tien","21000025");
            employeeDao.save(employee);
            List<Employee> employees = employeeDao.getAll();
            employees.forEach(System.out::println);
            Employee employee2 = employeeDao.getByUserName("Nguyen Duy Tien");
            System.out.println(employee2);
            Employee employeeDirec = employeeDao.getByUserNameDirectMapper("Nguyen Duy Tien");
            System.out.println(employeeDirec);
        };
    }
}
