package com.colruytgroup.designationBFF.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrentDesignationDto {
    private String id;
    private String name;
    private String futureDesignationOne;
    private String futureDesignationTwo;


}
