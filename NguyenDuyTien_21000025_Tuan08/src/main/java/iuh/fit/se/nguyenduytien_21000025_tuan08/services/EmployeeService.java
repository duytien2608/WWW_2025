package iuh.fit.se.nguyenduytien_21000025_tuan08.services;

import iuh.fit.se.entities.Employee;

import java.util.List;

public interface EmployeeService {
    public void save(Employee employee);
    public List<Employee> getAll();
    public Employee getById(Long id);
}
