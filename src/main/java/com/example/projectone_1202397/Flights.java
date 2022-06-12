package com.example.projectone_1202397;

import java.util.Objects;

public class Flights implements Comparable<Flights> {
    private int flight_number;
    private String airline_name;
    private String source;
    private String destination;
    private int Capacity;

    public Flights(int flight_number,String airline_name,String source,String destination,int Capacity){
        this.flight_number=flight_number;
        this.airline_name=airline_name;
        this.source=source;
        this.destination=destination;
        this.Capacity=Capacity;
    }

    public int getFlight_number() {
        return flight_number;
    }

    public void setFlight_number(int flight_number) {
        this.flight_number = flight_number;
    }

    public String getAirline_name() {
        return airline_name;
    }

    public void setAirline_name(String airline_name) {
        this.airline_name = airline_name;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getCapacity() {
        return Capacity;
    }

    public void setCapacity(int capacity) {
        Capacity = capacity;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flight_number=" + flight_number +
                ", airline_name='" + airline_name + '\'' +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", Capacity=" + Capacity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flights flights = (Flights) o;
        return flight_number == flights.flight_number && Capacity == flights.Capacity && Objects.equals(airline_name, flights.airline_name) && Objects.equals(source, flights.source) && Objects.equals(destination, flights.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flight_number, airline_name, source, destination, Capacity);
    }

    @Override
    public int compareTo(Flights o) {

        return Integer.compare(flight_number, o.flight_number);
    }
}
