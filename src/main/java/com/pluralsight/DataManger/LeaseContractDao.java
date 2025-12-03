package com.pluralsight.DataManger;

import com.pluralsight.Models.MyDataSource;
import com.pluralsight.Models.LeaseContract;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class LeaseContractDao {

    public void addLease(LeaseContract contract) {
        String sql = "INSERT INTO lease_contracts (vin, ending_value, lease_fee) VALUES (?, ?, ?)";


        try (Connection conn = MyDataSource.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {


            ps.setInt(1, contract.getVin());
            ps.setDouble(2, contract.getEndingValue());
            ps.setDouble(3, contract.getLeaseFee());
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }
}
