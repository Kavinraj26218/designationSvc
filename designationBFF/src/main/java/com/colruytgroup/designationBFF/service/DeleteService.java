package com.colruytgroup.designationBFF.service;

import com.colruytgroup.designationBFF.entity.EmployeeEntity;
import com.colruytgroup.designationBFF.repository.DeleteEmployeeRepository;
import org.springframework.stereotype.Service;

import javax.management.RuntimeErrorException;

@Service
public class DeleteService {

    DeleteEmployeeRepository deleteEmployeeRepository;
    public void deleteEmployee(String employeeId) {

            if(!deleteEmployeeRepository.deleteEmployeeById(employeeId))
        {
throw new RuntimeException();

        }


    }
}
