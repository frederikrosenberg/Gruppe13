package business;

import common.IPersistenceFacade;

/**
 *
 * @author fred
 */
public class Persistence {
    
    /**
     * The persistence instance
     */
    private static Persistence instance;
    
    /**
     * The persistence facade
     */
    private IPersistenceFacade persistenceFacade;
    
    /**
     * Gets the instance of the singleton
     * @return The instance of the singleton
     */
    public static Persistence getInstance() {
        if (instance == null) {
            instance = new Persistence();
        }
        return instance;
    }
    
    /**
     * Empty constructor
     */
    private Persistence() {
        
    }
    
    /**
     * Injects persistence facade
     * @param persistenceFacade The persistence facade to inject
     */
    public void injectPersistence(IPersistenceFacade persistenceFacade) {
        this.persistenceFacade = persistenceFacade;
    }
    
    /**
     * Gets the persistence facade
     * @return The persistence facade
     */
    public IPersistenceFacade getPersistenceFacade() {
        return persistenceFacade;
    }
    
}
