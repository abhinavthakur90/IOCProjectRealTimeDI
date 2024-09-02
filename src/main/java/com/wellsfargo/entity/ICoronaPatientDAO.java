package com.wellsfargo.entity;

import com.wellsfargo.bo.CoronaPatientBO;

public interface ICoronaPatientDAO {
    public int insertCoronaDb(CoronaPatientBO bo) throws Exception;
}
