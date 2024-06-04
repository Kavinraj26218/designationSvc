package com.colruytgroup.designationBFF.repository;

import com.colruytgroup.designationBFF.entity.EmployeeDefaultDesignationEntity;
import com.colruytgroup.designationBFF.entity.EmployeeDesignationsEntity;
import com.colruytgroup.designationBFF.entity.EmployeeEntity;
import com.colruytgroup.designationBFF.entity.EmployeeFutureDesignationsEntity;
import com.colruytgroup.designationBFF.model.employeeWrapper.EmployeeWrapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository {
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public EmployeeRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public EmployeeEntity fetchEmployeeId(String employeeId) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("emplId", employeeId);
        List<EmployeeEntity> employeeEntities = namedParameterJdbcTemplate
                .query("SELECT * FROM DSVC_EMPLOYEE WHERE ID=:emplId", sqlParameterSource, new EmployeeWrapper());
        EmployeeEntity employeeEntity = employeeEntities.stream().findFirst().orElseThrow(()->new IllegalArgumentException("Employee dont exist.."));
        return employeeEntity;
    }

    public EmployeeDesignationsEntity fetchEmployeeCurrentDesignation(Integer curDesignation) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("curDesig", curDesignation);
        List<EmployeeDesignationsEntity> employeeDesignationsEntities = namedParameterJdbcTemplate
                .query("Select * FROM DSVC_DESIGNATIONS WHERE DESIGNATION_ID=:curDesig", sqlParameterSource,
                        (rs, i) ->
                                EmployeeDesignationsEntity
                                        .builder()
                                        .id(rs.getString(1))
                                        .name(rs.getString(2))
                                        .futureDesignationOption2(rs.getString(4))
                                        .futureDesignationOption1(rs.getString(3))
                                        .build());
        EmployeeDesignationsEntity employeeDesignationsEntity = employeeDesignationsEntities.stream().findFirst().orElseThrow(IllegalArgumentException::new);
        return employeeDesignationsEntity;
    }

    public List<EmployeeFutureDesignationsEntity> fetchEmployeeFutureDesignations(String employeeId, String employeeId1) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("emplId", employeeId)
                .addValue("emplId1",employeeId1);

        return namedParameterJdbcTemplate.query("SELECT * FROM DSVC_FTR_DESIGNATIONS WHERE FTR_DESIGNATION_ID IN (:emplId,:emplId1)", sqlParameterSource,
                (rs, r) -> EmployeeFutureDesignationsEntity
                        .builder()
                        .id(rs.getString(1))
                        .name(rs.getString(2))
                        .build());


    }

    public List<EmployeeDefaultDesignationEntity> fetchDefaultDesignations() {
        return namedParameterJdbcTemplate.query("SELECT * FROM DSVC_NONDSGN_OPTIONS",
                (rs, r) -> EmployeeDefaultDesignationEntity.builder()
                        .id(rs.getString(1))
                        .name(rs.getString(2))
                        .build());
    }
}

