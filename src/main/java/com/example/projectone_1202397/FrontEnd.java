package com.example.projectone_1202397;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FrontEnd extends Application {

    static Group primaryGroup =new Group();
    static Scene primaryScene = new Scene(primaryGroup,1600,950);
    static TicketSale ticketSale = new TicketSale();
    static Image backGround =new Image("background.jpg");
    static Font font = new Font(35);

    @Override
    public void start(Stage stage) throws IOException {

        /*Scanner in = new Scanner(System.in);
        System.out.println("Enter a Passenger File name :");
        String Pfilename = in.nextLine();
        System.out.println("Opening " + Pfilename);

        System.out.println("Enter a Flight File name :");
        String Ffilename = in.nextLine();
        System.out.println("Opening " + Ffilename);*/

        File passengerFile = new File("passengers.txt");
        File flightFile = new File("flights.txt");

        ticketSale.readFlights(flightFile);
        ticketSale.readPassengers(passengerFile);

        stage.setMaximized(true);

        VBox vBox =new VBox();
        HBox H1= new HBox();
        HBox H2= new HBox();

        DropShadow dropShadow=new DropShadow();
        dropShadow.setColor(Color.DARKRED);
        dropShadow.setRadius(80);
        dropShadow.setWidth(80);
        dropShadow.setHeight(80);

        ImageView viewBG = new ImageView(backGround);
        primaryGroup.getChildren().add(viewBG);

        Button DisplayFlightsInfo = new Button("Display flight’s\n   information");
        DisplayFlightsInfo.setStyle("-fx-background-color: null");
        DisplayFlightsInfo.setFont(font);
        DisplayFlightsInfo.setTextFill(Color.WHITE);
        H1.getChildren().add(DisplayFlightsInfo);

        DisplayFlightsInfo.setOnAction(actionEvent -> DisplayFInfo(stage));
        DisplayFlightsInfo.addEventHandler(MouseEvent.MOUSE_ENTERED,(MouseEvent-> DisplayFlightsInfo.setEffect(dropShadow)));
        DisplayFlightsInfo.addEventHandler(MouseEvent.MOUSE_EXITED,(MouseEvent-> DisplayFlightsInfo.setEffect(null)));

        Button DisplayPassengersInfo = new Button("Display Passenger’s\n       information");
        DisplayPassengersInfo.setStyle("-fx-background-color: null");
        DisplayPassengersInfo.setFont(font);
        DisplayPassengersInfo.setTextFill(Color.WHITE);
        H1.getChildren().add(DisplayPassengersInfo);

        DisplayPassengersInfo.setOnAction(actionEvent -> DisplayPInfo(stage));
        DisplayPassengersInfo.addEventHandler(MouseEvent.MOUSE_ENTERED,(MouseEvent-> DisplayPassengersInfo.setEffect(dropShadow)));
        DisplayPassengersInfo.addEventHandler(MouseEvent.MOUSE_EXITED,(MouseEvent-> DisplayPassengersInfo.setEffect(null)));

        H1.setSpacing(10);
        vBox.getChildren().add(H1);

        Button AddEditFlights = new Button("Add/Edit Flights");
        AddEditFlights.setStyle("-fx-background-color: null");
        AddEditFlights.setFont(font);
        AddEditFlights.setTextFill(Color.WHITE);
        vBox.getChildren().add(AddEditFlights);

        AddEditFlights.setOnAction(actionEvent -> AddEditPas(stage));
        AddEditFlights.addEventHandler(MouseEvent.MOUSE_ENTERED,(MouseEvent-> AddEditFlights.setEffect(dropShadow)));
        AddEditFlights.addEventHandler(MouseEvent.MOUSE_EXITED,(MouseEvent-> AddEditFlights.setEffect(null)));


        Button revFlights = new Button("Reserve a ticket ");
        revFlights.setStyle("-fx-background-color: null");
        revFlights.setFont(font);
        revFlights.setTextFill(Color.WHITE);
        H2.getChildren().add(revFlights);

        revFlights.setOnAction(actionEvent -> Reserve_ticket(stage));
        revFlights.addEventHandler(MouseEvent.MOUSE_ENTERED,(MouseEvent-> revFlights.setEffect(dropShadow)));
        revFlights.addEventHandler(MouseEvent.MOUSE_EXITED,(MouseEvent-> revFlights.setEffect(null)));

        Button checkRev = new Button("Check a ticket");
        checkRev.setStyle("-fx-background-color: null");
        checkRev.setFont(font);
        checkRev.setTextFill(Color.WHITE);
        H2.getChildren().add(checkRev);

        checkRev.setOnAction(actionEvent -> Check_reserved(stage));
        checkRev.addEventHandler(MouseEvent.MOUSE_ENTERED,(MouseEvent-> checkRev.setEffect(dropShadow)));
        checkRev.addEventHandler(MouseEvent.MOUSE_EXITED,(MouseEvent-> checkRev.setEffect(null)));

        vBox.getChildren().add(H2);
        H2.setSpacing(10);

        Button cancelRev = new Button("Cancel a reservation");
        cancelRev.setStyle("-fx-background-color: null");
        cancelRev.setFont(font);
        cancelRev.setTextFill(Color.WHITE);
        vBox.getChildren().add(cancelRev);

        cancelRev.setOnAction(actionEvent -> Cancel_reservation(stage));
        cancelRev.addEventHandler(MouseEvent.MOUSE_ENTERED,(MouseEvent-> cancelRev.setEffect(dropShadow)));
        cancelRev.addEventHandler(MouseEvent.MOUSE_EXITED,(MouseEvent-> cancelRev.setEffect(null)));


        Button searchPer = new Button("Search a passenger");
        searchPer.setStyle("-fx-background-color: null");
        searchPer.setFont(font);
        searchPer.setTextFill(Color.WHITE);
        vBox.getChildren().add(searchPer);

        searchPer.setOnAction(actionEvent -> search(stage));
        searchPer.addEventHandler(MouseEvent.MOUSE_ENTERED,(MouseEvent-> searchPer.setEffect(dropShadow)));
        searchPer.addEventHandler(MouseEvent.MOUSE_EXITED,(MouseEvent-> searchPer.setEffect(null)));

        Button exit = new Button("Exit");
        exit.setStyle("-fx-background-color: null");
        exit.setFont(font);
        exit.setTextFill(Color.WHITE);
        vBox.getChildren().add(exit);

        exit.setOnAction(actionEvent -> stage.close());

        exit.addEventHandler(MouseEvent.MOUSE_ENTERED,(MouseEvent-> exit.setEffect(dropShadow)));
        exit.addEventHandler(MouseEvent.MOUSE_EXITED,(MouseEvent-> exit.setEffect(null)));

        vBox.setAlignment(Pos.CENTER);

        vBox.setSpacing(10);
        vBox.setLayoutX(370);
        vBox.setLayoutY(80);
        primaryGroup.getChildren().add(vBox);

        stage.setTitle("Basel Application");
        stage.setScene(primaryScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static void DisplayFInfo(Stage stage){

        Group DFGroup =new Group();
        Scene DFScene = new Scene(DFGroup,1600,950);

        Image backGround1 =new Image("background2.jpg");
        ImageView viewBG1 = new ImageView(backGround1);

        DFGroup.getChildren().add(viewBG1);

        VBox vBox= new VBox();
        HBox hBox=new HBox();

        Text textFlights = new Text();
        textFlights.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR,35));
        textFlights.setFill(Color.WHITE);
        textFlights.setStroke(Color.BLACK);
        textFlights.setStrokeWidth(2);
        textFlights.setText("All Flights Information:");
        vBox.getChildren().add(textFlights);

        TextArea textArea=new TextArea();
        textArea.setMinSize(1000,400);
        textArea.setFont(new Font(16));
        textArea.setEditable(false);
        vBox.getChildren().add(textArea);

        Button print_flights =new Button("Print Flights");

        print_flights.setFont(font);
        print_flights.setLayoutX(250);
        print_flights.setLayoutY(600);
        hBox.getChildren().add(print_flights);

        print_flights.setOnAction(actionEvent ->
                textArea.setText(ticketSale.getAllFlightsInfo()));

        Button Back =new Button("Back");
        //Back.setStyle("-fx-background-color: null");
        Back.setLayoutX(800);
        Back.setLayoutY(600);
        Back.setFont(font);
        hBox.getChildren().add(Back);

        Back.setOnAction(actionEvent -> {

            stage.setScene(primaryScene);
            stage.show();
        });

        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(80);

        vBox.getChildren().add(hBox);
        vBox.setSpacing(40);
        vBox.setAlignment(Pos.CENTER);
        vBox.setLayoutX(180);
        vBox.setLayoutY(80);

        DFGroup.getChildren().add(vBox);

        stage.setScene(DFScene);
        stage.show();

    }

    public static void DisplayPInfo(Stage stage){

        Group DPGroup =new Group();
        Scene DPScene = new Scene(DPGroup,1600,950);

        Image backGround1 =new Image("background2.jpg");
        ImageView viewBG1 = new ImageView(backGround1);

        DPGroup.getChildren().add(viewBG1);

        VBox vBox = new VBox();
        HBox hBox = new HBox();

        Text textF = new Text();
        textF.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR,35));
        textF.setFill(Color.WHITE);
        textF.setStroke(Color.BLACK);
        textF.setStrokeWidth(2);
        textF.setText("Flight Number:");
        vBox.getChildren().add(textF);

        TextField textFieldF =new TextField();
        textFieldF.setMaxSize(500,300);
        textFieldF.setAlignment(Pos.CENTER);
        textFieldF.setFont(new Font(30));
        vBox.getChildren().add(textFieldF);

        Text textF1 = new Text();
        textF1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR,35));
        textF1.setFill(Color.WHITE);
        textF1.setStroke(Color.BLACK);
        textF1.setStrokeWidth(2);
        textF1.setText("Passengers Information:");
        vBox.getChildren().add(textF1);

        TextArea textArea = new TextArea();
        textArea.setMinSize(1200,150);
        textArea.setFont(new Font(15));
        textArea.setEditable(false);

        vBox.getChildren().add(textArea);



        Button finFli =new Button("Find Passengers");
        //finFli.setStyle("-fx-background-color: null");
        finFli.setFont(font);
        hBox.getChildren().add(finFli);

        addBinding(finFli,textFieldF);

        finFli.setOnAction(actionEvent -> textArea.setText(ticketSale.getAllPassengersInfo(Integer.parseInt(textFieldF.getText()))));

        Button Back =new Button("Back");
        //Back.setStyle("-fx-background-color: null");
        Back.setFont(font);
        hBox.getChildren().add(Back);

        Back.setOnAction(actionEvent -> {

            stage.setScene(primaryScene);
            stage.show();
        });

        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(80);

        vBox.getChildren().add(hBox);
        vBox.setSpacing(40);
        vBox.setAlignment(Pos.CENTER);
        vBox.setLayoutX(80);
        vBox.setLayoutY(50);

        DPGroup.getChildren().add(vBox);

        stage.setScene(DPScene);
        stage.show();
    }

    public static void AddEditPas(Stage stage){

        //Create Group and Scene for action customerNew
        Group AEPGroup =new Group();
        Scene AEPScene = new Scene(AEPGroup, 1650, 900);

        Image backGround1 =new Image("background2.jpg");
        ImageView viewBG1 = new ImageView(backGround1);

        AEPGroup.getChildren().add(viewBG1);

        VBox vBox=new VBox();
        HBox hBox=new HBox();
        HBox hBox1=new HBox();
        HBox hBox2=new HBox();
        HBox hBox3=new HBox();
        HBox hBox4=new HBox();
        HBox hBox6=new HBox();

        Text textNC = new Text();
        textNC.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR,35));
        textNC.setFill(Color.WHITE);
        textNC.setStroke(Color.BLACK);
        textNC.setStrokeWidth(2);
        textNC.setText("Flight Number:");
        hBox.getChildren().add(textNC);

        //text field to input customer id
        TextField textFieldNC=new TextField();
        textFieldNC.setMinSize(350,70);
        hBox.getChildren().add(textFieldNC);

        hBox.setSpacing(25);

        vBox.getChildren().add(hBox);

        //text Customer Name
        Text textNC1 = new Text();
        textNC1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR,35));
        textNC1.setFill(Color.WHITE);
        textNC1.setStroke(Color.BLACK);
        textNC1.setStrokeWidth(2);
        textNC1.setText("Airline Name:");
        hBox1.getChildren().add(textNC1);

        //text field to input customer name
        TextField textFieldNC1=new TextField();
        textFieldNC1.setMinSize(350,70);
        hBox1.getChildren().add(textFieldNC1);

        hBox1.setSpacing(52);
        vBox.getChildren().add(hBox1);

        //text Customer Address
        Text textNC2 = new Text();
        textNC2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR,35));
        textNC2.setFill(Color.WHITE);
        textNC2.setStroke(Color.BLACK);
        textNC2.setStrokeWidth(2);
        textNC2.setText("Source:");
        hBox2.getChildren().add(textNC2);

        //text field to input customer address
        TextField textFieldNC2=new TextField();
        textFieldNC2.setMinSize(350,70);
        hBox2.getChildren().add(textFieldNC2);

        hBox2.setSpacing(170);
        vBox.getChildren().add(hBox2);

        //text Customer Mobile
        Text textNC3 = new Text();
        textNC3.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR,35));
        textNC3.setFill(Color.WHITE);
        textNC3.setStroke(Color.BLACK);
        textNC3.setStrokeWidth(2);
        textNC3.setText("Destination:");
        hBox3.getChildren().add(textNC3);

        //text field to input customer mobile
        TextField textFieldNC3=new TextField();
        textFieldNC3.setMinSize(350,70);
        hBox3.getChildren().add(textFieldNC3);

        hBox3.setSpacing(83);
        vBox.getChildren().add(hBox3);


        Text textNC5 = new Text();
        textNC5.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR,35));
        textNC5.setFill(Color.WHITE);
        textNC5.setStroke(Color.BLACK);
        textNC5.setStrokeWidth(2);
        textNC5.setText("Capacity:");
        hBox4.getChildren().add(textNC5);

        TextField textFieldNC4=new TextField();
        textFieldNC4.setMinSize(350,70);
        hBox4.getChildren().add(textFieldNC4);

        hBox4.setSpacing(137);
        vBox.getChildren().add(hBox4);

        Button saveAS =new Button("Save As");
        //saveAS.setStyle("-fx-background-color: null");
        saveAS.setFont(font);
        hBox6.getChildren().add(saveAS);
        saveAS.setVisible(false);

        saveAS.setOnAction(actionEvent -> {

            int flight_number=Integer.parseInt(textFieldNC.getText());
            String airline_name=textFieldNC1.getText();
            String source =textFieldNC2.getText();
            String destination =textFieldNC3.getText();
            int Capacity =Integer.parseInt(textFieldNC4.getText());

            for(int i=0 ; i <ticketSale.flightsSLinkedList.size() ; i++){
                if(Integer.parseInt(textFieldNC.getText())==ticketSale.flightsSLinkedList.get(i).getFlight_number()){
                    ticketSale.flightsSLinkedList.remove(i);
                    break;
                }
            }

            ticketSale.addFlight(flight_number,airline_name,source,destination,Capacity);

            textFieldNC.clear();
            textFieldNC1.clear();
            textFieldNC2.clear();
            textFieldNC3.clear();
            textFieldNC4.clear();

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Save edited.");
            alert.show();
        });

        Button addFlight =new Button("Save");
        //addFlight.setStyle("-fx-background-color: null");
        addFlight.setFont(font);
        hBox6.getChildren().add(addFlight);

        addFlight.setOnAction(actionEvent -> {

            //Create a variable of a boolean type and its initial value is false.
            boolean found = false;

            /*for loop spin from 0 to flightsSLinkedList length, if flight number existed makes value the found
                 variable true and break for loop */
            for(int i=0 ; i <ticketSale.flightsSLinkedList.size() ; i++){
                if(Integer.parseInt(textFieldNC.getText())==ticketSale.flightsSLinkedList.get(i).getFlight_number()){
                    found = true;
                    break;
                }
            }

            if(!found){
                int flight_number=Integer.parseInt(textFieldNC.getText());
                String airline_name=textFieldNC1.getText();
                String source =textFieldNC2.getText();
                String destination =textFieldNC3.getText();
                int Capacity =Integer.parseInt(textFieldNC4.getText());

                ticketSale.addFlight(flight_number,airline_name,source,destination,Capacity);

                textFieldNC.clear();
                textFieldNC1.clear();
                textFieldNC2.clear();
                textFieldNC3.clear();
                textFieldNC4.clear();

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Added.");
                alert.show();
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("""
                        The Flight entered is already exists.
                        If you want to modify the data, modify it and press Save As again
                        """);

                for(int i=0 ; i <ticketSale.flightsSLinkedList.size() ; i++){
                    if(Integer.parseInt(textFieldNC.getText())==ticketSale.flightsSLinkedList.get(i).getFlight_number()){
                        textFieldNC1.setText(ticketSale.flightsSLinkedList.get(i).getAirline_name());
                        textFieldNC2.setText(ticketSale.flightsSLinkedList.get(i).getSource());
                        textFieldNC3.setText(ticketSale.flightsSLinkedList.get(i).getDestination());
                        textFieldNC4.setText(String.valueOf(ticketSale.flightsSLinkedList.get(i).getCapacity()));
                    }
                }

                saveAS.setVisible(true);
                alert.show();

            }
        });

        Button Back =new Button("Back");
        //Back.setStyle("-fx-background-color: null");
        Back.setFont(font);
        hBox6.getChildren().add(Back);

        Back.setOnAction(actionEvent -> {

            stage.setScene(primaryScene);
            stage.show();
        });

        hBox6.setSpacing(250);
        hBox6.setAlignment(Pos.CENTER);
        vBox.getChildren().add(hBox6);

        vBox.setSpacing(25);
        AEPGroup.getChildren().add(vBox);
        vBox.setLayoutX(340);
        vBox.setLayoutY(80);

        addBinding(addFlight,textFieldNC,textFieldNC1,textFieldNC2,textFieldNC3,textFieldNC4);

        stage.setScene(AEPScene);
        stage.show();

    }

    public static void Reserve_ticket(Stage stage){

        Group RTGroup =new Group();
        Scene RTScene = new Scene(RTGroup, 1650, 900);

        Image backGround1 =new Image("background2.jpg");
        ImageView viewBG1 = new ImageView(backGround1);

        RTGroup.getChildren().add(viewBG1);

        VBox vBox=new VBox();
        VBox vBox1=new VBox();
        VBox vBox2=new VBox();
        HBox hBox=new HBox();
        HBox hBox1=new HBox();

        Text textNC = new Text();
        textNC.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR,35));
        textNC.setFill(Color.WHITE);
        textNC.setStroke(Color.BLACK);
        textNC.setStrokeWidth(2);
        textNC.setText("Flight Number:");
        vBox.getChildren().add(textNC);

        //text field to input customer id
        TextField textFieldNC=new TextField();
        textFieldNC.setMinSize(350,70);
        vBox1.getChildren().add(textFieldNC);

        //text Customer Name
        Text textNC1 = new Text();
        textNC1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR,35));
        textNC1.setFill(Color.WHITE);
        textNC1.setStroke(Color.BLACK);
        textNC1.setStrokeWidth(2);
        textNC1.setText("Name:");
        vBox.getChildren().add(textNC1);

        //text field to input customer name
        TextField textFieldNC1=new TextField();
        textFieldNC1.setMinSize(350,70);
        vBox1.getChildren().add(textFieldNC1);

        //text Customer Address
        Text textNC2 = new Text();
        textNC2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR,35));
        textNC2.setFill(Color.WHITE);
        textNC2.setStroke(Color.BLACK);
        textNC2.setStrokeWidth(2);
        textNC2.setText("Passport Number:");
        vBox.getChildren().add(textNC2);

        //text field to input customer address
        TextField textFieldNC2=new TextField();
        textFieldNC2.setMinSize(350,70);
        vBox1.getChildren().add(textFieldNC2);

        //text Customer Mobile
        Text textNC3 = new Text();
        textNC3.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR,35));
        textNC3.setFill(Color.WHITE);
        textNC3.setStroke(Color.BLACK);
        textNC3.setStrokeWidth(2);
        textNC3.setText("Nationality:");
        vBox.getChildren().add(textNC3);

        //text field to input customer mobile
        TextField textFieldNC3=new TextField();
        textFieldNC3.setMinSize(350,70);
        vBox1.getChildren().add(textFieldNC3);

        Text textNC5 = new Text();
        textNC5.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR,35));
        textNC5.setFill(Color.WHITE);
        textNC5.setStroke(Color.BLACK);
        textNC5.setStrokeWidth(2);
        textNC5.setText("Date:");
        vBox.getChildren().add(textNC5);

        TextField textFieldNC4=new TextField();
        textFieldNC4.setText(String.valueOf(new Date()));
        textFieldNC4.setMinSize(350,70);
        vBox1.getChildren().add(textFieldNC4);

        hBox.getChildren().addAll(vBox,vBox1);

        Button reserve =new Button("Reserve");
        //addFlight.setStyle("-fx-background-color: null");
        reserve.setFont(font);
        hBox1.getChildren().add(reserve);

        reserve.setOnAction(actionEvent -> {

            //Create a variable of a boolean type and its initial value is false.
            boolean found = false;

            /*for loop spin from 0 to flightsSLinkedList length, if flight number existed makes value the found
             variable true and break for loop */
            for(int i=0 ; i <ticketSale.flightsSLinkedList.size() ; i++){
                //System.out.println(textFieldNC.getText());
                if(Integer.parseInt(textFieldNC.getText())==ticketSale.flightsSLinkedList.get(i).getFlight_number()){
                    found = true;
                    break;
                }
            }

            if(found){

                int flight_number=Integer.parseInt(textFieldNC.getText());
                String name=textFieldNC1.getText();
                String Passport_number =textFieldNC2.getText();
                String Nationality =textFieldNC3.getText();

                int max=0;
                for(int i=0 ; i <ticketSale.passengersSLinkedList.size() ; i++) {

                    if (Integer.parseInt(textFieldNC.getText()) == ticketSale.passengersSLinkedList.get(i).getFlight_number()) {
                        if (max < ticketSale.passengersSLinkedList.get(i).getTicket_number()) {
                            max = ticketSale.passengersSLinkedList.get(i).getTicket_number();
                        }
                    }
                }
                int Ticket_number=max+1;

                ticketSale.addPassenger(flight_number,Ticket_number,name,Passport_number,Nationality,new Date());  ;

                textFieldNC.clear();
                textFieldNC1.clear();
                textFieldNC2.clear();
                textFieldNC3.clear();

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Added.");
                alert.show();

            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("The Flight entered is not exists");
                alert.show();

            }
        });

        Button Back =new Button("Back");
        //Back.setStyle("-fx-background-color: null");
        Back.setFont(font);
        hBox1.getChildren().add(Back);

        Back.setOnAction(actionEvent -> {

            stage.setScene(primaryScene);
            stage.show();
        });

        hBox.setSpacing(15);
        hBox1.setSpacing(100);
        hBox1.setAlignment(Pos.CENTER);

        vBox.setSpacing(50);
        vBox1.setSpacing(20);
        vBox2.getChildren().addAll(hBox,hBox1);
        vBox2.setSpacing(25);
        vBox2.setLayoutX(340);
        vBox2.setLayoutY(80);

        addBinding(reserve,textFieldNC,textFieldNC1,textFieldNC2,textFieldNC3,textFieldNC4);
        RTGroup.getChildren().add(vBox2);
        stage.setScene(RTScene);
        stage.show();
    }

    public static void Check_reserved(Stage stage){
        Group CRGroup =new Group();
        Scene CRScene = new Scene(CRGroup, 1650, 900);

        Image backGround1 =new Image("background2.jpg");
        ImageView viewBG1 = new ImageView(backGround1);

        CRGroup.getChildren().add(viewBG1);

        VBox vBox=new VBox();
        VBox vBox1=new VBox();
        VBox vBox2=new VBox();
        HBox hBox=new HBox();
        HBox hBox1=new HBox();

        Text textNC = new Text();
        textNC.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR,35));
        textNC.setFill(Color.WHITE);
        textNC.setStroke(Color.BLACK);
        textNC.setStrokeWidth(2);
        textNC.setText("Flight Number:");
        vBox.getChildren().add(textNC);

        //text field to input customer id
        TextField textFieldNC=new TextField();
        textFieldNC.setMinSize(350,70);
        vBox1.getChildren().add(textFieldNC);

        //text Customer Name
        Text textNC1 = new Text();
        textNC1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR,35));
        textNC1.setFill(Color.WHITE);
        textNC1.setStroke(Color.BLACK);
        textNC1.setStrokeWidth(2);
        textNC1.setText("Name:");
        vBox.getChildren().add(textNC1);

        //text field to input customer name
        TextField textFieldNC1=new TextField();
        textFieldNC1.setMinSize(350,70);
        vBox1.getChildren().add(textFieldNC1);

        TextArea textArea=new TextArea();
        textArea.setMinSize(400,200);
        textArea.setFont(new Font(20));
        textArea.setEditable(false);

        Button find =new Button("Find");
        //find.setStyle("-fx-background-color: null");
        find.setFont(font);
        hBox1.getChildren().add(find);

        find.setOnAction(actionEvent -> {

            for(int i=0 ; i <ticketSale.flightsSLinkedList.size() ; i++){

                if(Integer.parseInt(textFieldNC.getText())==ticketSale.flightsSLinkedList.get(i).getFlight_number()){

                    for(int j=0 ; j <ticketSale.passengersSLinkedList.size() ; j++){

                        if(textFieldNC1.getText().equalsIgnoreCase(ticketSale.passengersSLinkedList.get(j).getFull_name())){

                            textArea.setText("There is a reservation");
                            break;
                        }else{
                            textArea.setText("There is not a reservation");
                        }
                    }
                    break;
                }else{
                    textArea.setText("There is not a reservation");
                }
            }
        });

        Button Back =new Button("Back");
        //Back.setStyle("-fx-background-color: null");
        Back.setFont(font);
        hBox1.getChildren().add(Back);

        Back.setOnAction(actionEvent -> {

            stage.setScene(primaryScene);
            stage.show();
        });

        addBinding(find,textFieldNC,textFieldNC1);

        hBox1.setSpacing(100);
        hBox1.setAlignment(Pos.CENTER);
        vBox.setSpacing(70);
        vBox1.setSpacing(25);
        hBox.setSpacing(15);
        hBox.getChildren().addAll(vBox,vBox1);
        vBox2.getChildren().addAll(hBox,textArea,hBox1);
        vBox2.setLayoutX(280);
        vBox2.setLayoutY(80);
        vBox2.setSpacing(25);
        CRGroup.getChildren().add(vBox2);

        stage.setScene(CRScene);
        stage.show();
    }

    public static void Cancel_reservation(Stage stage){

        Group CRGroup =new Group();
        Scene CRScene = new Scene(CRGroup, 1650, 900);

        Image backGround1 =new Image("background2.jpg");
        ImageView viewBG1 = new ImageView(backGround1);

        CRGroup.getChildren().add(viewBG1);

        VBox vBox=new VBox();
        VBox vBox1=new VBox();
        VBox vBox2=new VBox();
        HBox hBox=new HBox();
        HBox hBox1=new HBox();

        Text textNC = new Text();
        textNC.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR,35));
        textNC.setFill(Color.WHITE);
        textNC.setStroke(Color.BLACK);
        textNC.setStrokeWidth(2);
        textNC.setText("Flight Number:");
        vBox.getChildren().add(textNC);

        //text field to input customer id
        TextField textFieldNC=new TextField();
        textFieldNC.setMinSize(350,70);
        vBox1.getChildren().add(textFieldNC);

        //text Customer Name
        Text textNC1 = new Text();
        textNC1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR,35));
        textNC1.setFill(Color.WHITE);
        textNC1.setStroke(Color.BLACK);
        textNC1.setStrokeWidth(2);
        textNC1.setText("Name:");
        vBox.getChildren().add(textNC1);

        //text field to input customer name
        TextField textFieldNC1=new TextField();
        textFieldNC1.setMinSize(350,70);
        vBox1.getChildren().add(textFieldNC1);

        TextArea textArea=new TextArea();
        textArea.setMinSize(400,200);
        textArea.setFont(new Font(20));
        textArea.setEditable(false);

        Button cancel =new Button("Cancel");
        //cancel.setStyle("-fx-background-color: null");
        cancel.setFont(font);
        hBox1.getChildren().add(cancel);

        cancel.setOnAction(actionEvent -> {
            for(int i=0 ; i <ticketSale.flightsSLinkedList.size() ; i++){

                if(Integer.parseInt(textFieldNC.getText())==ticketSale.flightsSLinkedList.get(i).getFlight_number()){

                    for(int j=0 ; j <ticketSale.passengersSLinkedList.size() ; j++){

                        if(textFieldNC1.getText().equalsIgnoreCase(ticketSale.passengersSLinkedList.get(j).getFull_name())){

                            ticketSale.passengersSLinkedList.remove(j);
                            break;
                        }
                    }
                    break;
                }
            }
        });

        Button find =new Button("Find");
        //find.setStyle("-fx-background-color: null");
        find.setFont(font);
        hBox1.getChildren().add(find);

        find.setOnAction(actionEvent -> {

            for(int i=0 ; i <ticketSale.flightsSLinkedList.size() ; i++){

                if(Integer.parseInt(textFieldNC.getText())==ticketSale.flightsSLinkedList.get(i).getFlight_number()){

                    for(int j=0 ; j <ticketSale.passengersSLinkedList.size() ; j++){

                        if(textFieldNC1.getText().equalsIgnoreCase(ticketSale.passengersSLinkedList.get(j).getFull_name())){

                            textArea.setText(ticketSale.flightsSLinkedList.get(i).toString()+"\n\n"+
                                    ticketSale.passengersSLinkedList.get(j).toString());

                            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                            alert.setContentText("If you want to cancel the trip, press Cancel");
                            alert.show();
                            break;
                        }else{
                            textArea.setText("The name for passenger entered does not exist for this flight");
                        }
                    }
                   break;
                }else{
                    textArea.setText("The number of flight entered does not exist");
                }
            }
        });

        Button Back =new Button("Back");
        //Back.setStyle("-fx-background-color: null");
        Back.setFont(font);
        hBox1.getChildren().add(Back);

        Back.setOnAction(actionEvent -> {

            stage.setScene(primaryScene);
            stage.show();
        });



        hBox1.setSpacing(100);
        hBox1.setAlignment(Pos.CENTER);
        vBox.setSpacing(70);
        vBox1.setSpacing(25);
        hBox.setSpacing(15);
        hBox.getChildren().addAll(vBox,vBox1);
        vBox2.getChildren().addAll(hBox,textArea,hBox1);
        vBox2.setLayoutX(280);
        vBox2.setLayoutY(80);
        vBox2.setSpacing(25);
        CRGroup.getChildren().add(vBox2);

        stage.setScene(CRScene);
        stage.show();
    }

    public static void search(Stage stage){

        Group CRGroup =new Group();
        Scene CRScene = new Scene(CRGroup, 1650, 900);

        Image backGround1 =new Image("background2.jpg");
        ImageView viewBG1 = new ImageView(backGround1);

        CRGroup.getChildren().add(viewBG1);

        VBox vBox=new VBox();
        HBox hBox=new HBox();
        HBox hBox1=new HBox();

        Text textNC = new Text();
        textNC.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR,35));
        textNC.setFill(Color.WHITE);
        textNC.setStroke(Color.BLACK);
        textNC.setStrokeWidth(2);
        textNC.setText("Name:");
        hBox.getChildren().add(textNC);

        //text field to input customer id
        TextField textFieldNC=new TextField();
        textFieldNC.setMinSize(350,70);
        textFieldNC.setAlignment(Pos.CENTER);
        hBox.getChildren().add(textFieldNC);

        TextArea textArea=new TextArea();
        textArea.setMinSize(400,200);
        textArea.setFont(new Font(20));
        textArea.setEditable(false);

        Button find =new Button("Find");
        //find.setStyle("-fx-background-color: null");
        find.setFont(font);
        hBox1.getChildren().add(find);

        find.setOnAction(actionEvent -> {

                    for(int j=0 ; j <ticketSale.passengersSLinkedList.size() ; j++){

                        if(textFieldNC.getText().equalsIgnoreCase(ticketSale.passengersSLinkedList.get(j).getFull_name())){

                            textArea.setText(ticketSale.passengersSLinkedList.get(j).toString());
                            break;
                        }else{
                            textArea.setText("The name for passenger entered does not exist ");
                        }
                    }
        });

        Button Back =new Button("Back");
        //Back.setStyle("-fx-background-color: null");
        Back.setFont(font);
        hBox1.getChildren().add(Back);

        Back.setOnAction(actionEvent -> {

            stage.setScene(primaryScene);
            stage.show();
        });

        hBox.setSpacing(30);
        hBox.setAlignment(Pos.CENTER);
        hBox1.setSpacing(90);
        hBox1.setAlignment(Pos.CENTER);
        vBox.setSpacing(30);
        vBox.setAlignment(Pos.CENTER);
        vBox.setLayoutX(300);
        vBox.setLayoutY(80);
        vBox.getChildren().addAll(hBox,textArea,hBox1);

        CRGroup.getChildren().add(vBox);

        stage.setScene(CRScene);
        stage.show();

    }

    public static void addBinding(Button submitBtn, TextField... textFields) {

        for (int i = 0; i < textFields.length; i++) {
            TextField tf = textFields[i];
            Node node = i == textFields.length - 1 ? submitBtn : textFields[i + 1];
            node.disableProperty().bind(
                    Bindings.createBooleanBinding(() -> tf.isDisable() || tf.getText() == null || tf.getText().isEmpty(),
                            tf.textProperty(), tf.disableProperty()));
        }
    }
}