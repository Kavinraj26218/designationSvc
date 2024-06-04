package com.colruytgroup.designationBFF.Controller;

import com.colruytgroup.designationBFF.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class WelcomeController {

    private  EmployeeService employeeService;



    @GetMapping("/welcome")
    public String welcome()
    {
        return employeeService.getFirstName();}
    @GetMapping("/getLastName")
        public String lastName()
    {
        return employeeService.getLastName();
    }

    @GetMapping("/getFullName")
    public String getFullName()
    {
        return employeeService.getFirstName() + " " + employeeService.getLastName();
    }
}
