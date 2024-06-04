package com.colruytgroup.designationBFF.service;

import com.colruytgroup.designationBFF.entity.EmployeeDefaultDesignationEntity;
import com.colruytgroup.designationBFF.entity.EmployeeDesignationsEntity;
import com.colruytgroup.designationBFF.entity.EmployeeEntity;
import com.colruytgroup.designationBFF.entity.EmployeeFutureDesignationsEntity;
import com.colruytgroup.designationBFF.model.CurrentDesignationDto;
import com.colruytgroup.designationBFF.model.DefaultDesignation;
import com.colruytgroup.designationBFF.model.EmployeeDesignationDTO;
import com.colruytgroup.designationBFF.model.FutureDesignation;
import com.colruytgroup.designationBFF.model.employeeWrapper.EmployeeWrapper;
import com.colruytgroup.designationBFF.repository.DeleteEmployeeRepository;
import com.colruytgroup.designationBFF.repository.EmployeeRepository;
import com.colruytgroup.designationBFF.repository.UpdateNameRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.springframework.jdbc.core.JdbcOperationsExtensionsKt.query;

@Service
@AllArgsConstructor
public class EmployeeService {
    private final UpdateNameRepository updateNameRepository;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    EmployeeRepository employeeRepository;
    DeleteEmployeeRepository deleteEmployeeRepository;

    public String getFirstName()
    {
        return "HELLO FROM SERVICE";
    }
     public String getLastName()
     {
         return "World from service";
     }
     public EmployeeDesignationDTO getEmployeeDetails(String employeeId){

         EmployeeEntity employeeEntity = employeeRepository.fetchEmployeeId(employeeId);
         EmployeeDesignationsEntity employeeDesignationsEntity=employeeRepository.fetchEmployeeCurrentDesignation(employeeEntity.getCurrentDesignation());
         List<EmployeeFutureDesignationsEntity> employeeFutureDesignationsEntity=employeeRepository.fetchEmployeeFutureDesignations(employeeDesignationsEntity.getFutureDesignationOption1(),employeeDesignationsEntity.getFutureDesignationOption2());
         List<EmployeeDefaultDesignationEntity>employeeDefaultDesignationEntity=employeeRepository.fetchDefaultDesignations();


         return EmployeeDesignationDTO.builder()
             .id(employeeEntity.getId())
             .firstName(employeeEntity.getFirstName())
             .lastName(employeeEntity.getLastName())
             .surveyStatus(employeeEntity.isSurveyStatus())
                 .currentDesignationDto(
                         CurrentDesignationDto.builder()
                                 .id(employeeDesignationsEntity.getId())
                                 .name(employeeDesignationsEntity.getName())
                                 .futureDesignationOne(employeeDesignationsEntity.getFutureDesignationOption1())
                                 .futureDesignationTwo(employeeDesignationsEntity.getFutureDesignationOption2())
                                 .build())
                 .futureDesignations(employeeFutureDesignationsEntity
                         .stream().
                         map(ftr->FutureDesignation.builder().id(ftr.getId()).name(ftr.getName()).build())
                         .collect(Collectors.toList()))
                 .defaultDesignations(employeeDefaultDesignationEntity
                         .stream()
                         .map(dft-> DefaultDesignation.builder().id(dft.getId()).name(dft.getName()).build())
                         .collect(Collectors.toList()))
             .build();

     }

}
