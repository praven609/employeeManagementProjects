package com.employee.demo.api;

import com.employee.demo.io.employee.activateResponse;
import com.employee.demo.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.employee.demo.io.employee.activateRequest;
import com.employee.demo.document.Employee;

import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeApi {
    private EmployeeRepository mongoEmployee;

    public EmployeeApi(EmployeeRepository mongoEmployee) {
        this.mongoEmployee = mongoEmployee;
    }

    @GetMapping("/activate")
    public activateResponse activateEmployee(@RequestBody activateRequest request) {
        activateResponse response = new activateResponse();
        try {
            Optional<Employee> dbEmployee = mongoEmployee.findById(request.getEmployeeID());
            if (dbEmployee.isPresent()) {
                Employee e = dbEmployee.get();
                if(e.isActive()) {
                    response.setStatus(activateResponse.STATUS_VALUES.EMPLOYEE_ALREADY_ACTIVATED);
                }
                else {
                    e.setActive(true);
                    //write when already active state
                    mongoEmployee.save(e);
                    response.setStatus(activateResponse.STATUS_VALUES.SUCCESS);
                }
            } else {
                response.setStatus(activateResponse.STATUS_VALUES.NO_EMPLOYEE_EXISTS_WITH_SPECIFIED_ID);
            }
        } catch (Exception e) {
            response.setStatus(activateResponse.STATUS_VALUES.INTERNAL_SERVER_ERROR);
        }
        return response;
    }
}
