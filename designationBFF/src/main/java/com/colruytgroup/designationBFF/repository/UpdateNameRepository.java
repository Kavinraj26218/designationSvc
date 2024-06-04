package com.colruytgroup.designationBFF.repository;

import com.colruytgroup.designationBFF.entity.EmployeeEntity;
import com.colruytgroup.designationBFF.model.employeeWrapper.EmployeeWrapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UpdateNameRepository {
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    public UpdateNameRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public boolean updateName(String employeeId,String firstName,String lastName)
    {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("emplId", employeeId)
                .addValue("firstName",firstName)
                .addValue("lastName",lastName);
      int updatedEmployees = namedParameterJdbcTemplate
                .update("UPDATE DSVC_EMPLOYEE SET FIRST_NAME=:firstName , LAST_NAME=:lastName WHERE ID=:emplId;", sqlParameterSource);
       return updatedEmployees>0;
    }
}
