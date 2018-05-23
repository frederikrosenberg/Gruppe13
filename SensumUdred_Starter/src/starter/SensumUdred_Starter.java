package starter;

import business.BusinessFacade;
import common.IBusinessFacade;
import common.IPersistenceFacade;
import common.IUI;
import persistence.PersistenceFacade;
import ui.GUI;

/**
 * Starter class
 * 
 * @author Andreas Mølgaard-Andersen
 * @author Lars Bjerregaard Jørgensen
 * @author Frederik Rosenberg
 * @author Mikkel Larsen
 * @author Sebastian Christensen
 * @author Kasper Schødts
 */
public class SensumUdred_Starter {

    /**
     * The main method for the program
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IPersistenceFacade persistence = new PersistenceFacade();
        IBusinessFacade business = new BusinessFacade();
        IUI ui = new GUI();
        
        business.injectPersistence(persistence);
        ui.injectBusiness(business);
        ui.startApplication(args);
        
    }
    
}
