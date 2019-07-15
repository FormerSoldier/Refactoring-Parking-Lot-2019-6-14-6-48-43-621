package com.thoughtworks.tdd.story;

public class SmartParkingBoy extends ParkingBoy{
    private int firstParkingLotIndex = 1;
    private int secondParkingLotIndex = 2;

    public int getLotAvailableParkingCountByIndex(int indexOfParkingLotList) {
        if(indexOfParkingLotList == firstParkingLotIndex)
            return getFirstParkingLot().getAvailableParkingCount();
        else if(indexOfParkingLotList == secondParkingLotIndex)
            return getSecondParkingLot().getAvailableParkingCount();
        return 0;
    }

    @Override
    public Ticket park(Car car) {
        if (getFirstParkingLot().getAvailableParkingCount() >= getSecondParkingLot().getAvailableParkingCount())
            return getFirstParkingLot().getTicketByCar(car);
        else
            return getSecondParkingLot().getTicketByCar(car);
    }
}
