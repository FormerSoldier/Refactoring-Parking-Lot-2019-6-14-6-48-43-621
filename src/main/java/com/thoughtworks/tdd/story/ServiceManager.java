package com.thoughtworks.tdd.story;

import java.util.ArrayList;
import java.util.List;

public class ServiceManager extends ParkingBoy{
    private List<ParkingBoy> parkingBoysList = new ArrayList<>();
    private int initParkingBoysCount = 3;

    public ServiceManager(){
        for(int i = 0; i < initParkingBoysCount; i++)
            parkingBoysList.add(new ParkingBoy());
    }

    public List<ParkingBoy> getParkingBoysList() {
        return parkingBoysList;
    }

    public void addParkingBoyToList(ParkingBoy parkingBoy) {
        parkingBoysList.add(parkingBoy);
    }

    public Ticket parkCarByNthBoy(int indexOfParkingBoysList, Car car) {
        return parkingBoysList.get(indexOfParkingBoysList-1).park(car);
    }

    public String displayErrorMessageByNthBoy(int indexOfParkingBoysList) {
        return parkingBoysList.get(indexOfParkingBoysList-1).query();
    }

    public Car fetchCarByNthBoy(int indexOfParkingBoysList, Ticket ticket) {
        return parkingBoysList.get(indexOfParkingBoysList-1).fetch(ticket);
    }
}
