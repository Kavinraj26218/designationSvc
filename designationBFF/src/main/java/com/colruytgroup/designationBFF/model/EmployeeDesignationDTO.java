package com.colruytgroup.designationBFF.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDesignationDTO {
    private String id;
    private String firstName;
    private String lastName;
    private boolean surveyStatus;
    private CurrentDesignationDto currentDesignationDto;
    private List<FutureDesignation> futureDesignations;
    private List<DefaultDesignation> defaultDesignations;
    private FutureDesignation futureDesignation;
    private DefaultDesignation defaultDesignation;




}
