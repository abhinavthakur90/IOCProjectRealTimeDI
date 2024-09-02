package com.wellsfargo.service;

import com.wellsfargo.dto.CoronaPatientDTO;
import com.wellsfargo.entity.CoronaPatientDAOImpl;

public interface ICoronaPatientService {

    public String coronaPatientRegistration(CoronaPatientDTO dto) throws Exception;
}
