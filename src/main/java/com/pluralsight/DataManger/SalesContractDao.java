package com.pluralsight.DataManger;

import com.pluralsight.Models.MyDataSource;
import com.pluralsight.Models.SalesContract;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class SalesContractDao {
    public void addSale(SalesContract contract) {
        String sql = "INSERT INTO sales_contracts (vin, sales_price, recording_fee, processing_fee) VALUES (?, ?, ?, ?)";


        try (Connection conn = MyDataSource.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {


            ps.setInt(1, contract.getVin());
            ps.setDouble(2, contract.getTotalPrice());
            ps.setDouble(3, contract.getRecordingFee());
            ps.setDouble(4, contract.getProcessingFee());
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }
}
