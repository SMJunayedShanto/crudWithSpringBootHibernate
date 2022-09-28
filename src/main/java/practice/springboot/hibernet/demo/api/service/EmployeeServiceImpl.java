package practice.springboot.hibernet.demo.api.service;

import practice.springboot.hibernet.demo.api.dao.EmployeeDAO;
import practice.springboot.hibernet.demo.api.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Transactional
    @Override
    public List<Employee> getAll() {

        return employeeDAO.getAll();
    }

    @Transactional
    @Override
    public Employee getById(int id) {
        return employeeDAO.getById(id);
    }

    @Transactional
    @Override
    public void save(Employee employee) {

        employeeDAO.save(employee);
    }

    @Transactional
    @Override
    public void delete(int id) {
        employeeDAO.delete(id);
    }
}
