/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package car_rental_services.controllers;

import static car_rental_services.Car_Rental_Services.netIsAvailable;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import utils.ConnectionUtil;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class RentedController implements Initializable {

    @FXML
    private Label start;
    @FXML
    private Label end;
    @FXML
    private Label pickdate;
    @FXML
    private Label picktime;
    @FXML
    private Label dropdate;
    @FXML
    private Label droptime;
    @FXML
    private Label carname;
    @FXML
    private BorderPane borderpane;
    int range = 0;
    Random random = new Random();
    Connection con = null;
    PreparedStatement preparedStatement = null;
    ResultSet rs = null;
    @FXML
    private ImageView opel;
    @FXML
    private ImageView hyundai;
    @FXML
    private ImageView suzuki;
    @FXML
    private ImageView volvo;
    @FXML
    private ImageView ford;
    @FXML
    private ImageView fordXV;
    @FXML
    private Label error;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try{  
            opel.setVisible(false);
            hyundai.setVisible(false);
            suzuki.setVisible(false);
            volvo.setVisible(false);
            ford.setVisible(false);
            fordXV.setVisible(false);
            Class.forName("com.mysql.jdbc.Driver");              
            try (Connection conn = DriverManager.getConnection(  
                    "jdbc:mysql://localhost:3306/car_rental_services","root","Vinaybhat375@")) {               
                Statement stmt=conn.createStatement();
                rs=stmt.executeQuery("select * from details");
                while(rs.next()){
                    range++;
                }         
            }
    }catch(ClassNotFoundException | SQLException e){ 
        System.out.println(e);
    }  
    filldetails();
    range = random.nextInt(range);
    }    
    
    private void loadUI(String ui){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(ui));   
        } catch(IOException ex) {
            Logger.getLogger(LandingPageController.class.getName()).log(Level.SEVERE,null,ex);
        }
        borderpane.setCenter(root);
    }
    public RentedController() throws SQLException {
        con = ConnectionUtil.conDB();
    }
    @FXML
    private void home(MouseEvent event) {
        if(netIsAvailable()) {
            loadUI("/car_rental_services/pages/LoginInHome.fxml");
        }
        else {
        loadUI("/car_rental_services/pages/Internet.fxml");
    }
    }
     private void filldetails() {
        String sql = "SELECT * FROM details Where id = ?";
        try {
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1,range);
            rs= preparedStatement.executeQuery();
            while(rs.next()) {
                start.setText(rs.getString(2));
                end.setText(rs.getString(3));
                pickdate.setText(rs.getString(4));
                picktime.setText(rs.getString(5));
                dropdate.setText(rs.getString(6));
                droptime.setText(rs.getString(7));
                System.out.println(rs.getInt(8));
                if(rs.getInt(8) == 1) {
                    opel.setVisible(true);
                    carname.setText("Opel Corsa"
                            + "");
                }
                if(rs.getInt(8) == 2) {
                    hyundai.setVisible(true);
                    carname.setText("Hyundai i20");
                }
                if(rs.getInt(8) == 3) {
                    suzuki.setVisible(true);
                    carname.setText("Suzuki Swift");
                }
                if(rs.getInt(8) == 4) {
                    volvo.setVisible(true);
                    carname.setText("Volvo");
                }
                if(rs.getInt(8) == 5) {
                    ford.setVisible(true);
                    carname.setText("Ford XV");
                }
                if(rs.getInt(8) == 6) {
                    fordXV.setVisible(true);
                    carname.setText("Ford");
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }     
    }
}
