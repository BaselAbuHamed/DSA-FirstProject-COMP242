package com.example.projectone_1202397;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

public class TicketSale {

    SLinkedList<Passengers> passengersSLinkedList=new SLinkedList<>();
    SLinkedList<Flights> flightsSLinkedList=new SLinkedList<>();


    public void readPassengers (File passengersFile){

        if(passengersFile.exists()){
            try {
                Scanner scanPas = new Scanner (passengersFile);
                while (scanPas.hasNext()){

                    String bufferLine = scanPas.nextLine();
                    String[] bufferSplit = bufferLine.split(",");

                    int flight_number = Integer.parseInt(bufferSplit[0].trim());
                    int Ticket_number = Integer.parseInt(bufferSplit[1].trim());
                    String Full_name = bufferSplit[2].trim();
                    String Passport_number = bufferSplit[3].trim();
                    String Nationality = bufferSplit[4].trim();

                    String [] bufferDate = bufferSplit[5].split("/");
                    int day=Integer.parseInt(bufferDate[0]);
                    int month=Integer.parseInt(bufferDate[1]);
                    int year=Integer.parseInt(bufferDate[2]);


                    Passengers tmp = new Passengers(flight_number,Ticket_number,Full_name,Passport_number,Nationality,new Date(year-1900,month-1,day));

                    passengersSLinkedList.add(tmp);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("Passengers file not found!\nCreating new file...");
            try{
                passengersFile.createNewFile();
            }
            catch (Exception e) {
                System.out.println("Error creating file!");
            }
        }
    }

    public void readFlights (File flightsFile){

        if(flightsFile.exists()){
            try {
                Scanner scanPas = new Scanner (flightsFile);
                while (scanPas.hasNext()){

                    String bufferLine = scanPas.nextLine();
                    String[] bufferSplit = bufferLine.split(",");

                    int flight_number = Integer.parseInt(bufferSplit[0].trim());
                    String airline_name = bufferSplit[1].trim();
                    String source = bufferSplit[2].trim();
                    String destination = bufferSplit[3].trim();
                    int Capacity = Integer.parseInt(bufferSplit[4].trim());

                    Flights tmp = new Flights(flight_number,airline_name,source,destination,Capacity);

                    flightsSLinkedList.add(tmp);

                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("Flights file not found!\nCreating new file...");
            try{
                flightsFile.createNewFile();
            }
            catch (Exception e) {
                System.out.println("Error creating file!");
            }
        }
    }

    public String getAllFlightsInfo(){
        
        StringBuilder FlightsInfo= new StringBuilder();

        try{
            for(int i = 0 ; i < flightsSLinkedList.size();i++){
                FlightsInfo.append(flightsSLinkedList.get(i).toString()).append("\n");
            }
        }catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array is out of Bounds"+e);
        }
        return FlightsInfo.toString();
    }

    public String getAllPassengersInfo(int flight_number){

        StringBuilder PassengersInfo = new StringBuilder();

        try{
            for(int i = 0 ; i < passengersSLinkedList.size();i++){
                if(passengersSLinkedList.get(i).getFlight_number()==flight_number){
                    PassengersInfo.append(passengersSLinkedList.get(i).toString()).append("\n");
                }
            }
        }catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array is out of Bounds"+e);
        }
        return PassengersInfo.toString();
    }

    public void addFlight(int flight_number,String airline_name,String source,String destination,int Capacity){
        flightsSLinkedList.add(new Flights(flight_number,airline_name,source,destination,Capacity));
    }

    public void addPassenger(int flight_number, int Ticket_number, String Full_name, String Passport_number, String Nationality, Date Birthdate){
        passengersSLinkedList.add(new Passengers(flight_number,Ticket_number,Full_name,Passport_number,Nationality,Birthdate));
    }

}
