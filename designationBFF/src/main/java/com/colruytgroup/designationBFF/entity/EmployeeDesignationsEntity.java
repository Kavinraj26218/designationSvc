package com.colruytgroup.designationBFF.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeDesignationsEntity {

    private String id;
    private String name;
    private String futureDesignationOption1;
    private String futureDesignationOption2;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFutureDesignationOption1() {
        return futureDesignationOption1;
    }

    public void setFutureDesignationOption1(String futureDesignationOption1) {
        this.futureDesignationOption1 = futureDesignationOption1;
    }

    public String getFutureDesignationOption2() {
        return futureDesignationOption2;
    }

    public void setFutureDesignationOption2(String futureDesignationOption2) {
        this.futureDesignationOption2 = futureDesignationOption2;
    }
}
