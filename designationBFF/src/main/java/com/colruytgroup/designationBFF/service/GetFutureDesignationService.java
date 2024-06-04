package com.colruytgroup.designationBFF.service;

import com.colruytgroup.designationBFF.entity.EmployeeDesignationsEntity;
import com.colruytgroup.designationBFF.entity.EmployeeEntity;
import com.colruytgroup.designationBFF.entity.EmployeeFutureDesignationsEntity;
import com.colruytgroup.designationBFF.model.FutureDesignation;
import com.colruytgroup.designationBFF.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GetFutureDesignationService {
    private EmployeeRepository employeeRepository;

    public List<FutureDesignation> getFutureDesignationsOfEmployees(String employeeId) {
        EmployeeEntity employeeEntity = employeeRepository.fetchEmployeeId(employeeId);
        EmployeeDesignationsEntity employeeDesignationsEntity=employeeRepository.fetchEmployeeCurrentDesignation(employeeEntity.getCurrentDesignation());
        List<EmployeeFutureDesignationsEntity> employeeFutureDesignationsEntity=employeeRepository.fetchEmployeeFutureDesignations(employeeDesignationsEntity.getFutureDesignationOption1(),employeeDesignationsEntity.getFutureDesignationOption2());

        return employeeFutureDesignationsEntity.stream().map(ftr->(FutureDesignation.builder().id(ftr.getId()).name(ftr.getName()).build())).toList();


    }
}
