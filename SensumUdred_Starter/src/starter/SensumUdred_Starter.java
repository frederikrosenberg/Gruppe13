package starter;

import business.BusinessFacade;
import common.IBusinessFacade;
import common.ILoginAttemptLog;
import common.IPersistenceFacade;
import common.IUI;
import common.LogType;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
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
    public static void main(String[] args) throws IOException, FileNotFoundException {
        IPersistenceFacade persistence = new PersistenceFacade();
        
        int id = persistence.addAttemptLog(new ILoginAttemptLog() {
            @Override
            public String getUsername() {
                return "Fred";
            }

            @Override
            public LogType getLogType() {
                return LogType.ATTEMPT_LOGIN;
            }

            @Override
            public Date getDate() {
                return new Date();
            }

            @Override
            public String getUserId() {
                return null;
            }
        });
        
        System.out.println(id);
//        IBusinessFacade business = new BusinessFacade();
//        IUI ui = new GUI();
//        
//        business.injectPersistence(persistence);
//        ui.injectBusiness(business);
//        ui.startApplication(args);
//        
    }
    
}
