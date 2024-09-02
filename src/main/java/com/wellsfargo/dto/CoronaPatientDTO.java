package com.wellsfargo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class CoronaPatientDTO implements Serializable
{
    private String patientRegistrationNo;
    private String patientName;
    private String patientAddrs;
    private Integer mobileNo;
    private Integer hospitalizationDays;
    private Integer billPerDay;
}

