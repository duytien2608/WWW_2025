package iuh.fit.se.nguyenduytien_21000025_tuan08.repositories;


import iuh.fit.se.nguyenduytien_21000025_tuan08.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
