package com.colruytgroup.designationBFF.entity;

import org.springframework.http.HttpStatus;


public class EmployeeEntity{
    private String id;
    private String firstName;
    private String lastName;

    private boolean surveyStatus;
    private Integer currentDesignation;
    private Integer futureDesignation;
    private Integer defaultDesignation;

    public EmployeeEntity(HttpStatus noContent) {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isSurveyStatus() {
        return surveyStatus;
    }

    public void setSurveyStatus(boolean surveyStatus) {
        this.surveyStatus = surveyStatus;
    }

    public Integer getCurrentDesignation() {
        return currentDesignation;
    }

    public void setCurrentDesignation(Integer currentDesignation) {
        this.currentDesignation = currentDesignation;
    }

    public Integer getFutureDesignation() {
        return futureDesignation;
    }

    public void setFutureDesignation(Integer futureDesignation) {
        this.futureDesignation = futureDesignation;
    }

    public Integer getDefaultDesignation() {
        return defaultDesignation;
    }

    public void setDefaultDesignation(Integer defaultDesignation) {
        this.defaultDesignation = defaultDesignation;
    }
}
