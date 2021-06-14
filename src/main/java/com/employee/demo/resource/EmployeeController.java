package com.employee.demo.resource;

import com.employee.demo.document.Department;
import com.employee.demo.document.Domain;
import com.employee.demo.document.Employee;
import com.employee.demo.repository.DepartmentRepository;
import com.employee.demo.repository.DomainRepository;
import com.employee.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/*import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;*/


import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/rest/users")
public class EmployeeController {

    private EmployeeRepository usersRepository;
    private DomainRepository domainRepository;
    private DepartmentRepository departmentRepository;

    public EmployeeController(EmployeeRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @GetMapping("/getAll")
    public List<Employee> getAll(){
        return usersRepository.findAll();
    }

    @GetMapping("/emp/activateEmployee")
    public boolean activateEmployee(@RequestBody Employee emp){
        Employee e = usersRepository.findById(emp.getId()).get();
        e.setActive(true);
        usersRepository.save(e);
        return true;
    }

    @GetMapping("/emp/deactivateEmployee")
    public boolean deactivateEmployee(@RequestBody Employee emp){
        Employee e = usersRepository.findById(emp.getId()).get();
        e.setActive(false);
        usersRepository.save(e);
        return true;
    }

    @GetMapping({"/getActive"})
    public List<Employee> getAllExample(@RequestBody Employee emp) {
        Example<Employee> e = Example.of(emp);
        return this.usersRepository.findAll(e);
    }

    @GetMapping({"/getDomain"})
    public List<Domain> getDetails() {
        return this.domainRepository.findAll();
    }

    @PostMapping({"/postDomain"})
    public Domain addDomain( @RequestBody Domain dom) {
        dom.setCreatedDate(new Date());
        return (Domain)this.domainRepository.insert(dom);
    }

    @DeleteMapping({"/deleteDomain"})
    public void deleteDomain() {
        this.domainRepository.deleteAll();
    }

    @GetMapping({"/getDept"})
    public List<Department> getDept() {
        return this.departmentRepository.findAll();
    }

    @PostMapping({"/postDept"})
    public Department addDept( @RequestBody Department dept) {
        dept.setCreatedAt(new Date());
        return (Department)this.departmentRepository.insert(dept);
    }

    @DeleteMapping({"/deleteDept"})
    public void deleteDept() {
        this.departmentRepository.deleteAll();
    }

    @PostMapping({"/post"})
    public Employee addEmployee( @RequestBody Employee emp) {
        emp.setJoiningDate(new Date());
        return (Employee)this.usersRepository.insert(emp);
    }

    @PutMapping({"/put"})
    public Employee update(@RequestBody Employee emp) {
        return (Employee)this.usersRepository.save(emp);
    }

    @DeleteMapping({"/deleteall"})
    public void deleteall() {
        this.usersRepository.deleteAll();
    }

    @DeleteMapping({"/delete/{id}"})
    public void delete(@RequestParam("id") Integer id) {
        this.usersRepository.deleteById(id);
    }
}
