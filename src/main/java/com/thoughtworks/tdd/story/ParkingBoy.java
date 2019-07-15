package com.thoughtworks.tdd.story;

/**
 * Created by 桐爷哥 on 2019/7/13.
 */
public class ParkingBoy {
    private ParkingLot firstParkingLot = new ParkingLot();
    private ParkingLot secondParkingLot = new ParkingLot();
    public Ticket park(Car car) {
        if (!firstParkingLot.isFull())
            return firstParkingLot.getTicketByCar(car);
        else
            return secondParkingLot.getTicketByCar(car);
    }

    public Car fetch(Ticket ticket) {
        Car car = firstParkingLot.getCarByTicket(ticket);
        if(car == null)
            car = secondParkingLot.getCarByTicket(ticket);
        return car;
    }

    public String query() {
        String message = firstParkingLot.queryMessage();
        if(message.equals(""))
            message = secondParkingLot.queryMessage();
        return message;
    }

    public ParkingLot getFirstParkingLot() {
        return firstParkingLot;
    }

    public ParkingLot getSecondParkingLot() {
        return secondParkingLot;
    }

    public void setSecondParkingLot(ParkingLot secondParkingLot) {
        this.secondParkingLot = secondParkingLot;
    }
}
