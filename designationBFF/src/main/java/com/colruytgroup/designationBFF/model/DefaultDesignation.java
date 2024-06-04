package com.colruytgroup.designationBFF.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DefaultDesignation {
    private String id;
    private String name;
}
