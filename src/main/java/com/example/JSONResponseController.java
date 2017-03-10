package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/json")
public class JSONResponseController {
    @GetMapping("/flights")
    public Flight getFlights() {
        Flight flight = new Flight();
        Ticket ticket = new Ticket();
        Person passenger = new Person();

        passenger.firstName = "Bob";
        passenger.lastName = "Wayne";
        ticket.price = 600;
        ticket.passenger = passenger;


        Ticket ticket2 = new Ticket();
        Person passenger2 = new Person();
        passenger2.firstName = "Dwayne";
        passenger2.lastName = "Johnson";
        ticket2.price = 200;
        ticket2.passenger = passenger2;

        List<Ticket> list = new ArrayList<>();
        list.add(ticket2);
        list.add(ticket);

        flight.tickets = list;

        System.out.println(list);
        System.out.println("Boom");
        return flight;
    }

    @GetMapping("/flights/flight")
    public Flight getFlight() {
        Flight flight = new Flight();
        Ticket ticket = new Ticket();
        Person passenger = new Person();

        passenger.firstName = "Dwayne";
        passenger.lastName = "Johnson";
        ticket.price = 200;
        ticket.passenger = passenger;
        List<Ticket> list = new ArrayList<>();
        list.add(ticket);

        flight.tickets = list;
        return flight;
    }



    public static class Flight {
        private List<Ticket> tickets;

        public List<Ticket> getTickets() { return tickets; }
        public void setTickets(List<Ticket> setTickets) { this.tickets = tickets; }
    }

    static class Ticket {
        private Person passenger;
        private int price;

        public int getPrice(){
            return price;
        }

        public void setPrice(int price){
            this.price = price;
        }
        public Person getPassenger() { return passenger; }
        public void setPassenger(Person passenger) {this.passenger = passenger; }
    }

    static class Person {
        private String firstName;
        private String lastName;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

    }

}
