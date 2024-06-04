package com.colruytgroup.designationBFF.service;

import com.colruytgroup.designationBFF.entity.EmployeeDefaultDesignationEntity;
import com.colruytgroup.designationBFF.entity.EmployeeDesignationsEntity;
import com.colruytgroup.designationBFF.entity.EmployeeEntity;
import com.colruytgroup.designationBFF.entity.EmployeeFutureDesignationsEntity;
import com.colruytgroup.designationBFF.model.CurrentDesignationDto;
import com.colruytgroup.designationBFF.model.DefaultDesignation;
import com.colruytgroup.designationBFF.model.EmployeeDesignationDTO;
import com.colruytgroup.designationBFF.model.FutureDesignation;
import com.colruytgroup.designationBFF.repository.EmployeeRepository;
import com.colruytgroup.designationBFF.repository.UpdateNameRepository;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UpdateService {

    private UpdateNameRepository updateNameRepository;

    public UpdateService(UpdateNameRepository updateNameRepository) {
        this.updateNameRepository = updateNameRepository;
    }

    public void updateEmployeeName(String firstName, String lastName, String employeeId)
    {
       if(!updateNameRepository.updateName(firstName,lastName,employeeId))
       {
           throw new RuntimeException();
       }


    }
}
