package com.thoughtworks.tdd.story;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    Map<Ticket, Car> parkingInfo = new HashMap<>();
    private int totalParkingCount = 10;
    private String message = "";

    public ParkingLot() {
    }
    public ParkingLot(int totalParkingCount) {
        this.totalParkingCount = totalParkingCount;
    }

    public Ticket getTicketByCar(Car car) {
        if(totalParkingCount == parkingInfo.size()){
            message = "Not enough position.";
            return null;
        }
        if(parkingInfo.values().contains(car) || car == null)
            return null;

        Ticket ticket = new Ticket();
        parkingInfo.put(ticket,car);
        return ticket;
    }

    public Car getCarByTicket(Ticket ticket) {
        if(!parkingInfo.containsKey(ticket) && ticket != null)
            message = "Unrecognized parking ticket.";
        if(ticket == null)
            message = "Please provide your parking ticket";
        return parkingInfo.remove(ticket);
    }

    public String queryMessage() {
        String string = message;
        message = "";
        return string;
    }
    // judge the parkingLot is full or not
    public boolean isFull(){
        return totalParkingCount == parkingInfo.size();
    }

    //get the available parking count from parkingLot
    public int getAvailableParkingCount(){
        return totalParkingCount - parkingInfo.size();
    }

    public int getTotalParkingCount() {
        return totalParkingCount;
    }
}
