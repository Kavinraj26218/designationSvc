package com.colruytgroup.designationBFF.model.employeeWrapper;

import com.colruytgroup.designationBFF.entity.EmployeeEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeWrapper implements RowMapper<EmployeeEntity> {
    @Override
    public EmployeeEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        EmployeeEntity employeeEntity = new EmployeeEntity(HttpStatus.NO_CONTENT);
        String firstName = rs.getString(2);
        String id = rs.getString(1);
        String lastName = rs.getString(3);
        int currentDesignation=rs.getInt(4);
        boolean surveyStatus= rs.getBoolean(5);
        employeeEntity.setFirstName(firstName);
        employeeEntity.setId(id);
        employeeEntity.setLastName(lastName);
        employeeEntity.setCurrentDesignation(currentDesignation);
        employeeEntity.setSurveyStatus(surveyStatus);
        return employeeEntity;
    }
}
