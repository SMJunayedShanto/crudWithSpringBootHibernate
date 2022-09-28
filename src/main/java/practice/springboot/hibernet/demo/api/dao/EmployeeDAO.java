package practice.springboot.hibernet.demo.api.dao;

import practice.springboot.hibernet.demo.api.model.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> getAll();

    Employee getById(int id);

    void save(Employee employee);

    void delete(int id);
}
