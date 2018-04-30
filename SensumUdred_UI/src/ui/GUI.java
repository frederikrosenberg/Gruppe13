/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import common.IBusinessFacade;
import common.IUI;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Sebas
 */
public class GUI extends Application implements IUI {
    private static GUI gui;
    private IBusinessFacade business;
    private Stage stage;
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        
        gui.stage = stage;
        stage.setScene(scene);
        stage.setTitle("Sensum Udred");
        stage.getIcons().add(new Image("Images/icon.png"));
        stage.show();
    }

    @Override
    public void injectBusiness(IBusinessFacade business) {
        this.business = business;
    }

    @Override
    public void startApplication(String[] args) {
        gui = this;
        launch(args);
    }
    
}
