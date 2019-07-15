package com.thoughtworks.tdd.story_test;

import com.thoughtworks.tdd.story.Car;
import com.thoughtworks.tdd.story.ParkingBoy;
import com.thoughtworks.tdd.story.SmartParkingBoy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Story4Test {

    @Test
    public void should_return_9_9_when_call_getLotAvailableParkingCountByNum_twice_given_two_car(){
        ParkingBoy smartParkingBoy = new SmartParkingBoy();
        smartParkingBoy.park(new Car());
        smartParkingBoy.park(new Car());

        Assertions.assertEquals(((SmartParkingBoy)smartParkingBoy).getLotAvailableParkingCountByIndex(1),9);
        Assertions.assertEquals(((SmartParkingBoy)smartParkingBoy).getLotAvailableParkingCountByIndex(2),9);

    }
}
