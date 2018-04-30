package starter;

import common.IUI;
import ui.GUI;

/**
 *
 * @author Frederik Rosenberg
 */
public class SensumUdred_Starter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        IUI gui = new GUI();
        //gui.injectBusiness(business);
        
        gui.startApplication(args);
        
    }
    
}
