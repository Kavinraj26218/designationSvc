package com.colruytgroup.designationBFF.repository;

import com.colruytgroup.designationBFF.entity.EmployeeEntity;
import com.colruytgroup.designationBFF.model.employeeWrapper.EmployeeWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DeleteEmployeeRepository {
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    public DeleteEmployeeRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }
    public boolean deleteEmployeeById(String employeeId)
    {
        SqlParameterSource sqlParameterSource=new MapSqlParameterSource().addValue("empid",employeeId);
      int ifDeleteEmployee = namedParameterJdbcTemplate
                .update("DELETE  FROM DSVC_EMPLOYEE WHERE ID=:empid", sqlParameterSource);
        return ifDeleteEmployee>0;

    }
}
