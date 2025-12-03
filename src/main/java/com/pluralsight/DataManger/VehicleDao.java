package com.pluralsight.DataManger;

import com.pluralsight.Models.MyDataSource;
import com.pluralsight.Models.Vehicle;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VehicleDao {

    public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM vehicles";


        try (Connection conn = MyDataSource.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {


            while (rs.next()) {
                vehicles.add(new Vehicle(
                        rs.getInt("id"),
                        rs.getInt("vin"),
                        rs.getString("make"),
                        rs.getString("model"),
                        rs.getInt("year"),
                        rs.getString("color"),
                        rs.getInt("odometer"),
                        rs.getDouble("price"),
                        rs.getString("type")
                ));
            }
        } catch (Exception e) { e.printStackTrace(); }


        return vehicles;
    }


    public List<Vehicle> getByMakeModel(String make, String model) {
        List<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM vehicles WHERE make = ? AND model = ?";


        try (Connection conn = MyDataSource.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {


            ps.setString(1, make);
            ps.setString(2, model);
            ResultSet rs = ps.executeQuery();


            while (rs.next()) {
                vehicles.add(new Vehicle(
                        rs.getInt("id"), rs.getInt("vin"), rs.getString("make"),
                        rs.getString("model"), rs.getInt("year"), rs.getString("color"),
                        rs.getInt("odometer"), rs.getDouble("price"), rs.getString("type")
                ));
            }
        } catch (Exception e) { e.printStackTrace(); }


        return vehicles;
    }


    public void deleteVehicle(int vin) {
        String sql = "DELETE FROM vehicles WHERE vin = ?";
        try (Connection conn = MyDataSource.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {


            ps.setInt(1, vin);
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }
}
