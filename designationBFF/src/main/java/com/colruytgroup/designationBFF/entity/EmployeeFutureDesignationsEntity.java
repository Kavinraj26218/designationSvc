package com.colruytgroup.designationBFF.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeFutureDesignationsEntity {
    private String id;
    private String name;
}