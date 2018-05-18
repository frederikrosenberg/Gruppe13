package persistence;

import common.ICase;
import common.ICaseLog;
import common.ICaseWorker;
import common.ICitizen;
import common.IDepartment;
import common.ILog;
import common.ILoginAttemptLog;
import common.IPersistenceFacade;
import common.IUser;
import common.LogType;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The facade the that business layer communicate with.
 * 
 * @author Andreas Mølgaard-Andersen
 * @author Lars Bjerregaard Jørgensen
 * @author Frederik Rosenberg 
 * @author Mikkel Larsen
 * @author Sebastian Christensen
 * @author Kasper Schødts
 */
public class PersistenceFacade implements IPersistenceFacade {

    private final String dbServer;
    
    private final String dbUserName;
    
    private final String dbPassword;
    
    
    public PersistenceFacade() throws FileNotFoundException, IOException {
        File credentials = new File("credentials.txt");
        
        Scanner s = new Scanner(credentials);
        
        List<String> lines = new ArrayList<>();
        
        while (s.hasNextLine()) {
            lines.add(s.nextLine());
        }
        
        if (lines.size() == 4) {
            dbUserName = lines.get(0);
            dbPassword = lines.get(1);
            String urlPort = lines.get(2);
            String db = lines.get(3);
            dbServer = "jdbc:postgresql://" + urlPort + "/" + db + "?ssl";
        } else {
            throw new java.io.IOException("File is not of correct format!\nNeeds to be four lines with username on the first line, password on the second line, server url + port on the thrid line and database bane on the fourh line");
        }
    }
    
    private Connection getDbConnection() throws SQLException {
        return DriverManager.getConnection(dbServer, dbUserName, dbPassword);
    }
    
     /**
     * Adds a user from a IUser and give the id from the database
     * @param user the given user
     * @return the id from the database
     */
    @Override
    public String addUser(IUser user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Adds a case from a ICase and returns the id
     * @param _case the given case
     * @return the id from the database
     */
    @Override
    public int addCase(ICase _case) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Adds a case worker from ICaseWorker and returns the id
     * Does not add
     * @param caseWorker the given case worker
     * @return the id from the database
     */
    @Override
    public int addCaseWorker(ICaseWorker caseWorker) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Adds a department from IDepartment and returns the id.
     * This does not add case workers, citizen or cases
     * @param department the given department
     * @return the id from the database
     */
    @Override
    public int addDeparment(IDepartment department) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Adds a citizen from ICitizen and returns the id
     * This does not add cases the citizen has
     * @param citizen the given citizen
     * @return the id from the database
     */
    @Override
    public int addCitizen(ICitizen citizen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Adds a standard log from ILog and returns the id
     * @param log the given log
     * @return the id from the database
     */
    @Override
    public int addLog(ILog log) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Adds a attempt log from IAttemptLog and returns the id
     * @param log the given log
     * @return the id from the database
     */
    @Override
    public int addAttemptLog(ILoginAttemptLog log) {
        //INSERT INTO "Log" (UserID, Type, DateTime) VALUES (null,?,?) RETURNING Id
        //INSERT INTO "AttemptLog" (Id, UserName) VALUES (Id,?)
        
        try(Connection con = getDbConnection()) {
            PreparedStatement statement = con.prepareStatement("INSERT INTO \"Log\" (UserID, Type, DateTime) VALUES (?,?,?) RETURNING Id");
            statement.setNull(1, 0);
            statement.setInt(2, log.getLogType().ordinal());
            statement.setTimestamp(3, new Timestamp(log.getDate().getTime()));
            statement.execute();
            ResultSet set = statement.getResultSet();
            set.next();
            int id = set.getInt(1);
            
            statement = con.prepareStatement("INSERT INTO \"AttemptLog\" (Id, UserName) VALUES (?,?)");
            statement.setInt(1, id);
            statement.setString(2, log.getUsername());
            statement.execute();
            return id;
        } catch (SQLException ex) {
            Logger.getLogger(PersistenceFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return -1;
    }

     /**
     * Adds a case log from ICaseLog and returns the id
     * @param log the given log
     * @return the id from the database
     */
    @Override
    public int addCaseLog(ICaseLog log) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Get all the logs from the database
     * @return the logs
     */
    @Override
    public List<ILog> getLogs() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Get all the logs with at given type
     * @param type the type of log
     * @return the logs of that type
     */
    @Override
    public List<ILog> getLogsOfType(LogType type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Get a specific case
     * @param caseId the case id
     * @return the given case with the id, or null if the case does not exist 
     */
    @Override
    public ICase getCase(int caseId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Get all the cases
     * @return all the cases
     */
    @Override
    public List<ICase> getAllCases() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Get all the cases belonging to that case worker
     * @param caseWorkerId the id of the case worker
     * @return the cases for the case worker, empty if the case worker does not exist
     */
    @Override
    public List<ICase> getCaseWorkersCases(int caseWorkerId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Get a specific user
     * @param userId the id of the user
     * @return the given user or null if the user does not exist
     */
    @Override
    public IUser getUser(String userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Get all the users
     * @return all the users
     */
    @Override
    public List<IUser> getUsers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Get a specific citizen
     * @param id the id of the citizen
     * @return the given citizen or null if the citizen does not exist
     */
    @Override
    public ICitizen getCitizen(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Get all the citizens
     * @return all the citizens 
     */
    @Override
    public List<ICitizen> getCitizens() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Get a specific department
     * @param id the given id
     * @return the specific department or null if the department does not exist
     */
    @Override
    public IDepartment getDepartment(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
