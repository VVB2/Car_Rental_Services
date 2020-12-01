/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package car_rental_services.controllers;

import static car_rental_services.Car_Rental_Services.netIsAvailable;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTimePicker;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import utils.ConnectionUtil;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class DetailsController implements Initializable {
    private Button monthbtn;
    @FXML
    private VBox enterDetails;
    @FXML
    private VBox checkDetails;
    @FXML
    private BorderPane borderpane;
    @FXML
    private TextField start;
    @FXML
    private TextField end;
    @FXML
    private JFXDatePicker pickupdate;
    @FXML
    private JFXTimePicker pickuptime;
    @FXML
    private JFXDatePicker dropoffdate;
    @FXML
    private JFXTimePicker dropofftime;
    @FXML
    private Label error;
    @FXML
    private Label startpoint;
    @FXML
    private Label endpoint;
    @FXML
    private Label timepickup;
    @FXML
    private Label datedropoff;
    @FXML
    private Label timedropoff;
    @FXML
    private Label datepickup;
    Connection con = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    LocalDate date = LocalDate.now().plusDays(1); 
    LocalTime time = LocalTime.now();
    @FXML
    private ScrollPane cars;
    @FXML
    private Pane Opel;
    @FXML
    private Pane Hyundai;
    @FXML
    private Pane Suzuki;
    @FXML
    private Pane Volvo;
    @FXML
    private Pane Ford_XV;
    @FXML
    private Pane Ford;
    @FXML
    private HBox errormessage;
    String restore=String.format("-fx-background-color:#212121;-fx-background-radius:5;-fx-effect: dropshadow(three-pass-box, #fff, 3, 0, 0, 0)");
    String bstyle=String.format("-fx-border-color:#70ad4d;-fx-border-width:2;-fx-border-radius:5");
    int choice = 0;

    private void loadUI(String ui){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(ui));   
        } catch(IOException ex) {
            Logger.getLogger(LandingPageController.class.getName()).log(Level.SEVERE,null,ex);
        }
        borderpane.setCenter(root);
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO 
        enterDetails.setVisible(true);
        checkDetails.setVisible(false);
        cars.setVisible(false);
        pickupdate.setValue(date);
        pickuptime.setValue(time);
    }    

    private void months(MouseEvent event) {
        monthbtn.setStyle("-fx-border-color: #70ad4d");
        monthbtn.setStyle("-fx-text-fill: #fff");
        monthbtn.setStyle("-fx-border-width: 2px");
    }

    @FXML
    private void home(MouseEvent event) {
        if(netIsAvailable()) {
            loadUI("/car_rental_services/pages/Home.fxml");
        }
        else {
            loadUI("/car_rental_services/pages/Internet.fxml");
        }
    }

    @FXML
    private void check(MouseEvent event) throws ParseException {
        if(start.getText().isEmpty() || end.getText().isEmpty() || dropoffdate.getValue() == null || dropofftime.getValue() == null) {
            error.setVisible(true);
        }
        else {
            startpoint.setText(start.getText().substring(0, 1).toUpperCase() + start.getText().substring(1));
            endpoint.setText(end.getText().substring(0, 1).toUpperCase() + end.getText().substring(1));
            timepickup.setText(pickuptime.getValue().toString().substring(0,5).trim());
            datepickup.setText(pickupdate.getValue().toString());
            timedropoff.setText(dropofftime.getValue().toString());
            datedropoff.setText(dropoffdate.getValue().toString());
            checkDetails.setVisible(true);
            enterDetails.setVisible(false);
            cars.setVisible(false);
        }
    }

    @FXML
    private void back(MouseEvent event) {
        checkDetails.setVisible(false);
        enterDetails.setVisible(true);
        cars.setVisible(false);
    }

    @FXML
    private void next(MouseEvent event) {
        checkDetails.setVisible(false);
        enterDetails.setVisible(false);
        cars.setVisible(true);
    }  
    public DetailsController() throws SQLException {
        con = ConnectionUtil.conDB();
    }
    public String details() {
        String status = "Success";
            String sql = "insert into details (start,end,pickupdate,pickuptime,dropoffdate,dropofftime,car) values (?,?,?,?,?,?,?)";
            try {
                preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, startpoint.getText());
                preparedStatement.setString(2, endpoint.getText());
                preparedStatement.setString(3, datepickup.getText());
                preparedStatement.setString(4, timepickup.getText());
                preparedStatement.setString(5, datedropoff.getText());
                preparedStatement.setString(6, timedropoff.getText());
                preparedStatement.setInt(7, choice);
                preparedStatement.execute();
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
                status = "Exception";
            }
            return status;
    }

    @FXML
    private void invisible(MouseEvent event) {
        error.setVisible(false);
    }

    @FXML
    private void opel(MouseEvent event) {
        choice = 1;
        Opel.setStyle(bstyle);
        Hyundai.setStyle(restore);
        Ford_XV.setStyle(restore);
        Ford.setStyle(restore);
        Suzuki.setStyle(restore);
        Volvo.setStyle(restore);
    }

    @FXML
    private void hyundai(MouseEvent event) {
        choice = 2;
        Opel.setStyle(restore);
        Hyundai.setStyle(bstyle);
        Ford_XV.setStyle(restore);
        Ford.setStyle(restore);
        Suzuki.setStyle(restore);
        Volvo.setStyle(restore);
    }

    @FXML
    private void suzuki(MouseEvent event) {
        choice = 3;
        Opel.setStyle(restore);
        Hyundai.setStyle(restore);
        Ford_XV.setStyle(restore);
        Ford.setStyle(restore);
        Suzuki.setStyle(bstyle);
        Volvo.setStyle(restore);
    }

    @FXML
    private void volvo(MouseEvent event) {
        choice = 4;
        Opel.setStyle(restore);
        Hyundai.setStyle(restore);
        Ford_XV.setStyle(restore);
        Ford.setStyle(restore);
        Suzuki.setStyle(restore);
        Volvo.setStyle(bstyle);
    }

    @FXML
    private void fordxv(MouseEvent event) {
        choice = 5;
        Opel.setStyle(restore);
        Hyundai.setStyle(restore);
        Ford_XV.setStyle(bstyle);
        Ford.setStyle(restore);
        Suzuki.setStyle(restore);
        Volvo.setStyle(restore);
    }

    @FXML
    private void ford(MouseEvent event) {  
        choice = 6;
        Opel.setStyle(restore);
        Hyundai.setStyle(restore);
        Ford_XV.setStyle(restore);
        Ford.setStyle(bstyle);
        Suzuki.setStyle(restore);
        Volvo.setStyle(restore);
    }

    @FXML
    private void finish(MouseEvent event) {
        if(choice!=0) {
            if(details().equals("Success")) {
                if(netIsAvailable()) {
                    loadUI("/car_rental_services/pages/LoginInHome.fxml");
                }
                else {
                    loadUI("/car_rental_services/pages/Internet.fxml");
                }
            }
        }
        else {
            errormessage.setVisible(true);
        }
    }

}
