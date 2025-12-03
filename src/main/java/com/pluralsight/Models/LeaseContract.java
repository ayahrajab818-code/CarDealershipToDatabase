package com.pluralsight.Models;


public class LeaseContract {
    private int vin;
    private double endingValue;
    private double leaseFee;


    public LeaseContract(int vin, double endingValue, double leaseFee) {
        this.vin = vin;
        this.endingValue = endingValue;
        this.leaseFee = leaseFee;
    }


    public int getVin() { return vin; }
    public double getEndingValue() { return endingValue; }
    public double getLeaseFee() { return leaseFee; }
}

