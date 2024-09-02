package com.wellsfargo.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CoronaPatientVO
{
    private String partientRegistrationNo;
    private String patientName;
    private String patientAddrs;
    private String mobileNo;
    private String hospitalizationDays;
    private String billPerDay;
}
