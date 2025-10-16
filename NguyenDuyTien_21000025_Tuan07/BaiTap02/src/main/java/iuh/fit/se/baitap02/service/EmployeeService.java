package iuh.fit.se.baitap02.service;



import iuh.fit.se.baitap02.enties.Employee;

import java.util.List;

public interface EmployeeService {
    void save(Employee employee);
    void update(Employee employee);
    void delete(int id);
    List<Employee> getAll();
    Employee getById(int id);
}
