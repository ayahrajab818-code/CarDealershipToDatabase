package com.pluralsight.Models;

public class SalesContract {

    private String vin;
    private double recordingFee;
    private double processingFee;


    public SalesContract(String vin, double recordingFee, double processingFee) {
        this.vin = vin;
        this.recordingFee = recordingFee;
        this.processingFee = processingFee;
    }


    public String getVin() {
        return vin;
    }

    public double getRecordingFee() {
        return recordingFee;
    }
    public double getProcessingFee() {
        return processingFee;
    }
    public double getTotalPrice() {
        return recordingFee + processingFee;
    }
    }





