package practice.springboot.hibernet.demo.api.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import practice.springboot.hibernet.demo.api.model.Employee;
import practice.springboot.hibernet.demo.api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/test")
    public String test(Model model){

        return "test";
    }

    @GetMapping("/employee")
    public List<Employee> getAll(){

        return employeeService.getAll();
    }

    @PostMapping("/employee")
    public Employee save(@RequestBody Employee employee){
        employeeService.save(employee);

        return employee;
    }

    @GetMapping("/employee/{id}")
    public Employee getById(@PathVariable int id){
        Employee employee = employeeService.getById(id);
        if(employee == null){
            throw new RuntimeException("Employee with id"+id+"is not found!");
        }
        return employee;
    }

    @DeleteMapping("/employee/{id}")
    public String delete(@PathVariable int id){
        employeeService.delete(id);

        return "deleted! id : "+id;
    }

    @PutMapping("/employee")
    public Employee update(@RequestBody Employee employee){
        employeeService.save(employee);

        return employee;
    }
}
