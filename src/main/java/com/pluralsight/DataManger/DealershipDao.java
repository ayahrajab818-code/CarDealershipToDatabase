package com.pluralsight.DataManger;

import com.pluralsight.Models.MyDataSource;
import com.pluralsight.Models.Dealership;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DealershipDao {

    public Dealership getDealership() {
        String sql = "SELECT * FROM dealerships LIMIT 1";


        try (Connection conn = MyDataSource.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {


            if (rs.next()) {
                return new Dealership(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getString("phone")
                );
            }
        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }
}
