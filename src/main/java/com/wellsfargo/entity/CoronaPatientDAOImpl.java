package com.wellsfargo.entity;

import com.wellsfargo.bo.CoronaPatientBO;
import lombok.AllArgsConstructor;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

@AllArgsConstructor
public class CoronaPatientDAOImpl implements ICoronaPatientDAO {
    DataSource ds;
    private static final String CORONA_DB_INSERT_QUERY = "INSERT INTO CORONA VALUES(CORONA_DB_SEQ.nextval,?,?,?,?,?,?,?,?)";
    @Override
    public int insertCoronaDb(CoronaPatientBO bo) throws Exception
    {
        PreparedStatement ps = null;
        Connection con=null;
        int result = 0;
        try {
            con = ds.getConnection();
            ps=con.prepareStatement(CORONA_DB_INSERT_QUERY);
            ps.setString(1, bo.getPatientName());
            ps.setString(2, bo.getPatientAddrs());
            ps.setInt(3, bo.getMobileNo());
            ps.setInt(4, bo.getHospitalizationDays());
            ps.setInt(5, bo.getBillPerDay());
            ps.setFloat(6, bo.getTotalBillAmount());
            ps.setFloat(7, bo.getDiscount());
            ps.setFloat(8, bo.getNetBillAmount());
            result = ps.executeUpdate();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (ps != null)
            {
                try {
                    ps.close();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            if (con != null)
            {
                try
                {
                    con.close();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
