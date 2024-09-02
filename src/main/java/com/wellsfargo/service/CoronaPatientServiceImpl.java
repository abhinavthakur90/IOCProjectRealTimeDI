package com.wellsfargo.service;

import com.wellsfargo.bo.CoronaPatientBO;
import com.wellsfargo.dto.CoronaPatientDTO;
import com.wellsfargo.entity.CoronaPatientDAOImpl;
import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor()
public class CoronaPatientServiceImpl implements ICoronaPatientService
{
    CoronaPatientDAOImpl dao;
    @Override
    public String coronaPatientRegistration(CoronaPatientDTO dto)
    {
        String message = null;
        CoronaPatientBO bo = new CoronaPatientBO();
        float netBillAmount, totalBillAmount, discount;
        bo.setPatientName(dto.getPatientName());
        bo.setPatientAddrs(dto.getPatientAddrs());
        bo.setMobileNo(dto.getMobileNo());
        bo.setBillPerDay(dto.getBillPerDay());
        bo.setHospitalizationDays(dto.getHospitalizationDays());
        totalBillAmount = (dto.getBillPerDay() * dto.getHospitalizationDays());
        if (totalBillAmount > 1_00_000 && totalBillAmount <= 2_00_000)
        {
            discount = 0.10f;
        }
        else if (totalBillAmount > 2_00_000)
        {
            discount = 0.20f;
        }
        else
        {
            discount = 0;
        }
        netBillAmount = (totalBillAmount - (discount * totalBillAmount));
        bo.setDiscount(discount * totalBillAmount);
        bo.setTotalBillAmount(totalBillAmount);
        bo.setNetBillAmount(netBillAmount);
        try
        {
            int dbWriteCode = dao.insertCoronaDb(bo);
            if (dbWriteCode == 1) {
                message = "Corona Patient Bill generated Successfully---------------->\n" + "Total Bill Amount " + bo.getTotalBillAmount()+"\n"+ "Discount Amount " + bo.getDiscount()+"\n"+ "Net Bill Amount " + bo.getNetBillAmount();
            }
        }
        catch (Exception e)
        {
            message = "Internal DB Write Error";
        }
        return message;
    }
}
