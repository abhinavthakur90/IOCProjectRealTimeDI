package com.wellsfargo.controller;

import com.wellsfargo.dto.CoronaPatientDTO;
import com.wellsfargo.service.CoronaPatientServiceImpl;
import com.wellsfargo.vo.CoronaPatientVO;
import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class MainController
{
    CoronaPatientServiceImpl service;
    public String calculatePatientBill(CoronaPatientVO vo) throws Exception
    {
        CoronaPatientDTO dto = new CoronaPatientDTO();
        dto.setPatientName(vo.getPatientName());
        dto.setPatientAddrs(vo.getPatientAddrs());
        dto.setMobileNo(Integer.parseInt(vo.getMobileNo()));
        dto.setBillPerDay(Integer.parseInt(vo.getBillPerDay()));
        dto.setHospitalizationDays(Integer.parseInt(vo.getHospitalizationDays()));
        return service.coronaPatientRegistration(dto);
    }
}
