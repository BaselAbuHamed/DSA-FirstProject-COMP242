package com.example.projectone_1202397;

import java.util.Date;

public class Passengers implements Comparable<Passengers> {

    private int flight_number;
    private int Ticket_number;
    private String Full_name;
    private String Passport_number;
    private String Nationality;
    private Date Birthdate;

    public Passengers(int flight_number, int Ticket_number, String Full_name, String Passport_number, String Nationality, Date Birthdate) {
        this.flight_number=flight_number;
        this.Ticket_number=Ticket_number;
        this.Full_name=Full_name;
        this.Passport_number=Passport_number;
        this.Nationality=Nationality;
        this.Birthdate=Birthdate;
    }

    public void setFlight_number(int flight_number) {
        this.flight_number = flight_number;
    }

    public int getFlight_number() {
        return flight_number;
    }

    public void setTicket_number(int ticket_number) {
        Ticket_number = ticket_number;
    }

    public int getTicket_number() {
        return Ticket_number;
    }

    public void setFull_name(String full_name) {
        Full_name = full_name;
    }

    public String getFull_name() {
        return Full_name;
    }

    public void setPassport_number(String passport_number) {
        Passport_number = passport_number;
    }

    public String getPassport_number() {
        return Passport_number;
    }

    public void setNationality(String nationality) {
        Nationality = nationality;
    }

    public String getNationality() {
        return Nationality;
    }

    public void setBirthdate(Date birthdate) {
        Birthdate = birthdate;
    }

    public Date getBirthdate() {
        return Birthdate;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "flight_number=" + flight_number +
                ", Ticket_number=" + Ticket_number +
                ", Full_name='" + Full_name + '\'' +
                ", Passport_number='" + Passport_number + '\'' +
                ", Nationality='" + Nationality + '\'' +
                ", Birthdate='" + Birthdate + '\'' +
                '}';
    }

    @Override
    public int compareTo(Passengers o) {
        return 0;
    }
}
