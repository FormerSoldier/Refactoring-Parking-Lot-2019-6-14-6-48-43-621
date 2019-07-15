package com.thoughtworks.tdd.story;

public class SuperSmartParkingBoy extends SmartParkingBoy{

    @Override
    public Ticket park(Car car) {
        double firstRate = Double.valueOf(getFirstParkingLot().getAvailableParkingCount()) / getFirstParkingLot().getTotalParkingCount();
        double secondRate = Double.valueOf(getSecondParkingLot().getAvailableParkingCount()) / getSecondParkingLot().getTotalParkingCount();
        if (firstRate >= secondRate)
            return getFirstParkingLot().getTicketByCar(car);
        else
            return getSecondParkingLot().getTicketByCar(car);
    }
}
