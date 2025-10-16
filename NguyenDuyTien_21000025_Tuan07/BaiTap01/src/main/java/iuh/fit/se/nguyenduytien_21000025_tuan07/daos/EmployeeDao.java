package iuh.fit.se.nguyenduytien_21000025_tuan07.daos;


import iuh.fit.se.nguyenduytien_21000025_tuan07.enties.Employee;

import java.util.List;

public interface EmployeeDao {
    void save(Employee employee);
    List<Employee> getAll();
    Employee getByUserName(String userName);
    Employee getByUserNameDirectMapper(String userName);
}
