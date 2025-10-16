package iuh.fit.se.baitap02.repository;


import iuh.fit.se.baitap02.enties.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
