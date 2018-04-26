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
 *
 * @author fsr19
 */
public class PersistenceFacade implements IPersistenceFacade {
    
    /**
     * The name all files start with
     */
    private final String commonName = "data_";

    /**
     * The file type for all files
     */
    private final String extension = ".ser";

    @Override
    public boolean save(IUserManager userManager, IDepartment department) {
        DataObject data = new DataObject(department, userManager);
        return save(data);
    }

    @Override
    public IDataObject load() {
        return load(DataObject.class);
    }
    
    
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
        return new File(commonName + type.getSimpleName() + extension).exists();
    }

    /**
     * Save the given object to the persistence store.
     *
     * @param object the given object to be stored
     * @return true if the object has been saved and false if object failed to
     * save.
     */
    private boolean save(Serializable object) {
        try (FileOutputStream fileOut = new FileOutputStream(commonName + object.getClass().getSimpleName() + extension)) {
            ObjectOutputStream stream = new ObjectOutputStream(fileOut);
            stream.writeObject(object);
            stream.close();
            return true;
        } catch (IOException ex) {
            return false;
        }
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
        try (FileInputStream fileIn = new FileInputStream(commonName + type.getSimpleName() + extension)) {
            ObjectInputStream in = new ObjectInputStream(fileIn);
            object = (T) in.readObject();
            in.close();
        } catch (IOException | ClassNotFoundException i) {
            return null;
        }
        return object;
    }
    
    
}
