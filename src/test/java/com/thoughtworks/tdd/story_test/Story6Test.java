package com.thoughtworks.tdd.story_test;

import com.thoughtworks.tdd.story.Car;
import com.thoughtworks.tdd.story.ParkingBoy;
import com.thoughtworks.tdd.story.ServiceManager;
import com.thoughtworks.tdd.story.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


public class Story6Test {
    // AC 1
    @Test
    public void should_return_ticket_when_call_park_given_car(){
        ServiceManager serviceManager = new ServiceManager();

        List<ParkingBoy> parkingBoysList = serviceManager.getParkingBoysList();
        for(int i = 0; i < parkingBoysList.size(); i++){
            Car car = new Car();
            Ticket ticket = parkingBoysList.get(i).park(car);
            Assertions.assertNotNull(ticket);
            Assertions.assertNotNull(parkingBoysList.get(i).fetch(ticket));
        }
        Assertions.assertNotEquals(parkingBoysList.size(),0);
    }

    //AC 2
    @Test
    public void should_return_ticket_when_call_manager_park_given_car(){
        ServiceManager serviceManager = new ServiceManager();
        Car car = new Car();
        Ticket ticket = serviceManager.park(car);

        Assertions.assertNotNull(ticket);
    }


    @Test
    public void should_return_car_when_call_manager_fetch_given_ticket(){
        ServiceManager serviceManager = new ServiceManager();
        Ticket ticket = serviceManager.park(new Car());

        Car car = serviceManager.fetch(ticket);
        Assertions.assertNotNull(car);
    }

    // AC 3

    @Test
    public void should_return_Unrecognized_parking_ticket_when_call_query_after_given_wrong_ticket_to_service_manager_parkingBoy_park(){
        ServiceManager serviceManager = new ServiceManager();
        Ticket ticket = new Ticket();
        Car car = serviceManager.fetchCarByNthBoy(1,ticket);
        String message = serviceManager.displayErrorMessageByNthBoy(1);
        Assertions.assertEquals(message,"Unrecognized parking ticket.");
    }

    @Test
    public void should_return_Unrecognized_parking_ticket_when_call_query_after_given_used_ticket_to_service_manager_parkingBoy_park(){
        ServiceManager serviceManager = new ServiceManager();
        Ticket ticket = serviceManager.parkCarByNthBoy(1,new Car());
        serviceManager.fetchCarByNthBoy(1,ticket);
        serviceManager.fetchCarByNthBoy(1,ticket);

        String message = serviceManager.displayErrorMessageByNthBoy(1);
        Assertions.assertEquals(message,"Unrecognized parking ticket.");
    }

    @Test
    public void should_return_Please_provide_your_parking_ticket_when_call_query_after_given_null_to_service_manager_parkingBoy_fetch(){
        ServiceManager serviceManager = new ServiceManager();
        serviceManager.fetchCarByNthBoy(1,null);

        String message = serviceManager.displayErrorMessageByNthBoy(1);
        Assertions.assertEquals(message,"Please provide your parking ticket");
    }


    @Test
    public void should_return_Not_enough_position_when_call_query_after_given_twenty_one_cars_to_service_manager_parkingBoy_park(){
        ServiceManager serviceManager = new ServiceManager();
        for(int i = 0; i < 20; i++)
            serviceManager.parkCarByNthBoy(1, new Car());
        serviceManager.parkCarByNthBoy(1, new Car());
        String message = serviceManager.displayErrorMessageByNthBoy(1);
        Assertions.assertEquals(message,"Not enough position.");

    }
}
