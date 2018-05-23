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
 * Applications starter class for GUI
 *
 * @author Andreas Mølgaard-Andersen
 * @author Lars Bjerregaard Jørgensen
 * @author Frederik Rosenberg
 * @author Mikkel Larsen
 * @author Sebastian Christensen
 * @author Kasper Schødts
 */
public class GUI extends Application implements IUI {

    /**
     * An instance of the GUI class.
     */
    private static GUI gui;
    
    /**
     * An instance of the IBusinessFacade.
     */
    private IBusinessFacade business;
    
    /**
     * An instance of the application stage.
     */
    private Stage stage;

    /**
     * Sets the stage and scene for the GUI, also loads the FXML Document, and
     * sets it as the scene.
     *
     * @param stage object
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/LoginScreen.fxml"));
        Scene scene = new Scene(root);

        gui.stage = stage;
        stage.setScene(scene);
        stage.setTitle("Sensum Udred");
        stage.getIcons().add(new Image("Images/icon.png"));
        stage.show();
    }

    /**
     * Injects a reference to the IBusinessFacase into the starter class.
     *
     * @param business object of the IBusinessfacade type
     */
    @Override
    public void injectBusiness(IBusinessFacade business) {
        this.business = business;
    }

    /**
     * Starts and launches the application.
     *
     * @param args
     */
    @Override
    public void startApplication(String[] args) {
        gui = this;
        launch(args);
    }
    
    /**
     * Gets the business facade
     * @return the business facade
     */
    public IBusinessFacade getBusiness() {
        return business;
    }
    
    /**
     * Get the ui instance
     * @return the gui object
     */
    public static GUI getInstance() {
        return gui;
    }

}
