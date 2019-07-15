package com.thoughtworks.tdd.story_test;

import com.thoughtworks.tdd.story.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Story5Test {

    @Test
    public void should_return_9_18_when_call_getLotAvailableParkingCountByNum_twice_given_third_car(){
        ParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy();
        ParkingLot parkingLot = new ParkingLot(20);
        superSmartParkingBoy.setSecondParkingLot(parkingLot);

        superSmartParkingBoy.park(new Car());
        superSmartParkingBoy.park(new Car());
        superSmartParkingBoy.park(new Car());

        Assertions.assertEquals(((SuperSmartParkingBoy)superSmartParkingBoy).getLotAvailableParkingCountByIndex(1),9);
        Assertions.assertEquals(((SuperSmartParkingBoy)superSmartParkingBoy).getLotAvailableParkingCountByIndex(2),18);

    }
}
