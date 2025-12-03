package com.pluralsight.Models;

public class Vehicle {
    private int id;
    private int vin;
    private String make;
    private String model;
    private int year;
    private String color;
    private int odometer;
    private double price;
    private String type;


    public Vehicle(int id, int vin, String make, String model, int year, String color, int odometer, double price, String type) {
        this.id = id;
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
        this.type = type;
    }


    public int getId() {
        return id; }
    public int getVin() {
        return vin; }
    public String getMake() {
        return make; }
    public String getModel() {
        return model; }
    public int getYear() {
        return year; }
    public String getColor() {
        return color; }
    public int getOdometer() {
        return odometer; }
    public double getPrice() {
        return price; }
    public String getType() {
        return type; }
}
