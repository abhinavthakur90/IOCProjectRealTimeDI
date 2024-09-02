package com.wellsfargo.bo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CoronaPatientBO
{
    private String patientRegistrationNo;
    private String patientName;
    private String patientAddrs;
    private Integer mobileNo;
    private Integer hospitalizationDays;
    private Integer billPerDay;
    private Float totalBillAmount;
    private Float discount;
    private Float netBillAmount;
}
