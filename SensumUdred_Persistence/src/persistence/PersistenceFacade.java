package persistence;

import common.IDataObject;
import common.IDepartment;
import common.IPersistenceFacade;
import common.IUserManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * The facade the that business layer communicate with.
 * 
 * Some of this class is reuse from another project: 
 *  https://github.com/Frede175/HospitalGame/blob/master/HospitalGame_Persistence/src/persistence/PersistenceFacade.java
 * 
 * @author Andreas Mølgaard-Andersen
 * @author Lars Bjerregaard Jørgensen
 * @author Frederik Rosenberg 
 * @author Mikkel Larsen
 * @author Sebastian Christensen
 * @author Kasper Schødts
 */
public class PersistenceFacade implements IPersistenceFacade {
    
    /**
     * The name all files start with
     */
    private static final String COMMON_NAME = "data_";

    /**
     * The file type for all files
     */
    private static final String EXTENSION = ".ser";

    /**
     * Saves the given user manager and department to disk.
     * This override other saved departments and user managers
     * @param userManager that needs to be saved
     * @param department that needs to be saved
     * @return weather the save was success full or not
     */
    @Override
    public boolean save(IUserManager userManager, IDepartment department) {
        DataObject data = new DataObject(department, userManager);
        return save(data);
    }

    /**
     * Loads saved department and user manager from disk.
     * @return a object containing the department and user manager, 
     * if there is no saved department or user manager this returns null.
     */
    @Override
    public IDataObject load() {
        return load(DataObject.class);
    }
    
    /**
     * Checks whether a save is available
     * @return true if there is a save available
     */
    @Override
    public boolean saveAvailable() {
        return fileExists(DataObject.class);
    }

    /**
     * Check if a file exists on the file system from the given type.
     *
     * @param <T>
     * @param type that need to see if a file exits
     * @return true if the file exits
     */
    private <T> boolean fileExists(Class<T> type) {
        return new File(COMMON_NAME + type.getSimpleName() + EXTENSION).exists();
    }

    /**
     * Save the given object to the persistence store.
     *
     * @param object the given object to be stored
     * @return true if the object has been saved and false if object failed to
     * save.
     */
    private boolean save(Serializable object) {
        boolean s;
        try (FileOutputStream fileOut = new FileOutputStream(COMMON_NAME + object.getClass().getSimpleName() + EXTENSION);
                ObjectOutputStream stream = new ObjectOutputStream(fileOut)) {
            stream.writeObject(object);
            s = true;
        } catch (IOException ex) {
            s = false;
        }
        return s;
    }

    /**
     * Get the given object form the persistence store.
     *
     * @param type The class that needs to be loaded
     * @return an object with the given class or null if an error occurs.
     */
    private <T extends Serializable> T load(Class<T> type) {
        if (!fileExists(type)) return null;
        T object;
        try (FileInputStream fileIn = new FileInputStream(COMMON_NAME + type.getSimpleName() + EXTENSION); ObjectInputStream in = new ObjectInputStream(fileIn)) {
            object = (T) in.readObject();
        } catch (IOException | ClassNotFoundException i) {
            object = null;
        }
        return object;
    }
    
    
}
