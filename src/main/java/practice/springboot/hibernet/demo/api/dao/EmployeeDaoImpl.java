package practice.springboot.hibernet.demo.api.dao;

import practice.springboot.hibernet.demo.api.model.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> getAll() {
        Session session = entityManager.unwrap(Session.class);
        Query<Employee> employeeQuery = session.createQuery("from Employee",Employee.class);
        List<Employee> employees = employeeQuery.getResultList();
        return employees;
    }

    @Override
    public Employee getById(int id) {
        Session session = entityManager.unwrap(Session.class);
        Employee employee = session.get(Employee.class,id);

        return employee;
    }

    @Override
    public void save(Employee employee) {
       Session currentSession = entityManager.unwrap(Session.class);
       currentSession.saveOrUpdate(employee);
    }

    @Override
    public void delete(int id) {
        Session session = entityManager.unwrap(Session.class);
        Employee employee = session.get(Employee.class,id);
        session.delete(employee);
    }
}
