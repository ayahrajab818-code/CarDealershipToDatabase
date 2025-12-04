package com.pluralsight.UserInerFace;

import com.pluralsight.DataManger.DealershipDao;
import com.pluralsight.DataManger.LeaseContractDao;
import com.pluralsight.DataManger.SalesContractDao;
import com.pluralsight.DataManger.VehicleDao;
import com.pluralsight.Models.LeaseContract;
import com.pluralsight.Models.SalesContract;
import com.pluralsight.Models.Vehicle;

public class UserInterFace {
    /*
In short, each DAO instance is the “bridge” between your console UI and the database.
Without them, your UI couldn’t read or write any data.
    */
    
    // DAO for interacting with the vehicles table (view, search, delete)
    private final VehicleDao vehicleDao = new VehicleDao();

    // DAO for handling vehicle sales (inserting sales into sales_contracts table)
    private final SalesContractDao salesDao = new SalesContractDao();

    // DAO for handling vehicle leases (inserting leases into lease_contracts table)
    private final LeaseContractDao leaseDao = new LeaseContractDao();

    // DAO for interacting with dealership information (dealerships table)
    private final DealershipDao dealershipDao = new DealershipDao();


    public void display() {
        int choice;
        do {
            System.out.println("==== DEALERSHIP MENU ====");
            System.out.println("1. View All Vehicles");
            System.out.println("2. Search by Make/Model");
            System.out.println("3. Buy Vehicle");
            System.out.println("4. Lease Vehicle");
            System.out.println("5. View All Sales");
            System.out.println("6. View All Leases");
            System.out.println("0. Exit");

            choice = ConsoleHelper.promptForInt("Choose an option");

            switch (choice) {
                case 1 -> viewAll();
                case 2 -> searchByMakeModel();
                case 3 -> buyVehicle();
                case 4 -> leaseVehicle();
                case 5 -> viewAllSales();
                case 6 -> viewAllLeases();

            }

        } while (choice != 0);
    }

    private void viewAll() {
        vehicleDao.getAllVehicles().forEach(this::printVehicle);
    }

    private void searchByMakeModel() {
        String make = ConsoleHelper.promptForString("Enter make");
        String model = ConsoleHelper.promptForString("Enter model");
        vehicleDao.getByMakeModel(make, model).forEach(this::printVehicle);
        vehicleDao.getByMakeModel(make, model).forEach(v ->
                System.out.println(v.getVin() + " " + v.getMake() + " " + v.getModel())
        );
    }

    private void buyVehicle() {
        String vin = ConsoleHelper.promptForString("Enter VIN to buy");
        SalesContract sc = new SalesContract(vin, 100, 295);
        salesDao.addSale(sc);
        vehicleDao.deleteVehicle(Integer.parseInt(vin));
        System.out.println("Purchase complete!");
    }

    private void leaseVehicle() {
        String vin = ConsoleHelper.promptForString("Enter VIN to lease");
        LeaseContract lc = new LeaseContract(vin, 5000, 300);
        leaseDao.addLease(lc);
        vehicleDao.deleteVehicle(Integer.parseInt(vin));
        System.out.println("Lease complete!");
    }

    // Helper method to print a vehicle in a readable format
    private void printVehicle(Vehicle v) {
        System.out.printf("VIN: %d | Make: %s | Model: %s | Year: %d | Price: $%.2f%n",
                v.getVin(), v.getMake(), v.getModel(), v.getYear(), v.getPrice());
    }

    // ------------------- Admin Methods -------------------

    private void viewAllSales() {
        System.out.println("==== ALL SALES ====");
        salesDao.getAllSales().forEach(s ->
                System.out.printf("Vehicle VIN: %s | Recording Fee: $%.2f | Processing Fee: $%.2f | Total: $%.2f%n",
                        s.getVin(), s.getRecordingFee(), s.getProcessingFee(), s.getTotalPrice())
        );
    }

    private void viewAllLeases() {
        System.out.println("==== ALL LEASES ====");
        leaseDao.getAllLeases().forEach(l ->
                System.out.printf("Vehicle VIN: %s | Ending Value: $%.2f | Lease Fee: $%.2f%n",
                        l.getVin(), l.getEndingValue(), l.getLeaseFee())
        );
    }
}