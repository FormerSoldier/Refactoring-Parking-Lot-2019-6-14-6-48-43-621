package com.thoughtworks.tdd.story_test;

import com.thoughtworks.tdd.story.Car;
import com.thoughtworks.tdd.story.ParkingBoy;
import com.thoughtworks.tdd.story.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Story3Test {

    @Test
    public void return_ticket_when_call_park_given_eleven_car(){
        ParkingBoy parkingBoy = new ParkingBoy();
        for(int i = 0; i < 10; i++)
            parkingBoy.park(new Car());
        Ticket ticket = parkingBoy.park(new Car());

        Assertions.assertNotNull(ticket);
    }
}
