package com.colruytgroup.designationBFF.Controller;

import com.colruytgroup.designationBFF.entity.EmployeeEntity;
import com.colruytgroup.designationBFF.model.EmployeeDesignationDTO;
import com.colruytgroup.designationBFF.model.FutureDesignation;
import com.colruytgroup.designationBFF.model.UpdateDto;
import com.colruytgroup.designationBFF.service.DeleteService;
import com.colruytgroup.designationBFF.service.EmployeeService;
import com.colruytgroup.designationBFF.service.GetFutureDesignationService;
import com.colruytgroup.designationBFF.service.UpdateService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService;
    private UpdateService updateService;
    private DeleteService deleteService;
    private GetFutureDesignationService getFutureDesignationService;



    @GetMapping("/employee/{id}")
    public ResponseEntity<EmployeeDesignationDTO >getEmployeeId(@PathVariable("id") String employeeId) {
       try {
           return new ResponseEntity<>(employeeService.getEmployeeDetails(employeeId),HttpStatus.OK);

       }
       catch (RuntimeException r)
       {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }

    }
    @PutMapping("/update_employee/{id}")
    public ResponseEntity updateEmployeeId(@PathVariable("id")String employeeId, @RequestBody UpdateDto updateDto)
    {
        try {
            updateService.updateEmployeeName(updateDto.getFirstName(),updateDto.getLastName(),employeeId );
            return new ResponseEntity(HttpStatus.ACCEPTED);

        }
        catch (RuntimeException r)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        }
    @DeleteMapping("/delete_employee/{id}")
    public ResponseEntity deleteEmployeeId(@PathVariable("id")String employeeId)
    {
        try {
            deleteService.deleteEmployee(employeeId);
            return new ResponseEntity(HttpStatus.OK);

        }
        catch(RuntimeException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
    }



    }
    @GetMapping("/employee_designation/{id}")
    public ResponseEntity<List<FutureDesignation>> getFutureDesignations(@PathVariable("id")String employeeId)
    {
        try {
            return new ResponseEntity<>(getFutureDesignationService.getFutureDesignationsOfEmployees(employeeId),HttpStatus.OK);

        }
        catch (RuntimeException r)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
         }


}
