package business;

import common.IPersistenceFacade;

/**
 *
 * @author fred
 */
public class Persistence {
    
    private static Persistence instance;
    
    private IPersistenceFacade persistenceFacade;
    
    public static Persistence getInstance() {
        if (instance == null) {
            instance = new Persistence();
        }
        return instance;
    }
    
    private Persistence() {
        
    }
    
    public void injectPersistence(IPersistenceFacade persistenceFacade) {
        this.persistenceFacade = persistenceFacade;
    }
    
    public IPersistenceFacade getPersistenceFacade() {
        return persistenceFacade;
    }
    
}
